package connection;

import connection.properties.ConnectionProperties;

public class TestDemo {

    public static void main(String[] args) {
        ConnectionProperties connectionProperties = new ConnectionProperties();
        connectionProperties.setConnectTimeout(10000L)
                .setHost("192.168.232.132").setPort(6379);
        RedisClient redisClient = new RedisClient(connectionProperties);
        System.out.println("");
    }
}
