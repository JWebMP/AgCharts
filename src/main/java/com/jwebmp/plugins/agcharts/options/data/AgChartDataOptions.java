package com.jwebmp.plugins.agcharts.options.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import java.util.List;

/**
 * Chart-level data options for AG Charts 12.2.0.
 * 
 * Defines chart-level data binding and source configuration.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgChartDataOptions<J extends AgChartDataOptions<J>> extends JavaScriptPart<J> {
    /** Raw data array for the chart. */
    private List<?> value;

    public List<?> getValue() {
        return value;
    }

    public @org.jspecify.annotations.NonNull J setValue(List<?> value) {
        this.value = value;
        return (J) this;
    }
}
