# kafka-demo
Produtor e consumidor kafka

#subindo zookeeper 
zookeeper-server-start.bat C:\kafka\config\zookeeper.properties

#subindo servidor kafka
kafka-server-start.bat C:\kafka\config\server.properties

#listando topicos
kafka-topics --bootstrap-server localhost:9092 --list

#criando topicos
kafka-topics --bootstrap-server localhost:9092 --create --topic testejava

#criando msgs kafka
kafka-console-producer --broker-list localhost:9092 --topic testejava

#consumindo msgs kafka
kafka-console-consumer --bootstrap-server localhost:9092 --topic testejava
kafka-console-consumer --bootstrap-server localhost:9092 --topic testejava --from-beginning 

#alterando as particoes de um topico
kafka-topics --bootstrap-server localhost:9092 --alter --topic testejava--partitions 10

#detalhando um topic
kafka-topics --bootstrap-server localhost:9092 --describe --topic testejava

#excluindo um topic (tem bug no windows) #solucao:  apagar a pasta data
kafka-topics --bootstrap-server localhost:9092 --list
kafka-topics --bootstrap-server localhost:9092 --delete --topic testejava

####
OBS: Caso, haja necessidade de ordem no kafka, é necessário usar chave 

##produzir
kafka-console-producer --broker-list localhost:9092 --topic teste --property "parse.key=true" --property "key.separator=,"

##consumir
kafka-console-consumer --bootstrap-server localhost:9092 --topic teste --property "print.key=true" --property "key.separator=," --group grupo1

