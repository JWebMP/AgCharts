package com.jwebmp.plugins.agcharts.options.touch;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Touch input options for AG Charts 12.2.0.
 * 
 * Controls touch gesture support including pan, zoom, and long-press.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgChartTouchOptions<J extends AgChartTouchOptions<J>> extends JavaScriptPart<J> {
    /** Enable/disable touch input. */
    private Boolean enabled;

    public Boolean getEnabled() {
        return enabled;
    }

    public @org.jspecify.annotations.NonNull J setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return (J) this;
    }
}
