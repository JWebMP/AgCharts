package com.jwebmp.plugins.agcharts.options.keyboard;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Keyboard input options for AG Charts 12.2.0.
 * 
 * Controls keyboard interaction support including navigation and shortcuts.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgChartKeyboardOptions<J extends AgChartKeyboardOptions<J>> extends JavaScriptPart<J> {
    /** Enable/disable keyboard input. */
    private Boolean enabled;

    public Boolean getEnabled() {
        return enabled;
    }

    public @org.jspecify.annotations.NonNull J setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return (J) this;
    }
}
