package listas;

public class Nodo<T> {
    
    private T dato;
    private Nodo next = null;

    public Nodo(){
    }
    
    public Nodo(T dato) {
        this.dato = dato;
        next = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + ", next=" + next + '}';
    }

}
