package repository;

import model.ListaDoble;


public interface PersistenceInterface<T>{
  void save(T t);
  ListaDoble<T> loadAll();
  T loadById(long id);
  void deleteById(long id);
}
