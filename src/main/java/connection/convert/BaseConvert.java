package connection.convert;

import connection.MsgContext;
import util.StringUtils;

public class BaseConvert {

    private String context;

    public static <T extends MsgContext> MsgContext converterToMeg(String context) {
        if (StringUtils.isEmpty(context)) {
            throw new RuntimeException("指令为空，转换失败。");
        }
        String[] contextSplit = context.split(" ");
        return MsgContext.build().setContexts(contextSplit);
    }

}
