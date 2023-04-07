package com.bodax.home.services;

import com.bodax.home.dtos.EntryPageInfoDto;

import java.util.Set;

public interface PageInfoService {

    EntryPageInfoDto getEntryPageInformation(Set<Integer> watchedProductIds);
}
