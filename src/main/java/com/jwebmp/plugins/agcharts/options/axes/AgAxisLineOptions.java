package com.jwebmp.plugins.agcharts.options.axes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgAxisLineOptions<J extends AgAxisLineOptions<J>> extends JavaScriptPart<J> {
    private Boolean enabled;
    private Integer width;
    private String color;
    private Double opacity;

    public Boolean getEnabled() {
        return enabled;
    }

    public @org.jspecify.annotations.NonNull J setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return (J) this;
    }

    public Integer getWidth() {
        return width;
    }

    public @org.jspecify.annotations.NonNull J setWidth(Integer width) {
        this.width = width;
        return (J) this;
    }

    public String getColor() {
        return color;
    }

    public @org.jspecify.annotations.NonNull J setColor(String color) {
        this.color = color;
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
