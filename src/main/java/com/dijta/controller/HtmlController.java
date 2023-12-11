package com.dijta.controller;


import com.dijta.HtmlSanitizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HtmlController {

    private final HtmlSanitizer htmlSanitizer;

    @Autowired
    public HtmlController(HtmlSanitizer htmlSanitizer) {
        this.htmlSanitizer = htmlSanitizer;
    }

    @PostMapping("/sanitize")
    public String sanitizeHtml(@RequestBody String inputHtml) {
        String sanitizedHtml = htmlSanitizer.sanitizeHtml(inputHtml);
        return sanitizedHtml;
    }
}

