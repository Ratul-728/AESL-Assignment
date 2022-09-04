package Assignment.Assignment.User;

public class UserResponse {
    private String status;
    private String msg;
    private Object data;

    public UserResponse(String status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public UserResponse() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void showResponse(){
        System.out.println("Status: "+ status);
        System.out.println("Message: "+ msg);
        System.out.println("Dat : "+ data);
    }
}
