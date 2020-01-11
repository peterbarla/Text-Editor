package defaultPackage;

import java.awt.Font;
import java.awt.Label;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Editor extends JFrame {

	private String title = "My Editor";

	private int editorWidth = 700;
	private int editorHeight = 800;
	private int distanceFromBorderX = 100;
	private int distanceFromBorderY = 100;

	private int buttonWidth = 100;
	private int buttonHeight = 50;
	private int distanceBetweenButtons = 10;

	private JButton saveButton;
	private int saveButtonLocationX = editorWidth / 2 - 3 / 2 * buttonWidth - distanceBetweenButtons / 2;
	private int saveButtonLocationY = buttonHeight / 2;

	private JButton loadButton;
	private int loadButtonLocationX = editorWidth / 2 + distanceBetweenButtons / 2;
	private int loadButtonLocationY = buttonHeight / 2;

	private JButton newButton;
	private int newButtonLocationX = distanceFromBorderX / 2;
	private int newButtonLocationY = buttonHeight / 2;

	private TextArea textArea;

	private JFileChooser fileChooser;

	private boolean isCurrentTextSaved = false;

	private NewFileCreator newFileCreator;

	private String loadedString;

	private FontColorChanger fontColorChanger;

	public Editor() {

		setJFrameAttributes();
		textArea = new TextArea();
		fontColorChanger = new FontColorChanger(textArea);
		add(textArea);

		saveButton = new JButton("SAVE");
		saveButton.setBounds(saveButtonLocationX, saveButtonLocationY, buttonWidth, buttonHeight);
		add(saveButton);

		loadButton = new JButton("LOAD");
		loadButton.setBounds(loadButtonLocationX, loadButtonLocationY, buttonWidth, buttonHeight);
		add(loadButton);

		newButton = new JButton("NEW");
		newButton.setBounds(newButtonLocationX, newButtonLocationY, buttonWidth, buttonHeight);
		add(newButton);

		add(fontColorChanger);

		saveButton.addActionListener(e -> {
			if (!textArea.getText().equals("")) {
				save();
			}
		});
		loadButton.addActionListener(e -> {
			load();
		});

		newButton.addActionListener(e -> {
			String currentText = textArea.getText();
			if (!currentText.equals(loadedString)) {
				isCurrentTextSaved = false;
				if (!textArea.getText().equals("") && !isCurrentTextSaved) {
					newFileCreator = new NewFileCreator(this, textArea);
					newFileCreator.makeNewFile();
				}
			} else {
				textArea.setText(null);
			}
		});

		setVisible(true);

	}

	public void setJFrameAttributes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
		setResizable(false);
		setBounds(distanceFromBorderX, distanceFromBorderY, editorWidth, editorHeight);
		setLayout(null);
	}

	public void save() {
		fileChooser = new JFileChooser();
		int retrival = fileChooser.showSaveDialog(null);
		if (retrival == JFileChooser.APPROVE_OPTION) {
			try {
				FileWriter writer = new FileWriter(fileChooser.getSelectedFile());
				writer.write(textArea.getText());
				writer.flush();
				writer.close();
				loadedString = textArea.getText();
				isCurrentTextSaved = true;
			} catch (Exception except) {
				except.printStackTrace();
			}
		}
	}

	public void load() {
		String text = null;
		String finalText = "";
		fileChooser = new JFileChooser();
		int retrival = fileChooser.showOpenDialog(null);
		if (retrival == JFileChooser.APPROVE_OPTION) {
			try (BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))) {
				while ((text = reader.readLine()) != null) {
					finalText += text + "\n";
				}
				textArea.setText(null);
				textArea.setText(finalText);
				loadedString = textArea.getText();
				isCurrentTextSaved = true;
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	public boolean getIsCurrentTextSaved() {
		return isCurrentTextSaved;
	}

	public void setIsCurrentTextSaved(boolean bool) {
		isCurrentTextSaved = bool;
	}
}
