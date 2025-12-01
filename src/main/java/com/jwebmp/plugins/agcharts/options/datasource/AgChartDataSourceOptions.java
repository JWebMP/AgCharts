package com.jwebmp.plugins.agcharts.options.datasource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Data source options for AG Charts 12.2.0.
 * 
 * Configures data binding adapters and remote data source behavior.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgChartDataSourceOptions<J extends AgChartDataSourceOptions<J>> extends JavaScriptPart<J> {
    /** Enable/disable remote data loading. */
    private Boolean enabled;

    public Boolean getEnabled() {
        return enabled;
    }

    public @org.jspecify.annotations.NonNull J setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return (J) this;
    }
}
