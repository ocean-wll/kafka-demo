package pers.ocean.kafkademo.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description kafka生产者
 * @Author ocean_wll
 * @Date 2021/7/31 4:08 下午
 */
@Component
public class OceanKafkaProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private KafkaProducer<String, Object> kafkaProducer;

    /**
     * 利用Spring的 kafkaTemplate 来发送消息
     *
     * @param topic topic
     * @param msg   消息内容
     */
    public void sendMsgByTemplate(String topic, String msg) {
        kafkaTemplate.send(topic, msg);
    }

    /**
     * 利用基础的 kafkaProducer 来发送消息
     *
     * @param topic topic
     * @param msg   消息内容
     */
    public void sendMsgByProducer(String topic, String msg) {
        ProducerRecord<String, Object> record = new ProducerRecord<>(topic, msg);
        kafkaProducer.send(record);
    }
}
