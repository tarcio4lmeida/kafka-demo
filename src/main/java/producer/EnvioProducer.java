package producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class EnvioProducer {

    public static void main(String[] args) {
        /*
         * 3 propriedades que configuram o kafka
         * 1 - IP DO KAFKA
         * 2 - Classe que serializa a chave
         * 3 - Classe que serializa o valor
         */
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        try(KafkaProducer<String, String> producer = new KafkaProducer<>(properties)){
            ProducerRecord<String, String> record = new ProducerRecord<>("testejava", "olá mundo 2");
            producer.send(record);
        }
    }
}
