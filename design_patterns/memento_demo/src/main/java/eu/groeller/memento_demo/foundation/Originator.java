package eu.groeller.memento_demo.foundation;

public interface Originator<T> {
    Memento<T> saveState(T state);
    T getState(Memento<T> savedState);
}
