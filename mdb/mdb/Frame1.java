package mdb;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Toolkit;

/*Copyright Raul Nunez 2015 All rights Reserved*/
public class Frame1 {

	private JFrame frmPoorMansImdb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frmPoorMansImdb.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPoorMansImdb = new JFrame();
		frmPoorMansImdb.setTitle("Poor Man's IMDB");
		frmPoorMansImdb.setIconImage(Toolkit.getDefaultToolkit().getImage("images/icon2.png"));
		frmPoorMansImdb.getContentPane().setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		frmPoorMansImdb.setBounds(100, 100, 450, 300);
		frmPoorMansImdb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPoorMansImdb.getContentPane().add(new JLabel(new ImageIcon("flame.jpg")));
		
		JButton btnNewMovie = new JButton("View Movie(s)");
		btnNewMovie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					viewmovie vm = new viewmovie();
					vm.viewmovie();
				} catch (Exception t) {
					t.printStackTrace();
				}
			}
		});
		btnNewMovie.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnNewMovie.setBounds(138, 135, 137, 39);
		btnNewMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frmPoorMansImdb.getContentPane().setLayout(null);
		frmPoorMansImdb.getContentPane().add(btnNewMovie);
		
		JButton btnNewButton = new JButton("Insert Movie(s)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					insertmovie nw = new insertmovie();
					nw.insertmovie();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		/*btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("jordan melts beams");
			}
		});*/
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnNewButton.setBounds(138, 71, 137, 39);
		frmPoorMansImdb.getContentPane().add(btnNewButton);
		
		JLabel lblWelcomeToCse = new JLabel("Poor Man's IMDB");
		lblWelcomeToCse.setForeground(Color.WHITE);
		lblWelcomeToCse.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToCse.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblWelcomeToCse.setBounds(53, 11, 330, 49);
		frmPoorMansImdb.getContentPane().add(lblWelcomeToCse);
		
		JButton btnNewButton_1 = new JButton("Delete Movie(s)");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deletemovie dm = new deletemovie();
				dm.deletemovie();
			}
		});
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		btnNewButton_1.setBounds(138, 195, 137, 39);
		frmPoorMansImdb.getContentPane().add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.add(new JLabel(new ImageIcon("images/flame.jpg")));
		panel.setBounds(0, 0, 434, 261);
		frmPoorMansImdb.getContentPane().add(panel);
	}
}
