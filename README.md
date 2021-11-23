# kafka-demo
Produtor e consumidor kafka

#listando topicos
kafka-topics --bootstrap-server localhost:9092 --list

#criando topicos
kafka-topics --bootstrap-server localhost:9092 --create --tpoic testejava

#criando msgs kafka
kafka-console-producer --broker-list localhost:9092 --topic teste

#consumindo msgs kafka
kafka-console-consumer --bootstrap-server localhost:9092 --topic testejava
kafka-console-consumer --bootstrap-server localhost:9092 --topic testejava --from-beginning 

