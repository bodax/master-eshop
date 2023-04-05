package com.bodax.home.domain.repository;

import com.bodax.home.domain.mappers.ProductMapper;
import com.bodax.home.dtos.ProductDto;
import com.bodax.home.dtos.ProductPropertiesDto;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import util.ResourceUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.bodax.home.configuration.internationalization.LocaleContext.getLocaleId;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final NamedParameterJdbcOperations jdbcTemplate;

    public ProductRepositoryImpl(NamedParameterJdbcOperations jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ProductDto> getProductsByCategoryId(String groupUrl) {
        final String query = ResourceUtils.resourceAsString("db/getProductsByCategory.sql");
        Map<String, String> properties = Map.of("lang", String.valueOf(getLocaleId()), "groupUrl", groupUrl);

        return jdbcTemplate.query(query, properties, new ProductMapper());
    }

    @Override
    public List<ProductDto> getRelationsForAllProductsInCategory(String groupUrl) {
        final String query = ResourceUtils.resourceAsString("db/getRelationProductsForAllProductsInCategory.sql");
        Map<String, String> properties = Map.of("lang", String.valueOf(getLocaleId()), "url", groupUrl);

        return jdbcTemplate.query(query, properties, new ProductMapper());
    }

    @Override
    public ProductDto getProductByUrl(String productId) {
        final String query = ResourceUtils.resourceAsString("db/getProductByUrl.sql");
        Map<String, String> properties = Map.of("lang", String.valueOf(getLocaleId()), "url", productId);

        return jdbcTemplate.queryForObject(query, properties, new ProductMapper());
    }

    @Override
    public Set<String> getProductPhotosByCategoryUrl(String url) {
        final String query = "SELECT DISTINCT filename FROM product_image pi JOIN product_lang pl ON pl.product_id = pi.product_id WHERE pl.url = :url";
        Map<String, String> properties = Map.of("url", url);

        return new HashSet<>(jdbcTemplate.query(query, properties, (rs, rowNum) -> rs.getString("filename")));
    }

    @Override
    public List<ProductPropertiesDto> getProductPropertiesByUrl(String productUrl) {
        final String query = ResourceUtils.resourceAsString("db/getProductPropertiesByUrl.sql");
        Map<String, String> properties = Map.of("lang", String.valueOf(getLocaleId()), "url", productUrl);

        return jdbcTemplate.query(query, properties, (rs, rowNum) -> new ProductPropertiesDto(
                rs.getInt("property_id"),
                rs.getString("characteristic"),
                rs.getString("value")
        ));

    }
}
