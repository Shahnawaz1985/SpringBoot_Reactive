package com.eric.spring.boot.reactive.beans;

import java.io.Serializable;

/**
 * 
 * @author Shahnawaz
 *
 */
public class Dish implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -478785039678504943L;
	
	private String description;
	private boolean delivered = false;
	
	public Dish() {
		
	}
	
	public Dish(String description) {
		this.description = description;
	}
	
	public static Dish deliver(Dish dish) {
		Dish deliveredDish = new Dish(dish.description);
		deliveredDish.delivered = true;
		return deliveredDish;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (delivered ? 1231 : 1237);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		Dish other = (Dish) obj;
		if (delivered != other.delivered)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dish {description=");
		builder.append(description);
		builder.append(", delivered=");
		builder.append(delivered);
		builder.append("}");
		return builder.toString();
	}
	
	

}
