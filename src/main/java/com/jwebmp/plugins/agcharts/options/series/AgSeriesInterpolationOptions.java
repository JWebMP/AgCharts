package com.jwebmp.plugins.agcharts.options.series;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Interpolation options for series that draw continuous lines.
  * @param <J> the self-referencing generic type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgSeriesInterpolationOptions<J extends AgSeriesInterpolationOptions<J>> extends JavaScriptPart<J> {
    private AgInterpolationType type;

    public AgInterpolationType getType() {
        return type;
    }

    public @org.jspecify.annotations.NonNull J setType(AgInterpolationType type) {
        this.type = type;
        return (J) this;
    }
}
