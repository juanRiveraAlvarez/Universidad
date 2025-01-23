package repository.factory;

import repository.*;

public class RepositoryFactory{

  public static PersistenceInterface createRepository(String type){

      if (type == "Empleado"){
        return new EmpleadoRepository();
      }else if(type == "Login"){
        return new LoginRepository();
      }

      throw new IllegalArgumentException("No se encuentra el repositorio");

  }
}

