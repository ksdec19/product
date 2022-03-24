package com.kh.product.web.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AddForm {
  
  @NotBlank @Size(min = 1, max = 50)
  private String productName;
  
  @NotBlank @Size(min = 1, max = 10)
  private Long productQuantity;
  
  @NotBlank @Size(min = 1, max = 10)
  private Long productPrice;
  
}
