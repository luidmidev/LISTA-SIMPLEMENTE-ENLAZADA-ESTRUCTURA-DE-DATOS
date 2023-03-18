package listas;

/**
 *
 * @author Luid
 * @param <T>
 */
public class Lista<T extends Comparable> {

    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int size;

    /**
     * Constructor: Inicia los punteros inicio y fin en null
     */
    public Lista() {
        inicio = null;
        fin = null;
        size = 0;
    }

    /**
     * Retorna el tamaño de la lista – número de nodos
     * @return 
     */
    public int size() {
        return size;
    }

    /**
     * Agrega un nuevo elemento al final de la lista
     * @param dato
     */
    public void add(T dato) {
        try {
            Nodo<T> n = new Nodo<>(dato);
            if (isEmpty()) {
                inicio = fin = n;
            } else {
                fin.setNext(n);
                fin = fin.getNext();
            }
            size++;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Verifica si la lista está vacía
     * @return 
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Elimina todos los elementos de la lista
     */
    public void clear() {
        inicio = null;
        fin = null;
        size = 0;
    }

    /**
     * Retorna el elemento de la lista según la posición
     * @param pos
     * @return 
     */
    @SuppressWarnings("null")
    public T get(int pos) {
        if (pos >= 0 && pos < size) {
            Nodo<T> pointer = null;
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    pointer = inicio;
                } else {
                    pointer = pointer.getNext();
                }
                if (pos == i) {
                    return pointer.getDato();
                }
            }
        }
        return null;
    }

    /**
     * Elimina elemento de la lista si es igual a un elemento referencia.
     * @param dato
     */
    public void remove(T dato) {
        if (!isEmpty()) {
            if (inicio == fin) {
                inicio = fin = null;
                size--;
            } else if (dato.compareTo(inicio.getDato()) == 0) {
                inicio = inicio.getNext();
                size--;
            } else {
                Nodo<T> a, b;
                a = inicio;
                b = inicio.getNext();
                while (b != null && dato.compareTo(b.getDato()) != 0) {
                    a = a.getNext();
                    b = b.getNext();
                }
                if (b != null) {
                    a.setNext(b.getNext());
                    if (b == fin) {
                        fin = a;
                    }
                    size--;
                }
            }
        } else {
            System.err.println("No se puede eliminar elementos en una lista vacia");
        }
    }

    /**
     * Inserta elemento en posición desplazando al elemento.
     * @param dato
     * @param pos
     */
    public void add(T dato, int pos) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (pos >= 0 && pos < size) {
            if (!isEmpty()) {
                if (inicio == fin && pos == 0) {
                    inicio = nuevo;
                    inicio.setNext(fin);
                    size++;
                } else if (pos == 0) {
                    nuevo.setNext(inicio.getNext());
                    inicio = nuevo;
                    size++;
                } else {
                    |Nodo<T> a, b;
                    a = inicio;
                    b = inicio.getNext();
                    int i = 1;
                    while (b != null && i < pos) {
                        a = a.getNext();
                        b = b.getNext();
                        i++;
                    }
                    if (b != null) {
                        nuevo.setNext(b);
                        a.setNext(nuevo);
                        size++;
                    }
                }
            } else {
                System.err.println("No se puede eliminar elementos en una lista vacia");
 }
 } else {
 System.err.println("Indice fuera de rango");
        }
    }

    /**
     * Verifica si la lista tiene un elemento referenciado
     * @param dato
     * @return 
     */
    public boolean contains(T dato) {
        Nodo<T> pointer = inicio;
        boolean encontrado = false;
        while (pointer != null && encontrado != true) {
            if (dato.compareTo(pointer.getDato()) == 0) {
                encontrado = true;
            } else {
                pointer = pointer.getNext();
            }
        }
        return encontrado;
    }

    /**
     * Devuelve el índice de un elemento
     * @param dato
     * @return 
     */
    public int indexOf(T dato) {
        Nodo<T> pointer = inicio;
        int index = 0;
        boolean encontrado = false;
        while (pointer != null && encontrado != true) {
            if (dato.compareTo(pointer.getDato()) == 0) {
                return index;
            } else {
                pointer = pointer.getNext();
            }
            index++;
        }
        return -1;
    }

    /**
     * Elimina elemento según la posición
     * @param pos
     */
    public void removePos(int pos) {
        if (!isEmpty()) {
            if (inicio == fin && pos == 0) {
                inicio = fin = null;
                size--;
            } else if (pos == 0) {
                inicio = inicio.getNext();
                size--;
            } else {
                Nodo<T> a, b;
                a = inicio;
                b = inicio.getNext();
                int i = 1;
                while (b != null && i < pos) {
                    a = a.getNext();
                    b = b.getNext();
                    i++;
                }
                if (b != null) {
                    a.setNext(b.getNext());
                    fin = a;
                    size--;
                }
            }
        }
    }

    /**
     * Imprime los nodos que conforman la lista
     */
    public void printedLinked() {
        Nodo<T> recorrer = inicio;
        while (recorrer != null) {
            System.out.print("[" + recorrer.getDato() + "]--->");
            recorrer = recorrer.getNext();
        }
        System.out.println("");
    }
}
