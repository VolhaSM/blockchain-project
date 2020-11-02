package blockchain.project.repository;

import java.util.List;

public interface GenericDao <T> {


    void create(T t);

    public T find(String searchStr);

    List<T> findAll(String searchStr);
}
