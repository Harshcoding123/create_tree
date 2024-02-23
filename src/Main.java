import java.util.*;
public class Main {
    public static class node{
        int val;
        node left;
        node right;

        node(int val){
            this.val =val;
        }

    }
    public static void createtree(node root){
        node a= new node(2);
        node b =new node(3);
        node c= new node(4);
        node d= new node(5);
        node e= new node(6);
        node f= new node(7);
//        node g= new node(7);
        root.left= a;
        root.right= b;
        a.left= c;
        a.right =d;
        b.right= f;
        b.left= e;

    }
    public static void display(node root){
        if(root==null) return;
        System.out.print(root.val+" ");
        display(root.left);
        display(root.right);
    }
    public static int size(node root){
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return 1;
      return  size(root.left)+size(root.right)+1;
    }
    public static int sum_of_tree_node(node root){
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return root.val;
       return sum_of_tree_node(root.left)+sum_of_tree_node(root.right)+root.val;
    }
    public static int max_value(node root){
        if(root==null) return Integer.MIN_VALUE;
        if(root.left==null&&root.right==null) return root.val;

        int p= Math.max(max_value(root.left),max_value(root.right));
        return Math.max(p,root.val);

    }
    public static int height(node root){
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return 0;

        int p= Math.max(height(root.left),height(root.right));
        return p+1;
    }
    public static void preorder(node root){
        if(root==null) return;
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(node root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);

    }
    public static void level_order_traversal1(node root,int n){
        if(root==null) return;

        if(n==1){
            System.out.print(root.val+" ");
            return;
        }
        level_order_traversal1(root.left,n-1);
        level_order_traversal1(root.right,n-1);
    }
    public static void level_order_traversal2(node root){
        Queue<node>q= new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            node temp =q.remove();
            System.out.print(temp.val+" ");
          if(temp.left!=null)  q.add(temp.left);
          if(temp.right!=null)  q.add(temp.right);

        }



    }
    public static void postorder(node root){
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val+" ");
    }
    public static void dfs_Inorder(node root){
        Stack<node>st= new Stack<>();
        st.push(root);
        while(st.size()>0){
            node temp=st.peek();
            if(temp.left!=null){
                
                st.push(temp.left);
                temp.left=null;
            }else{
                System.out.print(temp.val+" ");
                st.pop();
                if(temp.right!=null) st.push(temp.right);
            }
        }




    }
    public static void main(String[] args) {
        node root = new node(1);
        createtree(root);
//        display(root);
//        System.out.println();
//        System.out.println(size(root));
//        System.out.println(sum_of_tree_node(root));
//        System.out.println(max_value(root));
//        System.out.println(height(root));
//        preorder(root);
//        System.out.println();
//        inorder(root);
//        System.out.println();
//        postorder(root);
//        level_order_traversal1(root,1);
//        int level= height(root)+1;
//        for(int i=1;i<=level;i++){
//            level_order_traversal1(root,i);
//            System.out.println();
//        }
//        level_order_traversal2(root);
        dfs_Inorder(root);


    }
}