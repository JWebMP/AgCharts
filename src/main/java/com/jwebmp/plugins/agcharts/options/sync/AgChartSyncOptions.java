package com.jwebmp.plugins.agcharts.options.sync;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Chart-level sync options for AG Charts 12.2.0.
 * 
 * Enables synchronization of tooltips, highlights, and selections across multiple charts.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgChartSyncOptions<J extends AgChartSyncOptions<J>> extends JavaScriptPart<J> {
    /** Enable/disable chart synchronization. */
    private Boolean enabled;
    
    /** Sync mode: "tooltip", "highlight", or "selection". */
    private String mode;

    public Boolean getEnabled() {
        return enabled;
    }

    public @org.jspecify.annotations.NonNull J setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return (J) this;
    }

    public String getMode() {
        return mode;
    }

    public @org.jspecify.annotations.NonNull J setMode(String mode) {
        this.mode = mode;
        return (J) this;
    }
}
