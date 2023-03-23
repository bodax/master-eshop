package com.bodax.home.controllers;

import com.bodax.home.dtos.EntryPageInfo;
import com.bodax.home.services.PageInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntryController {

    private final PageInfoService pageInfoService;

    public EntryController(PageInfoService pageInfoService) {
        this.pageInfoService = pageInfoService;
    }

    @GetMapping("/api/page")
    public EntryPageInfo getEntryInformation(@RequestParam (name = "lan") String langCode) {

        return pageInfoService.getEntryPageInformation();
    }


}
