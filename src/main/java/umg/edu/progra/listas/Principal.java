package umg.edu.progra.listas;

/**
 *
 * @author Walter Cordova
 */
public class Principal {

    public static void main(String[] args) {

        Lista lista = new Lista();
        lista.insertarCabezaLista(1);
        lista.insertarCabezaLista(2);
        lista.insertarCabezaLista(3);
        lista.insertarCabezaLista(4);
        lista.insertarCabezaLista(5);
        lista.insertarCabezaLista(6);
        
        lista.visualizar();        
        
        
        System.out.println("\n");
        System.out.println("primero: " + lista.leerPrimero());
        
        
        
        lista.eliminar(3);
        System.out.println("lista: " + lista);
        
        System.out.println("\n");
        
        Nodo dato = lista.buscarLista(4);  
        System.out.println("dato: " + dato);
        
        
        lista.insertarLista(dato, 10);
        System.out.println("lista " + lista);
        
        
        dato = lista.buscarLista(5);        
        System.out.println("dato " + dato);
        lista.insertarLista(dato, 600);
        
        
        
        System.out.println("lista " + lista);
        
        lista.visualizar();
        
        System.out.println("\n");
        
		 // Resolver lo que se solicita a continuacion
        // Ejercicio 1: Ordenar la lista de forma ascendente
        ordenarListaAscendente(lista);
        System.out.println("\nLista ordenada de forma ascendente:");
        lista.visualizar();
        
        System.out.println("\n");
        
        // Ejercicio 2: Unir dos listas enlazadas
        Lista otraLista = new Lista();
        otraLista.insertarCabezaLista(7);
        otraLista.insertarCabezaLista(8);
        otraLista.insertarCabezaLista(9);

        unirListas(lista, otraLista);
        System.out.println("\nUnir dos listas:");
        lista.visualizar();

        System.out.println("\n");
        
        // Ejercicio 3: Separar números pares e impares
        Lista listaPares = new Lista();
        Lista listaImpares = new Lista();

        separarParesImpares(lista, listaPares, listaImpares);
        System.out.println("\nSepara números pares:");
        listaPares.visualizar();

        System.out.println("\nSeparar números impares:");
        listaImpares.visualizar();
    }

    
    ///Metodos pra resolver los ejercicion
    // Método para ordenar la lista de forma ascendente
    public static void ordenarListaAscendente(Lista lista) {
        // Convertir la lista en un array para ordenarla
        int tamaño = lista.obtenerTamaño();
        int[] array = new int[tamaño];
        Nodo actual = lista.leerPrimero();

        // Llenar el array con los datos de la lista
        for (int i = 0; i < tamaño; i++) {
            array[i] = actual.dato;
            actual = actual.enlace;
        }

        // Ordenar el array
        java.util.Arrays.sort(array);

        // Limpiar la lista original
        while (lista.leerPrimero() != null) {
            lista.eliminar(lista.leerPrimero().dato);
        }

        // Reconstruir la lista con los datos ordenados
        for (int i = tamaño - 1; i >= 0; i--) {
            lista.insertarCabezaLista(array[i]);
        }
    }

    // Método para unir dos listas enlazadas
    public static void unirListas(Lista lista1, Lista lista2) {
        Nodo actual = lista1.leerPrimero();

        // Recorrer la primera lista hasta el final
        while (actual.enlace != null) {
            actual = actual.enlace;
        }

        // Enlazar el último nodo de la primera lista con el primer nodo de la segunda lista
        actual.enlace = lista2.leerPrimero();
    }

    // Método para separar números pares e impares
    public static void separarParesImpares(Lista lista, Lista listaPares, Lista listaImpares) {
        Nodo actual = lista.leerPrimero();

        while (actual != null) {
            if (actual.dato % 2 == 0) {
                listaPares.insertarCabezaLista(actual.dato); // Insertar en lista de pares
            } else {
                listaImpares.insertarCabezaLista(actual.dato); // Insertar en lista de impares
            }
            actual = actual.enlace;
        }
    
}
}