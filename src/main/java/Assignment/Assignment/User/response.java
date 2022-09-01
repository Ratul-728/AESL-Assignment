package Assignment.Assignment.User;

public class response {
    private String Status;
    private String msg;
    private String data;

    public response(String status, String msg, String data) {
        Status = status;
        this.msg = msg;
        this.data = data;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
