package com.jwebmp.plugins.agcharts.options.contextmenu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Context menu options for AG Charts 12.2.0.
 * 
 * Configures right-click context menu behavior, including custom items and actions.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgChartContextMenuOptions<J extends AgChartContextMenuOptions<J>> extends JavaScriptPart<J> {
    /** Enable/disable context menu. */
    private Boolean enabled;

    public Boolean getEnabled() {
        return enabled;
    }

    public @org.jspecify.annotations.NonNull J setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return (J) this;
    }
}
