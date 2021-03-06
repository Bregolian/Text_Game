import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Runner implements KeyListener, WindowListener {
	JFrame jFrame = new JFrame();
	JPanel jPanel = new JPanel();
	JTextField jTextField = new JTextField(20);
	JTextArea jTextArea = new JTextArea(20, 20);
	int height = 20;
	String text = "";
	String newText = "";
	int ypos = 600;
	String userInput;
	Parser p;
	String response = "";
	Player player;
	Map map = new Map();
	JScrollPane jScrollPane;

	public static void main(String[] args) {
		Runner r = new Runner();
		r.setup();
	}

	private void setup() {
		GridBagConstraints c = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.NONE, new Insets(5, 2, 5, 2), 0, 0);
		jFrame.addWindowListener(this);
		jPanel.setLayout(new GridBagLayout());
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jTextArea.setText("Welcome to the game. What is your name?\n");
		jTextArea.setEditable(false);
		jTextArea.setWrapStyleWord(true);
		jTextArea.setLineWrap(true);
		jScrollPane = new JScrollPane(jTextArea);
		jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jFrame.add(jPanel);
		jPanel.add(jScrollPane, c);
		c.gridy++;
		jPanel.add(jTextField, c);
		// jTextField.setBounds(15, 625, 370, 20);
		// jPanel.setLayout(null);

		// jLabel.setBounds(15, ypos, 370, height);
		// jFrame.setSize(400, 700);
		jFrame.setVisible(true);
		jFrame.pack();
		jTextField.addKeyListener(this);
		jTextField.requestFocus();
		map.setUp();
		Inventory inven= new Inventory();
		Armor clothArmor=new Armor("Cloth Armor", 1, 10, 0);
		player = new Player(map.altar, inven.startItems2, 100, clothArmor);
		p = new Parser(player);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			text += jTextArea.getText();
			userInput = jTextField.getText();
			String[] input = userInput.split(" ");
			response = p.parse(input);
			text += p.arrayToString(input)+ "\n" + response + "\n";
			height += 40;
			ypos -= 40;
			jTextArea.setBounds(15, ypos, 370, height);
			newText = text;
			text = "";
			jTextArea.setText(newText);
			jTextArea.repaint();
			jScrollPane.revalidate();
			jScrollPane.repaint();
			System.out.println(jTextArea.getText());
			jTextField.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
