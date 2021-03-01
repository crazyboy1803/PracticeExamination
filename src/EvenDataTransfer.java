import java.util.Scanner;
class Node
{
    int rollno;
    Node next;
}
class Nodee
{
    int data;
    Nodee previous;
    Nodee next;
}
public class EvenDataTransfer 
{
    Node START;
    Nodee START1;
    Node tra1;
    EvenDataTransfer()
    {
        START = null;
        START1 = null;
        tra1=START;
    }
    void addnode()
    {
        System.out.println("Enter Data");
        Scanner sc2 = new Scanner(System.in);
        int rn = sc2.nextInt();
        
        Node newnode = new Node();
        newnode.rollno = rn;
        newnode.next = null;
        
        if(START == null)
        {
            START = newnode;
        }
        else
        {
            Node current = START;
            while(current.next != null)
            {
                current = current.next;
            }
            current.next = newnode;
        }
        System.out.println("Data Inserted.....");
    }
     void transferdata()
    {        
        if(START==null)
        {
            System.out.println("Singly linked list is empty");
        }
        else
        {
            while(tra1 != null)
            {
                System.out.println("1");
                if(tra1.rollno%2==0)
                {
                    System.out.println("2");
                    int item = tra1.rollno ;
                
                    Nodee newnode = new Nodee();
                    newnode.data = item;
                    newnode.previous=null;
                    newnode.next=null;
        
                    if(START1 == null)
                    {
                        START1 = newnode;
                    }
                    else
                    {
                        Nodee current1 = START1;
                        while(current1.next!=null)
                        {
                            current1=current1.next;
                        }
                        current1.next=newnode;
                        newnode.previous=current1;
                    }
                }
                else
                {
                    System.out.println("Try again");
                }                
                tra1=tra1.next;
            }
        this.viewvalue();
        }
    }
     void viewvalue()
    {
        if(START1 == null)
        {
          System.out.println("Doubly List Empty");
        }
        else
        {
            System.out.println("-------forward --------");
            //forward
            Nodee current;
            for (current = START1;current.next != null;current=current.next)
            {
                System.out.print(" "+current.data);
            }
            System.out.print(" "+current.data);
            //reverse
            System.out.println("\n-------backward --------");
            Nodee current1 = current;
            for(;current1!= null;current1=current1.previous)
            {
                System.out.print(" "+current1.data);
            }
        }
    }
    void deletenode()
    {
        if(START == null)
        {
            System.out.println("List Empty");
        }
        else
        {
            System.out.println("Deleted : "+START.rollno);
            START = START.next;
        }
    }
    void deletenodelast()
    {
        if(START == null)
        {
            System.out.println("List Empty");
        }
        else
        {
            Node current = START;
            Node SecondLast = null;
            while(current.next != null)
            {
                SecondLast=current;
                current = current.next;
            }
            System.out.println("Deleted element : "+current.rollno);
            SecondLast.next = null;
        }
    }
    void traversenode()
    {
        if(START == null)
        {
            System.out.println("List Empty");
        }
        else
        {
            Node current;
            for(current = START;current != null ;current = current.next)
            {
                System.out.print(" " +current.rollno);
            }
        }
    }
    void searchnode()
    {
        if(START == null)
        {
            System.out.println("List Empty");
        }
        else
        {
            System.out.println("Enter searching element");
            Scanner sc3 = new Scanner(System.in);
            int sea = sc3.nextInt();
            
            Node current;
            int count=0;
            for(current=START;current != null ;current=current.next)
            {
                if(current.rollno == sea)
                {
                    count++;
                    break;
                }
            }
            if(count>0)
            {
                System.out.println("Found");
            }
            else
            {
                System.out.println("Not Found");
            }
        }
    }
    public static void main(String arg[])
    {
        EvenDataTransfer obj = new EvenDataTransfer();
        while(true)
        {
            System.out.println("\npress 1 for insert");
            System.out.println("press 2 for delete");
            System.out.println("press 3 for delete from last");
            System.out.println("press 4 for traverse");
            System.out.println("press 5 for search");
            System.out.println("press 6 for transfer data to doubly");
            System.out.println("press 7 for Exit");
            
            System.out.println("Enter ur choice");
            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();
            
            switch(ch)
            {
                case 1:
                    obj.addnode();
                    break;
                case 2:
                    obj.deletenode();
                    break;
                case 3:
                    obj.deletenodelast();
                    break;
                case 4:
                    obj.traversenode();
                    break;
                case 5:
                    obj.searchnode();
                    break;
                case 6:
                    obj.transferdata();
                    break;
                case 7:
                    System.exit(0);
                   break;
                default:
                    System.out.println("Wrong choice");
                    
            }
        }
    }
}
