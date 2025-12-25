package com.jwebmp.plugins.agcharts.options.highlight;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Chart-level highlight options for AG Charts 12.2.0.
 * 
 * Controls the appearance of highlighted/unhighlighted items and series across the entire chart.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgChartHighlightOptions<J extends AgChartHighlightOptions<J>> extends JavaScriptPart<J> {
    /** Styles applied to highlighted items. */
    private AgChartHighlightStyleOptions<?> highlightedItem;
    
    /** Styles applied to non-highlighted items within a highlighted series. */
    private AgChartHighlightStyleOptions<?> unhighlightedItem;
    
    /** Styles applied to the series containing the highlighted item. */
    private AgChartHighlightStyleOptions<?> highlightedSeries;
    
    /** Styles applied to series not containing the highlighted item. */
    private AgChartHighlightStyleOptions<?> unhighlightedSeries;

    /** The opacity of the series when it is dimmed. */
    private Double dimOpacity;

    public AgChartHighlightStyleOptions<?> getHighlightedItem() {
        return highlightedItem;
    }

    public @org.jspecify.annotations.NonNull J setHighlightedItem(AgChartHighlightStyleOptions<?> highlightedItem) {
        this.highlightedItem = highlightedItem;
        return (J) this;
    }

    public AgChartHighlightStyleOptions<?> getUnhighlightedItem() {
        return unhighlightedItem;
    }

    public @org.jspecify.annotations.NonNull J setUnhighlightedItem(AgChartHighlightStyleOptions<?> unhighlightedItem) {
        this.unhighlightedItem = unhighlightedItem;
        return (J) this;
    }

    public AgChartHighlightStyleOptions<?> getHighlightedSeries() {
        return highlightedSeries;
    }

    public @org.jspecify.annotations.NonNull J setHighlightedSeries(AgChartHighlightStyleOptions<?> highlightedSeries) {
        this.highlightedSeries = highlightedSeries;
        return (J) this;
    }

    public AgChartHighlightStyleOptions<?> getUnhighlightedSeries() {
        return unhighlightedSeries;
    }

    public @org.jspecify.annotations.NonNull J setUnhighlightedSeries(AgChartHighlightStyleOptions<?> unhighlightedSeries) {
        this.unhighlightedSeries = unhighlightedSeries;
        return (J) this;
    }

    public Double getDimOpacity() {
        return dimOpacity;
    }

    public @org.jspecify.annotations.NonNull J setDimOpacity(Double dimOpacity) {
        this.dimOpacity = dimOpacity;
        return (J) this;
    }
}
