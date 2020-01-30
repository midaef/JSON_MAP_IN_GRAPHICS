package com.nameless;

import org.json.simple.JSONObject;

public class Main {
	public static void main(String[] args) {
		Parser parser = new Parser();
		JSONObject obj = parser.getJSONObject();
		new Plot(parser.getWidth(obj) * 100, parser.getHeight(obj) * 100 + 20, parser);
	}
}
