package com.law.lawonline.error;

import com.law.lawonline.helper.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;

@Controller
public class ErrorController {
    /**
     * Display an error page, as defined in web.xml <location>/error</location> element.
     */
    @RequestMapping("error")
    public String generalError(HttpServletRequest request, Model model) {
        // retrieve some useful information from the request
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        // String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
        String exceptionMessage = GlobalExceptionHandler.getExceptionMessage(throwable, statusCode);

        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }

        String message = MessageFormat.format("{0} returned for {1} with message {2}",
                statusCode, requestUri, exceptionMessage
        );

        model.addAttribute(Message.MESSAGE_ATTRIBUTE, message);
        return "error/500";
    }

}
