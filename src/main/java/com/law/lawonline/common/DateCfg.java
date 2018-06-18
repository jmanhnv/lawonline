package com.law.lawonline.common;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateCfg {
    private static DateCfg ourInstance = new DateCfg();

    public static DateCfg getInstance() {
        return ourInstance;
    }

    private DateCfg() {
    }

    public static Date getSysDate() {
        return new GregorianCalendar().getTime();
    }
}
