package logica;

import java.util.*;

public class Pedido {

	private List<Articulo> listaPedido;
	private String codigo;
	private boolean descuentoAplicado;
	private boolean paraLlevarONo;

	
	public Pedido() {
		listaPedido = new ArrayList<Articulo>();
		inicializar();
	}

	public boolean getParaLlevarONo() {
		return this.paraLlevarONo;
	}
	
	public void setParaLlevarONo(boolean estado) {
		this.paraLlevarONo = estado;
	}

	public void inicializar() {
		listaPedido.clear();
		this.setDescuentoAplicado(false);
		generarCodigo();
	}

	public void add(Articulo articuloDelCatalogo, int unidades) {
		Articulo articuloEnPedido = null;

		for (Articulo a : listaPedido) {
			if (a.getCodigo().equals(articuloDelCatalogo.getCodigo())) {
				articuloEnPedido = a;
				articuloEnPedido.setUnidades(articuloEnPedido.getUnidades() + unidades);
				break;
			}
		}

		if (articuloEnPedido == null) {
			Articulo articuloAPedido = new Articulo(articuloDelCatalogo);
			articuloAPedido.setUnidades(unidades);
			listaPedido.add(articuloAPedido);
		}

	}

	public void remove(Articulo articuloSeleccionado, int unidadesAEliminar) {

		for (Articulo art : listaPedido) {
			boolean codigoIgual = art.getCodigo().equals(articuloSeleccionado.getCodigo());
			if (codigoIgual && art.getUnidades() > unidadesAEliminar && !getDescuentoAplicado()) {
				art.setUnidades(art.getUnidades() - unidadesAEliminar);
				break;
			} else if (codigoIgual && art.getUnidades() > unidadesAEliminar && getDescuentoAplicado()) {
				art.setUnidades(art.getUnidades() - unidadesAEliminar);
				if (getTotal() < 50)
					setDescuentoAplicado(false);
				break;
			} else if (codigoIgual && articuloSeleccionado.getUnidades() < unidadesAEliminar
					&& !getDescuentoAplicado()) {
				listaPedido.remove(art);
				break;
			} else if (codigoIgual && articuloSeleccionado.getUnidades() < unidadesAEliminar
					&& getDescuentoAplicado()) {
				listaPedido.remove(art);
				if (getTotal() < 50)
					setDescuentoAplicado(false);
				break;
			}

		}
	}

	public float getTotal() {
		float precio = 0;
		for (Articulo a : listaPedido) {
			precio += a.getPrecio() * a.getUnidades();
		}
		if (precio >= 50) {
			precio *= 0.9;
			setDescuentoAplicado(true);
		}
		return precio;
	}

	public boolean getDescuentoAplicado() {
		return this.descuentoAplicado;
	}

	public void grabarPedido() {
		FileUtil.saveToFile(codigo, toStringEscrituraFichero());
	}

	public String getCodigo() {
		return codigo;
	}

	private void generarCodigo() {
		codigo = "";
		String base = "0123456789abcdefghijklmnopqrstuvwxyz";
		int longitudCodigo = 8;
		for (int i = 0; i < longitudCodigo; i++) {
			int numero = (int) (Math.random() * (base.length()));
			codigo += base.charAt(numero);
		}
	}

	public int buscarUnidadesArticulo(Articulo articulo) {
		for (Articulo art : listaPedido) {
			if (articulo.getCodigo().equals(art.getCodigo()))
				return art.getUnidades();
		}
		return 0;
	}

	@Override
	public String toString() {
		String result = "";
		for (Articulo art : listaPedido) {
			result += art.toString() + "\n";
		}
		result += "Total : " + String.format("%.2f", getTotal()) + "\u20AC";
		return result;
	}
	
	public String toStringEscrituraFichero() {
		String result = "";
		for (Articulo art : listaPedido) {
			result += art.toString() + "\n";
		}
		result += getParaLlevarONo() ? "Para llevar" : "Para comer aqu�";
		return result;
	}

	public void setDescuentoAplicado(boolean descuentoAplicado) {
		this.descuentoAplicado = descuentoAplicado;
	}

}
