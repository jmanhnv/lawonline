package com.law.lawonline.config;

import com.law.lawonline.common.Constants;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer implements Constants {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{SLASH};
    }
}
