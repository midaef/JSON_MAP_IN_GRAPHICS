package com.nameless;

import org.json.simple.JSONObject;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;

public class Render extends Canvas {

	private Parser parser;
	private ArrayList<Node> nodesList;
	private ArrayList<Edge> edgesList;

	public Render(Parser parser) {
		this.parser = parser;
		render();
	}

	@Override
	public void paint(Graphics g) {
		try {
			super.paint(g);
			JSONObject obj = parser.getJSONObject();
			nodesList = parser.getNodesList();
			edgesList = parser.getEdgesList();
			paintOval(g);
			paintLine(g);
		} catch (Exception ignored) {}
	}

	private void paintOval(Graphics g) {
		for (int i = 0; i < nodesList.size(); i++) {
			g.drawOval(nodesList.get(i).getX() * 100 - 25,
					nodesList.get(i).getY() * 100 - 25, 50, 50);
		}
	}

	private void paintLine(Graphics g) {
		for (int i = 0; i < edgesList.size(); i++) {
			Integer from_id = edgesList.get(i).getFrom_id();
			Integer to_id = edgesList.get(i).getTo_id();
			Integer from_x = getXforID(from_id);
			Integer from_y = getYforID(from_id);
			Integer to_x = getXforID(to_id);
			Integer to_y = getYforID(to_id);
			g.drawLine(from_x * 100, from_y * 100, to_x * 100, to_y * 100);
		}
	}

	private Integer getXforID(Integer id) {
		Integer x = Integer.parseInt(parser.getCords(id).split("/")[0]);
		return x;
	}

	private Integer getYforID(Integer id) {
		Integer y = Integer.parseInt(parser.getCords(id).split("/")[1]);
		return y;
	}

	private void render() {this.paint(null);}

}
