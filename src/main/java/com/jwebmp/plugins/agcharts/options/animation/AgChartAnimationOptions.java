package com.jwebmp.plugins.agcharts.options.animation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Chart-level animation options for AG Charts 12.2.0.
 * 
 * Controls animation duration, easing, and behavior across chart updates and initial rendering.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgChartAnimationOptions<J extends AgChartAnimationOptions<J>> extends JavaScriptPart<J> {
    /** Enable/disable all animations. */
    private Boolean enabled;
    
    /** Duration of animations in milliseconds. */
    private Integer duration;
    
    /** Easing function name (e.g., "easeInOut", "linear"). */
    private String easing;

    public Boolean getEnabled() {
        return enabled;
    }

    public @org.jspecify.annotations.NonNull J setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return (J) this;
    }

    public Integer getDuration() {
        return duration;
    }

    public @org.jspecify.annotations.NonNull J setDuration(Integer duration) {
        this.duration = duration;
        return (J) this;
    }

    public String getEasing() {
        return easing;
    }

    public @org.jspecify.annotations.NonNull J setEasing(String easing) {
        this.easing = easing;
        return (J) this;
    }
}
