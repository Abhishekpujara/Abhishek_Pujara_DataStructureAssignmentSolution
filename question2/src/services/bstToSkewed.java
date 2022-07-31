package services;


import java.util.ArrayList;

public class bstToSkewed{

    public static ArrayList<Integer> traversal(Node root){
        ArrayList<Integer> left;
        ArrayList<Integer> right;

        if (root == null) {
            return new ArrayList<>();
        }

        left = traversal(root.leftNode);
        left.add(root.data);
        right = traverseRight(root.rightNode);
        left.addAll(right);
        return left;
    }

    public static ArrayList<Integer> traverseRight(Node root){
        ArrayList<Integer> temp;
        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2;
        if (root == null) {
            return new ArrayList<>();
        }
        temp = traverseLeft(root.leftNode);
        temp1.addAll(temp);
        temp1.add(root.data);
        temp2 = traverseRight(root.rightNode);
        temp1.addAll(temp2);
        return temp1;
    }

    public static ArrayList<Integer> traverseLeft(Node root){
        ArrayList<Integer> temp;
        if (root == null) {
            return new ArrayList<>();
        }
        temp = traverseLeft(root.leftNode);
        temp.add(root.data);
        return temp;
    }

}
