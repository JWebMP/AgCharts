package com.jwebmp.plugins.agcharts.options.initialstate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Initial state options for AG Charts 12.2.0.
 * 
 * Defines chart initial state including zoom/pan position and selections.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgChartInitialStateOptions<J extends AgChartInitialStateOptions<J>> extends JavaScriptPart<J> {
    /** Zoom level for initial render. */
    private Double zoom;
    
    /** Pan/center position. */
    private Object pan;

    public Double getZoom() {
        return zoom;
    }

    public @org.jspecify.annotations.NonNull J setZoom(Double zoom) {
        this.zoom = zoom;
        return (J) this;
    }

    public Object getPan() {
        return pan;
    }

    public @org.jspecify.annotations.NonNull J setPan(Object pan) {
        this.pan = pan;
        return (J) this;
    }
}
