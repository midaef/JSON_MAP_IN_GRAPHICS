package com.nameless;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;

public class Parser {

	private ArrayList<Node> nodesList = new ArrayList<Node>();
	private ArrayList<Edge> edgesList = new ArrayList<Edge>();
	private JSONArray nodesArray;
	private JSONArray edgesArray;
	private JSONObject jsonObject;

	public Parser() {
		startParser();
	}

	private void startParser() {
		JSONParser parser = new JSONParser();
		try {
			jsonObject = (JSONObject) parser.parse(new FileReader("graph_1.json"));

			nodesArray = (JSONArray) jsonObject.get("nodes");
			edgesArray = (JSONArray) jsonObject.get("edges");

			getNodes(nodesArray);
			getEdges(edgesArray);

		} catch (Exception e) {e.printStackTrace();}
	}

	private void getNodes(JSONArray nodesArray) {
		for (int i = 0; i < nodesArray.size(); i++) {
			JSONObject jsonNode = (JSONObject) nodesArray.get(i);
			Integer id = Integer.parseInt(jsonNode.get("id").toString());
			Integer x = Integer.parseInt(jsonNode.get("x").toString());
			Integer y = Integer.parseInt(jsonNode.get("y").toString());
			Float cost = Float.parseFloat(jsonNode.get("cost").toString());
			String name = jsonNode.get("name").toString();
			Node node = new Node(id, x, y, cost, name);
			nodesList.add(node);
		}
	}

	private void getEdges(JSONArray edgesArray) {
		for (int i = 0; i < edgesArray.size(); i++) {
			JSONObject jsonNode = (JSONObject) edgesArray.get(i);
			Integer from_id = Integer.parseInt(jsonNode.get("from_id").toString());
			Integer to_id = Integer.parseInt(jsonNode.get("to_id").toString());
			Float weight = Float.parseFloat(jsonNode.get("weight").toString());
			Edge edge = new Edge(from_id, to_id, weight);
			edgesList.add(edge);
		}
	}

	public String getCords(Integer id) {
		for (int i = 0; i < nodesArray.size(); i++) {
			JSONObject jsonNode = (JSONObject) nodesArray.get(i);
			Integer ID = Integer.parseInt(jsonNode.get("id").toString());
			if (ID == id) {
				String x = jsonNode.get("x").toString();
				String y = jsonNode.get("y").toString();
				return x + "/" + y;
			}
		}
		return "";
	}

	public Integer getWidth(JSONObject object) {return Integer.parseInt(object.get("width").toString());}

	public Integer getHeight(JSONObject object) {return Integer.parseInt(object.get("height").toString());}

	public JSONObject getJSONObject() {return jsonObject;}

	public ArrayList getNodesList() {return nodesList;}

	public ArrayList getEdgesList() {return edgesList;}

}
