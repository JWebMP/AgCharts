# Sequence — Initial Chart Load

Flow based on `AgChart` lifecycle and websocket receivers.

```mermaid
sequenceDiagram
  participant Browser as Browser Angular component
  participant EventBus as EventBusService
  participant WebSocket as WebSocket channel
  participant Server as AgChart receiver
  participant Chart as AgChart subclass
  participant Renderer as ag-charts-angular

  Browser->>Browser: ngAfterViewInit triggers init
  Browser->>EventBus: initializeOptionsListener + initializeDataListener
  Browser->>EventBus: fetchOptions()
  EventBus->>WebSocket: send listenerNameOptions request
  WebSocket->>Server: route to InitialOptionsReceiver
  Server->>Chart: getInitialOptions()
  Chart-->>Server: Uni<AgChartOptions>
  Server-->>WebSocket: addDataResponse(listenerNameOptions, options)
  WebSocket-->>EventBus: deliver options payload
  EventBus-->>Browser: handleOptionsEvent sets chartOptions signal
  Browser->>Renderer: render ag-charts-angular component when chartReady
```

Notes
- Listener names derive from `DivSimple` id: `<id>Options` / `<id>Data`.
- Options payload may be raw object or wrapped in `{ out: [...] }`; handler normalizes before setting `chartOptions`.
