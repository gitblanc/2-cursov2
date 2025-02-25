package igu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMcDonalds;
	private JSpinner spinner;
	private JTextField textField;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private JLabel lblNewLabel;
	private JLabel lblUnidades;
	private JButton btnA�adir;
	private JLabel lblPrecioPedido;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setResizable(false);
		setTitle("McDonald's Espa\u00F1a");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 429);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblMcDonalds());
		contentPane.add(getSpinner());
		contentPane.add(getTextField());
		contentPane.add(getBtnSiguiente());
		contentPane.add(getBtnCancelar());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblUnidades());
		contentPane.add(getBtnA�adir());
		contentPane.add(getLblPrecioPedido());
		contentPane.add(getComboBox());
	}
	private JLabel getLblMcDonalds() {
		if (lblMcDonalds == null) {
			lblMcDonalds = new JLabel("   McDonald's");
			lblMcDonalds.setHorizontalAlignment(SwingConstants.LEFT);
			lblMcDonalds.setFont(new Font("Arial Black", Font.PLAIN, 44));
			lblMcDonalds.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
			lblMcDonalds.setBounds(34, 11, 483, 133);
		}
		return lblMcDonalds;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(1, 1, null, 1));
			spinner.setBounds(318, 198, 30, 20);
		}
		return spinner;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setEditable(false);
			textField.setBounds(318, 269, 86, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnSiguiente() {
		if (btnSiguiente == null) {
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.setEnabled(false);
			btnSiguiente.setBounds(318, 323, 89, 23);
		}
		return btnSiguiente;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setForeground(Color.WHITE);
			btnCancelar.setBackground(Color.RED);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnCancelar.setBounds(428, 323, 89, 23);
		}
		return btnCancelar;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Art\u00EDculos:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(34, 163, 74, 28);
		}
		return lblNewLabel;
	}
	private JLabel getLblUnidades() {
		if (lblUnidades == null) {
			lblUnidades = new JLabel("Unidades:");
			lblUnidades.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblUnidades.setBounds(318, 167, 74, 20);
		}
		return lblUnidades;
	}
	private JButton getBtnA�adir() {
		if (btnA�adir == null) {
			btnA�adir = new JButton("A\u00F1adir");
			btnA�adir.setBackground(Color.GREEN);
			btnA�adir.setForeground(Color.WHITE);
			btnA�adir.setBounds(383, 197, 89, 23);
		}
		return btnA�adir;
	}
	private JLabel getLblPrecioPedido() {
		if (lblPrecioPedido == null) {
			lblPrecioPedido = new JLabel("Precio Pedido:");
			lblPrecioPedido.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPrecioPedido.setBounds(318, 238, 127, 20);
		}
		return lblPrecioPedido;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(34, 197, 30, 22);
		}
		return comboBox;
	}
}
