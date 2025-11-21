package com.jwebmp.plugins.agcharts.options.legend;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Label style for legend pagination.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgChartLegendPaginationLabelOptions<J extends AgChartLegendPaginationLabelOptions<J>> extends JavaScriptPart<J> {
    private Integer fontSize;
    private String fontFamily;
    private String fontWeight;
    private String color;

    public Integer getFontSize() {
        return fontSize;
    }

    public @org.jspecify.annotations.NonNull J setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
        return (J) this;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public @org.jspecify.annotations.NonNull J setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
        return (J) this;
    }

    public String getFontWeight() {
        return fontWeight;
    }

    public @org.jspecify.annotations.NonNull J setFontWeight(String fontWeight) {
        this.fontWeight = fontWeight;
        return (J) this;
    }

    public String getColor() {
        return color;
    }

    public @org.jspecify.annotations.NonNull J setColor(String color) {
        this.color = color;
        return (J) this;
    }
}
