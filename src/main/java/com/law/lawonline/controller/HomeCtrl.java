package com.law.lawonline.controller;

import com.law.lawonline.common.PageViewer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeCtrl {
    @ModelAttribute("tabId")
    String tabId() {
        return "tab-home";
    }

    @GetMapping("/")
    public String index() {
        return PageViewer.HOME.getView();
    }
}
