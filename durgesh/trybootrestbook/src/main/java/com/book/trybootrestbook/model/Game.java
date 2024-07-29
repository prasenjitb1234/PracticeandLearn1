package com.book.trybootrestbook.model;

public class Game {

	private int id;
	private String name;
	private String company;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", company=" + company + "]";
	}
	public Game(int id, String name, String company) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
	}
	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
