package com.nameless;

import javax.swing.JFrame;
import java.awt.Dimension;

public class Plot extends JFrame {

	private JFrame frame;
	private Integer width;
	private Integer height;
	private Parser parser;

	public Plot(Integer width, Integer height, Parser parser) {
		this.width = width;
		this.height = height;
		this.parser = parser;
		init();
	}

	private void init() {
		frame = new JFrame("NameLess AR");
		frame.setPreferredSize(new Dimension(width, height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Render render = new Render(parser);
		frame.add(render);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		render.repaint();
	}


}
