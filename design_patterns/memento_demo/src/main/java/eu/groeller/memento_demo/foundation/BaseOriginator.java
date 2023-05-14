package eu.groeller.memento_demo.foundation;

public class BaseOriginator<T> implements Originator<T> {
    @Override
    public Memento<T> saveState(T state) {
        return new BaseMemento<>(state);
    }

    @Override
    public T getState(Memento<T> savedState) {
        return savedState.get();
    }

    private record BaseMemento<T>(T value) implements Memento<T> {
        @Override
            public T get() {
                return value;
            }
        }
}
