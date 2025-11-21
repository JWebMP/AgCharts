package com.jwebmp.plugins.agcharts.options.series;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;

import java.util.List;

/**
 * Pie Series options for AG Charts (community).
 *
 * Supports angle and optional radius keys, callout/sector labels, callout line,
 * title, colors arrays, per-sector styling, spacing and corner radius.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgPieSeriesOptions<J extends AgPieSeriesOptions<J>> extends AgSeriesBaseOptions<J> {

    // --- Required key ---
    private String angleKey; // DatumKey

    // --- Optional title ---
    private AgPieTitleOptions<?> title;

    // --- Labels & Callout Line ---
    private AgPieSeriesLabelOptions<?> calloutLabel;          // outside label options
    private AgPieSeriesSectorLabelOptions<?> sectorLabel;      // inside label options
    private AgPieSeriesCalloutOptions<?> calloutLine;          // line connecting sector to label

    // --- Colors ---
    private List<Object> fills;   // AgColorType[]; allow String or fill object
    private List<String> strokes; // CssColor[]

    // --- Opacity & Stroke ---
    private Double fillOpacity;   // 0..1
    private Double strokeOpacity; // 0..1
    private Integer strokeWidth;  // pixels

    // --- Geometry & Layout ---
    private Integer rotation;           // degrees
    private Integer outerRadiusOffset;  // pixels
    private Double outerRadiusRatio;    // ratio
    private Number radiusMin;           // override min radiusKey value
    private Number radiusMax;           // override max radiusKey value

    private AgDropShadowOptions<?> shadow;

    // tooltip inherited from base

    private Integer cornerRadius;       // per-sector corner radius
    private Integer sectorSpacing;      // spacing between sectors

    private Boolean hideZeroValueSectorsInLegend;

    // Per-sector line dash
    private List<Integer> lineDash;
    private Integer lineDashOffset;

    // --- Keys & Names ---
    private String radiusKey;       // DatumKey
    private String calloutLabelKey; // DatumKey
    private String sectorLabelKey;  // DatumKey
    private String legendItemKey;   // DatumKey

    private String angleName;       // human readable
    private String radiusName;
    private String calloutLabelName;
    private String sectorLabelName;

    // --- Identity & Data ---
    @JsonProperty("id")
    private String id;
    private List<?> data;
    private Boolean visible;

    private String cursor;            // CSS cursor
    private Object nodeClickRange;    // 'nearest' | 'exact' | number
    private Boolean showInLegend;
    private AgSeriesListeners<?> listeners;

    // highlight via base: setHighlight(...)

    public AgPieSeriesOptions() {
        setType("pie");
    }

    // --- Getters/Setters ---
    public String getAngleKey() { return angleKey; }
    public @org.jspecify.annotations.NonNull J setAngleKey(String angleKey) { this.angleKey = angleKey; return (J) this; }

    public AgPieTitleOptions<?> getTitle() { return title; }
    public @org.jspecify.annotations.NonNull J setTitle(AgPieTitleOptions<?> title) { this.title = title; return (J) this; }

    public AgPieSeriesLabelOptions<?> getCalloutLabel() { return calloutLabel; }
    public @org.jspecify.annotations.NonNull J setCalloutLabel(AgPieSeriesLabelOptions<?> calloutLabel) { this.calloutLabel = calloutLabel; return (J) this; }

    public AgPieSeriesSectorLabelOptions<?> getSectorLabel() { return sectorLabel; }
    public @org.jspecify.annotations.NonNull J setSectorLabel(AgPieSeriesSectorLabelOptions<?> sectorLabel) { this.sectorLabel = sectorLabel; return (J) this; }

    public AgPieSeriesCalloutOptions<?> getCalloutLine() { return calloutLine; }
    public @org.jspecify.annotations.NonNull J setCalloutLine(AgPieSeriesCalloutOptions<?> calloutLine) { this.calloutLine = calloutLine; return (J) this; }

    public List<Object> getFills() { return fills; }
    public @org.jspecify.annotations.NonNull J setFills(List<Object> fills) { this.fills = fills; return (J) this; }

    public List<String> getStrokes() { return strokes; }
    public @org.jspecify.annotations.NonNull J setStrokes(List<String> strokes) { this.strokes = strokes; return (J) this; }

    public Double getFillOpacity() { return fillOpacity; }
    public @org.jspecify.annotations.NonNull J setFillOpacity(Double fillOpacity) { this.fillOpacity = fillOpacity; return (J) this; }

    public Double getStrokeOpacity() { return strokeOpacity; }
    public @org.jspecify.annotations.NonNull J setStrokeOpacity(Double strokeOpacity) { this.strokeOpacity = strokeOpacity; return (J) this; }

    public Integer getStrokeWidth() { return strokeWidth; }
    public @org.jspecify.annotations.NonNull J setStrokeWidth(Integer strokeWidth) { this.strokeWidth = strokeWidth; return (J) this; }

    public Integer getRotation() { return rotation; }
    public @org.jspecify.annotations.NonNull J setRotation(Integer rotation) { this.rotation = rotation; return (J) this; }

    public Integer getOuterRadiusOffset() { return outerRadiusOffset; }
    public @org.jspecify.annotations.NonNull J setOuterRadiusOffset(Integer outerRadiusOffset) { this.outerRadiusOffset = outerRadiusOffset; return (J) this; }

    public Double getOuterRadiusRatio() { return outerRadiusRatio; }
    public @org.jspecify.annotations.NonNull J setOuterRadiusRatio(Double outerRadiusRatio) { this.outerRadiusRatio = outerRadiusRatio; return (J) this; }

    public Number getRadiusMin() { return radiusMin; }
    public @org.jspecify.annotations.NonNull J setRadiusMin(Number radiusMin) { this.radiusMin = radiusMin; return (J) this; }

    public Number getRadiusMax() { return radiusMax; }
    public @org.jspecify.annotations.NonNull J setRadiusMax(Number radiusMax) { this.radiusMax = radiusMax; return (J) this; }

    public AgDropShadowOptions<?> getShadow() { return shadow; }
    public @org.jspecify.annotations.NonNull J setShadow(AgDropShadowOptions<?> shadow) { this.shadow = shadow; return (J) this; }

    public Integer getCornerRadius() { return cornerRadius; }
    public @org.jspecify.annotations.NonNull J setCornerRadius(Integer cornerRadius) { this.cornerRadius = cornerRadius; return (J) this; }

    public Integer getSectorSpacing() { return sectorSpacing; }
    public @org.jspecify.annotations.NonNull J setSectorSpacing(Integer sectorSpacing) { this.sectorSpacing = sectorSpacing; return (J) this; }

    public Boolean getHideZeroValueSectorsInLegend() { return hideZeroValueSectorsInLegend; }
    public @org.jspecify.annotations.NonNull J setHideZeroValueSectorsInLegend(Boolean hideZeroValueSectorsInLegend) { this.hideZeroValueSectorsInLegend = hideZeroValueSectorsInLegend; return (J) this; }

    public List<Integer> getLineDash() { return lineDash; }
    public @org.jspecify.annotations.NonNull J setLineDash(List<Integer> lineDash) { this.lineDash = lineDash; return (J) this; }

    public Integer getLineDashOffset() { return lineDashOffset; }
    public @org.jspecify.annotations.NonNull J setLineDashOffset(Integer lineDashOffset) { this.lineDashOffset = lineDashOffset; return (J) this; }

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

    public Object getNodeClickRange() { return nodeClickRange; }
    public @org.jspecify.annotations.NonNull J setNodeClickRange(String range) { this.nodeClickRange = range; return (J) this; }
    public @org.jspecify.annotations.NonNull J setNodeClickRange(Integer pixels) { this.nodeClickRange = pixels; return (J) this; }

    public Boolean getShowInLegend() { return showInLegend; }
    public @org.jspecify.annotations.NonNull J setShowInLegend(Boolean showInLegend) { this.showInLegend = showInLegend; return (J) this; }

    public AgSeriesListeners<?> getListeners() { return listeners; }
    public @org.jspecify.annotations.NonNull J setListeners(AgSeriesListeners<?> listeners) { this.listeners = listeners; return (J) this; }
}
