import java.util.Scanner;

class Programa1 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int n = 1, aux, acum = 0, promedio, maximo = -9999999, minimo = 9999999;

    try {
      System.out.println("Ingrese cuanto numeros desea digitar -> ");
      n = sc.nextInt();
      for (int i = 0; i < n; i++) {
        aux = sc.nextInt();
        if (aux < minimo) {
          minimo = aux;
        } else if (aux > maximo) {
          maximo = aux;
        }
        acum = acum + aux;
      }

    } catch (Exception e) {
      System.out.println("Error " + e);
    }

    System.out.println("Resultados:");
    System.out.println("Valor maximo: " + maximo);
    System.out.println("Valor minimo: " + minimo);
    System.out.println("Suma de los enteros: " + acum);
    System.out.println("Promedio: " + acum / n);

  }
}
