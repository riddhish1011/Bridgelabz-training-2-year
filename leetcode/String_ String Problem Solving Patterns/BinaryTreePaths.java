// LeetCode 257: Binary Tree Paths
// https://leetcode.com/problems/binary-tree-paths/
// Difficulty: Easy

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        dfs(root, new StringBuilder(), paths);
        return paths;
    }

    private void dfs(TreeNode node, StringBuilder path, List<String> paths) {
        int len = path.length();

        if (len > 0) path.append("->");
        path.append(node.val);

        if (node.left == null && node.right == null) {
            paths.add(path.toString());
        } else {
            if (node.left != null) dfs(node.left, path, paths);
            if (node.right != null) dfs(node.right, path, paths);
        }

        path.setLength(len); // backtrack
    }

    public static void main(String[] args) {
        BinaryTreePaths sol = new BinaryTreePaths();

        // Tree:      1
        //           / \
        //          2   3
        //           \
        //            5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        System.out.println(sol.binaryTreePaths(root)); // ["1->2->5", "1->3"]
    }
}
