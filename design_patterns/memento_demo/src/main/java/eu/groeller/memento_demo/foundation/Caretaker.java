package eu.groeller.memento_demo.foundation;

import java.util.Optional;

public interface Caretaker<T> {
    void newState(T state);
    int countOfStates();
    T getStateAtIndex(int index);
    Optional<T> getFirstState();
    Optional<T> getLastState();

}
