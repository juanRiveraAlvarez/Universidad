import service.*;
import repository.*;
import repository.EmpleadoRepository;
import model.dto.*;
import model.*;

import java.util.Scanner;
import java.time.LocalDate;

public class App{

  
    public void menuPrincipal(){

    }
    public static void main(String[] args){

      Scanner sc = new Scanner(System.in);
      
      EmpleadoRepository er = new EmpleadoRepository();
      SolicitudCargarRepository scr = new SolicitudCargarRepository();
      SolicitudEliminarRepository ser = new SolicitudEliminarRepository();
      UsuarioService usuarioService = new UsuarioService();
      SolicitudCargarService solicitudCargarService = new SolicitudCargarService();
      SolicitudEliminarService solicitudEliminarService = new SolicitudEliminarService();

      LoginService ls = new LoginService();
      RegisterService registerService = new RegisterService();

      System.out.println("Bienvenido al inicio de sesion");
      //try{

        System.out.print("Por favor ingrese su id -> ");
        int id = sc.nextInt();
        System.out.print("Por favor ingrese su password -> ");
        String password = sc.next();
        while(ls.login((long)id, password).equals("")){
          System.out.println("CREDENCIALES INCORRECTAS, INTENTE NUEVA MENTE");
          System.out.print("Por favor ingrese su id -> ");
          id = sc.nextInt();
          System.out.print("Por favor ingrese su password -> ");
          password = sc.next();

        }

        if(ls.login((long)id, password).equals("investigador")){
          Usuario empleado = er.loadById((long) id);
          EquipoRepository qr = new EquipoRepository(empleado.getNombre(), (long) id);
          System.out.println("--------Equipo en disposicion------------");
          NodoDoble<Equipo> cabeza = qr.loadAll().getHead();
          while(cabeza != null){
            Equipo e = (Equipo) cabeza.getData();
            System.out.println(e.getNombre()+" "+e.getId());
            cabeza = cabeza.getNext();
          }
          System.out.println("Si desea solicitar nuevo equipo marque (1)");
          System.out.println("Si desea solicitar la eliminacion de equipo marque (2)");
          System.out.println("Si desea ver sus notificaciones marque (3)");
          int opcion = sc.nextInt();
          while(opcion != 1 && opcion != 2 && opcion != 3){
            System.out.println("Marque una opcion valida");
            System.out.println("Si desea solicitar nuevo equipo marque (1)");
            System.out.println("Si desea solicitar la eliminacion de equipo marque (2)");
            System.out.println("Si desea ver sus notificaciones marque (3)");
            opcion = sc.nextInt();
          }

          if(opcion == 1){
            System.out.println("Ingrese los datos del nuevo equipo");
            System.out.print("Nombre del equipo -> ");
            String nombreEquipo = sc.next();
            System.out.print("Codigo del equipo -> ");
            id = sc.nextInt();
            System.out.print("Valor del equipo -> ");
            int valor = sc.nextInt();
            scr.save(new SolicitudCargarEquipoDto(empleado.getNombre(), empleado.getId(), new Equipo(nombreEquipo, id, new Fecha((short)LocalDate.now().getDayOfMonth(),(short)LocalDate.now().getMonthValue(),(short) LocalDate.now().getYear()), valor))); 
            System.out.println("Solicitud Radicada");
          }else if(opcion == 2){
            sc.nextLine();
            System.out.print("Ingrese una descripcion de por que desea eliminar -> ");
            String descripcionEliminar = sc.nextLine();
            System.out.print("Ingrese el codigo del equipo que desea eliminar -> ");
            int codigoEliminar = sc.nextInt();
            ser.save(new SolicitudEliminarEquipoDto(empleado.getNombre(),empleado.getId(), codigoEliminar, descripcionEliminar)); 
            System.out.println("Solicitud Radicada");
          }else if(opcion == 3){
            solicitudCargarService.verSolicitudesById(id);
          }


        }else{
          System.out.println("administrador");
          Usuario empleado = er.loadById((long) id);
          EquipoRepository qr = new EquipoRepository(empleado.getNombre(), (long) id);
          System.out.println("--------Equipo en disposicion------------");
          NodoDoble<Equipo> cabeza = qr.loadAll().getHead();
          while(cabeza != null){
            Equipo e = (Equipo) cabeza.getData();
            System.out.println(e.getNombre()+" "+e.getId());
            cabeza = cabeza.getNext();
          }
          System.out.println("Si desea solicitar nuevo equipo marque (1)");
          System.out.println("Si desea solicitar la eliminacion de equipo marque (2)");
          System.out.println("Si desea registrar nuevo usuario marque (3)");
          System.out.println("Si desea cambiar password marque (4)");
          System.out.println("Si desea eliminar usuario (5)");
          System.out.println("Si desea gestionar solicitudes pendientes (6)");

          int opcion = sc.nextInt();
          while(opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4 && opcion != 5 && opcion != 6){
            System.out.println("Marque una opcion valida");
            System.out.println("Si desea solicitar nuevo equipo marque (1)");
            System.out.println("Si desea solicitar la eliminacion de equipo marque (2)");
            System.out.println("Si desea registrar nuevo usuario marque (3)");
            System.out.println("Si desea cambiar password marque (4)");
            System.out.println("Si desea eliminar usuario (5)");
            System.out.println("Si desea gestionar solicitudes pendientes (6)");
            opcion = sc.nextInt();
          }

          if(opcion == 1){
            System.out.println("Ingrese los datos del nuevo equipo");
            System.out.print("Nombre del equipo -> ");
            String nombreEquipo = sc.next();
            System.out.print("Codigo del equipo -> ");
            id = sc.nextInt();
            System.out.print("Valor del equipo -> ");
            int valor = sc.nextInt();
            scr.save(new SolicitudCargarEquipoDto(empleado.getNombre(), empleado.getId(), new Equipo(nombreEquipo, id, new Fecha((short)LocalDate.now().getDayOfMonth(),(short)LocalDate.now().getMonthValue(),(short) LocalDate.now().getYear()), valor))); 
            System.out.println("Solicitud Radicada");
          }else if(opcion == 2){
            sc.nextLine();
            System.out.print("Ingrese una descripcion de por que desea eliminar -> ");
            String descripcionEliminar = sc.nextLine();
            System.out.print("Ingrese el codigo del equipo que desea eliminar -> ");
            int codigoEliminar = sc.nextInt();
            ser.save(new SolicitudEliminarEquipoDto(empleado.getNombre(),empleado.getId(), codigoEliminar, descripcionEliminar)); 
            System.out.println("Solicitud Radicada");
          }else  if(opcion == 3){
            sc.nextLine();
            System.out.print("Ingrese el nombre -> ");
            String nombre = sc.nextLine();
            System.out.print("Ingrese el id -> ");
            id = sc.nextInt();
            System.out.print("Ingrese el dia de nacimeinto -> ");
            short dia = sc.nextShort();
            System.out.print("Ingrese el mes de nacimeinto -> ");
            short mes = sc.nextShort();
            System.out.print("Ingrese el ano de nacimeinto -> ");
            short ano = sc.nextShort();
            System.out.print("Insete ciudad de nacimeinto -> ");
            sc.nextLine();
            String ciudad = sc.nextLine();
            System.out.print("Ingrese el telefono -> ");
            long telefono = sc.nextLong();
            System.out.print("Insete el correo -> ");
            sc.nextLine();
            String correo = sc.nextLine();
            System.out.print("Insete el password -> ");
            password = sc.nextLine();
            System.out.print("Insete el rol -> ");
            String rol = sc.nextLine();

            registerService.registrarUsuario(
                nombre,
                (long)id,
                new Fecha(dia,mes,ano),
                "Medellin",
                (long)123,
                correo,
                new Direccion("null","null","null","null","null","null"),
                password,
                rol
              );

          }else if(opcion == 4){
            System.out.print("Inserte el id del usuario -> ");
            id = sc.nextInt();
            System.out.print("Inserte nueva password -> ");
            sc.nextLine();
            password = sc.nextLine();
            ls.changePassword((long)id,password);
          }else if(opcion == 5){
            System.out.print("Inserte el id del usuario a eliminar -> ");
            id = sc.nextInt();
            usuarioService.eliminarUsuario((long)id);
          }else if(opcion == 6){
            System.out.print("Si desea ver las solicitudes para agregar marque 1, si desea ver las solicitudes para eliminar marque 2 -> ");
            int opcion3 = sc.nextInt();
            if(opcion3 == 1){

              solicitudCargarService.verSolicitudes();
              System.out.print("Inserte el id del usuario -> ");
              int idUsuario = sc.nextInt();
              System.out.print("Inserte el id del equipo -> ");
              int idEquipo = sc.nextInt();
              System.out.print("Para aprobar marque 1, y para rechazar 2 -> ");
              int opcion2 = sc.nextInt();
              if(opcion2 == 1){
                solicitudCargarService.aprobarSolicitud(idUsuario, idEquipo);
              }else if(opcion2 == 2){
                solicitudCargarService.denegarSolicitud(idUsuario,idEquipo);
              }
            }else if(opcion3 == 2){
              
              solicitudEliminarService.verSolicitudes();
              System.out.print("Inserte el id del usuario -> ");
              int idUsuario = sc.nextInt();
              System.out.print("Inserte el id del equipo -> ");
              int idEquipo = sc.nextInt();
              System.out.print("Para aprobar marque 1, y para rechazar 2 -> ");
              int opcion2 = sc.nextInt();
              if(opcion2 == 1){
                solicitudEliminarService.aprobarSolicitud(idUsuario, idEquipo);
              }else if(opcion2 == 2){
                solicitudEliminarService.denegarSolicitud(idUsuario,idEquipo);
              }
            }
          }

        }
        
      /*}catch(Exception e){
        
        System.out.println(e);
        System.out.println("ERROR: INGRESE MAS TARDE");
         

      }*/
      
     /*
      NodoDoble<Usuario> first  = ur.loadAll().getHead();
      LoginService ls = new LoginService();
      EquipoRepository er = new EquipoRepository("Camila-Jimenez",(long)2345902);
      */
      /*
            ls.changePassword(2,"si","administrador");
          }

        }
        
      }catch(Exception e){
        
        System.out.println(e);
        System.out.println("ERROR: INGRESE MAS TARDE");
         

      }
      
     /*
      NodoDoble<Usuario> first  = ur.loadAll().getHead();
      LoginService ls = new LoginService();
      EquipoRepository er = new EquipoRepository("Camila-Jimenez",(long)2345902);
      */
      /*
      System.out.println(first.getData());
      while(first.getNext() != null){
       first = first.getNext();
       System.out.println(first.getData());
      }
      ur.deleteById(1075689);
      first  = ur.loadAll().getHead();
      System.out.println(first.getData());
      while(first.getNext() != null){
       first = first.getNext();
       System.out.println(first.getData());
      }
      */
     // ur.save(new Usuario("JUAN",123, new Fecha((short)1,(short)1,(short)1),"Medellin",123,"si@gmail.com", new Direccion(" "," "," "," "," "," ")," "));
     // ur.save(new Usuario("Pablo",456, new Fecha((short)2,(short)2,(short)2),"Medellin",123,"si2@gmail.com", new Direccion(" "," "," "," "," "," ")," "));
     /*
      first  = ur.loadAll().getHead();
      System.out.println(first.getData());
      while(first.getNext() != null){
       first = first.getNext();
       System.out.println(first.getData());
      }
      */
     // System.out.println(ls.login((long)2345934,"r482novMed."));
     //System.out.println(er.loadAll().getHead().getData());
    }
}
