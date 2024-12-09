package connection;

import connection.properties.ConnectionProperties;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 连接Redis客户端
 */
public class RedisClient {

    public ConnectionProperties properties;

    public Bootstrap bootstrap;

    public RedisClient(ConnectionProperties properties) {
        this.properties = properties;
        initConnection(properties);


    }

    /**
     * 初始化连接
     *
     * @param properties
     */
    private void initConnection(ConnectionProperties properties) {
        // 检查连接参数
        checkProperties(properties);
        // 建立连接
        NioEventLoopGroup worker = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.group(worker);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {

            }
        });
        // 处理连接
        try {
            ChannelFuture channelFu = bootstrap.connect(properties.getHost(), properties.getPort()).sync();
            channelFu.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * TODO
     * 检查连接参数
     *
     * @param properties
     */
    private void checkProperties(ConnectionProperties properties) {

    }


}