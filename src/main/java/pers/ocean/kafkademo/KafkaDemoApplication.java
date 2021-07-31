package pers.ocean.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pers.ocean.kafkademo.consumer.OceanKafkaConsumer;

@SpringBootApplication
public class KafkaDemoApplication {

    @Autowired
    private OceanKafkaConsumer oceanKafkaConsumer;

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }

    /**
     * 容器启动完以后打开kafka消费
     *
     * @return ApplicationRunner
     */
    @Bean
    public ApplicationRunner beginKafkaConsume() {
        return args -> oceanKafkaConsumer.listenBySimple();
    }

}
