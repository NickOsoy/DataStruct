package umg.edu.progra.listas.doblementeEnlazada;

public class DoblementeEnlazada {

	private Nodo head;
	private Nodo tail;

	public DoblementeEnlazada() {
		this.head = null;
		this.tail = null;
	}

	public void insertAtEnd(int data) {
		Nodo newNode = new Nodo(data);
		if (tail == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}

	public void insertAtBeginning(int data) {
		Nodo newNode = new Nodo(data);
		if (head == null) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}

	public boolean delete(int data) {
		Nodo current = head;
		while (current != null) {
			if (current.data == data) {
				if (current == head) {
					head = current.next;
					if (head != null)
						head.prev = null;
				} else if (current == tail) {
					tail = current.prev;
					if (tail != null)
						tail.next = null;
				} else {
					current.prev.next = current.next;
					current.next.prev = current.prev;
				}
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public boolean search(int data) {
		Nodo current = head;
		while (current != null) {
			if (current.data == data) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public void displayForward() {
		Nodo current = head;
		while (current != null) {
			System.out.print(current.data + " <-> ");
			current = current.next;
		}
		System.out.println("null");
	}

	public void displayBackward() {
		Nodo current = tail;
		while (current != null) {
			System.out.print(current.data + " <-> ");
			current = current.prev;
		}
		System.out.println("null");
	}
	
	// Método 1: Contar el número de nodos en la lista
	
	
	public int contarNodos() {
	    int contador = 0;
	    Nodo actual = head; // Empezamos desde la cabeza
	    while (actual != null) {
	        contador++;
	        actual = actual.next; // Avanzamos al siguiente nodo
	    }
	    return contador;
	}
	
	// Método 2: Insertar un nodo después de un valor específico
	
	public boolean insertarDespues(int valorExistente, int nuevoValor) {
	    Nodo actual = head;
	    while (actual != null) {
	        if (actual.data == valorExistente) {
	            Nodo nuevoNodo = new Nodo(nuevoValor);
	            
	            // Configurar enlaces del nuevo nodo
	            nuevoNodo.next = actual.next;
	            nuevoNodo.prev = actual;
	            
	            // Actualizar el nodo siguiente (si existe)
	            if (actual.next != null) {
	                actual.next.prev = nuevoNodo;
	            } else {
	                tail = nuevoNodo; // Si actual era el último nodo
	            }
	            
	            actual.next = nuevoNodo;
	            return true;
	        }
	        actual = actual.next;
	    }
	    return false; // No se encontró el valorExistente
	}
	
	
	// Método 3: Revertir la lista doblemente enlazada

	public void revertir() {
	    Nodo temporal = null;
	    Nodo actual = head;
	    
	    // Intercambiar prev y next de todos los nodos
	    while (actual != null) {
	        temporal = actual.prev;
	        actual.prev = actual.next;
	        actual.next = temporal;
	        actual = actual.prev; // Avanzar al "siguiente" nodo (que ahora es prev)
	    }
	    
	    // Actualizar cabeza y cola
	    if (temporal != null) {
	        tail = head;
	        head = temporal.prev;
	    }
	}
	
}

