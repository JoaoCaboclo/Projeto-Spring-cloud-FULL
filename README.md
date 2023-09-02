# Projeto-Spring-cloud-FULL

- Build Services  ( Mysql e MongoDB )			            	  - done
- Inter Process Communication	( WebConfig / RestTemplate )      - done
- Service Discovery using Netflix  ( Eureka )    			      - done
- Spring cloud Config-server                                      - done
- Implement API Gateway using Spring Cloud Gateway		          - done
-     Routing based on Request Headers .Authentication .Security .Load Balance
-     SSL Termination .Rastreability (log - trace - metricas) .A single point of failure (SPOF)
- Secure Microservices using Keycloak					          - done
- Implement Circuit Breaker (configurado no github e acessado pelo config-server)						                  - done
-     Resilience / Resiliency  (Resilience4J)
-     Testando: Inventory-service fora do ar
-               Inventory-service demorando a responder (alta latencia)
-               Retentativas para tornar o sistema mais robusto e resiliente
- Conteinerização dos Micro serviços : Docker                    - done
      - Gerando as imagens docker apos ter buildado a aplicação ( gerados os .jar )
        docker build . -t jcaboclo/discovery-server
        docker build . -t jcaboclo/inventory-service
        docker build . -t jcaboclo/order-service
        docker build . -t jcaboclo/product-service
        docker build . -t jcaboclo/spring-cloud-config-server
- Implement Distributed Tracing						              - to do
- Event Driven Architecture using Kafka					          - to do
- Monitoring Microservices using Prometheus and Grafana           - to do



Para rodar os arquivos docker, o docker desktop deverá estar iniciado no seu ambiente
   docker-compose.yml
   na mesma pasta deste arquivo, utilizer o comando
      Docker-compose up

Referência e fonte do meu aprendizado: Programming Techie
       Spring Boot Microservice Project Full Course in 6 Hours
             https://www.youtube.com/watch?v=mPPhcU7oWDU
