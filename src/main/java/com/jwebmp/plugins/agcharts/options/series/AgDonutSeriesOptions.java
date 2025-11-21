package com.jwebmp.plugins.agcharts.options.series;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import java.util.List;

/**
 * Donut Series options for AG Charts (community).
 *
 * Mirrors the Pie/Donut API: supports angle and optional radius keys, inner labels/circle,
 * inner/outer radius ratios and offsets, multi-series layout via ratios, and styling.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgDonutSeriesOptions<J extends AgDonutSeriesOptions<J>> extends AgSeriesBaseOptions<J> {

    // --- Required keys ---
    private String angleKey; // DatumKey

    // --- Optional keys ---
    private String radiusKey;       // DatumKey
    private String calloutLabelKey; // DatumKey
    private String sectorLabelKey;  // DatumKey
    private String legendItemKey;   // DatumKey

    // --- Names for display ---
    private String angleName;
    private String radiusName;
    private String calloutLabelName;
    private String sectorLabelName;

    // --- Identity/Data/Visibility ---
    @JsonProperty("id")
    private String id;
    private List<?> data;
    private Boolean visible;

    // --- Cursor/Interaction/Legend/Listeners ---
    private String cursor;
    private Object context;
    private Object nodeClickRange; // 'nearest' | 'exact' | number
    private Boolean showInLegend;
    private com.jwebmp.plugins.agcharts.options.series.AgSeriesListeners<?> listeners;

    // --- Labels & Title & Callouts ---
    private AgDonutSeriesLabelOptions<?> calloutLabel;
    private AgDonutSeriesSectorLabelOptions<?> sectorLabel;
    private AgDonutSeriesCalloutOptions<?> calloutLine;
    private AgDonutTitleOptions<?> title;

    // --- Inner labels and inner circle ---
    private List<AgDonutInnerLabel<?>> innerLabels;
    private AgDonutInnerCircle<?> innerCircle;

    // --- Geometry ---
    private Integer rotation;            // degrees
    private Integer outerRadiusOffset;   // px
    private Double outerRadiusRatio;     // ratio
    private Integer innerRadiusOffset;   // px
    private Double innerRadiusRatio;     // ratio (default handled by runtime ~0.7)

    private Number radiusMin;            // override auto min for radiusKey
    private Number radiusMax;            // override auto max for radiusKey

    private Integer cornerRadius;        // sector rounding
    private Integer sectorSpacing;       // px spacing between sectors

    // --- Colors & Styling ---
    private List<String> fills;          // sector fill colours to cycle
    private List<String> strokes;        // sector stroke colours to cycle
    private Double fillOpacity;
    private Double strokeOpacity;
    private Integer strokeWidth;
    private java.util.List<Integer> lineDash;
    private Integer lineDashOffset;
    private AgDropShadowOptions<?> shadow;

    // --- Tooltip/Highlight inherited from base via setTooltip()/setHighlight() ---

    /** Per-item styler for sectors. */
    @JsonRawValue
    private String itemStyler;

    public AgDonutSeriesOptions() {
        setType("donut");
    }

    // --- Getters/Setters ---
    public String getAngleKey() { return angleKey; }
    public @org.jspecify.annotations.NonNull J setAngleKey(String angleKey) { this.angleKey = angleKey; return (J) this; }

    public String getRadiusKey() { return radiusKey; }
    public @org.jspecify.annotations.NonNull J setRadiusKey(String radiusKey) { this.radiusKey = radiusKey; return (J) this; }

    public String getCalloutLabelKey() { return calloutLabelKey; }
    public @org.jspecify.annotations.NonNull J setCalloutLabelKey(String calloutLabelKey) { this.calloutLabelKey = calloutLabelKey; return (J) this; }

    public String getSectorLabelKey() { return sectorLabelKey; }
    public @org.jspecify.annotations.NonNull J setSectorLabelKey(String sectorLabelKey) { this.sectorLabelKey = sectorLabelKey; return (J) this; }

    public String getLegendItemKey() { return legendItemKey; }
    public @org.jspecify.annotations.NonNull J setLegendItemKey(String legendItemKey) { this.legendItemKey = legendItemKey; return (J) this; }

    public String getAngleName() { return angleName; }
    public @org.jspecify.annotations.NonNull J setAngleName(String angleName) { this.angleName = angleName; return (J) this; }

    public String getRadiusName() { return radiusName; }
    public @org.jspecify.annotations.NonNull J setRadiusName(String radiusName) { this.radiusName = radiusName; return (J) this; }

    public String getCalloutLabelName() { return calloutLabelName; }
    public @org.jspecify.annotations.NonNull J setCalloutLabelName(String calloutLabelName) { this.calloutLabelName = calloutLabelName; return (J) this; }

    public String getSectorLabelName() { return sectorLabelName; }
    public @org.jspecify.annotations.NonNull J setSectorLabelName(String sectorLabelName) { this.sectorLabelName = sectorLabelName; return (J) this; }

    public String getId() { return id; }
    public @org.jspecify.annotations.NonNull J setId(String id) { this.id = id; setSeriesId(id); return (J) this; }

    public List<?> getData() { return data; }
    public @org.jspecify.annotations.NonNull J setData(List<?> data) { this.data = data; return (J) this; }

    public Boolean getVisible() { return visible; }
    public @org.jspecify.annotations.NonNull J setVisible(Boolean visible) { this.visible = visible; return (J) this; }

    public String getCursor() { return cursor; }
    public @org.jspecify.annotations.NonNull J setCursor(String cursor) { this.cursor = cursor; return (J) this; }

    public Object getContext() { return context; }
    public @org.jspecify.annotations.NonNull J setContext(Object context) { this.context = context; return (J) this; }

    public Object getNodeClickRange() { return nodeClickRange; }
    public @org.jspecify.annotations.NonNull J setNodeClickRange(String range) { this.nodeClickRange = range; return (J) this; }
    public @org.jspecify.annotations.NonNull J setNodeClickRange(Integer pixels) { this.nodeClickRange = pixels; return (J) this; }

    public Boolean getShowInLegend() { return showInLegend; }
    public @org.jspecify.annotations.NonNull J setShowInLegend(Boolean showInLegend) { this.showInLegend = showInLegend; return (J) this; }

    public com.jwebmp.plugins.agcharts.options.series.AgSeriesListeners<?> getListeners() { return listeners; }
    public @org.jspecify.annotations.NonNull J setListeners(com.jwebmp.plugins.agcharts.options.series.AgSeriesListeners<?> listeners) { this.listeners = listeners; return (J) this; }

    public AgDonutSeriesLabelOptions<?> getCalloutLabel() { return calloutLabel; }
    public @org.jspecify.annotations.NonNull J setCalloutLabel(AgDonutSeriesLabelOptions<?> calloutLabel) { this.calloutLabel = calloutLabel; return (J) this; }

    public AgDonutSeriesSectorLabelOptions<?> getSectorLabel() { return sectorLabel; }
    public @org.jspecify.annotations.NonNull J setSectorLabel(AgDonutSeriesSectorLabelOptions<?> sectorLabel) { this.sectorLabel = sectorLabel; return (J) this; }

    public AgDonutSeriesCalloutOptions<?> getCalloutLine() { return calloutLine; }
    public @org.jspecify.annotations.NonNull J setCalloutLine(AgDonutSeriesCalloutOptions<?> calloutLine) { this.calloutLine = calloutLine; return (J) this; }

    public AgDonutTitleOptions<?> getTitle() { return title; }
    public @org.jspecify.annotations.NonNull J setTitle(AgDonutTitleOptions<?> title) { this.title = title; return (J) this; }

    public List<AgDonutInnerLabel<?>> getInnerLabels() { return innerLabels; }
    public @org.jspecify.annotations.NonNull J setInnerLabels(List<AgDonutInnerLabel<?>> innerLabels) { this.innerLabels = innerLabels; return (J) this; }

    public AgDonutInnerCircle<?> getInnerCircle() { return innerCircle; }
    public @org.jspecify.annotations.NonNull J setInnerCircle(AgDonutInnerCircle<?> innerCircle) { this.innerCircle = innerCircle; return (J) this; }

    public Integer getRotation() { return rotation; }
    public @org.jspecify.annotations.NonNull J setRotation(Integer rotation) { this.rotation = rotation; return (J) this; }

    public Integer getOuterRadiusOffset() { return outerRadiusOffset; }
    public @org.jspecify.annotations.NonNull J setOuterRadiusOffset(Integer outerRadiusOffset) { this.outerRadiusOffset = outerRadiusOffset; return (J) this; }

    public Double getOuterRadiusRatio() { return outerRadiusRatio; }
    public @org.jspecify.annotations.NonNull J setOuterRadiusRatio(Double outerRadiusRatio) { this.outerRadiusRatio = outerRadiusRatio; return (J) this; }

    public Integer getInnerRadiusOffset() { return innerRadiusOffset; }
    public @org.jspecify.annotations.NonNull J setInnerRadiusOffset(Integer innerRadiusOffset) { this.innerRadiusOffset = innerRadiusOffset; return (J) this; }

    public Double getInnerRadiusRatio() { return innerRadiusRatio; }
    public @org.jspecify.annotations.NonNull J setInnerRadiusRatio(Double innerRadiusRatio) { this.innerRadiusRatio = innerRadiusRatio; return (J) this; }

    public Number getRadiusMin() { return radiusMin; }
    public @org.jspecify.annotations.NonNull J setRadiusMin(Number radiusMin) { this.radiusMin = radiusMin; return (J) this; }

    public Number getRadiusMax() { return radiusMax; }
    public @org.jspecify.annotations.NonNull J setRadiusMax(Number radiusMax) { this.radiusMax = radiusMax; return (J) this; }

    public Integer getCornerRadius() { return cornerRadius; }
    public @org.jspecify.annotations.NonNull J setCornerRadius(Integer cornerRadius) { this.cornerRadius = cornerRadius; return (J) this; }

    public Integer getSectorSpacing() { return sectorSpacing; }
    public @org.jspecify.annotations.NonNull J setSectorSpacing(Integer sectorSpacing) { this.sectorSpacing = sectorSpacing; return (J) this; }

    public List<String> getFills() { return fills; }
    public @org.jspecify.annotations.NonNull J setFills(List<String> fills) { this.fills = fills; return (J) this; }

    public List<String> getStrokes() { return strokes; }
    public @org.jspecify.annotations.NonNull J setStrokes(List<String> strokes) { this.strokes = strokes; return (J) this; }

    public Double getFillOpacity() { return fillOpacity; }
    public @org.jspecify.annotations.NonNull J setFillOpacity(Double fillOpacity) { this.fillOpacity = fillOpacity; return (J) this; }

    public Double getStrokeOpacity() { return strokeOpacity; }
    public @org.jspecify.annotations.NonNull J setStrokeOpacity(Double strokeOpacity) { this.strokeOpacity = strokeOpacity; return (J) this; }

    public Integer getStrokeWidth() { return strokeWidth; }
    public @org.jspecify.annotations.NonNull J setStrokeWidth(Integer strokeWidth) { this.strokeWidth = strokeWidth; return (J) this; }

    public java.util.List<Integer> getLineDash() { return lineDash; }
    public @org.jspecify.annotations.NonNull J setLineDash(java.util.List<Integer> lineDash) { this.lineDash = lineDash; return (J) this; }

    public Integer getLineDashOffset() { return lineDashOffset; }
    public @org.jspecify.annotations.NonNull J setLineDashOffset(Integer lineDashOffset) { this.lineDashOffset = lineDashOffset; return (J) this; }

    public AgDropShadowOptions<?> getShadow() { return shadow; }
    public @org.jspecify.annotations.NonNull J setShadow(AgDropShadowOptions<?> shadow) { this.shadow = shadow; return (J) this; }

    public String getItemStyler() { return itemStyler; }
    public @org.jspecify.annotations.NonNull J setItemStyler(String itemStyler) { this.itemStyler = itemStyler; return (J) this; }
}
