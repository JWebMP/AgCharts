package com.jwebmp.plugins.agcharts.options;

import com.jwebmp.plugins.agcharts.options.series.AgSeriesLabelOptions;
import com.jwebmp.plugins.agcharts.options.theme.AgChartTheme;
import com.jwebmp.plugins.agcharts.options.theme.AgChartThemeOverrides;
import com.jwebmp.plugins.agcharts.options.theme.AgChartThemeSeriesGroupOverride;
import com.jwebmp.plugins.agcharts.options.theme.AgChartThemeSeriesOverride;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ThemeOverridesLabelTest {

    @Test
    void testBarSeriesLabelInThemeOverrides() {
        AgSeriesLabelOptions<?> label = new AgSeriesLabelOptions<>()
                .setEnabled(true)
                .setFontWeight("bold")
                .setFontFamily("Arial")
                .setColor("#333333");

        AgChartThemeSeriesOverride<?> seriesOverride = new AgChartThemeSeriesOverride<>()
                .setLabel(label);

        AgChartThemeOverrides<?> overrides = new AgChartThemeOverrides<>()
                .setBar(new AgChartThemeSeriesGroupOverride<>().setSeries(seriesOverride));

        AgChartTheme<?> theme = new AgChartTheme<>().setOverrides(overrides);

        AgChartOptions<?> options = new AgChartOptions<>()
                .setHeight(100)
                .setTheme(theme);

        String json = options.toJson();
        System.out.println("[DEBUG_LOG] Serialized options: " + json);

        assertTrue(json.contains("\"theme\""));
        assertTrue(json.contains("\"overrides\""));
        assertTrue(json.contains("\"bar\""));
        assertTrue(json.contains("\"series\""));
        assertTrue(json.contains("\"label\""));
        assertTrue(json.contains("\"enabled\" : true") || json.contains("\"enabled\":true"));
        assertTrue(json.contains("\"fontWeight\" : \"bold\"") || json.contains("\"fontWeight\":\"bold\""));
        assertTrue(json.contains("\"fontFamily\" : \"Arial\"") || json.contains("\"fontFamily\":\"Arial\""));
        assertTrue(json.contains("\"color\" : \"#333333\"") || json.contains("\"color\":\"#333333\""));
    }
}
