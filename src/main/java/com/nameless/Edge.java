package com.nameless;

public class Edge {

	private Integer from_id, to_id;
	private Float weight;

	public Edge(Integer from_id, Integer to_id, Float weight) {
		this.from_id = from_id;
		this.to_id = to_id;
		this.weight = weight;
	}

	public Float getWeight() {return weight;}

	public Integer getTo_id() {return to_id;}

	public Integer getFrom_id() {return from_id;}

}
