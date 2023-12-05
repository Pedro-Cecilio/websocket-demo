# Websocket - Spring Boot

Este projeto utiliza o framework Spring Boot para implementar um sistema de comunicação em tempo real através de WebSockets. A aplicação é dividida em duas partes principais: a configuração do WebSocket e o controle da comunicação.

Primeiramente, certifique-se de adicionar a dependência necessária ao seu arquivo de configuração do projeto.

```
implementation("org.springframework.boot:spring-boot-starter-websocket")

```

### Arquivo: WebSocketConfig.java

```

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        // Configuração do destino das mensagens

        registry.enableSimpleBroker("/room");
        
        // Prefixo para mensagens direcionadas à aplicação

        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        // Endpoint para conexão WebSocket

        registry.addEndpoint("/connect").setAllowedOriginPatterns("*");
        
        // Endpoint para conexão com SockJS

        registry.addEndpoint("/connect").setAllowedOriginPatterns("*").withSockJS();
    }
}
```

**@Configuration**: Indica que a classe é uma classe de configuração.

**@EnableWebSocketMessageBroker**: Habilita o suporte a mensagens WebSocket com o uso de um intermediário de mensagens.

**configureMessageBroker**: Configura o destino das mensagens e o prefixo para mensagens direcionadas à aplicação.

**registerStompEndpoints**: Registra os endpoints WebSocket para conexão, tanto padrão como com SockJS.

#

### Arquivo: WebSocketController.java

```
@Controller
public class WebSocketController {

    private HashMap<String, ArrayList<JoinDataDto>> participants = new HashMap<>();

    @MessageMapping("/room/{roomId}")
    @SendTo("/room/{roomId}")
    public ArrayList<JoinDataDto> joinRoom(@DestinationVariable("roomId") String roomId, JoinDataDto data) {
    
        // Adiciona participante à lista da sala
        
        participants.computeIfAbsent(roomId, k -> new ArrayList<>()).add(data);
        
        // Retorna a lista de participantes atualizada para a sala
        
        return participants.get(roomId);
    }
}
```

**@Controller**: Indica que a classe é um controlador Spring MVC.

**@MessageMapping("/room/{roomId}")**: Mapeia o endpoint para lidar com mensagens relacionadas a uma sala específica.

**@SendTo("/room/{roomId}")**: Especifica o destino para o qual enviar a resposta da mensagem.

**joinRoom**: Método que lida com a entrada de um novo participante em uma sala, atualizando a lista de participantes e retornando a lista atualizada.

#
