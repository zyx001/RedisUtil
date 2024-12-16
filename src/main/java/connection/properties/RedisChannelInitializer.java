package connection.properties;

import connection.handler.Encode;
import connection.handler.MesOutHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class RedisChannelInitializer extends ChannelInitializer<NioSocketChannel> {
    @Override
    protected void initChannel(NioSocketChannel ch) throws Exception {
//        ch.pipeline().addLast(new LoggingHandler(LogLevel.INFO)); // 日志处理器（可选）
//        ch.pipeline().addLast(new ClientInfoHandler());
        ch.pipeline().addLast(new MesOutHandler());
        ch.pipeline().addLast(new Encode());
    }
}
