package com.bodax.home.controllers;

import com.bodax.home.dtos.EntryPageInfoDto;
import com.bodax.home.services.PageInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class EntryController {

    private final PageInfoService pageInfoService;

    public EntryController(PageInfoService pageInfoService) {
        this.pageInfoService = pageInfoService;
    }

    @PostMapping("/api/page")
    public EntryPageInfoDto getEntryInformation(@RequestBody Set<Integer> watchedProductIds) {

        return pageInfoService.getEntryPageInformation(watchedProductIds);
    }


}
