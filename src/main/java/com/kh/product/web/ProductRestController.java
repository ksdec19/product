package com.kh.product.web;

import com.kh.product.domain.Product;
import com.kh.product.domain.svc.ProductSVC;
import com.kh.product.web.api.ApiResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/product/api")
public class ProductRestController {
  
    private final ProductSVC productSVC;
    
    // 상품등록
    @ResponseBody
    @PostMapping
    public ApiResult<Product> create (@RequestBody Product product) {
      Product insertProduct = productSVC.insert(product);
      ApiResult<Product> result = new ApiResult<>("00", "success", insertProduct);
      
      return result;
    }
    
    
//     전체조회
    @ResponseBody
    @GetMapping
    public ApiResult<List<Product>> findAll() {
      List<Product> list = productSVC.findAll();
      ApiResult<List<Product>> result = null;
      
      if(list.size() > 0) {
        result = new ApiResult<>("00", "success", list);
      } else {
        result = new ApiResult<>("99", "success", null);
      }
      return result;
    }
    
    // 건별조회
    @ResponseBody
    @GetMapping("/{productId}")
    public ApiResult<Product> findById(@PathVariable Long productId) {
      Product findedProduct = productSVC.findByProductId(productId);
      ApiResult<Product> result = null;
      
      if(findedProduct != null) {
        result = new ApiResult<>("00", "success", findedProduct);
      } else {
        result = new ApiResult<>("99", "fail", null);
      }
      return result;
    }
    
    // 수정
    @ResponseBody
    @PatchMapping("/{productId}")
    public ApiResult<Object> update(@PathVariable Long productId, @RequestBody Product product) {
      
      Product beforeUpdateProduct = productSVC.update(productId, product);
      
      ApiResult<Object> result = null;
      if(beforeUpdateProduct != null) {
        result = new ApiResult<>("00", "success", productSVC.update(productId, product));
      } else {
        result = new ApiResult<>("99", "fail", "입력하신 상품은 존재하지 않습니다.");
      }
      return result;
    }
    
    // 삭제
    @ResponseBody
    @DeleteMapping("/{productId}")
    public ApiResult<String> delete(@PathVariable Long productId) {
      
      Product deleteProduct = productSVC.delete(productId);
      
      ApiResult<String> result = null;
      if(deleteProduct != null) {
        result = new ApiResult<>("99", "fail", "입력하신 상품은 존재하지 않습니다");
  
      } else {
        result = new ApiResult<>("00", "success", "삭제완료!");
    
      }
      return result;
    }

}
