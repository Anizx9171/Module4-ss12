package model.service;

import java.util.List;

public interface IGenericService<T,ID> {
    List<T> findAll(int noPage);
    void cOrU(ID id);
    void delete(ID id);
    T findById(ID id);
}
