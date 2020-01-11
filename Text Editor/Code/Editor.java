package defaultPackage;

import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Editor extends JFrame {

	private String title = "My Editor";

	private int editorWidth = 700;
	private int editorHeight = 800;
	private int distanceFromBorderX = 100;
	private int distanceFromBorderY = 100;

	private TextField textField;
	private int textFieldDistanceFromFrameX = 50;
	private int textFieldDistanceFromFrameY = 100;
	private int textFieldDistanceFromSideBorder = 50;
	private int textFieldDistanceFromBottomBorder = 100;

	private int buttonWidth = 100;
	private int buttonHeight = 50;
	private int distanceBetweenButtons = 10;
	
	private JButton saveButton;
	private int saveButtonLocationX = editorWidth/2 - 3/2 *buttonWidth - distanceBetweenButtons/2;
	private int saveButtonLocationY = buttonHeight/2;
	
	private JButton loadButton;
	private int loadButtonLocationX = editorWidth/2 + distanceBetweenButtons/2;
	private int loadButtonLocationY = buttonHeight/2;

	public Editor() {

		setJFrameAttributes();

		textField = new TextField();
		textField.setBounds(textFieldDistanceFromFrameX, textFieldDistanceFromFrameY,
				editorWidth - 2 * textFieldDistanceFromFrameX - 20,
				editorHeight - (textFieldDistanceFromFrameY + textFieldDistanceFromBottomBorder));
		add(textField);

		saveButton = new JButton("SAVE");
		saveButton.setBounds(saveButtonLocationX,saveButtonLocationY,buttonWidth,buttonHeight);
		add(saveButton);
		
		loadButton = new JButton("LOAD");
		loadButton.setBounds(loadButtonLocationX,loadButtonLocationY,buttonWidth,buttonHeight);
		add(loadButton);
		
		

		setVisible(true);

	}

	public void setJFrameAttributes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
		setBounds(distanceFromBorderX, distanceFromBorderY, editorWidth, editorHeight);
		setLayout(null);
	}

}
