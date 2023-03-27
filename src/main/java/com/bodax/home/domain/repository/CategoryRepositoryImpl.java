package com.bodax.home.domain.repository;

import com.bodax.home.domain.entity.Category;
import com.bodax.home.domain.mappers.CategoryMapper;
import com.bodax.home.dtos.PropertyDto;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import util.ResourceUtils;

import java.util.List;
import java.util.Map;

@Component
public class CategoryRepositoryImpl implements CategoryRepository {

    public CategoryRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Category> findAllCategories() {
        final String query = ResourceUtils.resourceAsString("db/getCategories.sql");

        return jdbcTemplate.query(query, Map.of("lang", "1"), new CategoryMapper());
    }

    @Override
    public List<PropertyDto> getCharacteristicsValuesByCategory(String groupUrl) {
        final String query = ResourceUtils.resourceAsString("db/getCharacteristicsValuesByCategory.sql");

        return jdbcTemplate.query(query, Map.of("lang", "1", "url", groupUrl),
                (rs, rowNum) -> PropertyDto.builder()
                        .propertyId(rs.getInt("property_id"))
                        .name(rs.getString("name"))
                        .propertyValueId(rs.getInt("property_value_id"))
                        .build());
    }

}
