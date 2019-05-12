package cn.xzxy.lewy.iaweb.util;

public class MyMessage {

    //0表示成功;-1表示失败
    private String status;
    //向前端返回的内容
    private String message;

    public MyMessage(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

}
