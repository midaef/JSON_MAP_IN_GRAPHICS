package com.nameless;

public class Node {

	private Integer id, x, y;
	private Float cost;
	private String name;

	public Node(Integer id, Integer x, Integer y, Float cost, String name) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.cost = cost;
		this.name = name;
	}

	public Float getCost() {return cost;}

	public String getName() {return name;}

	public Integer getY() {return y;}

	public Integer getX() {return x;}

	public Integer getId() {return id;}

}
