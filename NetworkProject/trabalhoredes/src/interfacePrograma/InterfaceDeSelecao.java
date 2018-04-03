package interfacePrograma;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceDeSelecao {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceDeSelecao window = new InterfaceDeSelecao();
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
	public InterfaceDeSelecao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelSelecao = new JLabel("Selecione t\u00E9cnica de detec\u00E7\u00E3o");
		labelSelecao.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		labelSelecao.setBounds(83, 0, 263, 31);
		frame.getContentPane().add(labelSelecao);
		
		JButton btnParidade = new JButton("Paridade dupla");
		btnParidade.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnParidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnParidade.setBounds(12, 44, 192, 88);
		frame.getContentPane().add(btnParidade);
		
		JButton btnCrc = new JButton("CRC ");
		btnCrc.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCrc.setBounds(228, 44, 192, 88);
		frame.getContentPane().add(btnCrc);
		
		JButton btnChecksum = new JButton("CHECKSUM");
		btnChecksum.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnChecksum.setBounds(12, 145, 192, 88);
		frame.getContentPane().add(btnChecksum);
		
		JButton btnHamming = new JButton("Hamming");
		btnHamming.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnHamming.setBounds(228, 145, 192, 88);
		frame.getContentPane().add(btnHamming);
	}
}
