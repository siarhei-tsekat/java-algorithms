package graph;

import common.TreeNode;
import java.util.ArrayList;
import java.util.List;

/***
 * In a binary tree, a lonely node is a node that is the only child of its parent node.
 * The root of the tree is not lonely because it does not have a parent node.
 *
 * Given the root of a binary tree, return an array containing the values of all
 * lonely nodes in the tree. Return the list in any order.
 */

public class FindAllTheLonelyNodes {
    List<Integer> res = new ArrayList<>();

    public List<Integer> getLonelyNodes(TreeNode root) {
        func(root);
        return res;
    }

    public void func(TreeNode r) {
        if (r == null) return;

        if (r.left != null && r.right != null) { }
        else if (r.left == null && r.right != null) res.add(r.right.val);
        else if (r.left != null && r.right == null) res.add(r.left.val);

        func(r.left);
        func(r.right);
    }
}
