package com.bodax.home.services;

import com.bodax.home.domain.repository.ManufacturerRepository;
import com.bodax.home.dtos.ManufacturerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<ManufacturerDto> getManufacturersByCategoryUrl(String categoryUrl) {
        return manufacturerRepository.getManufacturersByCategoryUrl(categoryUrl);
    }
}
