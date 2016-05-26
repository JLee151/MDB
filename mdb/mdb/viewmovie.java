package mdb;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.List;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class viewmovie {

	private JFrame frmViewMovies;
	private JTable table;
	private JTextField search;

	/*static Connection conn;
	static Statement stat;*/
	
	/**
	 * Launch the application.
	 */
	public static void viewmovie() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewmovie window = new viewmovie();
					window.frmViewMovies.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public viewmovie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmViewMovies = new JFrame();
		frmViewMovies.setIconImage(Toolkit.getDefaultToolkit().getImage("images/view.png"));
		frmViewMovies.setTitle("View Movies");
		frmViewMovies.setBounds(100, 100, 450, 300);
		frmViewMovies.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton btnViewAll = new JButton("VIEW ALL");
		btnViewAll.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnViewAll.setBounds(0, 238, 434, 23);
		btnViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewallmovies vam = new viewallmovies();
				vam.viewallmovies();
			}
		});
		frmViewMovies.getContentPane().setLayout(null);
		frmViewMovies.getContentPane().add(btnViewAll);
		
		final JComboBox searchby = new JComboBox();
		searchby.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		searchby.setModel(new DefaultComboBoxModel(new String[] {"Actor", "Award", "Director", "Genre", "Movie", "MPAA", "Studio", "Score"}));
		searchby.setBounds(237, 34, 90, 20);
		frmViewMovies.getContentPane().add(searchby);
		
		search = new JTextField();
		search.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		search.setBounds(10, 34, 206, 20);
		frmViewMovies.getContentPane().add(search);
		search.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				searchbytype sbt = new searchbytype();
				sbt.search(search.getText(), searchby.getSelectedItem());
			}
		});
		btnSearch.setBounds(337, 34, 87, 20);
		frmViewMovies.getContentPane().add(btnSearch);
		
		JPanel panel = new JPanel();
		panel.add(new JLabel(new ImageIcon("images/thunder.jpg")));
		panel.setBounds(0, 0, 434, 261);
		frmViewMovies.getContentPane().add(panel);
	
		
	}
}
