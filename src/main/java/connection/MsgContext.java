package connection;

import java.io.Serializable;

public class MsgContext implements Serializable {

    private static final long serialVersionUID = -3380250635322546456L;

    private String command;

    private String[] contexts;

    public MsgContext(){}

    public static MsgContext build(){
        return new MsgContext();
    }

    public MsgContext setContexts(String[] contexts){
        this.contexts = contexts;
        return this;
    }

    public String[] getContexts(){
        return this.contexts;
    }


    public String getCommand() {
        return command;
    }

    public MsgContext setCommand(String command) {
        this.command = command;
        return this;
    }
}
