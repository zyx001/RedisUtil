package connection;

import connection.properties.ConnectionProperties;
import connection.handler.RedisChannelInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 连接Redis客户端
 */
public class RedisClient {

    public ConnectionProperties properties;

    public Bootstrap bootstrap;

    public ChannelGroup channelGroup;

    public RedisClient(ConnectionProperties properties) {
        this.properties = properties;
        initBootstrap(properties);
        if (properties.getActiveConnection() > 0) {
            createConnectPool();
        }
    }

    /**
     * 初始化连接
     */
    private void createConnectPool() {
        bootstrap.connect();
    }

    /**
     * 初始化连接
     *
     * @param properties
     */
    private void initBootstrap(ConnectionProperties properties) {
        // 检查连接参数
        checkProperties(properties);
        // 建立连接
        NioEventLoopGroup worker = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(worker);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(new RedisChannelInitializer());
    }

    /**
     * TODO
     * 检查连接参数
     *
     * @param properties
     */
    private void checkProperties(ConnectionProperties properties) {

    }

    /**
     * 获取空闲Channel
     */
    public Channel getIdleChannel() {
        Channel activeChannel = channelGroup.stream().filter(channel -> channel.isActive()).findFirst().orElse(null);
        return activeChannel;
    }

    /**
     * 获取连接
     * @return
     */
    public void getConnection() {
        bootstrap.connect();
    }


}
