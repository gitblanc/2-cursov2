package AVL;

public class AVLTree<T extends Comparable<T>> {
	private AVLNode<T> raiz;

	public AVLTree() {
		this.raiz = null;
	}

	public AVLNode<T> searchNode(T clave) {
		if (clave == null || this.raiz == null) {
			return null;
		}
		return searchNodeRecursivo(raiz, clave);
	}

	private AVLNode<T> searchNodeRecursivo(AVLNode<T> raiz2, T clave) {
		if (raiz2 == null) {
			return null;
		}
		// COMPARE TO devuelve > 0 si obj1 > obj2
		// devuelve < 0 si obj1 < obj2
		// devuelve = 0 si obj1 = obj2
		else if (raiz2.getInfo().compareTo(clave) > 0) {// si la clave es menor que el nodo
														// busca por la izquierda
			return searchNodeRecursivo(raiz2.getLeft(), clave);
		} else if (raiz2.getInfo().compareTo(clave) < 0) {// si la clave es mayor que el
															// nodo busca por la derecha
			return searchNodeRecursivo(raiz2.getRight(), clave);
		} else if (raiz2.getInfo().compareTo(clave) == 0) {// si la clave es igual que el nodo lo devuelve
			return raiz2;
		} else {// si no lo encuentra devuelve null
			return null;
		}
	}

	public int addNode(T clave) {
		if (clave == null) {
			return -2;
		} else if (this.raiz == null) {
			this.raiz = new AVLNode<T>(clave);
			return 0;
		} else if (searchNode(clave) != null) {
			return -1;
		} else {
			AVLNode<T> newNode = addNodeRecursivo(this.raiz, clave);

			this.raiz = newNode;
			return 0;
		}
	}

	private AVLNode<T> addNodeRecursivo(AVLNode<T> raiz2, T clave) {
		// CompareTo:
		// Si da 1, el de la izq es más grande que el parametro
		// Si da negativo, el de la izq es menor que el parametro
		// Si da 0 son iguales
		if (raiz2.getInfo().compareTo(clave) > 0) {
			if (raiz2.getLeft() != null) {
				raiz2.setLeft(addNodeRecursivo(raiz2.getLeft(), clave));
				return updateAndBalanceIfNecesary(raiz2);
			} else {
				raiz2.setLeft(new AVLNode<T>(clave));
				return updateAndBalanceIfNecesary(raiz2);
			}
		} else if (raiz2.getInfo().compareTo(clave) < 0) {
			if (raiz2.getRight() != null) {
				raiz2.setRight(addNodeRecursivo(raiz2.getRight(), clave));
				return updateAndBalanceIfNecesary(raiz2);
			} else {
				raiz2.setRight(new AVLNode<T>(clave));
				return updateAndBalanceIfNecesary(raiz2);
			}
		} else {
			return null;
		}
	}

	private AVLNode<T> updateAndBalanceIfNecesary(AVLNode<T> nodo) {
		nodo.updateBFHeight();
		if (nodo.getBF() == -2)

			if (nodo.getLeft().getBF() == 1)
				nodo = doubleLeftRotation(nodo);
			else // -1 o cero
				nodo = singleLeftRotation(nodo);
		else if (nodo.getBF() == 2)
			if (nodo.getRight().getBF() == -1)
				nodo = doubleRightRotation(nodo);
			else // 1 o cero
				nodo = singleRightRotation(nodo);
		return nodo;
	}

	private AVLNode<T> singleRightRotation(AVLNode<T> nodo) {
		AVLNode<T> aux = nodo.getRight();
		nodo.setRight(aux.getLeft());
		aux.setLeft(nodo);
		return aux;
	}

	private AVLNode<T> doubleRightRotation(AVLNode<T> nodo) {
		nodo.setRight(singleLeftRotation(nodo.getRight()));
		return singleRightRotation(nodo);
	}

	private AVLNode<T> singleLeftRotation(AVLNode<T> nodo) {
		AVLNode<T> aux = nodo.getLeft();
		nodo.setLeft(aux.getRight());
		aux.setRight(nodo);
		return aux;
	}

	private AVLNode<T> doubleLeftRotation(AVLNode<T> nodo) {
		nodo.setLeft(singleRightRotation(nodo.getLeft()));
		return singleLeftRotation(nodo);
	}

	/**
	 * 
	 * @return
	 */
	public String preOrder() {
		String cadena = recorridoPreOrderRecursivo(raiz);
		return cadena.substring(0, cadena.length() - 1);
	}

	private String recorridoPreOrderRecursivo(AVLNode<T> raiz2) {
		if (raiz2 == null) {
			return "";
		} else {
			String cadena = raiz2.getInfo().toString();
			cadena += "\t";
			cadena += recorridoPreOrderRecursivo(raiz2.getLeft());
			cadena += recorridoPreOrderRecursivo(raiz2.getRight());
			return cadena;
		}
	}

	/**
	 * 
	 * @return
	 */
	public String postOrder() {
		String cadena = recorridoPostOrderRecursivo(raiz);
		return cadena.substring(0, cadena.length() - 1);
	}

	private String recorridoPostOrderRecursivo(AVLNode<T> raiz2) {
		String cadena = "";
		if (raiz2 != null) {
			cadena += recorridoPostOrderRecursivo(raiz2.getLeft());
			cadena += recorridoPostOrderRecursivo(raiz2.getRight());
			cadena += raiz2.getInfo().toString() + "\t";
		}
		return cadena;
	}

	/**
	 * 
	 * @return
	 */
	public String inOrder() {
		String cadena = recorridoInOrderRecursivo(raiz);
		return cadena.substring(0, cadena.length() - 1);
	}

	private String recorridoInOrderRecursivo(AVLNode<T> raiz2) {
		String cadena = "";
		if (raiz2 != null) {
			cadena += recorridoInOrderRecursivo(raiz2.getLeft());
			cadena += raiz2.getInfo().toString() + "\t";
			cadena += recorridoInOrderRecursivo(raiz2.getRight());
		}
		return cadena;
	}

	public int removeNode(T clave) {
	}
}