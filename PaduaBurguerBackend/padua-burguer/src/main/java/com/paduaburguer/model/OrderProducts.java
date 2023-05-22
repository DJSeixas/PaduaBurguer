
  package com.paduaburguer.model;
  
  import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
  
  @Entity
  
  @Table(name = "order_products") 
  public class OrderProducts implements Serializable{ 
	  private static final long serialVersionUID = 1L;
  
  @JsonIgnore
  @EmbeddedId
  private OrderProductsPK id;
  
  @Column  
  private Double price;
  
  @Column 
  private Integer quantity;
  
  @Column 
  private Double discount;
  
  public OrderProducts() {}
  
  public OrderProducts(Orders orders,Product product , Double price, Integer
  quantity, Double discount) { 
		  super(); 
		  id.setOrders(orders);
		  id.setProduct(product); 
		  this.price = price; 
		  this.quantity = quantity;
		  this.discount = discount; 
  }
  
  public double getSubTotal() {
	  return (price - discount) * quantity;
  }
  
  @JsonIgnore
  public Orders getOrders() { 
	  return id.getOrders(); 
	  }
  
  public void setOrders(Orders orders) {
	  id.setOrders(orders);
  		}
  
  public Product getProduct() { 
	  return id.getProduct(); 
	  	}
  
  public void setProduct(Product product) {
	  id.setProduct(product);
  		}
  
  public OrderProductsPK getId() { 
	  return id; 
	  }
  
  
  public void setId(OrderProductsPK id) { 
	  this.id = id; 
	  }
  
  public Double getPrice() { 
	  return price; 
	  }
  
  public void setPrice(Double price) { 
	  this.price = price; 
	  }
  
  public Integer getQuantity() { 
	  return quantity; 
	  }
  
  public void setQuantity(Integer quantity) { 
	  this.quantity = quantity; 
	  }
  
  public Double getDesconto() { 
	  return discount; 
	  }
  
  public void setDesconto(Double discount) { 
	  this.discount = discount; 
	  }
  
  
  }
 