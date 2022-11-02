//package com.mq.rabbitmq;
//
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.ConnectionFactory;
//import com.rabbitmq.client.DeliverCallback;
//import org.junit.Test;
//import com.rabbitmq.client.Connection;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.util.concurrent.TimeoutException;
////@Service
//public class mqUtil {
//
//  private static final String HOST = "192.168.32.55"; // 设置IP地址
//  private static final String VIRTUALHOST = "/"; // 虚拟主机
//  private static final String USERNAME = "admin"; // 用户名
//  private static final String PASSWORD = "123456"; // 密码
//  private static final Integer PORT = 5673; // rabbitmq-server 端口
//
//  public Connection getConnection () {
//    Connection connection = null;
//// 获取链接
//    ConnectionFactory connectionFactory = new ConnectionFactory();
//    connectionFactory.setHost(HOST);
//    connectionFactory.setVirtualHost(VIRTUALHOST);
//    connectionFactory.setUsername(USERNAME);
//    connectionFactory.setPassword(PASSWORD);
//// rabbitmq 的服务器地址 15672:给rabbitmq management web程序,插件 web端客户端管理工具
////5672:给rabbitmq-server 服务器的
//    connectionFactory.setPort(PORT);
//// 建立链接
//    try {
//      Connection newConnection = connectionFactory.newConnection();
//      System.out.println(newConnection);
//      connection = newConnection;
//    } catch (IOException e) {
//      System.out.println("连接失败!!!");
//      e.printStackTrace();
//    } catch (TimeoutException e) {
//      System.out.println("连接超时!!!");
//      e.printStackTrace();
//    }
//    return connection;
//  }
//
//  public void test() throws IOException, TimeoutException {
//    Connection connection = this.getConnection();
//    Channel channel = connection.createChannel();
//    channel.queueDeclare("zjw_test", true, false, false, null);
//// 消息发布 (交换机名  路由名  其他属性  消息的字节数组)
//    channel.basicPublish("","zjw_test",null,"Hello Word!!!".getBytes());
//// 关闭连接
//    connection.close();
//  }
//
//
//  public void  tests () throws IOException {
//// 获取连接
//    Connection connection = this.getConnection();
//  System.out.println(21313123);
//// 创建频道
//    Channel channel = connection.createChannel();
//// 声明队列
//    try {
//      channel.queueDeclare("zjw_test",true,false,false,null);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
///**
// * 消费成功之后执行回调函数回调函数
// */
//    DeliverCallback deliverCallback = (consumerTag, delivery) -> {
//      String message = new String(delivery.getBody(), "UTF-8");
//      System.out.println(" [x] Received '" + message + "'");
//      System.out.println(123);
//    };
//    try {
//      channel.basicConsume("zjw_test", true, deliverCallback, consumerTag -> {});
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }
//
//
//
//}
