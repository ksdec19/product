package com.kh.product.web;

import com.kh.product.domain.Product;
import com.kh.product.domain.svc.ProductSVC;
import com.kh.product.web.form.AddForm;
import com.kh.product.web.form.DetailForm;
import com.kh.product.web.form.EditForm;
import com.kh.product.web.form.ListForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
  private final ProductSVC productSVC;
  
  // api
  @GetMapping()
  public String Main() {
    return "product";
  }
  
  
//  // 상품등록 화면
//  @GetMapping("/add")
//  private String addForm() {
//    return "product/addForm";
//  }
//
//  // 상품등록 처리
//  @PostMapping("/add")
//  public String add(
//      @ModelAttribute AddForm addForm,
//      RedirectAttributes redirectAttributes,
//      Model model) {
//
//    Product product = new Product();
//    product.setProductName(addForm.getProductName());
//    product.setProductQuantity(addForm.getProductQuantity());
//    product.setProductPrice(addForm.getProductPrice());
//
//    return null;
//  }
//
//  // 단건조회
//  @GetMapping("/{productId}")
//  public String detail(
//      @PathVariable Long productId,
//      Model model) {
//
//    Product detailProduct = productSVC.findByProductId(productId);
//
//    DetailForm detailForm = new DetailForm();
//    BeanUtils.copyProperties(detailProduct, detailForm);
//    model.addAttribute("detailForm", detailForm);
//
//    return "product/list";
//  }
//
//  //전체조회
//  @GetMapping("/all")
//  public String list(Model model) {
//    List<Product> list = productSVC.findAll();
//
//    List<ListForm> partOfList = new ArrayList<>();
//    for (Product product : list) {
//      ListForm listForm = new ListForm();
//      BeanUtils.copyProperties(product, listForm);
//      partOfList.add(listForm);
//    }
//
//    model.addAttribute("list", partOfList);
//    return "/product/list";
//  }
//
//  // 수정양식
//  @GetMapping("/{productId}/edit")
//  public String editForm(@PathVariable Long productId, Model model) {
//
//    Product product = productSVC.findByProductId(productId);
//
//    EditForm editForm = new EditForm();
//    BeanUtils.copyProperties(product, editForm);
//    model.addAttribute("editForm", editForm);
//
//    return "/product/editForm";
//  }
//
//  // 수정처리
//  @PostMapping("/{productId}/edit")
//  public String edit(@PathVariable Long productId,
//                     @Valid @ModelAttribute EditForm editForm,
//                     BindingResult bindingResult,
//                     RedirectAttributes redirectAttributes) {
//
//    Product product = new Product();
//    BeanUtils.copyProperties(editForm, product);
//    productSVC.update(productId, product);
//
//    return "redirect:/product/{productId}";
//  }
//
//  // 삭제
//  @GetMapping("/{productId}/del")
//  public String del(@PathVariable Long productId) {
//
//    productSVC.delete(productId);
//
//    return "redirect:/product";
//  }
//
}
