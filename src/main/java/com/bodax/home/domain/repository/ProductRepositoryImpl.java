package com.bodax.home.domain.repository;

import com.bodax.home.domain.mappers.ProductMapper;
import com.bodax.home.dtos.ProductDto;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import util.ResourceUtils;

import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final NamedParameterJdbcOperations jdbcTemplate;

    public ProductRepositoryImpl(NamedParameterJdbcOperations jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ProductDto> getProductsByCategoryId(String groupUrl) {
        final String query = ResourceUtils.resourceAsString("db/getProductsByCategory.sql");
        Map<String, String> properties = Map.of("lang", "1", "groupUrl", groupUrl);

        return jdbcTemplate.query(query, properties, new ProductMapper());
    }

    @Override
    public List<ProductDto> getRelationsForAllProductsInCategory(String groupUrl) {
        final String query = ResourceUtils.resourceAsString("db/getRelationProductsForAllProductsInCategory.sql");
        Map<String, String> properties = Map.of("lang", "1", "url", groupUrl);

        return jdbcTemplate.query(query, properties, new ProductMapper());

    }
}
