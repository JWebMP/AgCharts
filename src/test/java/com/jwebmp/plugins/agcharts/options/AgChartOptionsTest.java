package com.jwebmp.plugins.agcharts.options;

import com.jwebmp.plugins.agcharts.options.axes.AgCategoryAxisOptions;
import com.jwebmp.plugins.agcharts.options.axes.AgNumberAxisOptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AgChartOptionsTest {

    @Test
    void testAxesAsObject() {
        AgChartOptions<?> options = new AgChartOptions<>();
        options.getAxes()
                .setNumber(new AgNumberAxisOptions<>().setNice(true))
                .setCategory(new AgCategoryAxisOptions<>().setPaddingInner(0.1));

        String json = options.toJson();
        System.out.println("JSON Output: " + json);

        // Verify that "axes" is an object, not an array
        assertTrue(json.contains("\"axes\":{") || json.contains("\"axes\" : {"));
        assertTrue(json.contains("\"number\":{") || json.contains("\"number\" : {"));
        assertTrue(json.contains("\"category\":{") || json.contains("\"category\" : {"));
        assertTrue(json.contains("\"type\" : \"number\"") || json.contains("\"type\":\"number\""));
        assertTrue(json.contains("\"type\" : \"category\"") || json.contains("\"type\":\"category\""));
        assertTrue(json.contains("\"nice\" : true") || json.contains("\"nice\":true"));
        assertTrue(json.contains("\"paddingInner\" : 0.1") || json.contains("\"paddingInner\":0.1"));
    }
}
