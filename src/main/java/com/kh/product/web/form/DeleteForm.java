package com.kh.product.web.form;

import lombok.Data;

@Data
public class DeleteForm {

  private String productId;
  private String productName;
  private Long productQuantity;
  private Long productPrice;
  
}
