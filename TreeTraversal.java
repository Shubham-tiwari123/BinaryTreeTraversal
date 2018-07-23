
package binarytreetraversals;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.Iterator;
class Node{
    int data;
    Node left;
    Node right;
}

public class TreeTraversal {
    Scanner sc = new Scanner(System.in);
    Node root,newnode,temp,temp1;;
    public TreeTraversal() {
        root=null;
    }
    
    public void createBT(int value){
        int num;
        char side;
        int flag1=0,flag2=0;
            
        newnode = new Node();
        newnode.data = value;
        newnode.left=null;
        newnode.right=null;
            
        if(root==null){
            root = newnode;
        }
        else{
            temp = root;
            System.out.print("\nWhere to enter(L/R):-");
            side=sc.next().charAt(0);
            if(side=='L'){
                if(temp.left==null){
                    temp.left = newnode;
                    temp=null;
                }
                else{
                    temp=temp.left;
                }
                while(temp!=null){
                    System.out.print("\nWhere to enter(L/R):-");
                    side=sc.next().charAt(0);
                    if(side=='L'){
                        temp1 = temp;
                        temp=temp.left;
                        flag1=1;
                        flag2=0;
                    }
                    else{
                        temp1=temp;
                        temp=temp.right;
                        flag1=0;
                        flag2=1;
                    }
                }
                if(flag1==1)
                    temp1.left=newnode;
                else if(flag2==1)
                    temp1.right=newnode;
            }
            else{
                if(root.right==null){
                    root.right = newnode;
                    temp = null;
                }
                else{
                    temp=temp.right;
                }
                while(temp!=null){
                    System.out.print("\nWhere to enter(L/R):-");
                    side=sc.next().charAt(0);
                    if(side=='L'){
                        temp1 = temp;
                        temp=temp.left;
                        flag1=1;
                        flag2=0;
                    }
                    else{
                        temp1=temp;
                        temp=temp.right;
                        flag1=0;
                        flag2=1;
                    }
                }
                if(flag1==1)
                    temp1.left=newnode;
                else if(flag2==1)
                    temp1.right=newnode;
            }

        }
    }
    
    void nthNodeInorder(Node node,int position){
        int n=1;
        Stack<Node>s=new Stack<>();
        Queue<Node>q=new LinkedList<>();
        Node curr = node;
        while(curr!=null|| s.size() > 0){
            while(curr!=null){
                s.push(curr);
                curr=curr.left;
            }
            curr =s.pop();
            q.add(curr);
            curr=curr.right;
        }
        Iterator itr=q.iterator();  
        while(position!=n){  
            q.poll();
            n++;
        }
        System.out.println(q.element().data);
    }
    
    Node getRoot(){
        return root;
    }
    
    void nthNodePostOrder(Node node) {
        
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        Queue<Node>q=new LinkedList<>();
        if (node == null)
            return;
        s1.push(node);
        while (!s1.isEmpty()) 
        {
            // Pop an item from s1 and push it to s2
            Node temp = s1.pop();
            s2.push(temp);
            if (temp.left != null)
                s1.push(temp.left);
            if (temp.right != null)
                s1.push(temp.right);
        }
        while (!s2.isEmpty()) 
        {
            Node temp = s2.pop();
            q.add(temp);
        }
        Iterator itr=q.iterator(); 
        while(itr.hasNext()){  
            System.out.print("\n"+q.element().data);
            q.poll();
        }
    }
    
    void printSpiral(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        //queue.add(root);
        s1.push(node);
        System.out.print("\n");
        while(!s1.isEmpty()||!s2.isEmpty()){
            while(!s1.isEmpty()){
                temp = s1.pop();
                if(temp.right!=null)
                    s2.push(temp.right);
                if(temp.left!=null)
                    s2.push(temp.left);
                System.out.print(temp.data+" ");
            }
            while(!s2.isEmpty()){
                temp = s2.pop();
                if(temp.left!=null)
                    s1.push(temp.left);
                if(temp.right!=null)
                    s1.push(temp.right);
                System.out.print(temp.data+" ");
            }
        }   
    }
    
    void specialLevelOrder(Node node){
        if(node == null)
        return;
        if(node.left == null && node.right == null) {
            System.out.print(node.data+" ");
            return;
        }
        Queue<Node> myQueue = new LinkedList<>();
        Stack<Node> myStack = new Stack<>();
        Node temp = null;
        int size;
        int count = 0;
        boolean rightToLeft = false;
        myQueue.add(node);
        while (!myQueue.isEmpty()) {
            count++;
            size = myQueue.size();
            for (int i = 0; i < size; i++) {
                temp = myQueue.poll();
                if (rightToLeft == false) 
                   System.out.print(temp.data+" ");
                else
                    myStack.push(temp);            

                if(temp.left!=null)
                    myQueue.add(temp.left);

                if (temp.right!=null)
                    myQueue.add(temp.right);
            }

            if (rightToLeft == true) {
                while (!myStack.empty()) {
                    temp = myStack.pop();
                    System.out.print(temp.data+" ");
                }
            }
            if (count == 2) {
                rightToLeft = !rightToLeft;
                count = 0;
            }
            System.out.print("\n");
        }
    }
    
    void reverseOrder(Node node){
        Queue<Node> queue = new LinkedList<>();
        Stack<Node> s = new Stack<>();
        queue.add(node);
        s.push(node);
        System.out.print("\n");
        while(!queue.isEmpty()){
            temp = queue.poll();
            
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
            s.push(temp);
        }
        Iterator itr=s.iterator(); 
        while(itr.hasNext()){  
            temp = s.pop();
            System.out.print("\n"+temp.data);
        }
    }
    
    void reverseTreePath(Node node){
        Stack<Node>s=new Stack<>();
        Queue<Node>q=new LinkedList<>();
        Node curr = node;
        while(curr!=null|| s.size() > 0){
            while(curr!=null){
                s.push(curr);
                curr=curr.left;
            }
            curr =s.pop();
            q.add(curr);
            curr=curr.right;
        }
        Iterator itr=q.iterator();  
        while(itr.hasNext()){  
            s.add(q.element());
            q.poll();
        }
        
        itr=s.iterator();  
        while(itr.hasNext()){ 
            temp = s.pop();
            System.out.print("\n"+temp.data);
        }
    }
    
    Node newNode(int key){
        Node newNode = new Node();
        newNode.data = key;
        newNode.left = newNode.right = null;
        return newNode;
    }
    
    void diagonalPrint(Node node){
	Queue<Node> q = new LinkedList<>();
	Node sentinel = newNode(-1);
	while (node!=null){
            q.add(node);
            node = node.right;
	}
	q.add(sentinel);
	while (q.size() != 1){
            Node front = q.poll();
            if (front != sentinel){
                System.out.println("\n"+front.data);
                Node node1 = front.left;
                while (node1!=null){
                    q.add(node1);
                    node1 = node1.right;
                }
            }
            else{
                q.add(sentinel);
                System.out.print("\n");
            }
	}
    }
}
