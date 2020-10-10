
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class search_screen extends JFrame {

	private JPanel contentPane;
	private JTextField txtTypeHere;
	private boolean clicked;
	/**
	 * Launch the application.
	 */
	public static void display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search_screen frame = new search_screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public search_screen() {
		clicked = false;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {150, 400, 100};
		gbl_contentPane.rowHeights = new int[] {50, 100, 30, 150, 50};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		ImageIcon loading_gif = new ImageIcon(new ImageIcon(loading_screen.class.getResource("/img/02.gif"))
				.getImage().getScaledInstance(300, 305, java.awt.Image.SCALE_DEFAULT));
		ImageIcon search_gif = new ImageIcon(new ImageIcon(loading_screen.class.getResource("/img/search.png"))
				.getImage().getScaledInstance(30, 26, java.awt.Image.SCALE_DEFAULT));
		
		JLabel lblNewLabel = new JLabel("Enter Keywords");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		txtTypeHere = new JTextField();
		txtTypeHere.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		txtTypeHere.setBackground(new Color(204, 255, 255));
		GridBagConstraints gbc_txtTypeHere = new GridBagConstraints();
		gbc_txtTypeHere.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTypeHere.insets = new Insets(0, 0, 5, 5);
		gbc_txtTypeHere.gridx = 1;
		gbc_txtTypeHere.gridy = 2;
		contentPane.add(txtTypeHere, gbc_txtTypeHere);
		txtTypeHere.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicked = true;
			}
		});
		btnNewButton.setBackground(new Color(153, 255, 255));
		btnNewButton.setIcon(search_gif);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 2;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(loading_gif);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
	}
	
	public String getKeyWord() {
		return txtTypeHere.getText();
	}
	
	public boolean isclicked() {
		return clicked;
	}
}
