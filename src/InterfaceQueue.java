import java.util.Scanner;
class Node4
{
    int data;
    Node4 Next;
}
interface ADTQueue
{
    abstract void insert(int data);
    abstract int delete();
    abstract boolean isEmpty();
    abstract void traverse();
    abstract boolean search(int sea);
}
class InterfaceQueue implements ADTQueue
{
    Node4 Front,Rear;
    InterfaceQueue()
    {
        Front=null;
        Rear=null;
    }
    @Override
    public void insert(int data)
    {         
        Node4 newnode = new Node4();
        newnode.data=data;
        newnode.Next=null;
        
        if(Front == null)
        {
            Front = newnode;
            Rear=newnode;
        }
        else
        {
            Node4 current=Rear;
            while(current.Next!=null)
            {
                current = current.Next;
            }
            current.Next=newnode;
        }
        System.out.println("Data Inserted ....");
    }
    @Override
    public int delete()
    {
       if(!isEmpty())
       {
           System.out.println("Deleted :"+Front.data);
           Front = Front.Next;
       }
        else
       {
           System.out.println("Queue Empty");
       }
        return 0;
    }
    @Override
    public boolean isEmpty()
    {
        return Front==null;
    }
    @Override
    public void traverse()
    {
         if(!isEmpty())
         {
             System.out.println(".....SinglyQueueLinkedlist.....");
             Node4 current;
             for(current = Front ; current != null ; current=current.Next)
             {
                 System.out.print(" "+current.data);
             }
         }
        else
         {
             System.out.println("Queue Empty");
         }
    }
    @Override
    public boolean search(int sea)
    {
        boolean flag = false;
        if(!isEmpty())
        {
            int count=0;
            Node4 current;
            for(current=Front;current != Rear ;current=current.Next)
            {
                if(current.data == sea)
                {            
                    flag = true;
                    break;
                }
            }
        }
        else
        {
            System.out.println("List Empty");
        }
        return flag;
    }
    public static void main(String arg[])
    {
        InterfaceQueue obj = new InterfaceQueue();
        while(true)
        {
            1:
            System.out.println("\npress 1 for insert");
            System.out.println("press 2 for delete");
            System.out.println("press 3 for traverse");
            System.out.println("press 4 for searching element");
            System.out.println("press 5 for Exit");
            
            System.out.println("Enter your choice");
            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();
            switch(ch)
            {
                case 1:
                    System.out.println("Enter the value");
                    obj.insert(sc.nextInt());
                    break;
                case 2:
                    obj.delete();
                    break;
                case 3:
                    obj.traverse();
                    break;
                case 4:
                    System.out.println("Enter element to be searched");
                    int del = sc.nextInt();
                    if(obj.search(del))
                    {
                        System.out.println("Element Found");
                    }
                    else
                    {
                        System.out.println("Element not Found");
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong choice");
                    
            }
        }
    }
}
