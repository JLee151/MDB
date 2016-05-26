package mdb;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import java.sql.*;
import javax.swing.JPanel;
import java.awt.Color;

public class insertmovie {

	private JFrame frmInsertMovie;
	private JTextField movietitle;
	private JTextField movieyear;
	private JTextField actornamefield;
	private JTextField directorname;
	private JTextField studioname;
	private JTextField studiocity;
	private JTextField studiocountry;
	private JTextField genre;
	private JTextField mpaa;
	static Connection conn;
	static Statement stat;

	public class actor{
		String name;
		String gender;
		
	}
	/**
	 * Launch the application.
	 */
	public static void insertmovie() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insertmovie window = new insertmovie();
					window.frmInsertMovie.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public insertmovie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInsertMovie = new JFrame();
		frmInsertMovie.setIconImage(Toolkit.getDefaultToolkit().getImage("images/add.png"));
		frmInsertMovie.getContentPane().setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		frmInsertMovie.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		frmInsertMovie.setTitle("Insert Movie");
		frmInsertMovie.setBounds(100, 100, 450, 300);
		frmInsertMovie.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmInsertMovie.getContentPane().setLayout(null);
		
		movietitle = new JTextField();
		movietitle.setBounds(10, 27, 86, 20);
		frmInsertMovie.getContentPane().add(movietitle);
		movietitle.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblTitle.setBounds(10, 11, 46, 14);
		frmInsertMovie.getContentPane().add(lblTitle);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setForeground(Color.WHITE);
		lblYear.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblYear.setBounds(109, 11, 46, 14);
		frmInsertMovie.getContentPane().add(lblYear);
		
		movieyear = new JTextField();
		movieyear.setBounds(106, 27, 86, 20);
		frmInsertMovie.getContentPane().add(movieyear);
		movieyear.setColumns(10);
		
		JLabel lblActorName = new JLabel("Actor Name");
		lblActorName.setForeground(Color.WHITE);
		lblActorName.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblActorName.setBounds(217, 11, 70, 14);
		frmInsertMovie.getContentPane().add(lblActorName);
		
		actornamefield = new JTextField();
		actornamefield.setBounds(217, 27, 86, 20);
		frmInsertMovie.getContentPane().add(actornamefield);
		actornamefield.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblGender.setBounds(313, 11, 46, 14);
		frmInsertMovie.getContentPane().add(lblGender);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		comboBox.setBounds(313, 27, 46, 20);
		frmInsertMovie.getContentPane().add(comboBox);
		
		final ArrayList<actor> actors = new ArrayList<actor>();
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actor a = new actor();
				a.gender = comboBox.getSelectedItem().toString();
				a.name = actornamefield.getText();
				actors.add(a);
				for(int i = 0; i < actors.size(); i++){
					System.out.println("name: " + actors.get(i).name + " gender: " + actors.get(i).gender);
				}
				actornamefield.setText("");
			}
		});
		btnAdd.setBounds(368, 26, 56, 21);
		frmInsertMovie.getContentPane().add(btnAdd);
		
		JLabel lblDirectorName = new JLabel("Director Name");
		lblDirectorName.setForeground(Color.WHITE);
		lblDirectorName.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblDirectorName.setBounds(10, 58, 86, 14);
		frmInsertMovie.getContentPane().add(lblDirectorName);
		
		directorname = new JTextField();
		directorname.setBounds(10, 83, 86, 20);
		frmInsertMovie.getContentPane().add(directorname);
		directorname.setColumns(10);
		
		JLabel lblGender_1 = new JLabel("Gender");
		lblGender_1.setForeground(Color.WHITE);
		lblGender_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblGender_1.setBounds(109, 58, 46, 14);
		frmInsertMovie.getContentPane().add(lblGender_1);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		comboBox_1.setBounds(109, 83, 46, 20);
		frmInsertMovie.getContentPane().add(comboBox_1);
		
		JLabel lblStudio = new JLabel("Studio");
		lblStudio.setForeground(Color.WHITE);
		lblStudio.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblStudio.setBounds(10, 114, 46, 14);
		frmInsertMovie.getContentPane().add(lblStudio);
		
		studioname = new JTextField();
		studioname.setBounds(10, 139, 86, 20);
		frmInsertMovie.getContentPane().add(studioname);
		studioname.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(Color.WHITE);
		lblCity.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblCity.setBounds(109, 114, 46, 14);
		frmInsertMovie.getContentPane().add(lblCity);
		
		studiocity = new JTextField();
		studiocity.setBounds(109, 139, 86, 20);
		frmInsertMovie.getContentPane().add(studiocity);
		studiocity.setColumns(10);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setForeground(Color.WHITE);
		lblCountry.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblCountry.setBounds(217, 114, 46, 14);
		frmInsertMovie.getContentPane().add(lblCountry);
		
		studiocountry = new JTextField();
		studiocountry.setBounds(217, 139, 86, 20);
		frmInsertMovie.getContentPane().add(studiocountry);
		studiocountry.setColumns(10);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setForeground(Color.WHITE);
		lblGenre.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblGenre.setBounds(217, 58, 46, 14);
		frmInsertMovie.getContentPane().add(lblGenre);
		
		genre = new JTextField();
		genre.setBounds(217, 83, 86, 20);
		frmInsertMovie.getContentPane().add(genre);
		genre.setColumns(10);
		
		JLabel lblMpaa = new JLabel("MPAA Rating");
		lblMpaa.setForeground(Color.WHITE);
		lblMpaa.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblMpaa.setBounds(313, 58, 86, 14);
		frmInsertMovie.getContentPane().add(lblMpaa);
		
		mpaa = new JTextField();
		mpaa.setBounds(313, 83, 86, 20);
		frmInsertMovie.getContentPane().add(mpaa);
		mpaa.setColumns(10);
		
		JLabel lblAward = new JLabel("Award Nominee");
		lblAward.setForeground(Color.WHITE);
		lblAward.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblAward.setBounds(10, 170, 95, 14);
		frmInsertMovie.getContentPane().add(lblAward);
		
		final JComboBox awardnomination = new JComboBox();
		awardnomination.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		awardnomination.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		awardnomination.setBounds(10, 195, 86, 20);
		frmInsertMovie.getContentPane().add(awardnomination);
		
		JLabel lblAwardWon = new JLabel("Award Won");
		lblAwardWon.setForeground(Color.WHITE);
		lblAwardWon.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblAwardWon.setBounds(109, 170, 83, 14);
		frmInsertMovie.getContentPane().add(lblAwardWon);
		
		final JComboBox awardwon = new JComboBox();
		awardwon.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		awardwon.setModel(new DefaultComboBoxModel(new String[] {"", "Golden Globe Award", "Academy Award", "Nobel Prize", "MTV Award", "Cannes Film Festival Award", "BAFTA Award"}));
		awardwon.setBounds(109, 195, 119, 20);
		frmInsertMovie.getContentPane().add(awardwon);
		
		JLabel lblUserRating = new JLabel("User Rating");
		lblUserRating.setForeground(Color.WHITE);
		lblUserRating.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblUserRating.setBounds(257, 170, 70, 14);
		frmInsertMovie.getContentPane().add(lblUserRating);
		
		final JComboBox userrating = new JComboBox();
		userrating.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		userrating.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		userrating.setBounds(257, 195, 56, 20);
		frmInsertMovie.getContentPane().add(userrating);
		
		JButton btnNewButton = new JButton("ADD\r \nMOVIE");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					   Class.forName("org.sqlite.JDBC");
					}
				catch(ClassNotFoundException ex) {
				   System.out.println("Error: unable to load driver class!");
				   System.exit(1);
				}
				try {
					conn = DriverManager.getConnection("jdbc:sqlite:movie.db");
					stat = conn.createStatement();
					
					String sql;
					sql = "INSERT INTO Movie(title, year) VALUES ('" + movietitle.getText() + "', " + movieyear.getText() + ")";
					stat.executeUpdate(sql);
					sql = "INSERT INTO Directors(name, gender) VALUES ('" + directorname.getText() + "', '"+ comboBox_1.getSelectedItem() +"')";
					stat.executeUpdate(sql);
					sql = "INSERT INTO Genre(type) VALUES ('" + genre.getText() + "')";
					stat.executeUpdate(sql);
					sql = "INSERT INTO Studios(name, city, country) VALUES ('" + studioname.getText() + "', '" + studiocity.getText() + "', '" + studiocountry.getText() + "')";
					stat.executeUpdate(sql);
					sql = "INSERT INTO Awards(nominated, won) VALUES ('" + awardnomination.getSelectedItem() + "', '" + awardwon.getSelectedItem() + "')";
					stat.executeUpdate(sql);
					sql = "INSERT INTO MPAA(rating) VALUES ('" + mpaa.getText() + "')";
					stat.executeUpdate(sql);
					sql = "INSERT INTO UserScore(score) VALUES (" + userrating.getSelectedItem() + ")";
					stat.executeUpdate(sql);
					ResultSet rs = stat.executeQuery("SELECT max(movieID) as m FROM movie");
					int movieID = rs.getInt("m");
					for(int i = 0; i < actors.size(); i++){
						sql = "INSERT INTO actors (movieID, name, gender) VALUES (" + movieID + ", '" + actors.get(i).name + "', '" + actors.get(i).gender + "')";
						stat.executeUpdate(sql);
					}
					conn.close();
					stat.close();
					rs.close();
					movietitle.setText(""); movieyear.setText(""); 
					directorname.setText(""); genre.setText(""); 
					studioname.setText("");studiocity.setText("");studiocountry.setText("");
					mpaa.setText(""); 
					insertsuccesful is = new insertsuccesful();
					is.insertsuccess();
					
				} catch (SQLException e1) {
					operationfailure of = new operationfailure();
					of.opfail();
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		btnNewButton.setBounds(10, 226, 414, 35);
		frmInsertMovie.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		panel.add(new JLabel(new ImageIcon("images/flames2.jpg")));
		frmInsertMovie.getContentPane().add(panel);
	}
}
