package com.bodax.home.domain.repository;

import com.bodax.home.domain.mappers.ProductMapper;
import com.bodax.home.dtos.ProductDto;
import com.bodax.home.dtos.ProductMetaInfo;
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
        var query = ResourceUtils.resourceAsString("db/getProductsByCategory.sql");

        return jdbcTemplate.query(query, Map.of("lang", String.valueOf(getLocaleId()), "groupUrl", groupUrl), new ProductMapper());
    }

    @Override
    public List<ProductDto> getRelationsForAllProductsInCategory(String groupUrl) {
        var query = ResourceUtils.resourceAsString("db/getRelationProductsForAllProductsInCategory.sql");

        return jdbcTemplate.query(query, Map.of("lang", String.valueOf(getLocaleId()), "url", groupUrl), new ProductMapper());
    }

    @Override
    public ProductDto getProductByUrl(String productId) {
        var query = ResourceUtils.resourceAsString("db/getProductByUrl.sql");
        var properties = Map.of("lang", String.valueOf(getLocaleId()), "url", productId);

        return jdbcTemplate.queryForObject(query, properties, new ProductMapper());
    }

    @Override
    public Set<String> getProductPhotosByCategoryUrl(String url) {
        var query = "SELECT DISTINCT filename FROM product_image pi JOIN product_lang pl ON pl.product_id = pi.product_id WHERE pl.url = :url";
        var properties = Map.of("url", url);

        return new HashSet<>(jdbcTemplate.query(query, properties, (rs, rowNum) -> rs.getString("filename")));
    }

    @Override
    public List<ProductPropertiesDto> getProductPropertiesByUrl(String productUrl) {
        var query = ResourceUtils.resourceAsString("db/getProductPropertiesByUrl.sql");
        var properties = Map.of("lang", String.valueOf(getLocaleId()), "url", productUrl);

        return jdbcTemplate.query(query, properties, (rs, rowNum) -> new ProductPropertiesDto(
                rs.getInt("property_id"),
                rs.getString("characteristic"),
                rs.getString("value")
        ));
    }

    @Override
    public List<ProductDto> getRelatedProducts(String productUrl) {
        var query = ResourceUtils.resourceAsString("db/getRelatedProductsByProductUrl.sql");

        return jdbcTemplate.query(query, Map.of("lang", String.valueOf(getLocaleId()), "url", productUrl), new ProductMapper());
    }

    @Override
    public String getProductDescriptionByUrl(String productUrl) {
        var query = "SELECT description FROM product_lang pl WHERE pl.url = :url AND pl.language_id = :lang";

        return jdbcTemplate.queryForObject(query, Map.of("lang", String.valueOf(getLocaleId()), "url", productUrl), String.class);
    }

    @Override
    public ProductMetaInfo getProductMetaInfo(String productUrl) {
        var query = "SELECT product_id, name, description, meta_title, meta_keywords, meta_description FROM product_lang WHERE url = :url AND language_id = :lang";

        return jdbcTemplate.queryForObject(query, Map.of("lang", String.valueOf(getLocaleId()), "url", productUrl),
                (rs, rowNum) -> ProductMetaInfo.builder().id(rs.getInt("product_id"))
                        .name(rs.getString("name"))
                        .description(rs.getString("description"))
                        .metaTitle(rs.getString("meta_title"))
                        .metaKeywords(rs.getString("meta_keywords"))
                        .metaDescription(rs.getString("meta_description"))
                        .build());
    }
}
