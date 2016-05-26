package mdb;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Toolkit;

public class deletemovie {

	private JFrame frmDelete;
	private JTextField movietitle;
	static Connection conn;
	static Statement stat;

	/**
	 * Launch the application.
	 */
	public static void deletemovie() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deletemovie window = new deletemovie();
					window.frmDelete.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public deletemovie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDelete = new JFrame();
		frmDelete.setTitle("Delete Movie");
		frmDelete.setIconImage(Toolkit.getDefaultToolkit().getImage("images/delete.png"));
		frmDelete.setBounds(100, 100, 450, 300);
		frmDelete.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDelete.getContentPane().setLayout(null);
		
		JLabel lblMovieName = new JLabel("Movie title");
		lblMovieName.setForeground(Color.WHITE);
		lblMovieName.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblMovieName.setBounds(151, 11, 171, 83);
		frmDelete.getContentPane().add(lblMovieName);
		
		movietitle = new JTextField();
		movietitle.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		movietitle.setBounds(102, 77, 245, 56);
		frmDelete.getContentPane().add(movietitle);
		movietitle.setColumns(10);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//deleteselect ds;
				deleteselect.delselect(movietitle.getText());
				
			}
		});

		btnDelete.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		btnDelete.setBounds(102, 144, 245, 106);
		frmDelete.getContentPane().add(btnDelete);
		
		JPanel panel = new JPanel();
		panel.add(new JLabel(new ImageIcon("images/thunder2.jpg")));
		panel.setBounds(0, 0, 434, 261);
		frmDelete.getContentPane().add(panel);
	}

}
