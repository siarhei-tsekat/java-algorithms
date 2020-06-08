package common;

import java.util.ArrayList;
import java.util.List;

public class SerialNode {
    public String label;
    public int distance = 0;
    public SerialNode parent;
    public List<SerialNode> childs = new ArrayList<>();

    public SerialNode(String label) {
        this.label = label;
    }

    public void addChild(SerialNode child) {
        this.childs.add(child);
    }
}
