import java.io.*;
import java.util.*;

public class RoadNetwork {
    public static void main(String[] args) {
        Graph graph = new Graph();
        String filePath = "Datos vias.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
              System.out.println(line);
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    graph.addEdge(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la ciudad A:");
        String cityA = scanner.nextLine();
        System.out.println("Ingrese la ciudad B:");
        String cityB = scanner.nextLine();

        System.out.println("¿Están conectadas directamente?: " + graph.isDirectlyConnected(cityA, cityB));
        System.out.println("Camino más corto por distancia: " + graph.dijkstra(cityA, cityB, true));
        System.out.println("Camino más corto por tiempo: " + graph.dijkstra(cityA, cityB, false));
    }
}
