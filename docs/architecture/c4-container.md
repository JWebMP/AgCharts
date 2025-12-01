# C4 — Container

- JWebMP Server Container  
  - Hosts `AgChart` subclasses and websocket receivers (`InitialOptionsReceiver`, `DataReceiver`) registered through `IGuicedWebSocket`.  
  - Uses Guice (`AgChartsInclusionsModule`) to expose module/package scanning.  
  - Generates Angular artifacts from annotations (`@NgField`, `@NgMethod`, `@NgAfterViewInit`) and serves Mutiny-based options/data via `AjaxResponse`.
- Angular Client Container  
  - Angular 20 runtime produced by JWebMP build; contains generated AgChart component signals and subscriptions.  
  - Talks to server through EventBusService over websockets; renders AG Charts via `ag-charts-angular`.
- AG Charts JS Packages  
  - `ag-charts-community` plus optional `ag-charts-enterprise`, `ag-charts-angular`, `ag-charts-locale` declared in `AgChartsPageConfigurator`.
- Host Application Services  
  - Supply actual chart data/options by overriding `getInitialOptions()`/`getInitialData()` in concrete chart components.

```mermaid
graph TD
  Server[JWebMP Server Container]
  Angular[Angular Client Container]
  EventBus[EventBus WebSocket]
  ChartsLib[AG Charts JS Packages]
  HostData[Host Application Services]

  HostData -->|Implements getInitialOptions/getInitialData| Server
  Server -->|Registers websocket receivers| EventBus
  Angular -->|Subscribes to options/data| EventBus
  Server -->|Pushes options/data via AjaxResponse| EventBus
  Angular -->|Renders charts with| ChartsLib
  EventBus -->|Delivers payloads| Angular
```
