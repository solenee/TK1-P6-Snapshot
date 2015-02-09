package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.JTextComponent;


/**
 * @author EHOLIE Solene
 * 
 *         	
 */
public class TransactionsVisualization extends JFrame {

	// Display transactions
	JTextArea textarea = new JTextArea(10, 30);
	
	final static String DEFAULT_APP_NAME = "Snapshot-Algorithm by Chandy and Lamport";

	final static int NUMBER_OF_ACCOUNTS = 3;
	JButton bSnapshots[];
	JTextField balance[];
	

	public TransactionsVisualization() {
		super(DEFAULT_APP_NAME);
		// Main frame
		// -------------------------------------------

		Container content = this.getContentPane();
		content.setLayout(new BorderLayout());
		content.doLayout();

		// Transaction visualization
		content.add(
				new JScrollPane(textarea, 
						ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
						ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED),
				BorderLayout.CENTER);
		textarea.setEditable(false);
		
		// Accounts
		JPanel accounts = new JPanel(new GridLayout(NUMBER_OF_ACCOUNTS, 1));
		bSnapshots = new JButton[NUMBER_OF_ACCOUNTS];
		balance = new JTextField[NUMBER_OF_ACCOUNTS];
		for (int i=0; i <NUMBER_OF_ACCOUNTS; i++) {
			JPanel p = new JPanel();
			p.add(new JLabel("Account "+i));
			balance[i] = new JTextField("€", 5);
			balance[i].setEditable(false);
			p.add(balance[i]);
			bSnapshots[i] = new JButton("Snapshot");
			p.add(bSnapshots[i]);
			accounts.add(p);
			
		}
		content.add(accounts, BorderLayout.EAST);
				
		this.setLocation(250, 100);
		this.pack();

		// Build controler (event management)
		new Controller(this);
	}

	
	public class Controller {

		private TransactionsVisualization view;
		
		public Controller(TransactionsVisualization gui) {
			this.view = gui;
			
			view.setVisible(true);
		}

		private void onError(String errorMsg) {
			JOptionPane.showMessageDialog(null, "An error occurred : "
					+ errorMsg);
		}

		private void manageGUI() {
		}

	}

	public static void main(String[] args) {
		new TransactionsVisualization();
	}

	

}
