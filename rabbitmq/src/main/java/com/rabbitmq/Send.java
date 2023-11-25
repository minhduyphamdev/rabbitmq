package com.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Send {
    public final static String QUEUE_NAME = "queue-1";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (  Connection connection = factory.newConnection();
               Channel channel = connection.createChannel()
        ){
//            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
//            String message = "Hello World!";
//            String[] messages = new String[] {"text1","text2","text3","text4"};
//            for(String message: messages) {
            JSONObject json = new JSONObject();
            json.put("name","minh");
            channel.basicPublish("",QUEUE_NAME,null,json.toString().getBytes(StandardCharsets.UTF_8));
//            System.out.println(" [x] Sent '" + message + "'");


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
