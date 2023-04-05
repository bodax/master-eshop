package com.bodax.home.domain.mappers;

import com.bodax.home.dtos.CategoryDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<CategoryDto> {
    @Override
    public CategoryDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        CategoryDto category = new CategoryDto();
        category.setId(rs.getLong("category_id"));
        category.setName(rs.getString("name"));
        category.setUrl(rs.getString("url"));
        category.setParentId(rs.getLong("parent_id"));
        category.setFilename(rs.getString("filename"));

        return category;
    }
}
