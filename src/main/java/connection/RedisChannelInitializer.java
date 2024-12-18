package connection;

import connection.handler.RedisCodec;
import connection.handler.MesOutHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @description:
 * @author: ZhengYongPeng
 * @date: 2024-12-09 16:52
 */
public class RedisChannelInitializer extends ChannelInitializer<NioSocketChannel> {


    @Override
    protected void initChannel(NioSocketChannel channel) throws Exception {
        channel.pipeline().addLast(new MesOutHandler());
        channel.pipeline().addLast(new RedisCodec());
    }
}
