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

	public static void main(String[] args) {
		Runner r = new Runner();
		r.setup();
	}

	private void setup() {
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
		jFrame.add(jPanel);
		jPanel.add(jTextField);
		jTextField.setBounds(15, 650, 370, 20);
		jPanel.setLayout(null);
		jPanel.add(jLabel);
		jLabel.setBounds(15, 600, 370, height);
		jFrame.setSize(400, 700);
		jLabel.setText("Welcome to the game.");
		jFrame.setVisible(true);
		jTextField.addKeyListener(this);
		// for (int i = 0; i < 2; i++) {
		// text += jLabel.getText();
		// text += "<br>new stuff";
		// height += 20;
		// jLabel.setBounds(15, 500, 370, height);
		// }
		// text += "</html>";
		// jLabel.setText(text);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			text += jLabel.getText();
			text += "<br>"+jTextField.getText();
			height += 20;
			jLabel.setBounds(15, 500, 370, height);
			text += "</html>";
			newText=text;
			text="";
			jLabel.setText(newText);
			newText="";
			jTextField.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
