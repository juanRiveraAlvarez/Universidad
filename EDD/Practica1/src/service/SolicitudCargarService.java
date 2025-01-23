package service;

import repository.factory.RepositoryFactory;
import repository.PersistenceInterface;
import repository.EquipoRepository;
import repository.NotificacionesRepository;
import repository.SolicitudCargarRepository;
import repository.InventarioGeneralRepository;

import model.dto.SolicitudCargarEquipoDto;
import model.dto.InventarioGeneralDto;
import model.dto.NotificacionDto;
import model.NodoDoble;
import model.Usuario;

public class SolicitudCargarService{

  private PersistenceInterface empleadoRepository;

  public SolicitudCargarService(){
    this.empleadoRepository = RepositoryFactory.createRepository("Empleado");
  }

  public void verSolicitudes(){
    SolicitudCargarRepository solicitudCargarRepository = new SolicitudCargarRepository();
    NodoDoble<SolicitudCargarEquipoDto> cabeza = solicitudCargarRepository.loadAll().getHead(); 
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
    SolicitudCargarRepository solicitudCargarRepository = new SolicitudCargarRepository();
    InventarioGeneralRepository inventarioGeneralRepository = new InventarioGeneralRepository();
    equipoRepository.save(((SolicitudCargarEquipoDto)solicitudCargarRepository.loadById(idUsuario,idEquipo)).getEquipo());
    inventarioGeneralRepository.save(new InventarioGeneralDto(((Usuario)this.empleadoRepository.loadById(idUsuario)).getNombre(), idUsuario, equipoRepository.loadById(idEquipo)));
    solicitudCargarRepository.deleteById(idUsuario, idEquipo);
    notificacionesRepository.save(new NotificacionDto(idUsuario, idEquipo, "Aprobada"));
  }
  
  public void denegarSolicitud(long idUsuario, long idEquipo){
    SolicitudCargarRepository solicitudCargarRepository = new SolicitudCargarRepository();
    NotificacionesRepository notificacionesRepository = new NotificacionesRepository();
    solicitudCargarRepository.deleteById(idUsuario, idEquipo);
    notificacionesRepository.save(new NotificacionDto(idUsuario, idEquipo, "Denegada"));
  }

}
