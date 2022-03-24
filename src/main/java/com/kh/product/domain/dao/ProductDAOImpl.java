package com.kh.product.domain.dao;

import com.kh.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductDAOImpl implements ProductDAO {
  
  private final JdbcTemplate jdbcTemplate;
  
  // 상품등록
  @Override
  public Product create(Product product) {
  
    // SQL 작성
    StringBuffer sql = new StringBuffer();
    sql.append("insert into product ");
    sql.append("values( ");
    sql.append("    product_product_id_seq.nextval, ");   // 상품번호(시퀀스)
    sql.append("    ? , ");                               // 상품명
    sql.append("    ? , ");                               // 수량
    sql.append("    ? ) ");                               // 가격
  
    // SQL 실행
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(new PreparedStatementCreator() {
      @Override
      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement(
            sql.toString(),
            new String[]{"product_id"}
        );
      
        pstmt.setString(1, product.getProductName());
        pstmt.setLong(2, product.getProductQuantity());
        pstmt.setLong(3, product.getProductPrice());
      
        return pstmt;
      }
    }, keyHolder);
  
      long productId = keyHolder.getKey().longValue();
    return findByProductId(productId);
  }
  
  // 건별조회
  @Override
  public Product findByProductId(Long productId) {
  
    StringBuffer sql = new StringBuffer();
  
    sql.append("select ");
    sql.append("    product_id, ");
    sql.append("    product_name, ");
    sql.append("    product_quantity, ");
    sql.append("    product_price ");
    sql.append("from product ");
    sql.append("where product_id = ? ");
  
    Product   productItem = null;
    try {
      productItem = jdbcTemplate.queryForObject(
          sql.toString(),
          new BeanPropertyRowMapper<>(Product.class),
          productId);
    } catch (Exception e) {
      productItem = null;
    }
  
    return productItem;
  }
  
  // 전체조회
  @Override
  public List<Product> findAll() {
  
    StringBuffer sql = new StringBuffer();
    sql.append("select ");
    sql.append("    product_id, ");
    sql.append("    product_name, ");
    sql.append("    product_quantity, ");
    sql.append("    product_price ");
    sql.append("from product ");
    sql.append("Order by product_id ");
  
    List<Product> list = jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Product.class));
  
  
    return list;
  }
  
  // 수정
  @Override
  public Product update(Long productId, Product product) {
  
    StringBuffer sql = new StringBuffer();
    sql.append("update product ");
    sql.append("set product_name = ? , ");
    sql.append("    product_quantity = ? , ");
    sql.append("    product_price = ? ");
    sql.append("where product_id = ? ");
  
    // SQL 실행
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(new PreparedStatementCreator() {
      @Override
      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
        PreparedStatement pstmt = con.prepareStatement(
            sql.toString(),
            new String[]{"product_id"}
        );
      
        pstmt.setString(1, product.getProductName());
        pstmt.setLong(2, product.getProductQuantity());
        pstmt.setLong(3, product.getProductPrice());
        pstmt.setLong(4, product.getProductId());
      
        return pstmt;
      }
    }, keyHolder);
  
    productId  = keyHolder.getKey().longValue();
    return findByProductId(productId);
  }
  
  // 삭제
  @Override
  public Product delete(Long productId) {
  
    StringBuffer sql = new StringBuffer();
    sql.append("delete from product ");
    sql.append("where product_id = ? ");
    
    jdbcTemplate.update(sql.toString(), productId);
    
    return null;
  }
  
  
}
