package test.handler;


import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class RedisSubscriber implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {

    }
}
