package com.jwebmp.plugins.agcharts.options.formatter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Chart-level formatter configuration for AG Charts 12.2.0.
 * 
 * Modern replacement for deprecated formatter options. Provides global value formatting
 * for numbers, dates, and other data types across the chart.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgChartFormatterOptions<J extends AgChartFormatterOptions<J>> extends JavaScriptPart<J> {
    /** Global formatter function (raw JavaScript). */
    @JsonRawValue
    private String format;
    
    /** Enable/disable formatting. */
    private Boolean enabled;

    public String getFormat() {
        return format;
    }

    public @org.jspecify.annotations.NonNull J setFormat(String format) {
        this.format = format;
        return (J) this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public @org.jspecify.annotations.NonNull J setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return (J) this;
    }
}
