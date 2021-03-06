//Michael Cullimore
//CS3230
//Spring 2017 - Marsh

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
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Graphical extends JFrame {
    private static final long serialVersionUID = -7365155579638644639L;

    public static void main(String[] args) {
	// new Graphical();
    }

    private JPanel panel01;
    private JPanel panel02;
    private JTextArea messageArea;
    private JTextArea sendArea;
    private JScrollPane scrollBar01;
    private JButton sendButton;
    private JButton clearButton;
    private Socket socket01;
    private PrintWriter pw;

    public Graphical(Socket socket02) throws HeadlessException, IOException {
	this.socket01 = socket02;

	pw = new PrintWriter(socket01.getOutputStream(), true);

	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setResizable(true);
	this.setSize(new Dimension(800, 600));
	this.setTitle("Student Chat Redo");

	panel01 = new JPanel(new BorderLayout());

	messageArea = new JTextArea();
	messageArea.setEditable(false);
	messageArea.setLineWrap(true);
	messageArea.setWrapStyleWord(true);
	messageArea.setFont(new Font("Arial", Font.PLAIN, 16));

	scrollBar01 = new JScrollPane(messageArea);
	scrollBar01.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	panel01.add(scrollBar01, "Center");
	getContentPane().add(panel01);
	panel02 = new JPanel(new FlowLayout());

	sendArea = new JTextArea(3, 48);
	sendArea.setEditable(true);
	sendArea.setFont(new Font("Arial", Font.PLAIN, 16));
	sendArea.setLineWrap(true);
	sendArea.setWrapStyleWord(true);

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

	// send button's function
	sendButton.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		sendText();
	    }
	});

	// using ctrl+enter to send the text
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

	getContentPane().add(panel01);
	panel01.add(panel02, "South");
	panel01.setVisible(true);
	setVisible(true);
    }

    // adds the text to the message area
    public void addText(String chat) {
	messageArea.append(chat + "\n");
	messageArea.setCaretPosition(messageArea.getDocument().getLength());
    }

    // adds name to the message area
    private void sendText() {
	String chatSend;
	chatSend = sendArea.getText();
	sendArea.setText("");
	pw.println(chatSend);
    }

}
