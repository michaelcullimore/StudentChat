package cs3230;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Client extends JFrame implements WindowListener, MouseListener, KeyListener {
    /**
     *
     */
    private static final long serialVersionUID = -6918166283720253450L;
    private JTextArea message_area = null;
    private JTextField send_area = null;
    private JScrollPane scroll;
    private JPanel contentPanel;
    String username = null;

    Client(String s) {
	super(s);
	this.addWindowListener(this);
	this.setSize(800, 600);
	this.setResizable(true);
	this.setLayout(new BorderLayout());
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// Group g = new Group();
	// TODO
	contentPanel = new JPanel();
	contentPanel.setLayout(new FlowLayout());

	message_area = new JTextArea();
	message_area.setEditable(false);
	message_area.setLineWrap(true);
	message_area.setWrapStyleWord(true);
	scroll = new JScrollPane(message_area);
	scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	contentPanel.add(scroll, "Center");
	this.add(message_area, "Center");
	message_area.setFont(new Font("Arial", Font.PLAIN, 16));
	// message_area.add(g.FindConversationsOfStudent("Michael"));
	// TODO

	send_area = new JTextField(30);
	send_area.addKeyListener(this);
	send_area.setFont(new Font("Arial", Font.PLAIN, 16));

	send_area.addKeyListener(new KeyListener() {
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

	contentPanel.add(send_area);
	contentPanel.setBackground(new Color(221, 221, 221));

	JButton send = new JButton("Send");
	send.addMouseListener(this);
	contentPanel.add(send);
	JButton clear = new JButton("Clear");
	clear.addMouseListener(this);
	contentPanel.add(clear);

	// clear button's function
	clear.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		send_area.setText(null);
	    }
	});

	// send/change the text in the message area. doesn't quite add it to the
	// conversation yet.

	send.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent pE) {
		sendText();
	    }
	});

	this.add(contentPanel, "South");
	this.setVisible(true);
	send_area.requestFocus();

    }

    public void addText(String chat) {
	message_area.append(chat);
	message_area.setCaretPosition(message_area.getDocument().getLength());

    }

    @Override
    public void keyPressed(KeyEvent e) {
	if (e.getKeyCode() == KeyEvent.VK_ENTER && e.getModifiers() == KeyEvent.CTRL_MASK) {
	    sendText();
	}
    }

    @Override
    public void keyReleased(KeyEvent arg0) {

    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }

    @Override
    public void mouseClicked(MouseEvent arg0) {

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {

    }

    @Override
    public void mouseExited(MouseEvent arg0) {

    }

    @Override
    public void mousePressed(MouseEvent arg0) {

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    private void sendText() {
	String chatSend;
	String userName = "Michael";
	chatSend = send_area.getText();
	message_area.append(userName + ": " + chatSend + "\n\n");
	send_area.setText("");
    }

    @Override
    public void windowActivated(WindowEvent arg0) {

    }

    @Override
    public void windowClosed(WindowEvent arg0) {

    }

    @Override
    public void windowClosing(WindowEvent arg0) {

    }

    @Override
    public void windowDeactivated(WindowEvent arg0) {

    }

    @Override
    public void windowDeiconified(WindowEvent arg0) {

    }

    @Override
    public void windowIconified(WindowEvent arg0) {

    }

    @Override
    public void windowOpened(WindowEvent arg0) {

    }

}
