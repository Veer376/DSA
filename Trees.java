public class Trees {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
                 }
    }
    static class BuildTree{
       static int index=-1;
       static Node buildTree(int[] nodes){
           index++;
           if(nodes[index]==-1) return null;
           Node node= new Node(nodes[index]);
           node.left=buildTree(nodes);
           node.right=buildTree(nodes);
           return node;
       }
    }

    static int countNodes(Node head){
        if(head==null) return 0;
        int countleft=countNodes(head.left);
        int countright=countNodes(head.right);
        return countleft+countright+1;
    }
    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node head=BuildTree.buildTree(nodes);
        System.out.println(countNodes(head));

    }
}
