package defaultPackage;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FontColorChanger extends JMenuBar {

	private int width = 60;
	private int height = 50;
	private int x = 600;
	private int y = 25;

	private JMenu color;
	private JMenuItem red;
	private JMenuItem black;
	private JMenuItem blue;
	private JMenuItem green;

	private TextArea textArea;

	public FontColorChanger(TextArea textArea) {

		setAttributes();

		color = new JMenu("COLOR");
		red = new JMenuItem("RED");
		black = new JMenuItem("BLACK");
		blue = new JMenuItem("BLUE");
		green = new JMenuItem("GREEN");

		this.textArea = textArea;

		color.add(red);
		color.add(black);
		color.add(blue);
		color.add(green);

		red.addActionListener(e -> {
			textArea.setForeground(new Color(255, 20, 20));
		});
		black.addActionListener(e -> {
			textArea.setForeground(new Color(0, 0, 0));
		});
		blue.addActionListener(e -> {
			textArea.setForeground(new Color(20, 20, 255));
		});
		green.addActionListener(e -> {
			textArea.setForeground(new Color(20, 255, 20));
		});

		add(color);
	}

	public void setAttributes() {
		setBounds(x, y, width, height);
	}

}
