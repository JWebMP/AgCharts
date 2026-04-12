package com.jwebmp.plugins.agcharts.options.theme;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesLabelOptions;

/**
 * Series-level override container supporting a 'styler' callback.
  * @param <J> the self-referencing generic type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgChartThemeSeriesOverride<J extends AgChartThemeSeriesOverride<J>> extends JavaScriptPart<J> {
    /** JS function(params) returning an object of series style props. */
    @JsonRawValue
    private String styler;

    /** Highlight configuration to apply to all series of this type via theme overrides. */
    private com.jwebmp.plugins.agcharts.options.series.AgSeriesHighlightOptions<?> highlight;

    /** Label options applied via theme overrides (e.g., overrides.bar.series.label). */
    private AgSeriesLabelOptions<?> label;

    // Pie/Donut specific themeable options (kept generic to allow both pie and donut types)
    /** For pie/donut: outside labels (callout labels). */
    private JavaScriptPart<?> calloutLabel;
    /** For pie/donut: inside labels (sector labels). */
    private JavaScriptPart<?> sectorLabel;
    /** For pie/donut: callout line joining sector and label. */
    private JavaScriptPart<?> calloutLine;

    public String getStyler() {
        return styler;
    }

    public @org.jspecify.annotations.NonNull J setStyler(String styler) {
        this.styler = styler;
        return (J) this;
    }

    public com.jwebmp.plugins.agcharts.options.series.AgSeriesHighlightOptions<?> getHighlight() {
        return highlight;
    }

    public @org.jspecify.annotations.NonNull J setHighlight(com.jwebmp.plugins.agcharts.options.series.AgSeriesHighlightOptions<?> highlight) {
        this.highlight = highlight;
        return (J) this;
    }

    public AgSeriesLabelOptions<?> getLabel() {
        return label;
    }

    public @org.jspecify.annotations.NonNull J setLabel(AgSeriesLabelOptions<?> label) {
        this.label = label;
        return (J) this;
    }

    public JavaScriptPart<?> getCalloutLabel() {
        return calloutLabel;
    }

    public @org.jspecify.annotations.NonNull J setCalloutLabel(JavaScriptPart<?> calloutLabel) {
        this.calloutLabel = calloutLabel;
        return (J) this;
    }

    public JavaScriptPart<?> getSectorLabel() {
        return sectorLabel;
    }

    public @org.jspecify.annotations.NonNull J setSectorLabel(JavaScriptPart<?> sectorLabel) {
        this.sectorLabel = sectorLabel;
        return (J) this;
    }

    public JavaScriptPart<?> getCalloutLine() {
        return calloutLine;
    }

    public @org.jspecify.annotations.NonNull J setCalloutLine(JavaScriptPart<?> calloutLine) {
        this.calloutLine = calloutLine;
        return (J) this;
    }
}
