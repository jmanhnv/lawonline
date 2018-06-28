package com.law.lawonline.controller;

import com.law.lawonline.common.Constants;
import com.law.lawonline.common.PageViewer;
import com.law.lawonline.model.Result;
import com.law.lawonline.service.SearchService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
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

    //    @RequestMapping(value = "/search", produces = "text/plain;charset=UTF-8", method = RequestMethod.POST)
    @RequestMapping(value = "/search")
    public String search(Model model, @RequestParam("query") String searchKey, RedirectAttributes ra) {
        List<Result> results = searchService.search(searchKey);
        if (results.isEmpty())
            model.addAttribute("msg", "Không tìm thấy nội dung phù hợp.");

        model.addAttribute("results", results);
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

    @RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
    public void download(HttpServletResponse response, HttpServletRequest request, @PathVariable("id") String id) throws IOException {
        String fPath = searchService.getFilePathById(Integer.valueOf(id));
        if (StringUtils.isEmpty(fPath)) // set default
            fPath = USER_HOME + FILE_SEPARATOR + "data" + FILE_SEPARATOR + "Ban an so 113-2018- HSST.pdf";

        File f = new File(fPath);
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
