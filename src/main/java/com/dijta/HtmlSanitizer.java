package com.dijta;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.stereotype.Component;

@Component
public class HtmlSanitizer {

    public String sanitizeHtml(String inputHtml) {
        return Jsoup.clean(inputHtml, Whitelist.basic());
    }
}

