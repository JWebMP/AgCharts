package com.jwebmp.plugins.agcharts.options.series;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Bubble series specific label options. Inherits generic label options and
 * acts as a placeholder for any future bubble-specific label properties.
  * @param <J> the self-referencing generic type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgBubbleSeriesLabelOptions<J extends AgBubbleSeriesLabelOptions<J>> extends AgSeriesLabelOptions<J> {
}
