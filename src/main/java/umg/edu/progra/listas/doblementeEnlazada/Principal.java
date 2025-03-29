package umg.edu.progra.listas.doblementeEnlazada;

public class Principal {
	
 // listas doblementeEnlazadas
	public static void main(String[] args) {
	
	//1. Se crea la lista
    DoblementeEnlazada listaD = new DoblementeEnlazada();

    // 2. Insertar datos iniciales
    listaD.insertAtEnd(1); // Insertar al final
    listaD.insertAtBeginning(5); // Insertar al inicio
    listaD.insertAtEnd(2);
    listaD.insertAtEnd(3);

    System.out.println("---* Lista original *---");
    listaD.displayForward(); // 5 <-> 1 <-> 2 <-> 3 <-> null
    //listaD.displayBackward(); // 3 <-> 2 <-> 1 <-> 5 <-> null

    // 3. Contar nodos
    System.out.println("\n---* Contar nodos *---");
    System.out.println("Total de nodos: " + listaD.contarNodos()); // 4

    // 4. Insertar después de un valor
    System.out.println("\n---* Insertar después de 2 *---");
    boolean exito = listaD.insertarDespues(2, 10);
    if (exito) {
        System.out.println("Se inserto el 10 después de 2");
        listaD.displayForward(); // 5 <-> 1 <-> 2 <-> 10 <-> 3 <-> null
    } else {
        System.out.println("No se encontró el valor 2.");
    }

    // 5. Revertir la lista
    System.out.println("\n---* Lista revertida *---");
    listaD.revertir();
    listaD.displayForward(); // 3 <-> 6 <-> 2 <-> 1 <-> 5 <-> null ---original
    listaD.displayBackward(); // 5 <-> 1 <-> 2 <-> 10 <-> 3 <-> null --revertida

	}
}
