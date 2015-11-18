package print;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class PrintOptions extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrintOptions frame = new PrintOptions();
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
	public PrintOptions() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 225, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnRiteOfChristian = new JRadioButton("Rite of Christian Initiation");
		rdbtnRiteOfChristian.setBounds(20, 80, 166, 23);
		contentPane.add(rdbtnRiteOfChristian);
		
		JRadioButton rdbtnFirstCommunion = new JRadioButton("First Communion");
		rdbtnFirstCommunion.setBounds(20, 54, 109, 23);
		contentPane.add(rdbtnFirstCommunion);
		
		JRadioButton rdbtnConfirmation = new JRadioButton("Confirmation");
		rdbtnConfirmation.setBounds(20, 28, 109, 23);
		contentPane.add(rdbtnConfirmation);
		
		JButton btnEnglish = new JButton("English");
		btnEnglish.setBounds(10, 133, 89, 23);
		contentPane.add(btnEnglish);
		
		JButton btnSpanish = new JButton("Spanish");
		btnSpanish.setBounds(109, 133, 89, 23);
		contentPane.add(btnSpanish);
		
		JLabel lblCertificateType = new JLabel("Certificate Type:");
		lblCertificateType.setBounds(10, 11, 139, 14);
		contentPane.add(lblCertificateType);
		
		JLabel lblPrintLanguage = new JLabel("Print Language:");
		lblPrintLanguage.setBounds(10, 110, 89, 14);
		contentPane.add(lblPrintLanguage);
	}
}
