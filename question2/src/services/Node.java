package services;

public class Node{
    public int data;
    public services.Node leftNode;
    public services.Node rightNode;

    public Node(int value){
        data = value;
        leftNode = rightNode = null;
    }
}


