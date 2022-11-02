package com.ljm.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
    public static final String FANOUT_EXCHANGE = "fanout.exchange";
    public static final String FANOUT_QUEUE1 = "fanout.queue1";

    public static final String FANOUT_QUEUE2 = "fanout.queue2";
    @Bean(name = FANOUT_EXCHANGE)
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE, true, false);
    }



    @Bean(name = FANOUT_QUEUE1)
    public Queue fanoutQueue1() {
        return new Queue(FANOUT_QUEUE1, true, false, false);
    }
    @Bean(name = FANOUT_QUEUE2)
    public Queue fanoutQueue2() {
        return new Queue(FANOUT_QUEUE2, true, false, false);
    }

    @Bean
    public Binding bindingSimpleQueue1(@Qualifier(FANOUT_QUEUE1) Queue fanoutQueue1,
                                       @Qualifier(FANOUT_EXCHANGE) FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }
    @Bean
    public Binding bindingSimpleQueue2(@Qualifier(FANOUT_QUEUE2) Queue fanoutQueue2,
                                       @Qualifier(FANOUT_EXCHANGE) FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }
}
