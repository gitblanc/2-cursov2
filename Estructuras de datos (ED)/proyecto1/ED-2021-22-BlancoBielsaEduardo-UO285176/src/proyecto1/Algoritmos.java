/**
 * 
 */
package proyecto1;

/**
 * @author blanc
 *
 */
public class Algoritmos {

	// SIN EL DONOTHING
	// RECURSIVOS

	/*
	 * Versi�n recursiva del factorial de un n�mero
	 */
	public static double factorialRecursivo(int n) {
		doNothing();
		if (n == 0)
			return 1;
		return factorialRecursivo(n - 1) * n;

	}

	// POTENCIAS RECURSIVAS
	public static double potenciaRecursiva_v0(int n) {
		if (n == 0)
			return 1;
		return 2 * potenciaRecursiva_v0(n - 1);
	}

	public static double potenciaRecursiva_v1(int n) {
		if (n == 0)
			return 1;
		return potenciaRecursiva_v1(n - 1) + potenciaRecursiva_v1(n - 1);
	}

	public static double potenciaRecursiva_v2(int n) {
		if (n == 0)
			return 1;
		else if (n % 2 == 0)
			return (potenciaRecursiva_v2(n / 2) * potenciaRecursiva_v2(n / 2));
		else
			return (potenciaRecursiva_v2(n / 2) * potenciaRecursiva_v2(n / 2) * 2);
	}

	public static double potenciaRecursiva_v3(int n) {
		if (n == 0)
			return 1;
		long result = (long) potenciaRecursiva_v3(n / 2);
		if (n % 2 == 0)
			return (result * result);
		else
			return (result * result * 2);
	}

	/*
	 * Versi�n recursiva que devuelve el valor del termino d la serie de Fibonacci
	 */
	public static double fibonacciRecursivo(int n) {
		if (n == 1)
			return 0;
		else if (n == 2)
			return 1;
		return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
	}

	// ITERATIVOS

	/*
	 * Versi�n iterativa del factorial de un n�mero
	 */
	public static double factorialIterativo(int n) {
		double num = 1;
		for (int i = 1; i <= n; i++) {
			num = num * i;
		}
		return num;

	}

	/*
	 * Versi�n iterativa que calcula la potencia de 2 para un exponente dado
	 */
	public static double potenciaIterativa(int n) {
		if (n == 0)
			return (double) 1;
		double num = 1;
		for (int i = 1; i <= n; i++) {
			num = num * 2;
		}
		return num;

	}

	/*
	 * Versi�n iterativa que devuelve el valor del termino d la serie de Fibonacci
	 */
	public static double fibonacciIterativo(int n) {
		if (n == 1)
			return (double) 0;
		if (n == 2)
			return (double) 1;
		double num = 1;
		double anterior = 0;
		double siguiente = 0;
		for (int i = 3; i <= n; i++) {
			anterior = siguiente;
			siguiente = num;
			num = num + anterior;

		}
		return num;
	}

	/*
	 * Algoritmo de prueba de complejidad lineal y que muestra un texto por pantalla
	 */
	public static void lineal(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(i);
		}
	}

	/*
	 * Algoritmo de prueba de complejidad cuadr�tica y que muestra un texto por
	 * pantalla
	 */
	public static void cuadratica(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println(i + "," + j);
			}
		}
	}

	/*
	 * Algoritmo de prueba de complejidad c�bica y que muestra un texto por pantalla
	 */
	public static void cubica(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					System.out.println(i + "," + j + "," + k);
				}
			}
		}
	}

	/*
	 * Algoritmo de prueba de complejidad logar�tmica y que muestra un texto por
	 * pantalla
	 */
	public static void logaritmica(int n) {
		int num = (int) n;
		while (num > 0) {
			System.out.println(num);
			num = num / 2;
		}
	}

	// CON EL DONOTHING

	/*
	 * Algoritmo de prueba de complejidad lineal y que en vez de mostrar un texto
	 * utiliza el m�todo doNothing
	 */
	public static void linealdoNothing(int n) {
		for (int i = 0; i < n; i++) {
			doNothing();
		}
	}

	/*
	 * Algoritmo de prueba de complejidad cuadr�tica y que en vez de mostrar un
	 * texto utiliza el m�todo doNothing
	 */
	public static void cuadraticaNothing(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				doNothing();
			}
		}
	}

	/*
	 * Algoritmo de prueba de complejidad c�bica y que en vez de mostrar un texto
	 * utiliza el m�todo doNothing
	 */
	public static void cubicaNothing(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					doNothing();
				}
			}
		}
	}

	/*
	 * Algoritmo de prueba de complejidad logar�tmica y que en vez de mostrar un
	 * texto utiliza el m�todo doNothing
	 */
	public static void logaritmicadoNothing(int n) {
		int num = (int) n;
		while (num > 0) {
			doNothing();
			num = num / 2;
		}
	}

	/*
	 * M�todo que para el sistema un tiempo determinado (y simula la realizaci�n de
	 * una tarea)
	 */
	private static void doNothing() {
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// POTENCIAS RECURSIVAS
	public static double potenciaRecursiva_v0doNothing(int n) {
		doNothing();
		if (n == 0)
			return 1;
		return 2 * potenciaRecursiva_v0doNothing(n - 1);
	}

	public static double potenciaRecursiva_v1doNothing(int n) {
		doNothing();
		if (n == 0)
			return 1;
		return potenciaRecursiva_v1doNothing(n - 1) + potenciaRecursiva_v1doNothing(n - 1);
	}

	public static double potenciaRecursiva_v2doNothing(int n) {
		doNothing();
		if (n == 0)
			return 1;
		else if (n % 2 == 0)
			return (potenciaRecursiva_v2doNothing(n / 2) * potenciaRecursiva_v2doNothing(n / 2));
		else
			return (potenciaRecursiva_v2doNothing(n / 2) * potenciaRecursiva_v2doNothing(n / 2) * 2);
	}

	public static double potenciaRecursiva_v3doNothing(int n) {
		doNothing();
		if (n == 0)
			return 1;
		long result = (long) potenciaRecursiva_v3doNothing(n / 2);
		if (n % 2 == 0)
			return (result * result);
		else
			return (result * result * 2);
	}

}
