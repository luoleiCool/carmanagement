package com.luol.carmanagement.global;


import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.io.IOException;
import java.io.PrintWriter;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    /**
     * 参数空异常
     * @param e
     * @param resp
     */
    @ExceptionHandler(NullPointerException.class)
    public void nullException(NullPointerException e, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        log.error("参数空异常!");
        log.error(e.getMessage());
        PrintWriter out = resp.getWriter();
        out.write("参数空异常!");
        out.flush();
        out.close();
    }

}
