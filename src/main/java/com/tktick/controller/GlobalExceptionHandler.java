package com.tktick.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import com.tktick.model.constant.WebConstant;
import com.tktick.utils.WebUtil;

/**
 * 全局异常管理
 * 不会与springboot的BasicErrorController发生冲突
 * 替换掉HandlerExceptionResolver的方式，该方式与springboot中会发生冲突
 * 只能处理异常 500错误等，不能对404等错误进行管理
 * 对404错误需要使用 MyBasicErrorController该类目前只处理404页面的问题，根据路径不同跳转不同目录下的错误页面
 * @author user
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	public static final String DEFAULT_ERROR_PATH = "/web/error";
	
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, HttpServletResponse resp, Exception e) throws Exception {
    	e.printStackTrace();
    	if(WebUtil.isAjax(req)){
			PrintWriter writer = null;
			try {
				//resp.reset();
				writer = resp.getWriter();
				resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				resp.setContentType(MediaType.APPLICATION_JSON_VALUE);
				resp.setCharacterEncoding(WebConstant.DEFAULT_ENCODING); //避免乱码
				resp.setHeader("Cache-Control", "no-cache, must-revalidate");
				writer.print("chucuo");
				writer.flush();
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if(writer != null) writer.close();
			}
		}else{
	        ModelAndView mav = new ModelAndView();
	        mav.addObject("exception", e);
	        mav.addObject("url", req.getRequestURL());
	        mav.setViewName(DEFAULT_ERROR_PATH+"/500");
	        return mav;
		}
        return null;
    }
}
