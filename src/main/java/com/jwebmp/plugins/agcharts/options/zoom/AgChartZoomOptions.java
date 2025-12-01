package com.jwebmp.plugins.agcharts.options.zoom;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Chart-level zoom options for AG Charts 12.2.0.
 * 
 * Controls zoom and pan interactions, including keyboard/mouse modifiers and behavior.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgChartZoomOptions<J extends AgChartZoomOptions<J>> extends JavaScriptPart<J> {
    /** Enable/disable zoom functionality. */
    private Boolean enabled;
    
    /** Zoom behavior on mouse wheel ("zoom" or "pan"). */
    private String wheelBehaviour;
    
    /** Minimum zoom level. */
    private Double minZoom;

    public Boolean getEnabled() {
        return enabled;
    }

    public @org.jspecify.annotations.NonNull J setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return (J) this;
    }

    public String getWheelBehaviour() {
        return wheelBehaviour;
    }

    public @org.jspecify.annotations.NonNull J setWheelBehaviour(String wheelBehaviour) {
        this.wheelBehaviour = wheelBehaviour;
        return (J) this;
    }

    public Double getMinZoom() {
        return minZoom;
    }

    public @org.jspecify.annotations.NonNull J setMinZoom(Double minZoom) {
        this.minZoom = minZoom;
        return (J) this;
    }
}
