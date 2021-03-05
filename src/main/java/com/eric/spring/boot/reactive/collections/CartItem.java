package com.eric.spring.boot.reactive.collections;

import java.io.Serializable;


/**
 * 
 * @author Shahnawaz
 *
 */
public class CartItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3889238905876987343L;
	
	private Item item;
	private int quantity;
	
	private CartItem() {
		
	}
	
	public CartItem(Item item) {
		this.item = item;
		this.quantity = 1;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + quantity;
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
		CartItem other = (CartItem) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CartItem {item=");
		builder.append(item);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append("}");
		return builder.toString();
	}
	
	

}
