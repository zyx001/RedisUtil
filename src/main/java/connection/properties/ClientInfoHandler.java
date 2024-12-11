package connection.properties;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientInfoHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 打印连接成功的信息
        System.out.println("Connected to server: " + ctx.channel().remoteAddress());

        // 如果需要发送数据，可以在这里发起请求
        ctx.writeAndFlush("Hello, Server!");

        // 如果不需要发送任何消息，可以注释掉上面的行
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // 处理异常
        cause.printStackTrace();
        ctx.close();
    }
}
