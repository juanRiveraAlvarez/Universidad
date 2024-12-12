public class Ordenador {
  private int[] A;
  private int limit;

  public Ordenador(int capacity) {
    this.A = new int[capacity];
  }

  public int[] getA() {
    return A;
  }

  public void inicializar() {
    for (int i = 0; i < A.length; i++) {
      A[i] = (int) (Math.random() * 100) + 1;
    }
  }

  public void ordenar_burbuja() {
    for (int i = 0; i < A.length; i++) {
      for (int j = 1; j <= A.length - 1; j++) {
        if (this.A[j - 1] > this.A[j]) {
          int aux = this.A[j];
          this.A[j] = this.A[j - 1];
          this.A[j - 1] = aux;
        }
      }
    }
  }

  public void ordenar_seleccion() {
    int min = 101;
    int pos = 0;
    for (int i = 0; i < A.length; i++) {
      for (int j = i; j < A.length; j++) {
        if (A[j] < min) {
          min = A[j];
          pos = j;
        }
      }
      int aux = A[i];
      A[i] = min;
      A[pos] = aux;
      min = 101;
    }
  }

  public void ordenar_insercion() {
    for (int i = 1; i < A.length; i++) {
      int temp = A[i];
      int j = i;
      while (j > 0 && A[j - 1] > temp) {
        A[j] = A[j - 1];
        j = j - 1;
      }
      A[j] = temp;
    }
  }

  public static void mergeSort(int[] array) {
    if (array.length < 2) {
      return;
    }

    int mid = array.length / 2;
    int[] left = new int[mid];
    int[] right = new int[array.length - mid];

    System.arraycopy(array, 0, left, 0, mid);
    System.arraycopy(array, mid, right, 0, array.length - mid);

    mergeSort(left);
    mergeSort(right);

    merge(array, left, right);
  }

  private static void merge(int[] array, int[] left, int[] right) {
    int i = 0, j = 0, k = 0;

    while (i < left.length && j < right.length) {
      if (left[i] <= right[j]) {
        array[k++] = left[i++];
      } else {
        array[k++] = right[j++];
      }
    }

    while (i < left.length) {
      array[k++] = left[i++];
    }

    while (j < right.length) {
      array[k++] = right[j++];
    }
  }

  public void mostrar() {
    for (int i : this.A) {
      System.out.println(i);
    }
  }

  public static int busqueda_binaria(int[] arreglo, int objetivo) {
    int inicio = 0;
    int fin = arreglo.length - 1;

    while (inicio <= fin) {
      int medio = inicio + (fin - inicio) / 2;

      if (arreglo[medio] == objetivo) {
        return medio;
      }

      if (arreglo[medio] < objetivo) {
        inicio = medio + 1;
      } else {
        fin = medio - 1;
      }
    }
    return -1;
  }
}
