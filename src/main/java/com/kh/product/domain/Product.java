package com.kh.product.domain;

import lombok.Data;

@Data
public class Product {
  Long productId;         // 상품번호     number(10)
  String productName;     // 상품명       varchar2(50)
  Long productQuantity;   // 상품수량     number(10)
  Long productPrice;      // 상품가격     number(10)
}
