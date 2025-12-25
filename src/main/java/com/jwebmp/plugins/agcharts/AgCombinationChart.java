package com.jwebmp.plugins.agcharts;

import com.jwebmp.plugins.agcharts.options.AgChartOptions;
import com.jwebmp.plugins.agcharts.options.axes.AgAxesOptions;
import com.jwebmp.plugins.agcharts.options.axes.AgAxisBaseOptions;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesBaseOptions;
import io.smallrye.mutiny.Uni;

import java.util.ArrayList;
import java.util.List;

/**
 * Convenience Combination Chart component.
 *
 * Mirrors the ChartJS-style component approach and allows combining heterogeneous
 * series types (bar, line, area, scatter, bubble) in a single chart. You can also
 * provide axis configurations (e.g., set a secondary axis and link via axis.keys).
 *
 * Example usage:
 *   AgCombinationChart chart = new AgCombinationChart("salesCombo")
 *       .addSeries(new AgBarSeriesOptions<>()
 *           .setXKey("year").setYKey("men"))
 *       .addSeries(new AgLineSeriesOptions<>()
 *           .setXKey("year").setYKey("portions"));
 *   chart.getAxes()
 *       .setCategory(new AgCategoryAxisOptions<>().setPosition(AgCartesianAxisPosition.BOTTOM))
 *       .setNumber(new AgNumberAxisOptions<>().setPosition(AgCartesianAxisPosition.LEFT).setKeys(List.of("men")));
 *   // Additional axes can be configured similarly.
 * </code>
 */
public class AgCombinationChart<J extends AgCombinationChart<J>> extends AgChart<J>
{
    private final List<AgSeriesBaseOptions<?>> series = new ArrayList<>();
    private AgAxesOptions<?> axes; // optional

    public AgCombinationChart(String id)
    {
        super(id);
    }

    /** Add a series of any supported type (bar, line, area, scatter, bubble). */
    public J addSeries(AgSeriesBaseOptions<?> s)
    {
        if (s != null)
        {
            this.series.add(s);
        }
        return (J) this;
    }

    /** Replace the series array entirely. */
    public @org.jspecify.annotations.NonNull J setSeries(List<AgSeriesBaseOptions<?>> series)
    {
        this.series.clear();
        if (series != null)
        {
            this.series.addAll(series);
        }
        return (J) this;
    }

    /** Optional: provide axes for primary/secondary configuration and customisation. */
    public @org.jspecify.annotations.NonNull J setAxes(AgAxesOptions<?> axes)
    {
        this.axes = axes;
        return (J) this;
    }

    public List<AgSeriesBaseOptions<?>> getSeries()
    {
        return series;
    }

    public AgAxesOptions<?> getAxes()
    {
        if (axes == null)
        {
            axes = new AgAxesOptions<>();
        }
        return axes;
    }

    @Override
    public Uni<AgChartOptions<?>> getInitialOptions(com.jwebmp.core.base.ajax.AjaxCall<?> call, com.jwebmp.core.base.ajax.AjaxResponse<?> response)
    {
        return Uni.createFrom().item(() -> {
            AgChartOptions<?> options = new AgChartOptions<>();
            if (!series.isEmpty())
            {
                options.setSeries(series);
            }
            if (axes != null)
            {
                options.setAxes(axes);
            }
            return options;
        });
    }
}
