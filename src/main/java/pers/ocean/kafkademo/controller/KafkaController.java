package pers.ocean.kafkademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.ocean.kafkademo.constant.Constant;
import pers.ocean.kafkademo.producer.OceanKafkaProducer;

/**
 * @Description kafka测试的demo
 * @Author ocean_wll
 * @Date 2021/7/31 3:54 下午
 */
@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    @Autowired
    private OceanKafkaProducer producer;

    @GetMapping("/hi")
    public String helloWord() {
        return "hello word!";
    }

    @PostMapping("/send/template")
    public String sendMsgByTemplate(@RequestBody String msg) {
        producer.sendMsgByTemplate(Constant.KAFKA_TOPIC_OCEAN, msg);
        return "success";
    }

    @PostMapping("send/kafkaProducer")
    public String sendMsgByProducer(@RequestBody String msg) {
        producer.sendMsgByProducer(Constant.KAFKA_TOPIC_OCEAN_WLL, msg);
        return "success";
    }
}
