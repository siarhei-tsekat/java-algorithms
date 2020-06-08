package common;

import java.util.ArrayList;
import java.util.List;

public class SerialGraph {
    List<SerialNode> nodes = new ArrayList<SerialNode>();

    public void addNode(List<SerialNode> node) {
        nodes = node;
    }

    public SerialNode getNode(SerialNode start) {
        return nodes.stream().
                filter(n -> n.label.equals(start.label)).
                findFirst().
                orElse(null);
    }
}
