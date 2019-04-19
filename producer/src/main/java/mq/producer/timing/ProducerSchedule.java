package mq.producer.timing;


import mq.producer.proService.MessageProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.Executors;


@Component


public class ProducerSchedule implements SchedulingConfigurer
 {

    private static Logger log = LoggerFactory.getLogger(ProducerSchedule.class);
    @Resource
    private MessageProducerService messageProducerService;

//    @Scheduled(fixedDelay = 2000)
    public void sendmsgs(){
        messageProducerService.sendMessage(0,2);
        log.info("msgs线程ID："+Thread.currentThread().getId()+";执行时间："+new Date());

    }
    @Scheduled(fixedDelay = 5000)
    public void sendmsg(){
        messageProducerService.sendMessage3(1);
        log.info("msg1线程ID："+Thread.currentThread().getId()+";执行时间："+new Date());
    }
     @Scheduled(fixedDelay = 5000)
     public void sendmsg2(){
         messageProducerService.sendMessage2();
         log.info("msg2线程ID："+Thread.currentThread().getId()+";执行时间："+new Date());
     }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(Executors.newScheduledThreadPool(20));
    }
}
