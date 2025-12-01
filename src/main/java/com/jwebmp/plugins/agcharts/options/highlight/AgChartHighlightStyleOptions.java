package com.jwebmp.plugins.agcharts.options.highlight;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Highlight style configuration for chart-level highlighting.
 * 
 * Defines fill, stroke, and opacity changes when items/series are highlighted.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgChartHighlightStyleOptions<J extends AgChartHighlightStyleOptions<J>> extends JavaScriptPart<J> {
    /** Fill color for highlighted state. */
    private String fill;
    
    /** Fill opacity (0-1) for highlighted state. */
    private Double fillOpacity;
    
    /** Stroke color for highlighted state. */
    private String stroke;
    
    /** Stroke opacity (0-1) for highlighted state. */
    private Double strokeOpacity;
    
    /** Stroke width for highlighted state. */
    private Integer strokeWidth;

    public String getFill() {
        return fill;
    }

    public @org.jspecify.annotations.NonNull J setFill(String fill) {
        this.fill = fill;
        return (J) this;
    }

    public Double getFillOpacity() {
        return fillOpacity;
    }

    public @org.jspecify.annotations.NonNull J setFillOpacity(Double fillOpacity) {
        this.fillOpacity = fillOpacity;
        return (J) this;
    }

    public String getStroke() {
        return stroke;
    }

    public @org.jspecify.annotations.NonNull J setStroke(String stroke) {
        this.stroke = stroke;
        return (J) this;
    }

    public Double getStrokeOpacity() {
        return strokeOpacity;
    }

    public @org.jspecify.annotations.NonNull J setStrokeOpacity(Double strokeOpacity) {
        this.strokeOpacity = strokeOpacity;
        return (J) this;
    }

    public Integer getStrokeWidth() {
        return strokeWidth;
    }

    public @org.jspecify.annotations.NonNull J setStrokeWidth(Integer strokeWidth) {
        this.strokeWidth = strokeWidth;
        return (J) this;
    }
}
