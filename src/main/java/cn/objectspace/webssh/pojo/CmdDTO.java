package cn.objectspace.webssh.pojo;

public class CmdDTO {
    private String cmd;


    public CmdDTO() {
    }

    public CmdDTO(String cmd) {
        this.cmd = cmd;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    @Override
    public String toString() {
        return "CmdDTO{" +
                "cmd='" + cmd + '\'' +
                '}';
    }
}
