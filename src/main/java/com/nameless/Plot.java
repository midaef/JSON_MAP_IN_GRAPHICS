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

	private void addRender(Parser parser) {
		Runnable task = () -> {
			Render render = new Render(parser);
			frame.add(render);
			frame.repaint();
		};
		Thread thread = new Thread(task);
		thread.start();

	}

	private void init() {
		frame = new JFrame("JSON MAP IN GRAPHICS");
		frame.setPreferredSize(new Dimension(width, height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addRender(parser);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}

}