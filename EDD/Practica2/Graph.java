import java.io.*;
import java.util.*;

class Graph {
    private Map<String, List<Edge>> adjList = new HashMap<>();

    public void addEdge(String city1, String city2, int distance, int time) {
        adjList.putIfAbsent(city1, new ArrayList<>());
        adjList.putIfAbsent(city2, new ArrayList<>());
        adjList.get(city1).add(new Edge(city2, distance, time));
        adjList.get(city2).add(new Edge(city1, distance, time));
    }

    public boolean isDirectlyConnected(String city1, String city2) {
        if (!adjList.containsKey(city1)) return false;
        for (Edge edge : adjList.get(city1)) {
            if (edge.city.equals(city2)) return true;
        }
        return false;
    }

    public int dijkstra(String start, String end, boolean byDistance) {
    Map<String, Integer> distances = new HashMap<>();
    List<String> queue = new ArrayList<>();
    
    for (String city : adjList.keySet()) {
        distances.put(city, Integer.MAX_VALUE);
    }
    distances.put(start, 0);
    queue.add(start);
    
    while (!queue.isEmpty()) {
        String current = queue.get(0);
        int currentIndex = 0;
        
        for (int i = 1; i < queue.size(); i++) {
            if (distances.get(queue.get(i)) < distances.get(current)) {
                current = queue.get(i);
                currentIndex = i;
            }
        }
        queue.remove(currentIndex);
        
        if (current.equals(end)) return distances.get(current);
        
        for (Edge edge : adjList.getOrDefault(current, Collections.emptyList())) {
            int newCost = distances.get(current) + (byDistance ? edge.distance : edge.time);
            if (newCost < distances.get(edge.city)) {
                distances.put(edge.city, newCost);
                if (!queue.contains(edge.city)) {
                    queue.add(edge.city);
                }
            }
        }
    }
    return -1; // No hay camino
}
}

