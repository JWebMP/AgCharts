package com.jwebmp.plugins.agcharts.options.axes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgAxisBaseTickOptions<J extends AgAxisBaseTickOptions<J>> extends JavaScriptPart<J> {
    private Boolean enabled;
    private Integer minSpacing;
    private Integer maxSpacing;
    private Integer count;

    public Boolean getEnabled() {
        return enabled;
    }

    public @org.jspecify.annotations.NonNull J setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return (J) this;
    }

    public Integer getMinSpacing() {
        return minSpacing;
    }

    public @org.jspecify.annotations.NonNull J setMinSpacing(Integer minSpacing) {
        this.minSpacing = minSpacing;
        return (J) this;
    }

    public Integer getMaxSpacing() {
        return maxSpacing;
    }

    public @org.jspecify.annotations.NonNull J setMaxSpacing(Integer maxSpacing) {
        this.maxSpacing = maxSpacing;
        return (J) this;
    }

    public Integer getCount() {
        return count;
    }

    public @org.jspecify.annotations.NonNull J setCount(Integer count) {
        this.count = count;
        return (J) this;
    }
}
