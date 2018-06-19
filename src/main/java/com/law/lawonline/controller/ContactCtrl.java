package com.law.lawonline.controller;

import com.law.lawonline.common.PageViewer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactCtrl {
    @ModelAttribute("tabId")
    String tabId() {
        return "tab-contact";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        return PageViewer.CONTACT.getView();
    }
}
