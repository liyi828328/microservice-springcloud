package perseverance.li.entities;

/**
 * ---------------------------------------------------------------
 * Author: LiYi
 * Email: yi.li@yulore.com
 * Create: 2019-11-25 14:21
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2019-11-25 14:21 : Create by LiYi
 * ---------------------------------------------------------------
 */
public enum ResponseCode {

    /**
     * 成功
     */
    SUCCESS(200, "success"),
    /**
     * 服务异常
     */
    SERVICE_ERROR(500, "service error");

    private Integer code;
    private String msg;

    ResponseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
