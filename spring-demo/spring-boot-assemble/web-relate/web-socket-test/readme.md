# web-socket 测试

## 配置
- 实现 `WebSocketMessageBrokerConfigurer` 接口

## 注意点
- `@EnableWebSocketMessageBroker` 启用
- `@Controller` `@MessageMapping( "/hello" )` 配置映射
- `@SendTo( "/topic/greetings" )` 配置发送主题

## 点对点发送
- 要加 `spring-security` 支持 
- `SimpMessagingTemplate.convertAndSendToUser(xx)` 发送，js 要加 "/user" 前缀接收