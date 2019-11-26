package perseverance.li.consumer.books.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import perseverance.li.entities.Response;
import perseverance.li.entities.ResponseCode;
import perseverance.li.exception.BaseException;

import java.sql.Timestamp;

/**
 * ---------------------------------------------------------------
 * Author: LiYi
 * Email: yi.li@yulore.com
 * Create: 2019-11-25 15:27
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2019-11-25 15:27 : Create by LiYi
 * ---------------------------------------------------------------
 */
@RestControllerAdvice
public class ResponseExceptionHandler {

    /**
     * 处理未捕获的Exception
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        e.printStackTrace();
        //log.e xxx
        System.out.println("ResponseExceptionHandler exception");
        Response response = new Response(ResponseCode.SERVICE_ERROR.getCode(), ResponseCode.SERVICE_ERROR.getMsg(),
                null, e.getMessage(), new Timestamp(System.currentTimeMillis()));
        return response;
    }

    /**
     * 处理未捕获的RuntimeException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public Response handleRuntimeException(RuntimeException e) {
        //log.e xxx
        e.printStackTrace();
        System.out.println("ResponseExceptionHandler RuntimeException" );
        Response response = new Response(ResponseCode.SERVICE_ERROR.getCode(), ResponseCode.SERVICE_ERROR.getMsg(),
                null, e.getMessage(), new Timestamp(System.currentTimeMillis()));
        return response;
    }

    /**
     * 处理业务异常BaseException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public Response handleBaseException(BaseException e) {
        //log.e xxx
        System.out.println("ResponseExceptionHandler BaseException");
        ResponseCode baseResponse = e.getResponseCode();
        Response response = new Response(baseResponse.getCode(), baseResponse.getMsg(),
                null, null, null);
        return response;
    }
}
