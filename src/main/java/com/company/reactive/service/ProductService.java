package com.company.reactive.service;

import com.company.reactive.dto.ProductDto;
import com.company.reactive.repo.ProductRepository;
import com.company.reactive.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Flux<ProductDto> getProducts(){
        return productRepository.findAll().map(AppUtils::  entityToDto);
    }

    public Mono<ProductDto> getProduct(String id){
        return productRepository.findById(id).map(AppUtils :: entityToDto);
    }

    public Flux<ProductDto> getProductInPriceRange(double min, double max){
        return productRepository.findByPriceBetween(Range.closed(min,max));
    }

    public Mono<ProductDto> saveProduct(Mono<ProductDto> dtoMono){
        return dtoMono.map(AppUtils :: dtoToEntity)
                .flatMap(productRepository :: insert)
                .map(AppUtils :: entityToDto);
    }

    public Mono<ProductDto> updateProduct(Mono<ProductDto> productDtoMono , String id){
        return productRepository.findById(id)
                .flatMap(p->productDtoMono.map(AppUtils::dtoToEntity))
                .flatMap(productRepository::save)
                .map(AppUtils::entityToDto);
    }

    public Mono<Void> deleteProduct(String id){
        return productRepository.deleteById(id);
    }
}
