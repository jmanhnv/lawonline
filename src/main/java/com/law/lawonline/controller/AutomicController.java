package com.law.lawonline.controller;

import com.law.lawonline.common.PageViewer;
import com.law.lawonline.helper.Message;
import com.law.lawonline.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class AutomicController {
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
        String msg = null;
        if (searchKey == null || searchKey.isEmpty()) {
            msg = "Bạn chưa nhập nội dung tìm kiếm.";
        } else {
            //msg = String.format("%d document(s) found.", 4);
            DeveloperResource[] devResources = {new DeveloperResource("Google", "http://www.google.com"),
                    new DeveloperResource("Stackoverflow", "http://www.stackoverflow.com"),
                    new DeveloperResource("W3Schools", "http://www.w3schools.com")};

            model.addAttribute("count", devResources.length);

            //TODO test only
            searchService.search(searchKey);
        }

        model.addAttribute(Message.MESSAGE_ATTRIBUTE, msg);
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

    public static final class DeveloperResource {
        private final String name;
        private final String url;

        public DeveloperResource(String name, String url) {
            this.name = name;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }
    }
}
