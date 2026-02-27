package com.jwebmp.plugins.agcharts.options;

import com.jwebmp.plugins.agcharts.options.axes.*;
import com.jwebmp.plugins.agcharts.options.legend.AgChartLegendOptions;
import com.jwebmp.plugins.agcharts.options.legend.AgPadding;
import com.jwebmp.plugins.agcharts.options.series.*;
import com.jwebmp.plugins.agcharts.options.theme.AgChartTheme;
import com.jwebmp.plugins.agcharts.options.theme.AgChartThemeOverrides;
import com.jwebmp.plugins.agcharts.options.theme.AgChartThemeSeriesGroupOverride;
import com.jwebmp.plugins.agcharts.options.theme.AgChartThemeSeriesOverride;
import com.jwebmp.plugins.agcharts.options.tooltip.AgSeriesTooltipOptions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Builds chart options intended to mirror the requested v13 JSON example,
 * ensuring raw JavaScript for functions and expressions is supported.
 */
class RequestedOptionsJsonTest {

    @Test
    void testRequestedJsonShape() {
        // Theme overrides: bar.series.label
        AgChartThemeSeriesOverride<?> seriesOverride = new AgChartThemeSeriesOverride<>()
                .setLabel(new AgSeriesLabelOptions<>()
                        .setEnabled(true)
                        .setFontWeight("bold")
                        .setFontFamily("labelFont") // will serialize as string; retained support
                        .setColor("labelColor")      // will serialize as string; retained support
                );

        AgChartTheme<?> theme = new AgChartTheme<>()
                .setOverrides(new AgChartThemeOverrides<>()
                        .setBar(new AgChartThemeSeriesGroupOverride<>().setSeries(seriesOverride))
                );

        // Series 1: Intake
        AgBarSeriesOptions<?> intake = new AgBarSeriesOptions<>()
                .setDirection(AgSeriesDirection.HORIZONTAL)
                .setStacked(true)
                .setNormalizedTo(100)
                .setXKey("category")
                .setYKey("intake")
                .setYName("Intake Kg")
                .setStroke("intakeStroke")
                // Raw ternary expression for strokeWidth
                .setStrokeWidthRaw("currentStatus === 'success' ? 2 : 1")
                // Per-datum styler (uses raw variables)
                .setItemStyler("(params) => ({ fill: intakeFill, stroke: intakeStroke, strokeWidth: currentStatus === 'success' ? 2 : 1 })")
                // Labels with placement and raw formatter
                .setLabel(new AgBarSeriesLabelOptions<>()
                        .setEnabled(true)
                        .setColor("labelColor")
                        .setFontFamily("labelFont")
                        .setPlacement("inside-center")
                        .setFontSize(20)
                        .setFontWeight("bold")
                        .setFormatter("(p) => p.datum.intakePct > 5 ? p.datum.intake.toFixed(1) + 'kg (' + p.datum.intakePct.toFixed(0) + '%)' : ''")
                )
                // Tooltip with raw renderer
                .setTooltip(new AgSeriesTooltipOptions<>()
                        .setRenderer("(p) => ({ title: 'Intake', content: 'Weight: ' + formatKg(p.datum.intake) + '<br/>Share: ' + formatPct(p.datum.intakePct) })")
                );

        // Series 2: Packout
        AgBarSeriesOptions<?> packout = new AgBarSeriesOptions<>()
                .setDirection(AgSeriesDirection.HORIZONTAL)
                .setStacked(true)
                .setNormalizedTo(100)
                .setXKey("category")
                .setYKey("packout")
                .setYName("packoutLabel + ' Kg'") // retained as string; JS concat would be raw in Angular layer
                .setStroke("packoutStroke")
                .setStrokeWidthRaw("currentStatus === 'success' ? 2 : 1")
                .setItemStyler("(params) => ({ fill: packoutFill, stroke: packoutStroke, strokeWidth: currentStatus === 'success' ? 2 : 1 })")
                .setLabel(new AgBarSeriesLabelOptions<>()
                        .setEnabled(true)
                        .setColor("labelColor")
                        .setFontFamily("labelFont")
                        .setPlacement("inside-center")
                        .setFontSize(14)
                        .setFontWeight("bold")
                        .setFormatter("(p) => p.datum.packoutPct > 5 ? p.datum.packout.toFixed(1) + 'kg (' + p.datum.packoutPct.toFixed(0) + '%)' : ''")
                )
                .setTooltip(new AgSeriesTooltipOptions<>()
                        .setRenderer("(p) => ({ title: packoutLabel, content: 'Weight: ' + formatKg(p.datum.packout) + '<br/>Share: ' + formatPct(p.datum.packoutPct) })")
                );

        // Axes as object form (v13)
        AgNumberAxisOptions<?> x = new AgNumberAxisOptions<>()
                .setPosition(AgCartesianAxisPosition.BOTTOM)
                .setLabel(new AgBaseCartesianAxisLabelOptions<>().setEnabled(false))
                .setMin(0.0)
                .setMax(100.0);

        AgCategoryAxisOptions<?> y = new AgCategoryAxisOptions<>()
                .setPosition(AgCartesianAxisPosition.LEFT)
                .setLine(new AgAxisLineOptions<>().setEnabled(false))
                .setLabel(new AgBaseCartesianAxisLabelOptions<>().setEnabled(false))
                .setTick(new AgAxisBaseTickOptions<>().setEnabled(false));

        AgChartOptions<?> options = new AgChartOptions<>()
                .setHeight(100)
                .setPadding(new AgPadding<>().setTop(10).setBottom(10).setLeft(10).setRight(10))
                .setBackground(new AgChartBackground<>().setFill("transparent"))
                .setLegend(new AgChartLegendOptions<>().setEnabled(false))
                .setTheme(theme)
                .setSeries(List.of(intake, packout))
                .setAxes(new AgAxesOptions<>().setNumber(x).setCategory(y));

        String json = options.toJson();
        System.out.println("[DEBUG_LOG] Requested options JSON: " + json);

        // High-level checks
        assertTrue(json.contains("\"height\""));
        assertTrue(json.contains("\"padding\""));
        assertTrue(json.contains("\"background\""));
        assertTrue(json.contains("\"legend\""));
        assertTrue(json.contains("\"theme\""));
        assertTrue(json.contains("\"overrides\""));
        assertTrue(json.contains("\"bar\""));
        assertTrue(json.contains("\"series\""));
        assertTrue(json.contains("\"label\""));

        // Series checks
        assertTrue(json.contains("\"type\" : \"bar\"") || json.contains("\"type\":\"bar\""));
        assertTrue(json.contains("\"direction\" : \"horizontal\"") || json.contains("\"direction\":\"horizontal\""));
        assertTrue(json.contains("\"stacked\" : true") || json.contains("\"stacked\":true"));
        assertTrue(json.contains("\"normalizedTo\" : 100") || json.contains("\"normalizedTo\":100"));
        assertTrue(json.contains("\"xKey\" : \"category\"") || json.contains("\"xKey\":\"category\""));
        assertTrue(json.contains("\"yKey\" : \"intake\"") || json.contains("\"yKey\":\"intake\""));

        // Raw JS checks: strokeWidth ternary, label formatter function, tooltip renderer function
        assertTrue(json.contains("currentStatus === 'success' ? 2 : 1"));
        assertTrue(json.contains("(p) => p.datum.intakePct > 5"));
        assertTrue(json.contains("(p) => ({ title: 'Intake'"));

        // Axes object checks
        assertTrue(json.contains("\"axes\""));
        assertTrue(json.contains("\"number\""));
        assertTrue(json.contains("\"category\""));
        assertTrue(json.contains("\"min\" : 0") || json.contains("\"min\":0"));
        assertTrue(json.contains("\"max\" : 100") || json.contains("\"max\":100"));
        assertTrue(json.contains("\"position\" : \"bottom\"") || json.contains("\"position\":\"bottom\""));
        assertTrue(json.contains("\"position\" : \"left\"") || json.contains("\"position\":\"left\""));
    }
}
