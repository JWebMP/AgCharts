package com.jwebmp.plugins.agcharts.options.container;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Container options for AG Charts 12.2.0.
 * 
 * Defines chart container element configuration and behavior.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgChartContainerOptions<J extends AgChartContainerOptions<J>> extends JavaScriptPart<J> {
    /** Container element ID or selector. */
    private String id;
    
    /** CSS classes to apply to container. */
    private String className;

    public String getId() {
        return id;
    }

    public @org.jspecify.annotations.NonNull J setId(String id) {
        this.id = id;
        return (J) this;
    }

    public String getClassName() {
        return className;
    }

    public @org.jspecify.annotations.NonNull J setClassName(String className) {
        this.className = className;
        return (J) this;
    }
}
