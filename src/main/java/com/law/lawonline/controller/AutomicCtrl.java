package com.law.lawonline.controller;

import com.law.lawonline.common.Constants;
import com.law.lawonline.common.PageViewer;
import com.law.lawonline.helper.MessageHelper;
import com.law.lawonline.model.Result;
import com.law.lawonline.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class AutomicCtrl implements Constants {
    @Autowired
    private SearchService searchService;

    @ModelAttribute("tabId")
    String tabId() {
        return "tab-automic";
    }

    @RequestMapping(value = "/automic")
    public String automic() {
        return PageViewer.AUTOMIC.getView();
    }

    @RequestMapping("/search")
    public String search(Model model, @RequestParam("query") String searchKey, RedirectAttributes ra) {
        if (searchKey == null || searchKey.isEmpty()) {
            MessageHelper.addInfoAttribute(model, "Bạn chưa nhập nội dung tìm kiếm.");
        } else {
            List<Result> results = searchService.search(searchKey);
            model.addAttribute("results", results);
        }

        return PageViewer.AUTOMIC.getView();
    }

    @RequestMapping(value = "/preview")
    public void preview(HttpServletResponse response) throws IOException {
        File f = new File(USER_HOME + FILE_SEPARATOR + "data" + FILE_SEPARATOR + "Ban so 154-2018-HSST.pdf");
        FileInputStream fis = new FileInputStream(f);
        byte[] buffer = new byte[10240]; // default set file size is 10MB
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }

        response.setHeader("Content-Disposition", "inline; filename=\"" + f.getName() + "\"");
        response.setContentType("application/pdf");

        ServletOutputStream outputStream = response.getOutputStream();
        baos.writeTo(outputStream);
        outputStream.flush();
    }

}
