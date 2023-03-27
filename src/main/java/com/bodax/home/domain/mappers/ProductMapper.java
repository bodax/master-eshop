package com.bodax.home.domain.mappers;

import com.bodax.home.dtos.ProductDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<ProductDto> {
    @Override
    public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ProductDto.builder()
                .productId(rs.getInt("product_id"))
                .productName(rs.getString("product_name"))
                .categoryId(rs.getString("category_id"))
                .categoryName(rs.getString("category_name"))
                .price(rs.getDouble("base_price"))
                .discountPercent(rs.getDouble("discount_percent"))
                .url(rs.getString("url"))
                .fileName(rs.getString("fileName"))
                .iso(rs.getString("iso"))
                .build();
    }
}
