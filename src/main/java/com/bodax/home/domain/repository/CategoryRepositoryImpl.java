package com.bodax.home.domain.repository;

import com.bodax.home.configuration.internationalization.LocaleContext;
import com.bodax.home.domain.mappers.CategoryMapper;
import com.bodax.home.dtos.CategoryDto;
import com.bodax.home.dtos.CategoryMetaInfoDto;
import com.bodax.home.dtos.CategoryPropertyDto;
import com.bodax.home.dtos.PropertyValuesDto;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import util.ResourceUtils;

import java.util.List;
import java.util.Map;

import static com.bodax.home.configuration.internationalization.LocaleContext.*;

@Component
public class CategoryRepositoryImpl implements CategoryRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CategoryRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CategoryDto> findAllCategories() {
        final String query = ResourceUtils.resourceAsString("db/getCategories.sql");

        return jdbcTemplate.query(query, Map.of("lang", getLocaleId()), new CategoryMapper());
    }

    @Override
    public List<PropertyValuesDto> getCharacteristicsValuesByCategory(String groupUrl) {
        final String query = ResourceUtils.resourceAsString("db/getPropertyValuesByCategory.sql");

        return jdbcTemplate.query(query, Map.of("lang", String.valueOf(getLocaleId()), "url", groupUrl),
                (rs, rowNum) -> PropertyValuesDto.builder()
                        .propertyId(rs.getInt("property_id"))
                        .name(rs.getString("name"))
                        .propertyValueId(rs.getInt("property_value_id"))
                        .build());
    }

    //TODO: check possibility for merge with @getCharacteristicsValuesByCategory method
    @Override
    public List<CategoryPropertyDto> getCategoryProperties(String groupUrl) {
        final String query = ResourceUtils.resourceAsString("db/getCharacteristicsByCategory.sql");

        return jdbcTemplate.query(query, Map.of("lang", getLocaleId(), "url", groupUrl),
                (rs, rowNum) -> new CategoryPropertyDto(rs.getInt("property_id"), rs.getString("name")));

    }

    @Override
    public List<CategoryMetaInfoDto> getCategoryMetaInfo(String groupUrl) {

        final String query = "SELECT category_id, name, description, meta_title, meta_keywords, meta_description FROM category_lang WHERE url = :url AND language_id = '1'";

        return jdbcTemplate.query(query, Map.of("lang", getLocaleId(), "url", groupUrl),
                (rs, rowNum) -> CategoryMetaInfoDto.builder().id(rs.getInt("category_id"))
                        .name(rs.getString("name"))
                        .description(rs.getString("description"))
                        .metaTitle(rs.getString("meta_title"))
                        .metaKeywords(rs.getString("meta_keywords"))
                        .metaDescription(rs.getString("meta_description")).build());
    }
}
