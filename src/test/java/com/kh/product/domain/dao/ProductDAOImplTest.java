package com.kh.product.domain.dao;

import com.kh.product.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ProductDAOImplTest {
  
  @Autowired
  private ProductDAO productDAO;
  
  @Test
  @DisplayName("상품등록")
  void create() {
    Product product = new Product();
  
    product.setProductName("포켓몬빵");
    product.setProductQuantity(3L);
    product.setProductPrice(3000L);
  
    Product create = productDAO.create(product);
    Assertions.assertThat(create.getProductId()).isEqualTo(6);
    log.info("create={}", create);
  }
  
  @Test
  @DisplayName("건별조회")
  void findByProductId() {
    Long productId = 1L;
    Product findedProduct = productDAO.findByProductId(productId);
    Assertions.assertThat(findedProduct.getProductName()).isEqualTo("피카츄빵");
    log.info("product={}", findedProduct);
  }
  
  @Test
  @DisplayName("전체조회")
  void findAll() {
    List<Product> list = productDAO.findAll();
    Assertions.assertThat(list.size()).isEqualTo(4);
    log.info("list={}", list);
  }
  
  @Test
  @DisplayName("수정")
  void update() {
    Long productId = 5L;
    
    Product beforeUpdateProduct = productDAO.findByProductId(productId);
    log.info("beforeUpdateProduct{}", beforeUpdateProduct);
    
    beforeUpdateProduct.setProductName("캐스퍼");
    beforeUpdateProduct.setProductQuantity(1L);
    beforeUpdateProduct.setProductPrice(20000000L);
    productDAO.update(productId, beforeUpdateProduct);
    
    Product afterUpdateProduct = productDAO.findByProductId(productId);
  
    Assertions.assertThat(beforeUpdateProduct.getProductName()).isEqualTo(afterUpdateProduct.getProductName());
    Assertions.assertThat(beforeUpdateProduct.getProductQuantity()).isEqualTo(afterUpdateProduct.getProductQuantity());
    Assertions.assertThat(beforeUpdateProduct.getProductPrice()).isEqualTo(afterUpdateProduct.getProductPrice());
    log.info("afterUpdateProduct={}",afterUpdateProduct);
  }
  
  @Test
  @DisplayName("삭제")
  void delete() {
    Long productId = 4L;
    
    Product deleteProduct = productDAO.delete(productId);
    Assertions.assertThat(productDAO.findByProductId(4L)).isNull();
  }
  
}