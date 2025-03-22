package umg.edu.progra.listas;

/**
 *
 * @author Walter Cordova
 */
public class Lista {

    private Nodo primero;

    @Override
    public String toString() {
        return "=>" + primero;
    }

    /**
     * Constructor para inicializar una lista
     */
    public Lista() {
        primero = null;
    }

    /**
     * Devuelve el nodo inicial
     *
     * @return
     */
    public Nodo leerPrimero() {
        return primero;
    }

    /**
     * Inserta valores a la lista
     *
     * @param entrada
     */
    public void insertarCabezaLista(int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = primero;
        primero = nuevo;

    }

    /**
     * inserta un elemento a partir de anterior
     *
     * @param anterior
     * @param entrada
     */
    public void insertarLista(Nodo anterior, int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = anterior.enlace;
        anterior.enlace = nuevo;

    }

    /**
     * elimina el elemento entrada
     *
     * @param entrada
     */
    public void eliminar(int entrada) {
        Nodo actual, anterior;
        boolean encontrado;
        actual = primero;
        anterior = null;
        encontrado = false;
        // Bucle de búsqueda
        while ((actual != null) && !(actual.dato == entrada)) {
            if (!(actual.dato == entrada)) {
                anterior = actual;
                actual = actual.enlace;
            }
        }
        if (actual != null) {
            // Se distingue entre que el nodo sea el cabecera
            // o del resto de la lista
            if (actual == primero) {
                primero = actual.enlace;
            } else {
                anterior.enlace = actual.enlace;
            }
            actual = null;
        }
    }

    /**
     * busca el elemento destino
     *
     * @param destino
     * @return
     */
    public Nodo buscarLista(int destino) {
        Nodo indice;
        for (indice = primero; indice != null; indice = indice.enlace) {
            if (indice.dato == destino) {
                return indice;
            }
        }
        return null;
    }

    /**
     * recorre la lista y muestra cada dato
     */
    public void visualizar() {
        Nodo n;
        n = primero;
        while (n != null) {
            System.out.print(n.dato + " ");
            n = n.enlace;
        }
    }
    
	/**
	* Crear los metodos que se solicitan
    /**
     * 1 - Método para invertir la lista enlazada
     */

    public void invertirLista() {
        Nodo anterior = null;
        Nodo actual = primero;
        Nodo siguiente = null;

        while (actual != null) {
            siguiente = actual.enlace;
            actual.enlace = anterior;
            anterior = actual;
            actual = siguiente;
        }

        primero = anterior;
    }
    
    /**
     * 2 - Método para obtener el elemento en la posición n desde el final
     */

    
    public int obtenerElementoDesdeFinal(int n) {
        if (primero == null || n < 1) {
            throw new IllegalArgumentException("La lista está vacía o la posición no es válida.");
        }

        Nodo puntero1 = primero;
        Nodo puntero2 = primero;

        for (int i = 0; i < n; i++) {
            if (puntero2 == null) {
                throw new IllegalArgumentException("La posición excede el tamaño de la lista.");
            }
            puntero2 = puntero2.enlace;
        }

        while (puntero2 != null) {
            puntero1 = puntero1.enlace;
            puntero2 = puntero2.enlace;
        }

        return puntero1.dato;
    }
    
    
    /**
     * 3 - Método para eliminar duplicados en una lista enlazada
     */

    
    public void eliminarDuplicados() {
        if (primero == null) {
            return;
        }

        Nodo actual = primero;

        while (actual != null && actual.enlace != null) {
            if (actual.dato == actual.enlace.dato) {
                actual.enlace = actual.enlace.enlace;
            } else {
                actual = actual.enlace;
            }
        }
    }

    
    

    /**
     * 4 - Método para obtener el tamaño de la lista enlazada
     */
    
   
    public int obtenerTamaño() {
        int tamaño = 0;
        Nodo actual = primero;

        while (actual != null) {
            tamaño++;
            actual = actual.enlace;
        }

        return tamaño;
    }
}
