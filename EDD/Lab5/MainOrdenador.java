public class MainOrdenador{
    public static void main(String[] args) {
        Ordenador O = new Ordenador(10);

        System.out.println("Burbuja");
        O.inicializar();
        O.mostrar();
        O.ordenar_burbuja();
        O.mostrar();

        System.out.println("Seleccion");
        O.inicializar();
        O.mostrar();
        O.ordenar_seleccion();
        O.mostrar();

        System.out.println("Insercion");
        O.inicializar();
        O.mostrar();
        O.ordenar_insercion();
        O.mostrar();

        System.out.println("Mergesort");
        O.inicializar();
        O.mostrar();
        O.mergeSort(O.getA());
        O.mostrar();

        System.out.println(Ordenador.busqueda_binaria(O.getA(), O.getA()[2]));

    }
}