package cs3230;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Graphical extends JFrame {
    private static final long serialVersionUID = -7365155579638644639L;

    public static void main(String[] args) {
	new Graphical();
    }

    private JPanel panel01;
    private JPanel panel02;
    private JTextArea messageArea;
    private JTextArea sendArea;
    private JScrollPane scrollBar;
    private JButton sendButton;
    private JButton clearButton;

    public Graphical() throws HeadlessException {
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(new Dimension(800, 600));
	this.setResizable(true);

	panel01 = new JPanel(new BorderLayout());

	messageArea = new JTextArea(
		"iodsuifusiuyv iuxyvcui xzyvuytsaydf usdyyoxcv uixzyuvuxzi ovuzxiovs dtfuystadf ysvuxcoiv hiyxcui xuiy xuicy uiuiyuy u y iuy iuy iuy yuty utyu t yu yg jg jh ghj yu tyut yu tty ry tryt yu ");

	messageArea = new JTextArea();
	messageArea.setEditable(false);
	messageArea.setLineWrap(true);
	messageArea.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollBar = new JScrollPane(messageArea);
	scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	panel01.add(scrollBar, "Center");

	getContentPane().add(panel01);
	panel02 = new JPanel(new FlowLayout());
	sendArea = new JTextArea(0, 48);
	sendArea.setEditable(true);
	sendArea.setFont(new Font("Arial", Font.PLAIN, 16));

	sendButton = new JButton("Send");
	clearButton = new JButton("Clear");
	panel02.add(sendArea);
	panel02.add(sendButton);
	panel02.add(clearButton);

	// clear button's function
	clearButton.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		sendArea.setText(null);
	    }
	});

	sendButton.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		sendText();
	    }
	});

	sendArea.addKeyListener(new KeyListener() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER && e.getModifiers() == KeyEvent.CTRL_MASK) {
		    sendText();
		}
	    }

	    @Override
	    public void keyReleased(KeyEvent e) {
	    }

	    @Override
	    public void keyTyped(KeyEvent e) {
	    }
	});
	panel01.add(panel02, "South");

	panel01.setVisible(true);
	setVisible(true);
    }

    private void sendText() {
	String chatSend;
	String userName = "Michael";
	chatSend = sendArea.getText();
	messageArea.append(userName + ": " + chatSend + "\n");
	sendArea.setText("");
    }

}
