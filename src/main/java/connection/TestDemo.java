package connection;

import connection.properties.ConnectionProperties;
import io.netty.channel.Channel;

public class TestDemo {

    public static void main(String[] args) {
        ConnectionProperties connectionProperties = new ConnectionProperties();
        connectionProperties.setConnectTimeout(10000L)
                .setHost("192.168.232.132").setPort(6379);
        RedisClient redisClient = new RedisClient(connectionProperties);
        redisClient.getConnection();
        redisClient.getConnection();
        redisClient.getConnection();
        redisClient.getConnection();
        Channel idleChannel = redisClient.getIdleChannel();
        if (idleChannel != null) {
            idleChannel.write("set msg 123");
        }
        System.out.println("");
    }
}
