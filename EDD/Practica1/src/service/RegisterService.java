package service;

import repository.factory.RepositoryFactory;
import repository.PersistenceInterface;
import model.Usuario;
import model.Direccion;
import model.Fecha;
import model.dto.LoginDto;

public class RegisterService {

  private PersistenceInterface loginRepository;
  private PersistenceInterface empleadoRepository;

  public RegisterService() {
    this.loginRepository = RepositoryFactory.createRepository("Login");
    this.empleadoRepository = RepositoryFactory.createRepository("Empleado");
  }

  public void registrarUsuario(String nombre, long id, Fecha fecha_nacimiento, String ciudad_nacimiento, long tel,
      String email, Direccion dir, String password, String rol) {
    this.empleadoRepository.save(new Usuario(nombre, id, fecha_nacimiento, ciudad_nacimiento, tel, email, dir));
    this.loginRepository.save(new LoginDto(id, password, rol));
  }

}
