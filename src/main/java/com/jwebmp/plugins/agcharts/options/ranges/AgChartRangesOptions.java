package com.jwebmp.plugins.agcharts.options.ranges;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Chart-level ranges options for AG Charts 12.2.0.
 * 
 * Defines range buttons and selectors for axis/data filtering and selection UI.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgChartRangesOptions<J extends AgChartRangesOptions<J>> extends JavaScriptPart<J> {
    /** Enable/disable range selection UI. */
    private Boolean enabled;
    
    /** Preset range buttons (e.g., "1w", "1m", "3m", "1y", "all"). */
    private Object presets;

    public Boolean getEnabled() {
        return enabled;
    }

    public @org.jspecify.annotations.NonNull J setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return (J) this;
    }

    public Object getPresets() {
        return presets;
    }

    public @org.jspecify.annotations.NonNull J setPresets(Object presets) {
        this.presets = presets;
        return (J) this;
    }
}
