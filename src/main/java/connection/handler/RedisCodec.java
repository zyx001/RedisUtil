package connection.handler;

import connection.MsgContext;
import connection.convert.BaseConvert;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class RedisCodec extends ByteToMessageCodec<String> {

    private static final String BEGIN_SYMBOL = "*";

    private static final String SEPARATOR = "\r\n";

    private static final String DOLLAR = "$";

    @Override
    protected void encode(ChannelHandlerContext ctx, String msg, ByteBuf out) throws Exception {
        MsgContext msgContext = BaseConvert.converterToMeg(msg);
        String[] contexts = msgContext.getContexts();
        StringBuilder command = new StringBuilder(BEGIN_SYMBOL);
        command.append(contexts.length);
        command.append(SEPARATOR);
        for (String context : contexts) {
            command.append(DOLLAR).append(context.length()).append(SEPARATOR).append(context).append(SEPARATOR);
        }
        msgContext.setCommand(command.toString());
        System.out.println(command);
        byte[] commandBytes = msgContext.getCommand().getBytes(StandardCharsets.UTF_8);
        out.writeBytes(commandBytes);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        byte[] bytes = new byte[in.readableBytes()];
        in.readBytes(bytes);
    }
}
