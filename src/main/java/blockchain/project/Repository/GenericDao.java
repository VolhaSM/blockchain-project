package blockchain.project.Repository;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <T> {


    void create(T t);
    void update(T t);
    T read(Class clazz, Serializable id);
    void delete(T t);

    public T find(String searchStr);

    List<T> findAll(String searchStr);
}
