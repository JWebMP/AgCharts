package com.jwebmp.plugins.agcharts.options;

import com.jwebmp.plugins.agcharts.options.series.AgPieSeriesLabelOptions;
import com.jwebmp.plugins.agcharts.options.theme.AgChartTheme;
import com.jwebmp.plugins.agcharts.options.theme.AgChartThemeOverrides;
import com.jwebmp.plugins.agcharts.options.theme.AgChartThemeSeriesGroupOverride;
import com.jwebmp.plugins.agcharts.options.theme.AgChartThemeSeriesOverride;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ThemeOverridesPieLabelsTest {

    @Test
    void testPieSeriesCalloutLabelInThemeOverrides() {
        AgPieSeriesLabelOptions<?> calloutLabel = new AgPieSeriesLabelOptions<>()
                .setEnabled(true)
                .setFontWeight("bold")
                .setFontFamily("Arial")
                .setColor("#333333");

        AgChartThemeSeriesOverride<?> seriesOverride = new AgChartThemeSeriesOverride<>()
                .setCalloutLabel(calloutLabel);

        AgChartThemeOverrides<?> overrides = new AgChartThemeOverrides<>()
                .setPie(new AgChartThemeSeriesGroupOverride<>().setSeries(seriesOverride));

        AgChartTheme<?> theme = new AgChartTheme<>().setOverrides(overrides);

        AgChartOptions<?> options = new AgChartOptions<>()
                .setHeight(100)
                .setTheme(theme);

        String json = options.toJson();
        System.out.println("[DEBUG_LOG] Pie overrides serialized options: " + json);

        assertTrue(json.contains("\"theme\""));
        assertTrue(json.contains("\"overrides\""));
        assertTrue(json.contains("\"pie\""));
        assertTrue(json.contains("\"series\""));
        assertTrue(json.contains("\"calloutLabel\""));
        assertTrue(json.contains("\"enabled\" : true") || json.contains("\"enabled\":true"));
        assertTrue(json.contains("\"fontWeight\" : \"bold\"") || json.contains("\"fontWeight\":\"bold\""));
        assertTrue(json.contains("\"fontFamily\" : \"Arial\"") || json.contains("\"fontFamily\":\"Arial\""));
        assertTrue(json.contains("\"color\" : \"#333333\"") || json.contains("\"color\":\"#333333\""));
    }
}
