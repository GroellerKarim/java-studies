package eu.groeller.memento_demo.foundation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BaseCaretaker<T> implements Caretaker<T> {
    private final List<Memento<T>> states;
    private final Originator<T> originator;

    public BaseCaretaker() {
        this.states = new ArrayList<>();
        this.originator = new BaseOriginator<>();
    }

    @Override
    public void newState(T state) {
        Objects.requireNonNull(state);
        final var memento = this.originator.saveState(state);
        this.states.add(memento);
    }

    @Override
    public int countOfStates() {
        return this.states.size();
    }

    @Override
    public T getStateAtIndex(int index) {
        if(index < 0 || index >= this.states.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return originator.getState(this.states.get(index));
    }

    @Override
    public Optional<T> getFirstState() {
        final var optionalState = this.states.stream().findFirst();

        if(optionalState.isEmpty()) {
            return Optional.empty();
        }
        final var state = this.originator.getState(optionalState.get());

        return Optional.of(state);
    }

    @Override
    public Optional<T> getLastState() {
        if(this.states.isEmpty()) {
            return Optional.empty();
        }
        final var mementoOfState = this.states.get(this.states.size() - 1);
        final var state = this.originator.getState(mementoOfState);

        return Optional.of(state);
    }
}
