package com.jwebmp.plugins.agcharts.options.series.fills;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import java.util.List;

/**
 * Gradient fill configuration for series or markers.
 * type should be 'gradient'.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgGradientColor<J extends AgGradientColor<J>> extends JavaScriptPart<J> {
    private final String type = "gradient";
    private List<AgGradientColorStop<?>> colorStops;
    private Number rotation; // degrees

    public String getType() {
        return type;
    }

    public List<AgGradientColorStop<?>> getColorStops() {
        return colorStops;
    }

    public @org.jspecify.annotations.NonNull J setColorStops(List<AgGradientColorStop<?>> colorStops) {
        this.colorStops = colorStops;
        return (J) this;
    }

    public Number getRotation() {
        return rotation;
    }

    public @org.jspecify.annotations.NonNull J setRotation(Number rotation) {
        this.rotation = rotation;
        return (J) this;
    }
}
