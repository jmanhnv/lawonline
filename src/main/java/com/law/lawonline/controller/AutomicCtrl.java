package com.law.lawonline.controller;

import com.law.lawonline.common.PageViewer;
import com.law.lawonline.helper.MessageHelper;
import com.law.lawonline.model.Result;
import com.law.lawonline.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class AutomicCtrl {
    @Autowired
    private SearchService searchService;

    @ModelAttribute("tabId")
    String tabId() {
        return "tab-automic";
    }

    @RequestMapping(value = "/automic", method = RequestMethod.GET)
    public String automic(Model model) {
        return PageViewer.AUTOMIC.getView();
    }

    @RequestMapping("/search")
    public String search(Model model, @RequestParam("q") String searchKey, RedirectAttributes ra) {
        if (searchKey == null || searchKey.isEmpty()) {
            MessageHelper.addInfoAttribute(model, "Bạn chưa nhập nội dung tìm kiếm.");
        } else {
            List<Result> results = searchService.search(searchKey);
            model.addAttribute("results", results);
        }

        return PageViewer.AUTOMIC.getView();
    }


    @GetMapping("/user")
    public String user(Principal principal) {
        // Get authenticated user name from Principal
        System.out.println(principal.getName());
        return "user";
    }

    @GetMapping("/admin")
    public String admin() {
        // Get authenticated user name from SecurityContext
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println(context.getAuthentication().getName());
        return "admin";
    }

}
