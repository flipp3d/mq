package mq.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class ProducerConfig {
    public static final String EXCHANGE = "exchangeTest1";
    public static final String ROUTINGKEY = "test";
    public static final String QUEUE_NAME = "queueTest1";

    @Bean
    public Binding bindingExchangeQueue() {
        return new Binding(QUEUE_NAME, Binding.DestinationType.QUEUE,EXCHANGE,ROUTINGKEY,new HashMap<>());
    }

//    @Bean
//    public Binding bindingExchangeQueue(DirectExchange exchange, Queue queue) {
//        return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY);
//    }
//
//    @Bean
//    public DirectExchange getdirectExchange() {
//        return new DirectExchange(EXCHANGE, true, true);
//    }
//
//    @Bean
//    public Queue queue() {
//        return new Queue(QUEUE_NAME);
//    }



}
