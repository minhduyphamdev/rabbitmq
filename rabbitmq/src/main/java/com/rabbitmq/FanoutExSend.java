package com.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class FanoutExSend {
    public final static String QUEUE_NAME = "queue-1";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (  Connection connection = factory.newConnection();
               Channel channel = connection.createChannel()
        ){
            String message = "This is a mobile";

            channel.basicPublish("fanout exchange","",null,message.getBytes());


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
