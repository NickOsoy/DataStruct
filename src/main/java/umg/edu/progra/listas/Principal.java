package umg.edu.progra.listas;

import umg.edu.progra.listas.doblementeEnlazada.DoblementeEnlazada;

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
        lista.ordenarListaAscendente(lista);
        System.out.println("\nLista ordenada de forma ascendente:");
        lista.visualizar();
        
        System.out.println("\n");
        
        // Ejercicio 2: Unir dos listas enlazadas
        Lista otraLista = new Lista();
        otraLista.insertarCabezaLista(7);
        otraLista.insertarCabezaLista(8);
        otraLista.insertarCabezaLista(9);

        lista.unirListas(lista, otraLista);
        System.out.println("\nUnir dos listas:");
        lista.visualizar();

        System.out.println("\n");
        
        // Ejercicio 3: Separar números pares e impares
        Lista listaPares = new Lista();
        Lista listaImpares = new Lista();

        lista.separarParesImpares(lista, listaPares, listaImpares);
        System.out.println("\nSepara números pares:");
        listaPares.visualizar();

        System.out.println("\nSeparar números impares:");
        listaImpares.visualizar();
    

    
    }   
}   