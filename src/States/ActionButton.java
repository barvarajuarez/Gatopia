package src.States;

public interface ActionButton {
    //Se pide una interfaz a los botones permitiendo que cambie la accion si se presiona
    /*Un ADT define un conjunto de operaciones que se pueden realizar en los datos, 
    pero no especifica cómo se implementan esas operaciones. 
    En otras palabras, proporciona una interfaz abstracta sin revelar detalles internos. */
    public abstract void doAction();
}
