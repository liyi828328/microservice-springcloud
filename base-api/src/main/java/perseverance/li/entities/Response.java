package perseverance.li.entities;

import java.sql.Timestamp;

/**
 * ---------------------------------------------------------------
 * Author: perseverance_li
 * Email: perseverance_li@126.com
 * Create: 2019-11-22 17:02
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2019-11-22 17:02 : Create by perseverance_li
 * ---------------------------------------------------------------
 */

public class Response {

    private Integer code;
    private String msg;
    private Object data;
    private Timestamp timestamp;
    private String errorMsg;

    public Response() {
    }

    public Response(Integer code, String msg, Object data, String errorMsg, Timestamp timestamp) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.errorMsg = errorMsg;
        this.timestamp = timestamp;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
