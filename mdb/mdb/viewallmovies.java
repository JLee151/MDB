package mdb;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.JScrollPane;

public class viewallmovies {

	private JFrame frame;
	private JTable table;
	static Connection conn;
	static Statement stat;

	/**
	 * Launch the application.
	 */
	public static void viewallmovies() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewallmovies window = new viewallmovies();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public viewallmovies() {
		initialize();
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		
		try {
			   Class.forName("org.sqlite.JDBC");
			}
		catch(ClassNotFoundException ex) {
		   System.out.println("Error: unable to load driver class!");
		   System.exit(1);
		}
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:movie.db");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stat = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ResultSet rs = stat.executeQuery("SELECT Movie.title, Movie.year, Directors.name, MPAA.rating "
				+ "FROM Movie, Directors, MPAA "
				+ "WHERE Directors.movieID = Movie.movieID AND MPAA.movieID = Movie.movieID");
			table = new JTable();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			scrollPane.setViewportView(table);
			
			conn.close();
			stat.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
