package connection;

import connection.handler.Encode;
import connection.handler.MesOutHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: ZhengYongPeng
 * @date: 2024-12-09 16:52
 */
public class RedisChannelInitializer extends ChannelInitializer<NioSocketChannel> {


    @Override
    protected void initChannel(NioSocketChannel channel) throws Exception {
        channel.pipeline().addLast(new MesOutHandler());
        channel.pipeline().addLast(new Encode());
    }
}
