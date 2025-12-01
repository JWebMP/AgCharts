# ERD — Chart Option Model

- Scope: configuration objects wired in `AgChartOptions` and `AgSeriesBaseOptions` (no persistence layer present).
- Relationships derived from fields in `options/AgChartOptions.java` and `options/series/AgSeriesBaseOptions.java`.

```mermaid
erDiagram
  AgChartOptions ||--o{ AgAxisBaseOptions : axes
  AgChartOptions ||--o{ AgSeriesBaseOptions : series
  AgChartOptions ||--|| AgChartLegendOptions : legend
  AgChartOptions ||--|| AgChartTooltipOptions : tooltip
  AgChartOptions ||--|| AgLocaleOptions : locale
  AgChartOptions ||--|| AgChartBackground : background
  AgChartOptions ||--|| AgChartTheme : theme
  AgChartOptions ||--|| AgSeriesAreaOptions : seriesArea
  AgChartOptions ||--|| AgChartOverlaysOptions : overlays
  AgChartOptions ||--|| AgNavigatorOptions : navigator
  AgChartOptions ||--|| AgGradientLegendOptions : gradientLegend

  AgSeriesBaseOptions ||--|| AgSeriesLabelOptions : label
  AgSeriesBaseOptions ||--|| AgSeriesMarkerOptions : marker
  AgSeriesBaseOptions ||--|| AgSeriesTooltipOptions : tooltip
  AgSeriesBaseOptions ||--|| AgSeriesSegmentationOptions : segmentation
  AgSeriesBaseOptions ||--|| AgSeriesHighlightOptions : highlight

  AgSeriesBaseOptions ||--o{ AgGradientColor : gradientFill
  AgSeriesBaseOptions ||--o{ AgPatternFill : patternFill
  AgSeriesBaseOptions ||--o{ AgImageFill : imageFill
```

Notes
- Fill can also be a raw color string (`setFill(String)`), but ERD focuses on object relations.
- Additional axes/legend subclasses inherit from the exported packages; extend this diagram if new relations are introduced.
