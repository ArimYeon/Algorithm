import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1991 {
    static class Node{
        char data;
        int parent, right, left;
        Node(char data){
            this.data = data;
            this.parent = this.right = this.left = -1;
        }
    }

    static Node A[] = new Node[26];

    // 전위 순회
    static void preOrder(int node){
        System.out.print(A[node].data);
        if (A[node].left != -1) preOrder(A[node].left);
        if (A[node].right != -1) preOrder(A[node].right);
    }
    // 중위 순회
    static void inOrder(int node){
        if (A[node].left != -1) inOrder(A[node].left);
        System.out.print(A[node].data);
        if (A[node].right != -1) inOrder(A[node].right);
    }
    // 후위 순회
    static void postOrder(int node){
        if (A[node].left != -1) postOrder(A[node].left);
        if (A[node].right != -1) postOrder(A[node].right);
        System.out.print(A[node].data);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i<n; i++){
            A[i] = new Node((char)('A'+i));
        }
        for (int i = 0; i<n; i++){
            String input = br.readLine().replaceAll(" ","");
            char data = input.charAt(0);
            char left = input.charAt(1);
            char right = input.charAt(2);
            if (left != '.'){
                A[data - 'A'].left = left - 'A';
                A[left - 'A'].parent = data - 'A';
            }
            if (right != '.'){
                A[data - 'A'].right = right - 'A';
                A[right - 'A'].parent = data - 'A';
            }
        }
        preOrder(0);
        System.out.print("\n");
        inOrder(0);
        System.out.print("\n");
        postOrder(0);
    }
}

//public class Main {
//    static class Node{
//        char data;
//        Node r, l;
//        Node(char data){
//            this.data = data;
//        }
//    }
//
//    static class Tree{
//        Node root;
//        public Tree(char data, char left, char right){
//            root = new Node(data);
//            if (right != '.')
//                root.r = new Node(right);
//            if (left != '.')
//                root.l = new Node(left);
//        }
//        public void add(char data, char left, char right){
//            find(root.l, data, left, right);
//            find(root.r, data, left, right);
//        }
//        public void find(Node node, char data, char left, char right){
//            if (node == null)   return;
//            if (node.data == data){
//                if (right != '.')
//                    node.r = new Node(right);
//                if (left != '.')
//                    node.l = new Node(left);
//            }else{
//                find(node.l, data, left, right);
//                find(node.r, data, left, right);
//            }
//        }
//        // 전위 순회
//        public void preOrder(Node node){
//            System.out.print(node.data);
//            if (node.l != null) preOrder(node.l);
//            if (node.r != null) preOrder(node.r);
//        }
//        // 중위 순회
//        public void inOrder(Node node){
//            if (node.l != null) inOrder(node.l);
//            System.out.print(node.data);
//            if (node.r != null) inOrder(node.r);
//        }
//        // 후위 순회
//        public void postOrder(Node node){
//            if (node.l != null) postOrder(node.l);
//            if (node.r != null) postOrder(node.r);
//            System.out.print(node.data);
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        char[] input1 = br.readLine().replaceAll(" ", "").toCharArray();
//        Tree tree = new Tree(input1[0], input1[1], input1[2]);
//        for (int i = 1; i < n; i++){
//            char[] input = br.readLine().replaceAll(" ", "").toCharArray();
//            tree.add(input[0], input[1], input[2]);
//        }
//        tree.preOrder(tree.root);
//        System.out.print("\n");
//        tree.inOrder(tree.root);
//        System.out.print("\n");
//        tree.postOrder(tree.root);
//    }
//}