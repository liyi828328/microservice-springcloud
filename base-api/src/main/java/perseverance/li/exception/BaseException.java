package perseverance.li.exception;

import perseverance.li.entities.ResponseCode;

/**
 * ---------------------------------------------------------------
 * Author: LiYi
 * Email: yi.li@yulore.com
 * Create: 2019-11-25 15:25
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2019-11-25 15:25 : Create by LiYi
 * ---------------------------------------------------------------
 */
public class BaseException extends RuntimeException {

    private ResponseCode responseCode;

    public BaseException(ResponseCode code) {
        this.responseCode = code;
    }

    public BaseException(Throwable cause, ResponseCode code) {
        super(cause);
        this.responseCode = code;
    }

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }
}
