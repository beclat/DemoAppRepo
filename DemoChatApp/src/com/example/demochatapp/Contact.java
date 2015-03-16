package com.example.demochatapp;

public class Contact implements Comparable<Contact>{
	
	String name;
	long id;
	long image_id;
	
	public Contact( long id, String name, long image_id) {
		super();
		this.name = name;
		this.id = id;
		this.image_id = image_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getImage_id() {
		return image_id;
	}
	public void setImage_id(long image_id) {
		this.image_id = image_id;
	}
	@Override
	public int compareTo(Contact another) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(another.getName());
	}

}
