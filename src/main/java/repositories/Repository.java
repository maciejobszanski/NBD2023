package repositories;

import java.util.List;

public interface Repository<T> {
    T get(long id);
    List<T> getList();
    boolean remove(T obj);
    T add (T obj);

}
