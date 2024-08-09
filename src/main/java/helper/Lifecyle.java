package helper;

public interface Lifecyle<T> {
    boolean init(final T opts);

    void shutdown();
}
