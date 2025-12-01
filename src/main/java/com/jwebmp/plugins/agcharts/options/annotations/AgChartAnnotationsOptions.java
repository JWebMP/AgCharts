package com.jwebmp.plugins.agcharts.options.annotations;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import java.util.List;

/**
 * Chart-level annotations options for AG Charts 12.2.0.
 * 
 * Defines annotations such as lines, text labels, and shapes overlaid on the chart.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgChartAnnotationsOptions<J extends AgChartAnnotationsOptions<J>> extends JavaScriptPart<J> {
    /** List of annotation objects. */
    private List<?> value;

    public List<?> getValue() {
        return value;
    }

    public @org.jspecify.annotations.NonNull J setValue(List<?> value) {
        this.value = value;
        return (J) this;
    }
}
