package com.jwebmp.plugins.agcharts.options.listeners;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Chart-level event listeners for AG Charts 12.2.0.
 * 
 * Defines callback handlers for chart events (click, hover, selection, etc.).
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgChartListenersOptions<J extends AgChartListenersOptions<J>> extends JavaScriptPart<J> {
    /** Raw JavaScript function for handling chart click events. */
    @JsonRawValue
    private String onClick;
    
    /** Raw JavaScript function for handling hover/highlight events. */
    @JsonRawValue
    private String onHighlight;
    
    /** Raw JavaScript function for handling selection events. */
    @JsonRawValue
    private String onSelection;

    public String getOnClick() {
        return onClick;
    }

    public @org.jspecify.annotations.NonNull J setOnClick(String onClick) {
        this.onClick = onClick;
        return (J) this;
    }

    public String getOnHighlight() {
        return onHighlight;
    }

    public @org.jspecify.annotations.NonNull J setOnHighlight(String onHighlight) {
        this.onHighlight = onHighlight;
        return (J) this;
    }

    public String getOnSelection() {
        return onSelection;
    }

    public @org.jspecify.annotations.NonNull J setOnSelection(String onSelection) {
        this.onSelection = onSelection;
        return (J) this;
    }
}
