package mq.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ProducerApplication //implements CommandLineRunner
 {

//    @Resource
//    ProducerSchedule producerSchedule;

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);


    }


//    @Override
//    public void run(String... args) throws Exception {
//
//        producerSchedule.getById();
//    }
}
