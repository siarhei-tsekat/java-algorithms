package common;

import java.util.*;

public class GraphNode {

    private String name;

    private List<GraphNode> shortestPath = new LinkedList<>();

    private Integer distance = 0;

    Map<GraphNode, Integer> adjacentNodes = new HashMap<>();

    public void updateDistanceAndPath(ArrayList<GraphNode> updatedShortestPath, Integer updatedDistance) {
        if (shortestPath.isEmpty()) {
            shortestPath.addAll(updatedShortestPath);
            distance = updatedDistance;
        } else if (distance > updatedDistance) {
            shortestPath.clear();
            shortestPath.addAll(updatedShortestPath);
            distance = updatedDistance;
        }
    }

    public void addDestination(GraphNode destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public GraphNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GraphNode> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<GraphNode> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<GraphNode, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<GraphNode, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    @Override
    public String toString() {
        return name;
    }
}
