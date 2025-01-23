package service;

import repository.factory.RepositoryFactory;
import repository.PersistenceInterface;
import repository.EquipoRepository;
import repository.NotificacionesRepository;
import repository.SolicitudEliminarRepository;
import repository.InventarioGeneralRepository;

import model.dto.SolicitudEliminarEquipoDto;
import model.dto.InventarioGeneralDto;
import model.dto.NotificacionDto;
import model.NodoDoble;
import model.Usuario;

public class SolicitudEliminarService{

  private PersistenceInterface empleadoRepository;

  public SolicitudEliminarService(){
    this.empleadoRepository = RepositoryFactory.createRepository("Empleado");
  }

  public void verSolicitudes(){
    SolicitudEliminarRepository solicitudCargarRepository = new SolicitudEliminarRepository();
    NodoDoble<SolicitudEliminarEquipoDto> cabeza = solicitudCargarRepository.loadAll().getHead(); 
    while(cabeza != null){
      System.out.println(cabeza.getData().toString());
      cabeza = cabeza.getNext();
    }

  }
  
  public void verSolicitudesById(long idUsuario){
    NotificacionesRepository notificacionesRepository = new NotificacionesRepository();
    NodoDoble<NotificacionDto> cabeza = notificacionesRepository.loadByIdUser(idUsuario).getHead();
    while(cabeza != null){
      System.out.println(cabeza.getData().toString());
      cabeza = cabeza.getNext();
    }
  }

  public void aprobarSolicitud(long idUsuario, long idEquipo){
    EquipoRepository equipoRepository = new EquipoRepository(((Usuario)this.empleadoRepository.loadById(idUsuario)).getNombre(), idUsuario); 
    NotificacionesRepository notificacionesRepository = new NotificacionesRepository();
    SolicitudEliminarRepository solicitudEliminarRepository = new SolicitudEliminarRepository();
    InventarioGeneralRepository inventarioGeneralRepository = new InventarioGeneralRepository();
    equipoRepository.deleteById(idEquipo);
    inventarioGeneralRepository.deleteById(idUsuario, idEquipo);
    solicitudEliminarRepository.deleteById(idUsuario, idEquipo);
    notificacionesRepository.save(new NotificacionDto(idUsuario, idEquipo, "Aprobada"));
    inventarioGeneralRepository.ordenar();
  }
  
  public void denegarSolicitud(long idUsuario, long idEquipo){
    SolicitudEliminarRepository solicitudEliminarRepository = new SolicitudEliminarRepository();
    NotificacionesRepository notificacionesRepository = new NotificacionesRepository();
    InventarioGeneralRepository inventarioGeneralRepository = new InventarioGeneralRepository();
    solicitudEliminarRepository.deleteById(idUsuario, idEquipo);
    notificacionesRepository.save(new NotificacionDto(idUsuario, idEquipo, "Denegada"));
    inventarioGeneralRepository.ordenar();
  }

}
