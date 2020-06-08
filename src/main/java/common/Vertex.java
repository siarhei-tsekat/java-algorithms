package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Vertex {
    private Integer distance = 0;
    public String label;
    private ArrayList<Vertex> shortestPath = new ArrayList<>();
    private Map<Vertex, Integer> map = new HashMap<>();

    public Vertex(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return label.equals(vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    public void addShortestPath(ArrayList<Vertex> path) {
        if (shortestPath.isEmpty()) {
            shortestPath.addAll(path);
        } else {
            if (shortestPath.size() > path.size()) {
                shortestPath.clear();
                shortestPath.addAll(path);
            }
        }
    }

    @Override
    public String toString() {
        return label;
    }

    public ArrayList<Vertex> getShortestPath() {
        return shortestPath;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Integer getDistanceToMe() {
        return distance;
    }

    public void updateDistanceAndPath(ArrayList<Vertex> path, Integer updatedDistance) {
        if (shortestPath.isEmpty()) {
            shortestPath.addAll(path);
            distance = updatedDistance;
        } else {
            if (distance > updatedDistance) {
                shortestPath.clear();
                shortestPath.addAll(path);
                distance = updatedDistance;
            }
        }
    }

    public void addVertex(Vertex v2, int distance) {
        map.put(v2, distance);
    }

    public Integer getDistanceTo(Vertex adjVertex) {
        return map.get(adjVertex);
    }
}
