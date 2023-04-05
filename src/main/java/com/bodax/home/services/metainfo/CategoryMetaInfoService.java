package com.bodax.home.services.metainfo;

import com.bodax.home.dtos.CategoryMetaInfoDto;

import java.util.List;

public interface CategoryMetaInfoService {

 List<CategoryMetaInfoDto> getMetaInfo(String group);

}
