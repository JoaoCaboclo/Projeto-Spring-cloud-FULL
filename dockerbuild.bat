docker build . -t jcaboclo/discovery-server  --  server.port= 8761
docker build . -t jcaboclo/inventory-service
docker build . -t jcaboclo/api-gateway
docker build . -t jcaboclo/order-service
docker build . -t jcaboclo/product-service
docker build . -t jcaboclo/spring-cloud-config-server