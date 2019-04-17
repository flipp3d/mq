package mq.consumer.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {
    public static final String EXCHANGE = "exchangeTest1";
    public static final String ROUTINGKEY = "test";
    public static final String QUEUE_NAME = "IMES_ME_BAS_PLANT";
    public static final String QUEUE_NAME1 = "queueTest1";

//    @Bean
//    public Binding bindingExchangeQueue() {
//        return new Binding(QUEUE_NAME1, Binding.DestinationType.QUEUE,EXCHANGE,ROUTINGKEY,new HashMap<>());
//    }

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
//        return new Queue(QUEUE_NAME1);
//    }
}
