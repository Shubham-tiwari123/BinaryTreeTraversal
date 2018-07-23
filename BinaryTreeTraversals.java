
package binarytreetraversals;

import java.util.Scanner;

public class BinaryTreeTraversals {

    public void start(){
        Scanner sc=new Scanner(System.in);
        int choice,value;
        TreeTraversal t = new TreeTraversal();
        do{
            System.out.print("\n1)Create\n2)Nth node using inorder\n"
                    + "3)Nth node using inorder\n4)Spiral level order\n"
                    + "5)Level order traversal with direction change after every two levels"
                    + "\n6)Reverse Level order\n7)Reverse Tree path\n8)Exit");
            System.out.print("\nEnter your choice:-");
            choice=sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("\nNumber of nodes:-");
                    int num=sc.nextInt();
                    for(int i=0;i<num;i++){
                        System.out.print("\nValue:-");
                        value = sc.nextInt();
                        t.createBT(value);
                    }
                    break;
                case 2:Node node= t.getRoot();
                       System.out.print("\nNode position:-");
                       int position = sc.nextInt();
                       t.nthNodeInorder(node,position);
                       break;
                case 3:node =t.getRoot();
                       t.nthNodePostOrder(node);
                       break;
                case 4:node =t.getRoot();
                       t.printSpiral(node);
                       break;
                case 5:node = t.getRoot();
                       t.specialLevelOrder(node);
                       break;
                case 6:node = t.getRoot();
                       t.reverseOrder(node);
                case 7:node = t.getRoot();
                       t.reverseTreePath(node);
                       break;
            }
        }while(choice!=8);
    }
    public static void main(String[] args) {
       BinaryTreeTraversals bt = new BinaryTreeTraversals();
       bt.start();
    }
    
}
