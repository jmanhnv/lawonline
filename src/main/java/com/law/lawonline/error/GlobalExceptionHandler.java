package com.law.lawonline.error;

import com.google.common.base.Throwables;
import com.law.lawonline.common.Constants;
import com.law.lawonline.helper.Message;
import com.law.lawonline.helper.MessageHelper;
import groovy.util.logging.Slf4j;
import org.elasticsearch.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@ControllerAdvice(basePackages = "com.law.lawonline.controller")
public class GlobalExceptionHandler implements Constants {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Autowired
    private MessageSource messageSource;

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, "date", new CustomDateEditor(dateFormat, true));
    }

    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public Message handleException(Exception e, Model m) {
        logger.error("An unknow exception ocurred ", e);

        MessageHelper.addErrorAttribute(m, e.getMessage());

        return new Message(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), Message.Type.DANGER);
    }

    @ResponseBody
    @ExceptionHandler(value = NullPointerException.class)
    public Message handleNullPointerException(Exception e) {
        logger.error("A null pointer exception ocurred ", e);
        return null;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public Message handleResourceNotFoundException() {
        logger.error("An resource not found exception ocurred");
        return new Message(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), Message.Type.DANGER);
    }

    public static String getExceptionMessage(Throwable throwable, Integer statusCode) {
        if (throwable != null)
            return Throwables.getRootCause(throwable).getMessage();

        HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
        return httpStatus.getReasonPhrase();
    }
}
