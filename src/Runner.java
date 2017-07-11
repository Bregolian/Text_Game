import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Runner implements KeyListener {
	JFrame jFrame = new JFrame();
	JPanel jPanel = new JPanel();
	JTextField jTextField = new JTextField();
	JLabel jLabel = new JLabel();
	int height = 20;
	String text = "<html>";
	String newText = "<html>";
	int ypos = 600;
	String userInput;
	Parser p = new Parser();
	String response = "";

	public static void main(String[] args) {
		Runner r = new Runner();
		r.setup();
	}

	private void setup() {
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
		jFrame.add(jPanel);
		jPanel.add(jTextField);
		jTextField.setBounds(15, 625, 370, 20);
		jPanel.setLayout(null);
		jPanel.add(jLabel);
		jLabel.setBounds(15, ypos, 370, height);
		jFrame.setSize(400, 700);
		jLabel.setText("Welcome to the game. What is your name?");
		jFrame.setVisible(true);
		jTextField.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			text += jLabel.getText();
			userInput = jTextField.getText();
			String[] input = userInput.split(" ");
			response = p.parse(input);
			text += "<br>" + ">" + jTextField.getText() + "<br>" + response;
			height += 40;
			ypos -= 40;
			jLabel.setBounds(15, ypos, 370, height);
			newText = text;
			text = "";
			jLabel.setText(newText);
			jLabel.repaint();
			System.out.println(jLabel.getText());
			jTextField.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
