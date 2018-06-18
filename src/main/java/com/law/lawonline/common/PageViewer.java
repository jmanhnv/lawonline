package com.law.lawonline.common;

public enum PageViewer {
    HOME("home"),
    AUTOMIC("automic"),
    CONSULTANT("consultant"),
    CONTACT("contact"),
    NOT_FOUND("404"),
    INTERNAL_SERVER_ERROR("500");

    String view;

    PageViewer(String view) {
        this.view = view;
    }

    public String getView() {
        return view;
    }

    @Override
    public String toString() {
        return view;
    }
}
