package com.jwebmp.plugins.agcharts.options.axes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Options for axes in AG Charts 13.0.0.
 * In v13, axes can be configured as an object where keys are axis types or identifiers.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@SuppressWarnings("unchecked")
public class AgAxesOptions<J extends AgAxesOptions<J>> extends JavaScriptPart<J> {
    private AgNumberAxisOptions<?> number;
    private AgCategoryAxisOptions<?> category;
    private AgTimeAxisOptions<?> time;
    private AgLogAxisOptions<?> log;
    private AgGroupedCategoryAxisOptions<?> groupedCategory;

    // Polar Axes (Enterprise)
    private JavaScriptPart<?> angle;
    private JavaScriptPart<?> radius;

    public AgNumberAxisOptions<?> getNumber() {
        return number;
    }

    public @org.jspecify.annotations.NonNull J setNumber(AgNumberAxisOptions<?> number) {
        this.number = number;
        return (J) this;
    }

    public AgCategoryAxisOptions<?> getCategory() {
        return category;
    }

    public @org.jspecify.annotations.NonNull J setCategory(AgCategoryAxisOptions<?> category) {
        this.category = category;
        return (J) this;
    }

    public AgTimeAxisOptions<?> getTime() {
        return time;
    }

    public @org.jspecify.annotations.NonNull J setTime(AgTimeAxisOptions<?> time) {
        this.time = time;
        return (J) this;
    }

    public AgLogAxisOptions<?> getLog() {
        return log;
    }

    public @org.jspecify.annotations.NonNull J setLog(AgLogAxisOptions<?> log) {
        this.log = log;
        return (J) this;
    }

    public AgGroupedCategoryAxisOptions<?> getGroupedCategory() {
        return groupedCategory;
    }

    public @org.jspecify.annotations.NonNull J setGroupedCategory(AgGroupedCategoryAxisOptions<?> groupedCategory) {
        this.groupedCategory = groupedCategory;
        return (J) this;
    }

    public JavaScriptPart<?> getAngle() {
        return angle;
    }

    public @org.jspecify.annotations.NonNull J setAngle(JavaScriptPart<?> angle) {
        this.angle = angle;
        return (J) this;
    }

    public JavaScriptPart<?> getRadius() {
        return radius;
    }

    public @org.jspecify.annotations.NonNull J setRadius(JavaScriptPart<?> radius) {
        this.radius = radius;
        return (J) this;
    }
}
