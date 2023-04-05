package com.bodax.home.domain.repository;

import com.bodax.home.dtos.ManufacturerDto;

import java.util.List;

public interface ManufacturerRepository {
    List<ManufacturerDto> getManufacturersByCategoryUrl(String categoryUrl);
}
