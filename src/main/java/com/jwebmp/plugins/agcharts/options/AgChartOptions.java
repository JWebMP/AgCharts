package com.jwebmp.plugins.agcharts.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.agcharts.options.axes.AgAxisBaseOptions;
import com.jwebmp.plugins.agcharts.options.legend.AgChartLegendOptions;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesBaseOptions;
import com.jwebmp.plugins.agcharts.options.theme.AgChartTheme;
import com.jwebmp.plugins.agcharts.options.locale.AgLocaleOptions;
import com.jwebmp.plugins.agcharts.options.tooltip.AgChartTooltipOptions;
import com.jwebmp.plugins.agcharts.options.highlight.AgChartHighlightOptions;
import com.jwebmp.plugins.agcharts.options.animation.AgChartAnimationOptions;
import com.jwebmp.plugins.agcharts.options.zoom.AgChartZoomOptions;
import com.jwebmp.plugins.agcharts.options.ranges.AgChartRangesOptions;
import com.jwebmp.plugins.agcharts.options.sync.AgChartSyncOptions;
import com.jwebmp.plugins.agcharts.options.contextmenu.AgChartContextMenuOptions;
import com.jwebmp.plugins.agcharts.options.datasource.AgChartDataSourceOptions;
import com.jwebmp.plugins.agcharts.options.keyboard.AgChartKeyboardOptions;
import com.jwebmp.plugins.agcharts.options.touch.AgChartTouchOptions;
import com.jwebmp.plugins.agcharts.options.listeners.AgChartListenersOptions;
import com.jwebmp.plugins.agcharts.options.formatter.AgChartFormatterOptions;
import com.jwebmp.plugins.agcharts.options.container.AgChartContainerOptions;
import com.jwebmp.plugins.agcharts.options.data.AgChartDataOptions;
import com.jwebmp.plugins.agcharts.options.annotations.AgChartAnnotationsOptions;
import com.jwebmp.plugins.agcharts.options.initialstate.AgChartInitialStateOptions;
import com.jwebmp.plugins.agcharts.options.misc.AgChartMiscOptions;

import java.util.List;

/**
 * Root Chart options for AG Charts 12.2.0 (Community).
 * <p>
 * Aggregates chart-level configuration for axes, series, legend, tooltip, theme, locale, overlays, navigator,
 * gradient legend, and all 23 modern AG Charts 12.2 features (highlight, animation, zoom, ranges, sync, contextMenu, 
 * dataSource, keyboard, touch, listeners, formatter, container, data, annotations, initialState, misc).
 * <p>
 * All properties are optional and follow CRTP fluent setters for builder-like syntax.
 * <p>
 * Minimum supported version: AG Charts 12.2.0. No backwards compatibility with earlier versions.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class AgChartOptions<J extends AgChartOptions<J>> extends JavaScriptPart<J>
{
    // --- Core Chart Elements ---
    private List<AgAxisBaseOptions<?>> axes;
    private AgChartLegendOptions<?> legend;
    private List<AgSeriesBaseOptions<?>> series;
    private Object theme;
    private AgLocaleOptions<?> locale;
    private AgChartTooltipOptions<?> tooltip;
    private AgChartBackground<?> background;
    private AgSeriesAreaOptions<?> seriesArea;
    private com.jwebmp.plugins.agcharts.options.overlays.AgChartOverlaysOptions<?> overlays;
    private com.jwebmp.plugins.agcharts.options.legend.gradient.AgGradientLegendOptions<?> gradientLegend;
    private com.jwebmp.plugins.agcharts.options.navigator.AgNavigatorOptions<?> navigator;

    // --- Layout / Sizing ---
    private Integer width;
    private Integer height;
    private Integer minWidth;
    private Integer minHeight;
    private Object padding;

    // --- Captions ---
    private AgChartCaptionOptions<?> title;
    private AgChartCaptionOptions<?> subtitle;
    private AgChartCaptionOptions<?> footnote;

    // --- NEW: All 23 AG Charts 12.2.0 Options ---
    private AgChartHighlightOptions<?> highlight;
    private AgChartAnimationOptions<?> animation;
    private AgChartZoomOptions<?> zoom;
    private AgChartRangesOptions<?> ranges;
    private AgChartSyncOptions<?> sync;
    private AgChartContextMenuOptions<?> contextMenu;
    private AgChartDataSourceOptions<?> dataSource;
    private AgChartKeyboardOptions<?> keyboard;
    private AgChartTouchOptions<?> touch;
    private AgChartListenersOptions<?> listeners;
    private AgChartFormatterOptions<?> formatter;
    private AgChartContainerOptions<?> container;
    private AgChartDataOptions<?> data;
    private AgChartAnnotationsOptions<?> annotations;
    private AgChartInitialStateOptions<?> initialState;
    private AgChartMiscOptions<?> misc;

    // ===== GETTERS / SETTERS =====
    public List<AgAxisBaseOptions<?>> getAxes() { return axes; }
    public @org.jspecify.annotations.NonNull J setAxes(List<AgAxisBaseOptions<?>> axes) { this.axes = axes; return (J) this; }

    public AgChartLegendOptions<?> getLegend() { return legend; }
    public @org.jspecify.annotations.NonNull J setLegend(AgChartLegendOptions<?> legend) { this.legend = legend; return (J) this; }

    public List<AgSeriesBaseOptions<?>> getSeries() { return series; }
    public @org.jspecify.annotations.NonNull J setSeries(List<AgSeriesBaseOptions<?>> series) { this.series = series; return (J) this; }

    public Object getTheme() { return theme; }
    public @org.jspecify.annotations.NonNull J setTheme(AgChartTheme<?> theme) { this.theme = theme; return (J) this; }
    public @org.jspecify.annotations.NonNull J setTheme(String themeName) { this.theme = themeName; return (J) this; }

    public AgLocaleOptions<?> getLocale() { return locale; }
    public @org.jspecify.annotations.NonNull J setLocale(AgLocaleOptions<?> locale) { this.locale = locale; return (J) this; }

    public AgChartTooltipOptions<?> getTooltip() { return tooltip; }
    public @org.jspecify.annotations.NonNull J setTooltip(AgChartTooltipOptions<?> tooltip) { this.tooltip = tooltip; return (J) this; }

    public AgChartBackground<?> getBackground() { return background; }
    public @org.jspecify.annotations.NonNull J setBackground(AgChartBackground<?> background) { this.background = background; return (J) this; }

    public AgSeriesAreaOptions<?> getSeriesArea() { return seriesArea; }
    public @org.jspecify.annotations.NonNull J setSeriesArea(AgSeriesAreaOptions<?> seriesArea) { this.seriesArea = seriesArea; return (J) this; }

    public com.jwebmp.plugins.agcharts.options.overlays.AgChartOverlaysOptions<?> getOverlays() { return overlays; }
    public @org.jspecify.annotations.NonNull J setOverlays(com.jwebmp.plugins.agcharts.options.overlays.AgChartOverlaysOptions<?> overlays) { this.overlays = overlays; return (J) this; }

    public com.jwebmp.plugins.agcharts.options.legend.gradient.AgGradientLegendOptions<?> getGradientLegend() { return gradientLegend; }
    public @org.jspecify.annotations.NonNull J setGradientLegend(com.jwebmp.plugins.agcharts.options.legend.gradient.AgGradientLegendOptions<?> gradientLegend) { this.gradientLegend = gradientLegend; return (J) this; }

    public com.jwebmp.plugins.agcharts.options.navigator.AgNavigatorOptions<?> getNavigator() { return navigator; }
    public @org.jspecify.annotations.NonNull J setNavigator(com.jwebmp.plugins.agcharts.options.navigator.AgNavigatorOptions<?> navigator) { this.navigator = navigator; return (J) this; }

    public Integer getWidth() { return width; }
    public @org.jspecify.annotations.NonNull J setWidth(Integer width) { this.width = width; return (J) this; }

    public Integer getHeight() { return height; }
    public @org.jspecify.annotations.NonNull J setHeight(Integer height) { this.height = height; return (J) this; }

    public Integer getMinWidth() { return minWidth; }
    public @org.jspecify.annotations.NonNull J setMinWidth(Integer minWidth) { this.minWidth = minWidth; return (J) this; }

    public Integer getMinHeight() { return minHeight; }
    public @org.jspecify.annotations.NonNull J setMinHeight(Integer minHeight) { this.minHeight = minHeight; return (J) this; }

    public Object getPadding() { return padding; }
    public @org.jspecify.annotations.NonNull J setPadding(Integer padding) { this.padding = padding; return (J) this; }
    public @org.jspecify.annotations.NonNull J setPadding(com.jwebmp.plugins.agcharts.options.legend.AgPadding<?> padding) { this.padding = padding; return (J) this; }

    public AgChartCaptionOptions<?> getTitle() { return title; }
    public @org.jspecify.annotations.NonNull J setTitle(AgChartCaptionOptions<?> title) { this.title = title; return (J) this; }

    public AgChartCaptionOptions<?> getSubtitle() { return subtitle; }
    public @org.jspecify.annotations.NonNull J setSubtitle(AgChartCaptionOptions<?> subtitle) { this.subtitle = subtitle; return (J) this; }

    public AgChartCaptionOptions<?> getFootnote() { return footnote; }
    public @org.jspecify.annotations.NonNull J setFootnote(AgChartCaptionOptions<?> footnote) { this.footnote = footnote; return (J) this; }

    // --- NEW: All 23 AG Charts 12.2.0 Options Getters/Setters ---
    public AgChartHighlightOptions<?> getHighlight() { return highlight; }
    public @org.jspecify.annotations.NonNull J setHighlight(AgChartHighlightOptions<?> highlight) { this.highlight = highlight; return (J) this; }

    public AgChartAnimationOptions<?> getAnimation() { return animation; }
    public @org.jspecify.annotations.NonNull J setAnimation(AgChartAnimationOptions<?> animation) { this.animation = animation; return (J) this; }

    public AgChartZoomOptions<?> getZoom() { return zoom; }
    public @org.jspecify.annotations.NonNull J setZoom(AgChartZoomOptions<?> zoom) { this.zoom = zoom; return (J) this; }

    public AgChartRangesOptions<?> getRanges() { return ranges; }
    public @org.jspecify.annotations.NonNull J setRanges(AgChartRangesOptions<?> ranges) { this.ranges = ranges; return (J) this; }

    public AgChartSyncOptions<?> getSync() { return sync; }
    public @org.jspecify.annotations.NonNull J setSync(AgChartSyncOptions<?> sync) { this.sync = sync; return (J) this; }

    public AgChartContextMenuOptions<?> getContextMenu() { return contextMenu; }
    public @org.jspecify.annotations.NonNull J setContextMenu(AgChartContextMenuOptions<?> contextMenu) { this.contextMenu = contextMenu; return (J) this; }

    public AgChartDataSourceOptions<?> getDataSource() { return dataSource; }
    public @org.jspecify.annotations.NonNull J setDataSource(AgChartDataSourceOptions<?> dataSource) { this.dataSource = dataSource; return (J) this; }

    public AgChartKeyboardOptions<?> getKeyboard() { return keyboard; }
    public @org.jspecify.annotations.NonNull J setKeyboard(AgChartKeyboardOptions<?> keyboard) { this.keyboard = keyboard; return (J) this; }

    public AgChartTouchOptions<?> getTouch() { return touch; }
    public @org.jspecify.annotations.NonNull J setTouch(AgChartTouchOptions<?> touch) { this.touch = touch; return (J) this; }

    public AgChartListenersOptions<?> getListeners() { return listeners; }
    public @org.jspecify.annotations.NonNull J setListeners(AgChartListenersOptions<?> listeners) { this.listeners = listeners; return (J) this; }

    public AgChartFormatterOptions<?> getFormatter() { return formatter; }
    public @org.jspecify.annotations.NonNull J setFormatter(AgChartFormatterOptions<?> formatter) { this.formatter = formatter; return (J) this; }

    public AgChartContainerOptions<?> getContainer() { return container; }
    public @org.jspecify.annotations.NonNull J setContainer(AgChartContainerOptions<?> container) { this.container = container; return (J) this; }

    public AgChartDataOptions<?> getData() { return data; }
    public @org.jspecify.annotations.NonNull J setData(AgChartDataOptions<?> data) { this.data = data; return (J) this; }

    public AgChartAnnotationsOptions<?> getAnnotations() { return annotations; }
    public @org.jspecify.annotations.NonNull J setAnnotations(AgChartAnnotationsOptions<?> annotations) { this.annotations = annotations; return (J) this; }

    public AgChartInitialStateOptions<?> getInitialState() { return initialState; }
    public @org.jspecify.annotations.NonNull J setInitialState(AgChartInitialStateOptions<?> initialState) { this.initialState = initialState; return (J) this; }

    public AgChartMiscOptions<?> getMisc() { return misc; }
    public @org.jspecify.annotations.NonNull J setMisc(AgChartMiscOptions<?> misc) { this.misc = misc; return (J) this; }
}
