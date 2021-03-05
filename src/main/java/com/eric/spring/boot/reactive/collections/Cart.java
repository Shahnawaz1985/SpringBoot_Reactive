package com.eric.spring.boot.reactive.collections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * 
 * @author Shahnawaz
 *
 */
@Document(value="carts")
public class Cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4053487717434778198L;
	
	@Id
	private String id;
	private List<CartItem> cartItems;
	
	private Cart() {
		
	}
	
	public Cart(String id) {
		this(id, new ArrayList<>());
	}
	
	public Cart(String id, List<CartItem> cartItems) {
		this.id = id;
		this.cartItems = cartItems;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartItems == null) ? 0 : cartItems.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (cartItems == null) {
			if (other.cartItems != null)
				return false;
		} else if (!cartItems.equals(other.cartItems))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cart {id=");
		builder.append(id);
		builder.append(", cartItems=");
		builder.append(cartItems);
		builder.append("}");
		return builder.toString();
	}
	
	

}
