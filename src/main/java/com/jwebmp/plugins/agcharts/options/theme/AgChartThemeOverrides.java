package com.jwebmp.plugins.agcharts.options.theme;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Aggregates overrides per series type. Expand with other types as needed.
  * @param <J> the self-referencing generic type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgChartThemeOverrides<J extends AgChartThemeOverrides<J>> extends JavaScriptPart<J> {
    private AgChartThemeSeriesGroupOverride<?> bar;
    private AgChartThemeSeriesGroupOverride<?> line;
    private AgChartThemeSeriesGroupOverride<?> area;
    private AgChartThemeSeriesGroupOverride<?> scatter;
    private AgChartThemeSeriesGroupOverride<?> bubble;
    private AgChartThemeSeriesGroupOverride<?> histogram;
    private AgChartThemeSeriesGroupOverride<?> pie;
    private AgChartThemeSeriesGroupOverride<?> donut;

    public AgChartThemeSeriesGroupOverride<?> getBar() {
        return bar;
    }

    public @org.jspecify.annotations.NonNull J setBar(AgChartThemeSeriesGroupOverride<?> bar) {
        this.bar = bar;
        return (J) this;
    }

    public AgChartThemeSeriesGroupOverride<?> getLine() {
        return line;
    }

    public @org.jspecify.annotations.NonNull J setLine(AgChartThemeSeriesGroupOverride<?> line) {
        this.line = line;
        return (J) this;
    }

    public AgChartThemeSeriesGroupOverride<?> getArea() {
        return area;
    }

    public @org.jspecify.annotations.NonNull J setArea(AgChartThemeSeriesGroupOverride<?> area) {
        this.area = area;
        return (J) this;
    }

    public AgChartThemeSeriesGroupOverride<?> getScatter() {
        return scatter;
    }

    public @org.jspecify.annotations.NonNull J setScatter(AgChartThemeSeriesGroupOverride<?> scatter) {
        this.scatter = scatter;
        return (J) this;
    }

    public AgChartThemeSeriesGroupOverride<?> getBubble() {
        return bubble;
    }

    public @org.jspecify.annotations.NonNull J setBubble(AgChartThemeSeriesGroupOverride<?> bubble) {
        this.bubble = bubble;
        return (J) this;
    }

    public AgChartThemeSeriesGroupOverride<?> getHistogram() {
        return histogram;
    }

    public @org.jspecify.annotations.NonNull J setHistogram(AgChartThemeSeriesGroupOverride<?> histogram) {
        this.histogram = histogram;
        return (J) this;
    }

    public AgChartThemeSeriesGroupOverride<?> getPie() {
        return pie;
    }

    public @org.jspecify.annotations.NonNull J setPie(AgChartThemeSeriesGroupOverride<?> pie) {
        this.pie = pie;
        return (J) this;
    }

    public AgChartThemeSeriesGroupOverride<?> getDonut() {
        return donut;
    }

    public @org.jspecify.annotations.NonNull J setDonut(AgChartThemeSeriesGroupOverride<?> donut) {
        this.donut = donut;
        return (J) this;
    }
}
