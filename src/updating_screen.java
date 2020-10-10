import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class updating_screen extends JFrame {

	private JPanel contentPane;
	private static ImageIcon gif;

	/**
	 * Launch the application.
	 */
	public static void display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updating_screen frame = new updating_screen();
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
	public updating_screen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {100, 400, 100};
		gbl_contentPane.rowHeights = new int[] {50, 150, 150, 50};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Fetching News");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		ImageIcon loading_gif = new ImageIcon(new ImageIcon(loading_screen.class.getResource("/img/mag.gif"))
				.getImage().getScaledInstance(75, 75, java.awt.Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(loading_gif);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		int rand = (int)(Math.random() * 2);
		
		if(rand == 0) {
			gif = new ImageIcon(new ImageIcon(loading_screen.class.getResource("/img/eating_chip.gif"))
					.getImage().getScaledInstance(185, 150, java.awt.Image.SCALE_DEFAULT));
		}
		else if(rand == 1) {
			gif = new ImageIcon(new ImageIcon(loading_screen.class.getResource("/img/eating_popcorn.gif"))
					.getImage().getScaledInstance(185, 150, java.awt.Image.SCALE_DEFAULT));
		}
		else {
			gif = new ImageIcon(new ImageIcon(loading_screen.class.getResource("/img/eating_rice.gif"))
					.getImage().getScaledInstance(185, 150, java.awt.Image.SCALE_DEFAULT));
		}
		lblNewLabel_1.setIcon(gif);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
	}

}
