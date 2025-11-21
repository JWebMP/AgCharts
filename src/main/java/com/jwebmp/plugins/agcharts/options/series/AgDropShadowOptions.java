package com.jwebmp.plugins.agcharts.options.series;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Drop shadow options used behind series shapes.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgDropShadowOptions<J extends AgDropShadowOptions<J>> extends JavaScriptPart<J> {
    private Boolean enabled;
    private String color;
    private Integer xOffset;
    private Integer yOffset;
    private Integer blur;
    private Double opacity;

    public Boolean getEnabled() {
        return enabled;
    }

    public @org.jspecify.annotations.NonNull J setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return (J) this;
    }

    public String getColor() {
        return color;
    }

    public @org.jspecify.annotations.NonNull J setColor(String color) {
        this.color = color;
        return (J) this;
    }

    public Integer getXOffset() {
        return xOffset;
    }

    public @org.jspecify.annotations.NonNull J setXOffset(Integer xOffset) {
        this.xOffset = xOffset;
        return (J) this;
    }

    public Integer getYOffset() {
        return yOffset;
    }

    public @org.jspecify.annotations.NonNull J setYOffset(Integer yOffset) {
        this.yOffset = yOffset;
        return (J) this;
    }

    public Integer getBlur() {
        return blur;
    }

    public @org.jspecify.annotations.NonNull J setBlur(Integer blur) {
        this.blur = blur;
        return (J) this;
    }

    public Double getOpacity() {
        return opacity;
    }

    public @org.jspecify.annotations.NonNull J setOpacity(Double opacity) {
        this.opacity = opacity;
        return (J) this;
    }
}
