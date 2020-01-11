package defaultPackage;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

public class TextArea extends JTextArea {

	private int editorWidth = 700;
	private int editorHeight = 800;

	private int textAreaDistanceFromFrameX = 50;
	private int textAreaDistanceFromFrameY = 100;
	private int textAreaDistanceFromRightSideBorder = 50;
	private int textAreaDistanceFromBottomBorder = 100;

	public TextArea() {
		setTextAreaAttributes();
	}

	public void setTextAreaAttributes() {
		setBounds(textAreaDistanceFromFrameX, textAreaDistanceFromFrameY,
				editorWidth - 2 * textAreaDistanceFromFrameX - 5,
				editorHeight - (textAreaDistanceFromFrameY + textAreaDistanceFromBottomBorder));
		setForeground(new Color(0, 0, 0));
		setFont(new Font("Courier New", Font.BOLD, 15));
		setLineWrap(true);
	}
}
