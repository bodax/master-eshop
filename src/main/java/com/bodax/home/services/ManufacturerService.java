package com.bodax.home.services;

import com.bodax.home.dtos.ManufacturerDto;

import java.util.List;

public interface ManufacturerService {

    List<ManufacturerDto> getManufacturersByCategoryUrl (String categoryUrl);

}
