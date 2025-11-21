package com.jwebmp.plugins.agcharts.options.formatters;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Per-property formatter format strings for the chart-level formatter.
 * Each field may be set to a static format string appropriate for the property/domain.
 * Examples:
 *  - Time: "%b %Y"
 *  - Number: "$#{0>6.2f}"
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgChartPropertyFormatterFormats<J extends AgChartPropertyFormatterFormats<J>> extends JavaScriptPart<J>
{
    private String x;
    private String y;
    private String angle;
    private String radius;
    private String size;
    private String color;
    private String label;
    private String secondaryLabel;
    private String calloutLabel;
    private String sectorLabel;

    public String getX() { return x; }
    public @org.jspecify.annotations.NonNull J setX(String x) { this.x = x; return (J) this; }

    public String getY() { return y; }
    public @org.jspecify.annotations.NonNull J setY(String y) { this.y = y; return (J) this; }

    public String getAngle() { return angle; }
    public @org.jspecify.annotations.NonNull J setAngle(String angle) { this.angle = angle; return (J) this; }

    public String getRadius() { return radius; }
    public @org.jspecify.annotations.NonNull J setRadius(String radius) { this.radius = radius; return (J) this; }

    public String getSize() { return size; }
    public @org.jspecify.annotations.NonNull J setSize(String size) { this.size = size; return (J) this; }

    public String getColor() { return color; }
    public @org.jspecify.annotations.NonNull J setColor(String color) { this.color = color; return (J) this; }

    public String getLabel() { return label; }
    public @org.jspecify.annotations.NonNull J setLabel(String label) { this.label = label; return (J) this; }

    public String getSecondaryLabel() { return secondaryLabel; }
    public @org.jspecify.annotations.NonNull J setSecondaryLabel(String secondaryLabel) { this.secondaryLabel = secondaryLabel; return (J) this; }

    public String getCalloutLabel() { return calloutLabel; }
    public @org.jspecify.annotations.NonNull J setCalloutLabel(String calloutLabel) { this.calloutLabel = calloutLabel; return (J) this; }

    public String getSectorLabel() { return sectorLabel; }
    public @org.jspecify.annotations.NonNull J setSectorLabel(String sectorLabel) { this.sectorLabel = sectorLabel; return (J) this; }
}
