package com.law.lawonline.controller;

import com.law.lawonline.common.PageViewer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConsultantController {
    @ModelAttribute("tabId")
    String tabId() {
        return "tab-consult";
    }

    @RequestMapping(value = "/consult", method = RequestMethod.GET)
    public String consult(Model model) {
        return PageViewer.CONSULTANT.getView();
    }
}
