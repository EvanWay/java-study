package com.evan.study.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Direct（直连型交换机）配置类
 * @author Evan
 */
@Configuration
public class DirectRabbitConfig {
    /**
     * 队列 起名：study-TestDirectQueue
     */
    @Bean
    public Queue testDirectQueue() {
        // durable:是否持久化,默认是true,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
        // exclusive:默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
        // autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
        // return new Queue("TestDirectQueue",true,false,false);

        //一般设置一下队列的持久化就好,其余两个就是默认false
        return new Queue("study-TestDirectQueue",true);
    }

    /**
     * Direct交换机 起名：study-TestDirectExchange
     */
    @Bean
    DirectExchange testDirectExchange() {
        return new DirectExchange("study-TestDirectExchange",true,false);
    }

    /**
     * 绑定
     * 将队列和交换机绑定, 并设置用于匹配键：study-TestDirectRouting
     */
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(testDirectQueue()).to(testDirectExchange()).with("study-TestDirectRouting");
    }

//    @Bean
//    DirectExchange lonelyDirectExchange() {
//        return new DirectExchange("lonelyDirectExchange");
//    }
}
