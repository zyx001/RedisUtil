package connection.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;

public class ChannelActiveWatchHandler extends ChannelInboundHandlerAdapter {

    public ChannelGroup channelGroup;

    /**
     * 监听channel连事件，当有链接产生时，将链接的channel放入ChannelGroup中。
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        channelGroup.add(ctx.channel());
        ctx.fireChannelActive();
    }
}
