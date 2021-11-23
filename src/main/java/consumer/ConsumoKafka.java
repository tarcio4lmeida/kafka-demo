package consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class ConsumoKafka {

    public static void main(String[] args) {

        /*
         * 4 propriedades que configuram o kafka
         * 1 - IP DO KAFKA
         * 2 - Classe que deserializa a chave
         * 3 - Classe que deserializa o valor
         * 4 - ID do grupo para consumir
         * 5 - Capturar as mensagens desde a mais antiga
         */

        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group1");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        while(true) {
            try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties)) {
                consumer.subscribe(Arrays.asList("testejava"));
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));

                for (ConsumerRecord<String, String> record : records) {
                    System.out.println(record.value());
                }
            }
            System.out.println("Fim");
        }
    }

}
