package mq.producer.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfigtwo {
    public static final String EXCHANGE = "exchangeTest1";
    public static final String ROUTINGKEY = "test";
    public static final String QUEUE_NAME = "queueTest2";

//    @Bean
//    public Binding bindingExchangeQueue2() {
//        return new Binding(QUEUE_NAME, Binding.DestinationType.QUEUE,EXCHANGE,ROUTINGKEY,new HashMap<>());
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
//        return new Queue(QUEUE_NAME);
//    }



}
