package com.yh.st.base.exception;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by DingYS on 2017/2/20.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    protected Logger logger = Logger.getLogger(this.getClass());

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(Exception e, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(DEFAULT_ERROR_VIEW);
        logger.error(e);
        System.out.println(e);
        return mav;
    }
}
