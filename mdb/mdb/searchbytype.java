package mdb;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class searchbytype {

	private JFrame frame;
	private JTable table;
	static String search;
	static String type;
	static Connection conn;
	static Statement stat;

	/**
	 * Launch the application.
	 */
	public static void search(String s, Object object) {
		search = s;
		type = (String) object;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchbytype window = new searchbytype();
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
	public searchbytype() {
		initialize();
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
		if(type == "Actor"){
			try {
				conn = DriverManager.getConnection("jdbc:sqlite:movie.db");
				stat = conn.createStatement();
				
				String sql;
				sql = "SELECT Movie.title, Movie.year, Actors.name, MPAA.rating"
						+ " FROM Movie, Actors, MPAA "
						+ "WHERE Movie.movieID = Actors.movieID AND Movie.movieID = MPAA.movieID AND Actors.name LIKE '%" + search + "%'";
				ResultSet rs = stat.executeQuery(sql);
				table = new JTable();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				scrollPane.setViewportView(table);
				
				conn.close();
				stat.close();
				rs.close();
				
			} catch (SQLException e1) {
				operationfailure of = new operationfailure();
				of.opfail();
				e1.printStackTrace();
			}
		}
		
		if(type == "Award"){
			try {
				conn = DriverManager.getConnection("jdbc:sqlite:movie.db");
				stat = conn.createStatement();
				
				String sql;
				sql = "SELECT Movie.title, Movie.year, Awards.won as Award, MPAA.rating"
						+ " FROM Movie, Awards, MPAA "
						+ "WHERE Movie.movieID = Awards.movieID AND Movie.movieID = MPAA.movieID AND Awards.won LIKE '%" + search + "%'";
				ResultSet rs = stat.executeQuery(sql);
				table = new JTable();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				scrollPane.setViewportView(table);
				
				conn.close();
				stat.close();
				rs.close();
				
			} catch (SQLException e1) {
				operationfailure of = new operationfailure();
				of.opfail();
				e1.printStackTrace();
			}
		}
		
		if(type == "Director"){
			try {
				conn = DriverManager.getConnection("jdbc:sqlite:movie.db");
				stat = conn.createStatement();
				
				String sql;
				sql = "SELECT Movie.title, Movie.year, Directors.name, MPAA.rating"
						+ " FROM Movie, Directors, MPAA "
						+ "WHERE Movie.movieID = Directors.movieID AND Movie.movieID = MPAA.movieID AND Directors.name LIKE '%" + search + "%'";
				ResultSet rs = stat.executeQuery(sql);
				table = new JTable();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				scrollPane.setViewportView(table);
				
				conn.close();
				stat.close();
				rs.close();
				
			} catch (SQLException e1) {
				operationfailure of = new operationfailure();
				of.opfail();
				e1.printStackTrace();
			}
		}
		
		if(type == "Genre"){
			try {
				conn = DriverManager.getConnection("jdbc:sqlite:movie.db");
				stat = conn.createStatement();
				
				String sql;
				sql = "SELECT Movie.title, Movie.year, Genre.type as Genre, MPAA.rating"
						+ " FROM Movie, Genre, MPAA "
						+ "WHERE Movie.movieID = Genre.movieID AND Movie.movieID = MPAA.movieID AND Genre.type LIKE '%" + search + "%'";
				ResultSet rs = stat.executeQuery(sql);
				table = new JTable();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				scrollPane.setViewportView(table);
				
				conn.close();
				stat.close();
				rs.close();
				
			} catch (SQLException e1) {
				operationfailure of = new operationfailure();
				of.opfail();
				e1.printStackTrace();
			}
		}
		
		if(type == "Movie"){
			try {
				conn = DriverManager.getConnection("jdbc:sqlite:movie.db");
				stat = conn.createStatement();
				
				String sql;
				sql = "SELECT Movie.title, Movie.year, Directors.name as Director, MPAA.rating"
						+ " FROM Movie, Directors, MPAA "
						+ "WHERE Movie.movieID = Directors.movieID AND Movie.movieID = MPAA.movieID AND Movie.title LIKE '%" + search + "%'";
				ResultSet rs = stat.executeQuery(sql);
				table = new JTable();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				scrollPane.setViewportView(table);
				
				conn.close();
				stat.close();
				rs.close();
				
			} catch (SQLException e1) {
				operationfailure of = new operationfailure();
				of.opfail();
				e1.printStackTrace();
			}
		}
		
		if(type == "MPAA"){
			try {
				conn = DriverManager.getConnection("jdbc:sqlite:movie.db");
				stat = conn.createStatement();
				
				String sql;
				sql = "SELECT Movie.title, Movie.year, Directors.name as Director, MPAA.rating"
						+ " FROM Movie, Directors, MPAA "
						+ "WHERE Movie.movieID = Directors.movieID AND Movie.movieID = MPAA.movieID AND MPAA.rating LIKE '%" + search + "%'";
				ResultSet rs = stat.executeQuery(sql);
				table = new JTable();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				scrollPane.setViewportView(table);
				
				conn.close();
				stat.close();
				rs.close();
				
			} catch (SQLException e1) {
				operationfailure of = new operationfailure();
				of.opfail();
				e1.printStackTrace();
			}
		}
		
		if(type == "Studio"){
			try {
				conn = DriverManager.getConnection("jdbc:sqlite:movie.db");
				stat = conn.createStatement();
				
				String sql;
				sql = "SELECT Movie.title, Movie.year, Studios.name as Studio, MPAA.rating"
						+ " FROM Movie, Studios, MPAA "
						+ "WHERE Movie.movieID = Studios.movieID AND Movie.movieID = MPAA.movieID AND Studios.name LIKE '%" + search + "%'";
				ResultSet rs = stat.executeQuery(sql);
				table = new JTable();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				scrollPane.setViewportView(table);
				
				conn.close();
				stat.close();
				rs.close();
				
			} catch (SQLException e1) {
				operationfailure of = new operationfailure();
				of.opfail();
				e1.printStackTrace();
			}
		}
		
		if(type == "Score"){
			try {
				conn = DriverManager.getConnection("jdbc:sqlite:movie.db");
				stat = conn.createStatement();
				
				String sql;
				sql = "SELECT Movie.title, Movie.year, UserScore.score as Score, MPAA.rating"
						+ " FROM Movie, UserScore, MPAA "
						+ "WHERE Movie.movieID = UserScore.movieID AND Movie.movieID = MPAA.movieID AND UserScore.score = " + search + "";
				ResultSet rs = stat.executeQuery(sql);
				table = new JTable();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				scrollPane.setViewportView(table);
				
				conn.close();
				stat.close();
				rs.close();
				
			} catch (SQLException e1) {
				operationfailure of = new operationfailure();
				of.opfail();
				e1.printStackTrace();
			}
		}
		
		
	}

}
