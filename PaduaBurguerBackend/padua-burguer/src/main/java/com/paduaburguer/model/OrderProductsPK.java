
  package com.paduaburguer.model;
  
  import java.io.Serializable; import java.util.Objects;
  
  import jakarta.persistence.Embeddable; import jakarta.persistence.JoinColumn;
  import jakarta.persistence.ManyToOne;
  
  @Embeddable public class OrderProductsPK implements Serializable { private
  static final long serialVersionUID = 1L;
  
  @ManyToOne
  @JoinColumn(name = "order_id") 
  private Orders orders;
  
  @ManyToOne
  @JoinColumn(name = "product_id") 
  
  	private Product product;
  
  	public Orders getOrders() { 
  		return orders; 
	  	} 
  
  	public void setOrders(Orders orders) {
  		this.orders = orders; 
  		} 
  
  	public Product getProduct() { 
  		return product; 
  		} 
  
  	public void setProduct(Product product) { 
  		this.product = product; 
  		}
  
  @Override public int hashCode() { return Objects.hash(orders, product); }
  
  @Override public boolean equals(Object obj) { if (this == obj) return true;
  if (obj == null) return false; if (getClass() != obj.getClass()) return
  false; OrderProductsPK other = (OrderProductsPK) obj; return
  Objects.equals(orders, other.orders) && Objects.equals(product, other.product);
  }
  
  
  }
 
