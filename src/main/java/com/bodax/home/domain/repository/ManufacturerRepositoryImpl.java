package com.bodax.home.domain.repository;

import com.bodax.home.configuration.internationalization.LocaleContext;
import com.bodax.home.dtos.ManufacturerDto;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import util.ResourceUtils;

import java.util.List;
import java.util.Map;

import static com.bodax.home.configuration.internationalization.LocaleContext.*;


@Repository
public class ManufacturerRepositoryImpl implements ManufacturerRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ManufacturerRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ManufacturerDto> getManufacturersByCategoryUrl(String categoryUrl) {
        final String query = ResourceUtils.resourceAsString("db/getManufacturersByCategory.sql");

        return jdbcTemplate.query(query, Map.of("lang", getLocaleId(), "url", categoryUrl),
                (rs, rowNum) -> new ManufacturerDto(rs.getInt("manufacturer_id"), rs.getString("name")));
    }
}
