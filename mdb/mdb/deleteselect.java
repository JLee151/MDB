package mdb;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class deleteselect extends JDialog {

	private final JPanel contentPanel = new JPanel();
	static String search;
	static Connection conn;
	static Statement stat;
	static ArrayList<String> mov = new ArrayList<String>();
	
	/**
	 * Launch the application.
	 */
	public static void delselect(String s) {
		search = s;
		try {
			deleteselect dialog = new deleteselect();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws SQLException 
	 */
	public deleteselect() throws SQLException {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		final JList list;// = new JList();
		JScrollPane scrollPane = new JScrollPane();
		ArrayList<String> values = new ArrayList<String>();
		
		try {
			   Class.forName("org.sqlite.JDBC");
			}
		catch(ClassNotFoundException ex) {
		   System.out.println("Error: unable to load driver class!");
		   System.exit(1);
		}
		conn = DriverManager.getConnection("jdbc:sqlite:movie.db");
		stat = conn.createStatement();
		String sql;

		
		sql = "SELECT count(movieID) as c FROM Movie WHERE title LIKE '%" + search + "'";
		final ResultSet size = stat.executeQuery(sql);
		int s = size.getInt("c");
		//final String[] values = new String[s];
		sql = "SELECT title FROM Movie WHERE title LIKE '%" + search + "%'";
		ResultSet rs = stat.executeQuery(sql);
		
		while(rs.next()){
			values.add(rs.getString("title"));
		}
		
		list = new JList(values.toArray());
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			scrollPane.setViewportView(list);
			
			conn.close();
			stat.close();
			rs.close();
			size.close();
			
			
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						try {
							   Class.forName("org.sqlite.JDBC");
							}
						catch(ClassNotFoundException ex) {
						   System.out.println("Error: unable to load driver class!");
						   System.exit(1);
						}
						try{
							conn = DriverManager.getConnection("jdbc:sqlite:movie.db");
							stat = conn.createStatement();
							//List<String> val = new ArrayList<String>();
							//val = list.getSelectedValue().toString();
							ListModel model = list.getModel();
							//System.out.println(model.getSize());
							for(int i : list.getSelectedIndices()){

								String sql = "SELECT movieID FROM movie WHERE title LIKE '%" + model.getElementAt(i) + "%'";
								ResultSet rs = stat.executeQuery(sql);
								int movieID = rs.getInt("movieID");

								sql = "DELETE FROM Movie WHERE movieID = " + movieID + "";
								stat.executeUpdate(sql);
								sql = "DELETE FROM Actors WHERE movieID = " + movieID + "";
								stat.executeUpdate(sql);
								sql = "DELETE FROM Awards WHERE movieID = " + movieID + "";
								stat.executeUpdate(sql);
								sql = "DELETE FROM Directors WHERE movieID = " + movieID + "";
								stat.executeUpdate(sql);
								sql = "DELETE FROM Genre WHERE movieID = " + movieID + "";
								stat.executeUpdate(sql);
								sql = "DELETE FROM MPAA WHERE movieID = " + movieID + "";
								stat.executeUpdate(sql);
								sql = "DELETE FROM Studios WHERE movieID = " + movieID + "";
								stat.executeUpdate(sql);
								sql = "DELETE FROM UserScore WHERE movieID = " + movieID + "";
								stat.executeUpdate(sql);
								
								rs.close();
							}
							
							conn.close();
							stat.close();
							
							insertsuccesful is = new insertsuccesful();
							is.insertsuccess();
							dispose();
							
						}catch (SQLException e) {
							// TODO Auto-generated catch block
							operationfailure of = new operationfailure();
							of.opfail();
							e.printStackTrace();
						}
					
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
