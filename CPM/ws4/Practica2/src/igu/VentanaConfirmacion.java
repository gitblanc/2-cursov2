package igu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaConfirmacion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblFinalizarPedido;
	private JLabel lblCodigoRecogida;
	private JTextField textCodigoPedido;
	private JButton btnFinalizar;
	private VentanaRegistro vR;
	private JLabel lblTotal;
	private JLabel lblPrecioTotal;
	private JLabel lblConDescuento;

	/**
	 * Constructor con par�metro VentanaRegistro que crea el frame
	 */
	public VentanaConfirmacion(VentanaRegistro vReg) {
		this.vR = vReg;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaConfirmacion.class.getResource("/img/logo.png")));
		setBackground(Color.WHITE);
		setTitle("McDonald's: Confirmaci\u00F3n del pedido");
		setBounds(100, 100, 683, 350);
		getContentPane().setLayout(null);
		getContentPane().add(getLblFinalizarPedido());
		getContentPane().add(getLblCodigoRecogida());
		getContentPane().add(getTextCodigoPedido());
		getContentPane().add(getBtnFinalizar());
		getContentPane().add(getLblTotal());
		getContentPane().add(getLblPrecioTotal());
		getContentPane().add(getLblConDescuento());

	}

	/*
	 * Getter para el label Pulse Finalizar para confirmar su pedido
	 */
	private JLabel getLblFinalizarPedido() {
		if (lblFinalizarPedido == null) {
			lblFinalizarPedido = new JLabel("   Pulse Finalizar para confirmar su pedido");
			lblFinalizarPedido.setBounds(0, 86, 667, 50);
			lblFinalizarPedido.setBackground(Color.WHITE);
			lblFinalizarPedido.setVerticalAlignment(SwingConstants.TOP);
			lblFinalizarPedido.setIcon(new ImageIcon(VentanaConfirmacion.class.getResource("/img/ok.png")));
			lblFinalizarPedido.setFont(new Font("Arial Black", Font.PLAIN, 25));
		}
		return lblFinalizarPedido;
	}

	/*
	 * Getter para el label El c�digo de recogida es:
	 */
	private JLabel getLblCodigoRecogida() {
		if (lblCodigoRecogida == null) {
			lblCodigoRecogida = new JLabel("El c\u00F3digo de recogida es: ");
			lblCodigoRecogida.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCodigoRecogida.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblCodigoRecogida.setBounds(62, 158, 248, 33);
		}
		return lblCodigoRecogida;
	}

	/*
	 * Getter para el JTextField c�digo del pedido
	 */
	private JTextField getTextCodigoPedido() {
		if (textCodigoPedido == null) {
			textCodigoPedido = new JTextField();
			textCodigoPedido.setBackground(Color.LIGHT_GRAY);
			textCodigoPedido.setEditable(false);
			textCodigoPedido.setText(vR.getVentanaPrincipal().getPedido().getCodigo());
			textCodigoPedido.setBounds(320, 160, 134, 34);
			textCodigoPedido.setColumns(10);
		}
		return textCodigoPedido;
	}

	/*
	 * Getter para el JButton finalizar. Realiza la acci�n de cerrar las ventanas.
	 */
	private JButton getBtnFinalizar() {
		if (btnFinalizar == null) {
			btnFinalizar = new JButton("Finalizar");
			btnFinalizar.setEnabled(true);
			btnFinalizar.setForeground(Color.WHITE);
			btnFinalizar.setBackground(Color.GREEN);
			btnFinalizar.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					finalizar();

				}
			});
			btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnFinalizar.setBounds(568, 277, 89, 23);
		}
		return btnFinalizar;
	}

	/*
	 * M�todo que graba el pedido, vuelve a inicializar la ventana principal y
	 * cierra las dem�s ventanas
	 */
	private void finalizar() {
		vR.getVentanaPrincipal().getPedido().grabarPedido();
		vR.getVentanaPrincipal().getPedido().inicializar();
		dispose();
		vR.dispose();
	}

	/*
	 * Getter para el JLabel total
	 */
	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel("Total: ");
			lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTotal.setFont(new Font("Arial", Font.PLAIN, 17));
			lblTotal.setBounds(62, 214, 248, 33);
		}
		return lblTotal;
	}

	/*
	 * Getter para el JLabel precio total
	 */
	private JLabel getLblPrecioTotal() {
		if (lblPrecioTotal == null) {
			lblPrecioTotal = new JLabel(textoPrecio());
			lblPrecioTotal.setFont(new Font("Arial", Font.BOLD, 14));
			lblPrecioTotal.setBounds(320, 215, 134, 34);
		}
		return lblPrecioTotal;
	}

	/*
	 * M�todo que devuelve el precio sin descuento y en el caso de que se aplicase
	 * un descuento muestra un label oculto conforme a que se ha aplicado el
	 * descuento
	 */
	private String textoPrecio() {
		float total = vR.getVentanaPrincipal().getPedido().getTotal();
		if (total > 50) {
			getLblConDescuento().setText("Descuento del 10% aplicado.");
			return String.format("%.2f", total * 0.9);
		} else {
			return String.format("%.2f", total);
		}
	}

	/*
	 * Getter para el JLabel descuento, que no mostrar� nada salvo que haya un
	 * descuento
	 */
	private JLabel getLblConDescuento() {
		if (lblConDescuento == null) {
			lblConDescuento = new JLabel("");
			lblConDescuento.setForeground(Color.RED);
			lblConDescuento.setBounds(464, 214, 193, 33);
		}
		return lblConDescuento;
	}
}
