package connection.handler;

import connection.handler.RedisCodec;
import connection.handler.MesOutHandler;
import connection.properties.ConnectionProperties;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class RedisChannelInitializer extends ChannelInitializer<NioSocketChannel> {

    @Override
    protected void initChannel(NioSocketChannel ch) throws Exception {
        ch.pipeline().addLast(new MesOutHandler());
        ch.pipeline().addLast(new RedisCodec());
    }
}
