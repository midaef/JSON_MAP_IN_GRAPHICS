package com.nameless;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Render extends Canvas {

	private Parser parser;
	private ArrayList<Node> nodesList;
	private ArrayList<Edge> edgesList;

	private Graphics2D g2d;

	public Render(Parser parser) {
		this.parser = parser;
		render();
	}


	@Override
	public void paint(Graphics g) {
		try {
			super.paint(g);
			g2d = (Graphics2D) g;
			nodesList = parser.getNodesList();
			edgesList = parser.getEdgesList();
			paintLine(g2d);
			paintOval(g);
			paintName(g);
		} catch (Exception ignored) {}
	}

	private void paintOval(Graphics g) {
		for (int i = 0; i < nodesList.size(); i++) {
			Integer cost = Math.round(nodesList.get(i).getCost()) * 10;
			g.setColor(Color.darkGray);
			g.fillOval(nodesList.get(i).getX() * 100 + 20,
					nodesList.get(i).getY() * 100 + 20, 40 + cost, 40 + cost);

			g.drawOval(nodesList.get(i).getX() * 100 + 20,
					nodesList.get(i).getY() * 100 + 20, 40 + cost, 40 + cost);

		}
	}

	private void paintLine(Graphics2D g) {
		for (int i = 0; i < edgesList.size(); i++) {
			Integer from_id = edgesList.get(i).getFrom_id();
			Integer to_id = edgesList.get(i).getTo_id();
			Integer from_x = getXforID(from_id);
			Integer from_y = getYforID(from_id);
			Integer to_x = getXforID(to_id);
			Integer to_y = getYforID(to_id);
			g.setStroke(new BasicStroke(edgesList.get(i).getWeight() / 2));
			g.drawLine(from_x * 100 + 40, from_y * 100 + 40, to_x * 100 + 40, to_y * 100 + 40);
		}
	}

	private void paintName(Graphics g) {
		for (int i = 0; i < nodesList.size(); i++) {
			Font f = g.getFont();
			Font name = new Font(f.getName(), Font.BOLD, 12);
			g.setFont(name);
			g.setColor(Color.blue);
			g.drawString(nodesList.get(i).getName(),
						nodesList.get(i).getX() * 100 + 15,nodesList.get(i).getY() * 100 + 15);
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

	private void render() {
		this.paint(null);
	}

}
