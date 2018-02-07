package com.pnj.hibernate.model;

import javax.persistence.Entity;

@Entity
public class Apple extends Fruit {

	private String color;
	
	private String taste;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	@Override
	public String toString() {
		return "Apple [color=" + color + ", taste=" + taste + ", getName()=" + getName() + ", getLocalName()="
				+ getLocalName() + "]";
	}
}
