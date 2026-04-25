# JWebMP AG Charts

[![Maven Central](https://img.shields.io/maven-central/v/com.jwebmp.plugins/agcharts)](https://central.sonatype.com/artifact/com.jwebmp.plugins/agcharts)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue)](https://www.apache.org/licenses/LICENSE-2.0)

![Java 25+](https://img.shields.io/badge/Java-25%2B-green)
![Modular](https://img.shields.io/badge/Modular-JPMS-green)
![Angular](https://img.shields.io/badge/Angular-20-DD0031?logo=angular)
![TypeScript](https://img.shields.io/badge/TypeScript-5-3178C6?logo=typescript)

<!-- Tech icons row -->
![AG Charts](https://img.shields.io/badge/AG_Charts-13.1.0-0084FF)
![JWebMP](https://img.shields.io/badge/JWebMP-2.0-0A7)

Enterprise-grade charting library integration for JWebMP with Angular 21. Provides CRTP-based fluent Java API for AG Charts 13.1.0 with full TypeScript type generation, reactive data binding, and server-side chart configuration.

Built on [AG Charts 13.1.0](https://charts.ag-grid.com/) · [Angular 21](https://angular.dev/) · [JWebMP Core](https://jwebmp.com/) · JPMS module `com.jwebmp.plugins.agcharts` · Java 25+

**Version: 13.1.0** — Full AG Charts 13.1.0 API compliance with 38/38 chart options implemented.

## 📦 Installation

```xml
<dependency>
  <groupId>com.jwebmp.plugins</groupId>
  <artifactId>agcharts</artifactId>
  <version>2.0.0-RC9</version>
</dependency>
```

<details>
<summary>Gradle (Kotlin DSL)</summary>

```kotlin
implementation("com.jwebmp.plugins:agcharts:2.0.0-RC9")
```
</details>

### NPM Dependencies

The plugin automatically includes AG Charts dependencies:

```json
{
  "dependencies": {
    "ag-charts-angular": "^13.1.0",
    "ag-charts-community": "^13.1.0"
  }
}
```

## ✨ Features

- **Complete AG Charts 13.1.0 API** — All 38 official chart options implemented with type-safe Java models
- **CRTP Fluent Builders** — Type-safe, self-referencing fluent setters for intuitive chart configuration
- **Angular 21 Integration** — Seamless integration with Angular components via JWebMP annotations
- **TypeScript Type Generation** — Automatic TypeScript interface generation from Java models
- **Reactive Data Binding** — Real-time chart updates via Angular data bindings and observables
- **Server-Side Configuration** — Define charts in Java with automatic client-side rendering
- **Multiple Chart Types** — Line, Bar, Area, Scatter, Bubble, Pie, Donut, Histogram, and more
- **Advanced Axes** — Number, Time, Log, Category, Grouped Category, Ordinal Time axes
- **Rich Interactions** — Tooltips, legends, zoom, pan, highlighting, animations, context menus
- **Theming Support** — Built-in themes (Material, Polychrome, Vivid, Solar) with custom theme API
- **Gradient Legends** — Specialized gradient legends for heatmaps and continuous color scales
- **Navigator Component** — Mini-chart navigator for large datasets with zoom controls
- **Overlays & Annotations** — Custom overlays, chart annotations, and watermarks
- **JPMS Modular** — Full Java Platform Module System support with explicit dependencies

## 🚀 Quick Start

### Basic Line Chart

```java
@NgComponent
public class LineChartComponent implements INgComponent<LineChartComponent> {

    @Override
    public String render() {
        AgChartOptions<LineChartComponent> options = new AgChartOptions<>(this)
            .setData("""
                [
                    { month: 'Jan', sales: 100 },
                    { month: 'Feb', sales: 150 },
                    { month: 'Mar', sales: 130 }
                ]
                """)
            .setSeries(List.of(
                new AgLineSeriesOptions<>()
                    .setXKey("month")
                    .setYKey("sales")
                    .setYName("Sales")
            ))
            .setAxes(List.of(
                new AgCategoryAxisOptions<>()
                    .setType("category")
                    .setPosition(AgCartesianAxisPosition.BOTTOM),
                new AgNumberAxisOptions<>()
                    .setType("number")
                    .setPosition(AgCartesianAxisPosition.LEFT)
            ));

        return """
            <ag-charts-angular
                [options]="chartOptions">
            </ag-charts-angular>
            """;
    }
}
```

### Multi-Series Bar Chart

```java
AgChartOptions<MyComponent> options = new AgChartOptions<>(this)
    .setTitle(new AgChartCaptionOptions<>()
        .setText("Quarterly Sales by Region"))
    .setData(salesData)
    .setSeries(List.of(
        new AgBarSeriesOptions<>()
            .setXKey("quarter")
            .setYKey("north")
            .setYName("North Region"),
        new AgBarSeriesOptions<>()
            .setXKey("quarter")
            .setYKey("south")
            .setYName("South Region")
    ))
    .setLegend(new AgChartLegendOptions<>()
        .setEnabled(true)
        .setPosition(new AgChartLegendPositionOptions<>()
            .setPosition("bottom")));
```

### Pie Chart with Donut

```java
AgChartOptions<MyComponent> options = new AgChartOptions<>(this)
    .setData(categoryData)
    .setSeries(List.of(
        new AgDonutSeriesOptions<>()
            .setAngleKey("value")
            .setCalloutLabelKey("category")
            .setInnerRadiusRatio(0.7)
            .setInnerLabels(List.of(
                new AgDonutInnerLabel<>()
                    .setText("Total")
                    .setFontSize(24)
            ))
    ))
    .setTitle(new AgChartCaptionOptions<>()
        .setText("Market Share by Category"));
```

## 📐 Architecture

### AG Charts 13.1.0 Options — Complete Implementation ✅

All 38 official AG Charts 13.1.0 options are implemented:

#### Core Chart Elements (19 options)

| Option | Description | Java Class |
|---|---|---|
| `axes` | Chart axes configuration | `AgNumberAxisOptions`, `AgCategoryAxisOptions`, `AgTimeAxisOptions`, etc. |
| `series` | Data series (line, bar, pie, etc.) | `AgLineSeriesOptions`, `AgBarSeriesOptions`, `AgPieSeriesOptions`, etc. |
| `legend` | Chart legend configuration | `AgChartLegendOptions` |
| `tooltip` | Tooltip behavior and styling | `AgChartTooltipOptions` |
| `theme` | Chart theme (built-in or custom) | `AgChartTheme`, `AgChartThemeName` |
| `locale` | Localization settings | `AgLocaleOptions` |
| `background` | Chart background styling | `AgChartBackground` |
| `seriesArea` | Series area background | `AgSeriesAreaOptions` |
| `overlays` | Custom overlays and watermarks | `AgChartOverlaysOptions` |
| `navigator` | Mini-chart navigator | `AgNavigatorOptions` |
| `gradientLegend` | Gradient legend for continuous scales | `AgGradientLegendOptions` |
| `width` | Chart width | `Integer` |
| `height` | Chart height | `Integer` |
| `minWidth` | Minimum chart width | `Integer` |
| `minHeight` | Minimum chart height | `Integer` |
| `padding` | Chart padding | `AgPadding` |
| `title` | Chart title | `AgChartCaptionOptions` |
| `subtitle` | Chart subtitle | `AgChartCaptionOptions` |
| `footnote` | Chart footnote | `AgChartCaptionOptions` |

#### Interactions & Features (19 options)

| Option | Description | Java Class |
|---|---|---|
| `highlight` | Chart-level highlighting | `AgHighlightOptions` |
| `animation` | Animation configuration | `AgAnimationOptions` |
| `zoom` | Zoom and pan control | `AgZoomOptions` |
| `ranges` | Preset range buttons | `AgRangesOptions` |
| `sync` | Multi-chart synchronization | `AgSyncOptions` |
| `contextMenu` | Context menu control | `AgContextMenuOptions` |
| `dataSource` | Data source adapter | `AgDataSourceOptions` |
| `keyboard` | Keyboard input control | `AgKeyboardOptions` |
| `touch` | Touch gesture control | `AgTouchOptions` |
| `listeners` | Chart-level event callbacks | `AgListenersOptions` |
| `formatter` | Modern formatter configuration | `AgFormatterOptions` |
| `container` | Chart container element | `AgContainerOptions` |
| `data` | Chart-level data binding | `List<?>` or JSON string |
| `annotations` | Chart annotations | `AgAnnotationsOptions` |
| `initialState` | Initial zoom/pan state | `AgInitialStateOptions` |
| `misc` | Miscellaneous options | `AgMiscOptions` |

### CRTP Pattern

All options classes use the Curiously Recurring Template Pattern for type-safe fluent builders:

```java
public class AgChartOptions<J extends AgChartOptions<J>>
        extends ChartOptionsBase<J> {

    public J setTitle(AgChartCaptionOptions<?> title) {
        this.title = title;
        return (J) this;
    }

    public J setSeries(List<AgSeriesBaseOptions<?>> series) {
        this.series = series;
        return (J) this;
    }
}
```

This ensures method chaining returns the correct type:

```java
AgChartOptions<MyComponent> options = new AgChartOptions<>(this)
    .setTitle(title)    // Returns AgChartOptions<MyComponent>
    .setSeries(series)  // Still AgChartOptions<MyComponent>
    .setLegend(legend); // Type-safe throughout
```

### Component Architecture

```
┌─────────────────────────────────────────────────────────────┐
│                    JWebMP Application (Java)                 │
│                                                              │
│  ┌─────────────────────────────────────────────────────┐   │
│  │         @NgComponent ChartComponent                  │   │
│  │                                                       │   │
│  │  AgChartOptions<ChartComponent> options =            │   │
│  │      new AgChartOptions<>(this)                      │   │
│  │          .setData(salesData)                         │   │
│  │          .setSeries(lineSeriesList)                  │   │
│  │          .setAxes(axesList);                         │   │
│  │                                                       │   │
│  │  render() {                                          │   │
│  │      return "<ag-charts-angular                      │   │
│  │               [options]='chartOptions'>";           │   │
│  │  }                                                   │   │
│  └─────────────────────────────────────────────────────┘   │
│                          │                                   │
│                          │ TypeScript Generation            │
│                          ▼                                   │
└─────────────────────────────────────────────────────────────┘
                           │
                           │ Compilation
                           ▼
┌─────────────────────────────────────────────────────────────┐
│              Angular 21 Application (TypeScript)             │
│                                                              │
│  ┌─────────────────────────────────────────────────────┐   │
│  │    chart-component.component.ts                      │   │
│  │                                                       │   │
│  │    chartOptions: AgChartOptions = {                  │   │
│  │        data: [...],                                  │   │
│  │        series: [{                                    │   │
│  │            type: 'line',                             │   │
│  │            xKey: 'date',                             │   │
│  │            yKey: 'value'                             │   │
│  │        }]                                            │   │
│  │    };                                                │   │
│  └─────────────────────────────────────────────────────┘   │
│                          │                                   │
│                          ▼                                   │
│  ┌─────────────────────────────────────────────────────┐   │
│  │    <ag-charts-angular                                │   │
│  │        [options]="chartOptions">                     │   │
│  │    </ag-charts-angular>                              │   │
│  └─────────────────────────────────────────────────────┘   │
│                          │                                   │
└──────────────────────────┼───────────────────────────────────┘
                           │
                           ▼
                   ┌──────────────────┐
                   │   AG Charts      │
                   │   Rendering      │
                   │   (Canvas/SVG)   │
                   └──────────────────┘
```

## 🔧 Configuration

### Chart Types

#### Cartesian Charts

```java
// Line Chart
new AgLineSeriesOptions<>()
    .setXKey("date")
    .setYKey("value")
    .setStroke("blue")
    .setStrokeWidth(2);

// Bar Chart (Vertical)
new AgBarSeriesOptions<>()
    .setXKey("category")
    .setYKey("amount")
    .setFill("steelblue");

// Area Chart
new AgAreaSeriesOptions<>()
    .setXKey("x")
    .setYKey("y")
    .setFill("rgba(0, 150, 136, 0.5)")
    .setStroke("rgb(0, 150, 136)");

// Scatter Chart
new AgScatterSeriesOptions<>()
    .setXKey("weight")
    .setYKey("height")
    .setMarker(new AgSeriesMarkerOptions<>()
        .setShape(AgMarkerShape.CIRCLE)
        .setSize(8));

// Bubble Chart
new AgBubbleSeriesOptions<>()
    .setXKey("x")
    .setYKey("y")
    .setSizeKey("size")
    .setColorKey("category");
```

#### Polar Charts

```java
// Pie Chart
new AgPieSeriesOptions<>()
    .setAngleKey("value")
    .setCalloutLabelKey("label")
    .setSectorLabelKey("value");

// Donut Chart
new AgDonutSeriesOptions<>()
    .setAngleKey("value")
    .setCalloutLabelKey("category")
    .setInnerRadiusRatio(0.7)
    .setInnerCircle(new AgDonutInnerCircle<>()
        .setFill("white"));
```

### Axes Configuration

```java
// Number Axis
new AgNumberAxisOptions<>()
    .setType("number")
    .setPosition(AgCartesianAxisPosition.LEFT)
    .setTitle(new AgAxisCaptionOptions<>()
        .setText("Revenue ($)"))
    .setLabel(new AgAxisLabelOptions<>()
        .setFormat(",.0f"));

// Category Axis
new AgCategoryAxisOptions<>()
    .setType("category")
    .setPosition(AgCartesianAxisPosition.BOTTOM)
    .setTitle(new AgAxisCaptionOptions<>()
        .setText("Quarter"));

// Time Axis
new AgTimeAxisOptions<>()
    .setType("time")
    .setPosition(AgCartesianAxisPosition.BOTTOM)
    .setInterval(new AgAxisTimeIntervalOptions<>()
        .setTimeUnit(AgTimeIntervalUnit.MONTH)
        .setStep(1));

// Log Axis
new AgLogAxisOptions<>()
    .setType("log")
    .setPosition(AgCartesianAxisPosition.LEFT)
    .setBase(10);
```

### Legend Configuration

```java
new AgChartLegendOptions<>()
    .setEnabled(true)
    .setPosition(new AgChartLegendPositionOptions<>()
        .setPosition("bottom"))
    .setItem(new AgChartLegendItemOptions<>()
        .setMarker(new AgChartLegendItemMarkerOptions<>()
            .setShape(AgMarkerShape.CIRCLE)
            .setSize(12)))
    .setPagination(new AgChartLegendPaginationOptions<>()
        .setMarker(new AgChartLegendPaginationButtonOptions<>()
            .setSize(15)));
```

### Tooltip Configuration

```java
new AgChartTooltipOptions<>()
    .setEnabled(true)
    .setMode(AgTooltipMode.GROUPED)
    .setPosition(new AgTooltipPositionOptions<>()
        .setType("pointer")
        .setXOffset(10)
        .setYOffset(10))
    .setInteraction(new AgTooltipInteractionOptions<>()
        .setEnabled(true));
```

### Themes

```java
// Built-in theme
options.setTheme(AgChartThemeName.AG_MATERIAL);

// Custom theme
AgChartTheme theme = new AgChartTheme()
    .setPalette(new AgChartThemePalette()
        .setFills(List.of("#5470C6", "#91CC75", "#FAC858"))
        .setStrokes(List.of("#5470C6", "#91CC75", "#FAC858")))
    .setOverrides(new AgChartThemeParams()
        .setCommon(commonOverrides));

options.setTheme(theme);
```

## 🔌 API Reference

### Core Classes

#### AgChartOptions

Main chart configuration class:

```java
public class AgChartOptions<J extends AgChartOptions<J>> {
    J setData(String jsonData);
    J setSeries(List<AgSeriesBaseOptions<?>> series);
    J setAxes(List<? extends AgAxisOptions<?>> axes);
    J setLegend(AgChartLegendOptions<?> legend);
    J setTooltip(AgChartTooltipOptions<?> tooltip);
    J setTheme(AgChartTheme theme);
    J setTitle(AgChartCaptionOptions<?> title);
    J setSubtitle(AgChartCaptionOptions<?> subtitle);
    J setWidth(Integer width);
    J setHeight(Integer height);
    // ... 30+ more options
}
```

#### Series Options

Base class for all series types:

```java
public abstract class AgSeriesBaseOptions<J extends AgSeriesBaseOptions<J>> {
    J setType(String type);
    J setVisible(Boolean visible);
    J setShowInLegend(Boolean showInLegend);
    J setHighlightStyle(AgSeriesHighlightStyleOptions<?> style);
    J setListeners(AgSeriesListeners<?> listeners);
    J setTooltip(AgSeriesTooltipOptions<?> tooltip);
}
```

Series implementations:
- `AgLineSeriesOptions` — Line charts
- `AgBarSeriesOptions` — Bar charts (vertical/horizontal)
- `AgAreaSeriesOptions` — Area charts
- `AgScatterSeriesOptions` — Scatter plots
- `AgBubbleSeriesOptions` — Bubble charts
- `AgPieSeriesOptions` — Pie charts
- `AgDonutSeriesOptions` — Donut charts
- `AgHistogramSeriesOptions` — Histograms
- `AgRangeBarSeriesOptions` — Range bars
- `AgRangeAreaSeriesOptions` — Range areas

#### Axis Options

- `AgNumberAxisOptions` — Numeric axes
- `AgCategoryAxisOptions` — Categorical axes
- `AgTimeAxisOptions` — Time-based axes
- `AgLogAxisOptions` — Logarithmic axes
- `AgGroupedCategoryAxisOptions` — Grouped categories
- `AgOrdinalTimeAxisOptions` — Ordinal time axes

## 🧪 Testing

### Running Tests

```bash
# Run all tests
mvn clean test

# Run specific test
mvn test -Dtest=AgChartsTest
```

### Test Example

```java
@Test
public void testChartCreation() {
    AgChartOptions<TestComponent> options = new AgChartOptions<>(component)
        .setData("[{x: 1, y: 10}, {x: 2, y: 20}]")
        .setSeries(List.of(
            new AgLineSeriesOptions<>()
                .setXKey("x")
                .setYKey("y")
        ));

    assertNotNull(options.getData());
    assertEquals(1, options.getSeries().size());
}
```

## 🗺️ Module Graph

```
com.jwebmp.plugins.agcharts
 ├── com.jwebmp.client              (JWebMP client utilities)
 ├── com.jwebmp.core                (JWebMP core)
 ├── com.jwebmp.core.angular        (Angular integration)
 ├── com.guicedee.guicedinjection   (Guice DI)
 ├── com.fasterxml.jackson.annotation (JSON annotations)
 └── com.jwebmp.core.base.angular.client (Angular client services)
```

### Exported Packages

- `com.jwebmp.plugins.agcharts` — Core plugin classes
- `com.jwebmp.plugins.agcharts.options` — Main options classes
- `com.jwebmp.plugins.agcharts.options.axes` — Axis configuration
- `com.jwebmp.plugins.agcharts.options.series` — Series types
- `com.jwebmp.plugins.agcharts.options.legend` — Legend configuration
- `com.jwebmp.plugins.agcharts.options.tooltip` — Tooltip configuration
- `com.jwebmp.plugins.agcharts.options.theme` — Theme support
- `com.jwebmp.plugins.agcharts.options.navigator` — Navigator component
- `com.jwebmp.plugins.agcharts.options.animation` — Animation control
- `com.jwebmp.plugins.agcharts.options.zoom` — Zoom/pan control
- ... and 15+ more specialized packages

## 🧰 Troubleshooting & Best Practices

### Chart Not Rendering

**Problem**: Chart component appears but chart doesn't render

**Solutions**:
- Verify `ag-charts-angular` is included in Angular dependencies
- Check that `chartOptions` variable is properly bound in template
- Ensure data format matches series configuration (key names must match)
- Check browser console for AG Charts initialization errors

### Data Not Updating

**Problem**: Chart doesn't update when data changes

**Solutions**:
- Use Angular change detection: reassign `chartOptions` object instead of mutating
- For reactive updates, use Angular observables with `async` pipe
- Call `agChart.update()` method explicitly if using imperative API

### Performance Issues

**Problem**: Chart is slow with large datasets

**Solutions**:
- Use `navigator` component for large time-series datasets
- Enable `grouping` for high-cardinality data
- Consider data sampling or aggregation on server side
- Disable animations for real-time updates: `setAnimation(false)`
- Use `zoom` to focus on subsets of data

### Type Errors

**Problem**: TypeScript compilation errors in generated code

**Solutions**:
- Regenerate TypeScript with `mvn clean compile`
- Verify AG Charts version matches plugin version (13.1.0)
- Check that all required fields are set on options objects
- Use fluent setters consistently (don't mix with direct field access)

### Best Practices

- **Use CRTP pattern correctly** — Always use generic type `<J extends YourClass<J>>`
- **Set required fields** — Ensure `type`, `xKey`, `yKey` are set for series
- **Leverage themes** — Use built-in themes for consistent styling
- **Handle null data** — Check for null/undefined data before rendering
- **Optimize updates** — Batch data updates to minimize re-renders
- **Follow Angular patterns** — Use observables for reactive data
- **Document custom themes** — Keep theme configurations in separate files
- **Test with real data** — Use production-like datasets for testing

## 📚 Documentation

### Core Resources

- **[AG Charts Documentation](https://charts.ag-grid.com/javascript/quick-start/)** — Official AG Charts documentation
- **[AG Charts API Reference](https://charts.ag-grid.com/javascript/api/)** — Complete API reference
- **[AG Charts Angular](https://charts.ag-grid.com/angular/)** — Angular integration guide
- **[JWebMP Home](https://jwebmp.com/)** — JWebMP framework documentation

### Related Plugins

- **AG Charts Enterprise**: [`../agcharts-enterprise/README.md`](../agcharts-enterprise/README.md)
- **AG Grid Community**: [`../aggrid/README.md`](../aggrid/README.md)
- **Angular Plugin**: [`../angular/README.md`](../angular/README.md)
- [AG Charts Examples](https://charts.ag-grid.com/javascript/examples/)
- [Angular Integration Guide](https://charts.ag-grid.com/angular/)

## 🤝 Contributing

Issues and pull requests are welcome.

### Guidelines

- Follow CRTP pattern for all option classes
- Include tests for new chart types or options
- Update TypeScript interfaces when adding new options
- Maintain AG Charts API compliance
- Document new features with examples
- Run full test suite before submitting PR

## 📄 License

[Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0)

---

**JWebMP AG Charts** — Enterprise-grade charting for Java web applications with Angular 21.

Built with ❤️ using Java 25+, AG Charts 13.1.0, Angular 21, and JPMS.
