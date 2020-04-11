package com.uchung.departmentappraise.controller;

import com.uchung.departmentappraise.service.exception.InfoEmptyException;
import com.uchung.departmentappraise.service.exception.OtherException;
import com.uchung.departmentappraise.service.exception.ServiceException;
import com.uchung.departmentappraise.until.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 父类控制器
 */
public class BaseController {
    public static final Integer SUCCESS = 200;
//    protected static Logger log = LoggerFactory.getLogger(BaseController.class);

    /**
     * 处理异常处
     * @param e
     * @return
     */
    @ExceptionHandler({ServiceException.class})
    @ResponseBody
    public JsonResult<Void> HandleException(Throwable e){
        JsonResult<Void> jr =new JsonResult<>(e);
        if(e instanceof InfoEmptyException) {
            jr.setState(401);
        }else if(e instanceof OtherException){
            jr.setState(402);
        }
        return jr;
    }
}
