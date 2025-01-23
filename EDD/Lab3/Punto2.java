public class Punto2{
  public static void main(String[] args){
    Agenda agenda = new Agenda(5); 
    agenda.importUsers();
    for(Usuario i: agenda.getRegistro()){
      System.out.println(i.toString());
    }
    System.out.println("Eliminando usuario de id 3");
    agenda.eliminar(3);
    agenda.toFile("Agenda2.txt");
  }
}
