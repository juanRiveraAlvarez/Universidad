public class MainOrdenadoAgenda {
    public static void main(String[] args) {
        OrdenadoAgenda O = new OrdenadoAgenda();
        Usuario u1 = new Usuario("Juan",12);
        Usuario u2 = new Usuario("Amelia",41);
        Usuario u3 = new Usuario("Jose",23);
        Usuario u4 = new Usuario("Mari",2);
        Usuario u5 = new Usuario("Alejo",100);
        Usuario u6 = new Usuario("Pipe",34);
        O.agregarUsuario(u1);
        O.agregarUsuario(u2);
        O.agregarUsuario(u3);
        O.agregarUsuario(u4);
        O.agregarUsuario(u5);
        O.agregarUsuario(u6);
        O.mostrar();
        O.ordenar();
        O.mostrar();
    }
}
