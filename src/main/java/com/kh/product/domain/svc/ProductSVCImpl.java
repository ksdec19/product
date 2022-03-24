package com.kh.product.domain.svc;

import com.kh.product.domain.Product;
import com.kh.product.domain.dao.ProductDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ProductSVCImpl implements ProductSVC {
  
  private final ProductDAO productDAO;
  
  // 상품등록
  @Override
  public Product insert(Product product) {
    return productDAO.create(product);
  }
  
  // 건별조회
  @Override
  public Product findByProductId(Long productId) {
    return productDAO.findByProductId(productId);
  }
  
  // 전체조회
  @Override
  public List<Product> findAll() {
    return productDAO.findAll();
  }
  
  // 수정
  @Override
  public Product update(Long productId, Product product) {
    return productDAO.update(productId, product);
  }
  
  // 삭제
  @Override
  public Product delete(Long productId) {
    return productDAO.delete(productId);
  }
}
