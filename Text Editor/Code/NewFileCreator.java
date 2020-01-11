package defaultPackage;

import java.awt.Font;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;

public class NewFileCreator extends JFrame {

	private String title = "Text Editor";

	private int distanceFromBorderX = 100;
	private int distanceFromBorderY = 100;

	private int saveWindowWidth = 400;
	private int saveWindowHeight = 150;

	private int saveWindowButtonWidth = 100;
	private int saveWindowButtonHeight = 50;
	private int saveWindowButtonDistanceFromX = 25;
	private int saveWindowButtonDistanceFromy = 25;

	private JButton saveWindowButton;
	private JButton dontSaveaveWindowButton;

	private Label label;
	private int labelWidth = 250;
	private int labelHeight = 50;
	private int labelX = 10;

	private Editor editor;
	private TextArea textArea;

	public NewFileCreator(Editor editor, TextArea textArea) {
		setAttributes();
		this.editor = editor;
		this.textArea = textArea;

		makeNewFile();

		setVisible(true);
	}

	public void setAttributes() {
		setBounds(distanceFromBorderX + 50, distanceFromBorderY + 50, saveWindowWidth, saveWindowHeight);
		setResizable(false);
		setLayout(null);
		setTitle(title);
	}

	public void makeNewFile() {
		if (!editor.getIsCurrentTextSaved()) {

			saveWindowButton = new JButton("SAVE");
			saveWindowButton.setBounds(saveWindowButtonDistanceFromX, saveWindowButtonDistanceFromy + 25,
					saveWindowButtonWidth, saveWindowButtonHeight);

			dontSaveaveWindowButton = new JButton("DON`T SAVE");
			dontSaveaveWindowButton.setBounds(saveWindowWidth - saveWindowButtonWidth - saveWindowButtonHeight,
					saveWindowButtonDistanceFromy + 25, saveWindowButtonWidth + 10, saveWindowButtonHeight);

			label = new Label("Do you want to save current file?");
			label.setFont(new Font("Courier New", Font.BOLD, 15));
			label.setBounds(labelX, 0, labelWidth, labelHeight);

			add(saveWindowButton);
			add(dontSaveaveWindowButton);
			add(label);

			dontSaveaveWindowButton.addActionListener(e -> {
				textArea.setText(null);
				editor.setIsCurrentTextSaved(false);
				this.dispose();
			});

			saveWindowButton.addActionListener(e -> {
				editor.save();
				this.dispose();
			});

		}
	}
}
