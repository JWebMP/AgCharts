# Sequence — Data Fetch and Update

```mermaid
sequenceDiagram
  participant Browser as Browser Angular component
  participant EventBus as EventBusService
  participant WebSocket as WebSocket channel
  participant Server as DataReceiver
  participant Chart as AgChart subclass

  Browser->>EventBus: fetchDataChannel()
  EventBus->>WebSocket: send listenerNameData request
  WebSocket->>Server: route to DataReceiver
  Server->>Chart: getInitialData()
  Chart-->>Server: Uni<Object> (may be null)
  Server-->>WebSocket: addDataResponse(listenerNameData, DynamicData)
  WebSocket-->>EventBus: deliver data payload
  EventBus-->>Browser: handleDataEvent(value)
  Browser->>Browser: merge value into first series data or options.data then update chartOptions
```

Notes
- Subsequent server pushes can reuse the same listener to stream updates; handler keeps existing options and overlays new data.
- Errors during parsing are logged on the client; no retry/backoff is currently coded.
