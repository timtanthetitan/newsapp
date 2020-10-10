
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.ScrollPane;
import java.awt.Point;
import javax.swing.border.LineBorder;
import java.awt.Panel;
import java.awt.Label;
import java.awt.TextArea;
import java.util.ArrayList;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class front_page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void run(ArrayList<String> links, ArrayList<String> sources, ArrayList<String> titles) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					front_page frame = new front_page(links, sources, titles);
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
	public front_page(ArrayList<String> links, ArrayList<String> sources, ArrayList<String> titles) {
		setBackground(SystemColor.window);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowHeights = new int[] {50, 50, 650, 50};
		gbl_contentPane.columnWidths = new int[] {50, 450, 450, 50};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Latest News");
		lblNewLabel.setFont(new Font("Courier New", Font.BOLD, 30));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		Panel l_panel = new Panel();
		l_panel.setBackground(new Color(127, 255, 212));
		GridBagConstraints gbc_l_panel = new GridBagConstraints();
		gbc_l_panel.insets = new Insets(0, 0, 5, 5);
		gbc_l_panel.gridx = 1;
		gbc_l_panel.gridy = 2;
		contentPane.add(l_panel, gbc_l_panel);
		
		GridBagLayout gbl_l_panel = new GridBagLayout();
		gbl_l_panel.columnWidths = new int[] {30, 390, 30};
		gbl_l_panel.rowHeights = new int[] {30, 590, 30};
		gbl_l_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_l_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		l_panel.setLayout(gbl_l_panel);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		
		System.out.println(links.size()/2);
		textArea.setRows(links.size()/2);
		textArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
//		GridBagConstraints gbc_textArea = new GridBagConstraints();
//		gbc_textArea.fill = GridBagConstraints.BOTH;
//		gbc_textArea.gridx = 1;
//		gbc_textArea.gridy = 1;
		
		for(int i = 0; i < links.size() / 2; i++) {
			textArea.append(sources.get(i) + ": ");
			textArea.append("\n");
			textArea.append(titles.get(i));
			textArea.append("\n");
			textArea.append(links.get(i));
			textArea.append("\n" + "\n");
		}
		
//		JLabel l_text = new JLabel(text);
//		l_text.setVerticalAlignment(SwingConstants.TOP);
//		l_text.setFont(new Font("Courier New", Font.PLAIN, 13));
//		GridBagConstraints gbc_l_text = new GridBagConstraints();
//		gbc_l_text.anchor = GridBagConstraints.NORTHWEST;
//		gbc_l_text.gridx = 1;
//		gbc_l_text.gridy = 1;
//		l_panel.add(l_text, gbc_l_text);
		
		JScrollPane sp1 = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		GridBagConstraints gbc_sp1 = new GridBagConstraints();
		gbc_sp1.fill = GridBagConstraints.BOTH;
		gbc_sp1.gridx = 1;
		gbc_sp1.gridy = 1;
		l_panel.add(sp1, gbc_sp1);
		
		Panel r_panel = new Panel();
		r_panel.setBackground(new Color(127, 255, 212));
		GridBagConstraints gbc_r_panel = new GridBagConstraints();
		gbc_r_panel.insets = new Insets(0, 0, 5, 5);
		gbc_r_panel.gridx = 2;
		gbc_r_panel.gridy = 2;
		contentPane.add(r_panel, gbc_r_panel);
		GridBagLayout gbl_r_panel = new GridBagLayout();
		gbl_r_panel.columnWidths = new int[] {30, 390, 30};
		gbl_r_panel.rowHeights = new int[] {30, 590, 30};
		gbl_r_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_r_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		r_panel.setLayout(gbl_r_panel);
		
		
		JTextArea textArea2 = new JTextArea();
		textArea2.setWrapStyleWord(true);
		textArea2.setLineWrap(true);
		textArea2.setRows(links.size()/2);
		textArea2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		
		for(int i = links.size() / 2; i < links.size(); i++) {
			textArea2.append(sources.get(i) + ": ");
			textArea2.append("\n");
			textArea2.append(titles.get(i));
			textArea2.append("\n");
			textArea2.append(links.get(i));
			textArea2.append("\n" + "\n");
		}
		
//		JLabel r_text = new JLabel(text);
//		r_text.setVerticalAlignment(SwingConstants.TOP);
//		r_text.setFont(new Font("Courier New", Font.PLAIN, 13));
//		GridBagConstraints gbc_r_text = new GridBagConstraints();
//		gbc_r_text.anchor = GridBagConstraints.NORTHWEST;
//		gbc_r_text.gridx = 1;
//		gbc_r_text.gridy = 1;
//		r_panel.add(r_text, gbc_r_text);
		
		JScrollPane sp2 = new JScrollPane(textArea2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		GridBagConstraints gbc_sp2 = new GridBagConstraints();
		gbc_sp2.fill = GridBagConstraints.BOTH;
		gbc_sp2.gridx = 1;
		gbc_sp2.gridy = 1;
		r_panel.add(sp2, gbc_sp2);
	}

}
