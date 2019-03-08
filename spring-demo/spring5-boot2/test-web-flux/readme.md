# WebFlux demo
- [原文参考](https://www.ibm.com/developerworks/cn/java/spring5-webflux-reactive/index.html)

## Controller
- 方法返回 `Flux`、`Mono`   

## 服务器推送事件
- Server-Sent Events，简称 SSE
- 允许服务端不断地推送数据到客户端
- 相对 WebSocket，SSE 只支持服务端到客户端的单向数据传递
- 功能较弱，优势是使用简易的文本格式来表示传输的数据
  - 为 W3C 规范，浏览器端支持比较广泛
- SSE 是一个不断产生数据的流，非常适合于用反应式流来表示
- 在 WebFlux 中只需要返回 Flux<ServerSentEvent>，就会自动按照 SSE 规范发送响应