package pers.ocean.kafkademo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pers.ocean.kafkademo.constant.Constant;

import java.time.Duration;
import java.util.Collections;

/**
 * @Description kafka消费者
 * @Author ocean_wll
 * @Date 2021/7/31 4:10 下午
 */
@Component
public class OceanKafkaConsumer {

    @Autowired
    private KafkaConsumer<String, Object> kafkaConsumer;

    /**
     * 消费监听
     *
     * @param data kafka的消息
     */
    @KafkaListener(topics = {Constant.KAFKA_TOPIC_OCEAN})
    public void listenBySpring(String data) {
        System.out.println("============= Spring consumer begin ===========");
        System.out.println(data);
        System.out.println("============= Spring consumer end ===========");
    }

    /**
     * 利用kafkaConsumer来实现kafka消费监听，主动来取
     */
    public void listenBySimple() {
        // 订阅topic
        kafkaConsumer.subscribe(Collections.singletonList(Constant.KAFKA_TOPIC_OCEAN_WLL));
        // 死循环去拉取kafka数据
        while (true) {
            // 拉取指定时间时间段内的数据
            ConsumerRecords<String, Object> records = kafkaConsumer.poll(Duration.ZERO);
            records.forEach(item -> {
                System.out.println("============= kafkaConsumer begin ===========");
                System.out.println("record key: " + item.key());
                System.out.println("record value:" + item.value());
                System.out.println("============= kafkaConsumer end ===========");
            });
        }
    }

}
