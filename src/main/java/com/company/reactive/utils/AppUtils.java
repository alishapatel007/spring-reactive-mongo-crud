package com.company.reactive.utils;

import com.company.reactive.dto.ProductDto;
import com.company.reactive.entity.Product;
import org.springframework.beans.BeanUtils;

//@Mapper(componentModel="spring")
public class AppUtils {
    /*AppUtils MAPPER = Mappers.getMapper(AppUtils.class);
    ProductDto entityToDto(Product entity);
    Product dtoToEntity(ProductDto dto);*/

    public static ProductDto entityToDto(Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    public static Product dtoToEntity(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }
}
