package com.kh.product.domain.dao;

import com.kh.product.domain.Product;

import java.util.List;

public interface ProductDAO {

  // 상품등록
  Product create(Product product);
  
  // 건별조회
  Product findByProductId(Long productId);
  
  // 전체조회
  List<Product> findAll();
  
  // 수정
  Product update(Long productId, Product product);
  
  // 삭제
  Product delete(Long productId);
}
