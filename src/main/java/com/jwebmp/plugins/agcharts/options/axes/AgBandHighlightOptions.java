package com.jwebmp.plugins.agcharts.options.axes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgBandHighlightOptions<J extends AgBandHighlightOptions<J>> extends JavaScriptPart<J> {
    private Boolean enabled;
    private String fill;
    private Double fillOpacity;

    public Boolean getEnabled() {
        return enabled;
    }

    public @org.jspecify.annotations.NonNull J setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return (J) this;
    }

    public String getFill() {
        return fill;
    }

    public @org.jspecify.annotations.NonNull J setFill(String fill) {
        this.fill = fill;
        return (J) this;
    }

    public Double getFillOpacity() {
        return fillOpacity;
    }

    public @org.jspecify.annotations.NonNull J setFillOpacity(Double fillOpacity) {
        this.fillOpacity = fillOpacity;
        return (J) this;
    }
}
