package com.interviewdose;

/*
     0
    / \
   1   2
  /   / \
 5   3  4

 */


import java.util.ArrayList;
import java.util.List;

public class SerializeNAryTree {

    static class TreeNode {
        int val ;
        List<TreeNode> children = new ArrayList<>();
        TreeNode(int num) {
            this.val = num ;
        }

        TreeNode () {}
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "" ;
        }

        String result = "" + root.val ;
        result += "," + root.children.size() ;
        for(int i = 0 ; i < root.children.size() ; i++) {
            result += "," + serialize(root.children.get(i));
        }

        return result ;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) {
            return null ;
        }

        int [] i = new int[1] ;
        return helper(data.split(","), i) ;
    }

    TreeNode helper(String[] nums, int[] i) {
        if(nums.length == i[0]) {
            return null ;
        }

        String number = nums[i[0]++] ;
        TreeNode root = new TreeNode(Integer.valueOf(number)) ;

        int noOfChildren = Integer.valueOf(nums[i[0]++]) ;
        for(int c = 0 ; c < noOfChildren ; c++) {
            TreeNode child = helper(nums, i) ;
            if(child != null) {
                root.children.add(child) ;
            }
        }

        return root ;
    }

    public static void main(String[] args) {
        SerializeNAryTree codec = new SerializeNAryTree() ;

        TreeNode root = new TreeNode(0) ;
        root.children.add(new TreeNode(1)) ;
        root.children.get(0).children.add(new TreeNode(5)) ;
        root.children.add(new TreeNode(2)) ;
        root.children.get(1).children.add(new TreeNode(3)) ;
        root.children.get(1).children.add(new TreeNode(4)) ;

        String serialized = codec.serialize(root) ;
        System.out.println(serialized);

        TreeNode deserializedTree = codec.deserialize(serialized);

        serialized = codec.serialize(deserializedTree) ;
        System.out.println(serialized);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

