import java.util.Scanner;
class Student
{
    int Studentid;
    String StudentName;
    int Studentage;
    Student previous;
    Student next;
}
public class StudentInformation
{
    Student START;
    StudentInformation()
    {
        START = null;
    }
    void add_detail()
    {
        System.out.println("Entry start");
        Scanner sc2 = new Scanner(System.in);
        System.out.print("Enter Student ID=");
        int id = sc2.nextInt();
        System.out.print("Enter Name=");
        String name= sc2.next();
        System.out.print("Enter Age=");
        int age=sc2.nextInt();
        
        Student newnode = new Student();
        newnode.Studentid = id;
        newnode.StudentName=name;
        newnode.Studentage=age;
        newnode.previous=null;
        newnode.next=null;
        
        if(START == null)
        {
            START = newnode;
        }
        else
        {
            Student current = START;
            while(current.next!=null)
            {
                current=current.next;
            }
            current.next=newnode;
            newnode.previous=current;
        }
    }
    void Delete_detail()
    {
        //to check whether the list is empty or not.
        if(START  == null)
        {
           System.out.println("Doubly Linked List Is Empty");
        }
        else
        {            
            //if list is not empty the take input the value which we want to delete.
            Scanner sc4 = new Scanner(System.in);
            System.out.println("Enter the id of student which you want to delete");
            int value = sc4.nextInt();
            //counter for whether the value is present or not.
            int count=0;
            Student current = START;
            //loop for check all the elements of linked list.
            while(current.next!=null)
            {
                if(current.Studentid==value)
                {
                    //if the value is present the count will be increased.
                    count++;
                    break;
                }
                current=current.next;
            }
            //this is for checking last element of linked list.
            if(current.Studentid==value)
            {
                count++;                    
            }
            if(count>0)
            {
                //if counter value will be more than zero the  processing of deleting start.
                current = START;
                while(current.Studentid != value)
                {
                    //to take the variable current to the node where the value present.
                    current = current.next;            
                }
                // to print deleted value.
                System.out.println("Deleted record name  :"+current.StudentName);
                //for the first value of linked list.
                if(current.previous==null && current.next!=null)
                {
                    START =current.next;
                    START.previous = null;
                }
                //for the last value of linked list.
                else if(current.next==null && current.previous!=null)
                {
                    current.previous.next = null;
                }        
                //for only one value present in linked list.
                else if(current.next==null && current.previous==null)
                {
                    START=null;
                }
                //for any middle value.
                else
                {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
            }
            else
            {                
                //when value is not present.
                System.out.println("record Not Found");
            }            
        }
        
    }
    void SortedNodebyName()
    {
        if(START==null)
        {
            System.out.println("No record found");
        }
        else
        {
            Student current = START;
            int id,age;
            String name;
            while(current.next!=null)
            {                
                Student current_next = current.next;                
                while(current_next !=null)
                {
                    if(current.StudentName.compareToIgnoreCase(current_next.StudentName)>0)
                    {
                        name=current.StudentName;
                        id=current.Studentid;
                        age=current.Studentage;
                        current.StudentName=current_next.StudentName;
                        current.Studentid=current_next.Studentid;
                        current.Studentage=current_next.Studentage;
                        current_next.StudentName=name;
                        current_next.Studentid=id;
                        current_next.Studentage=age;
                    }
                      
                    current_next=current_next.next;
                }
                current=current.next;
            }
        }
    }
    void SortedNodebyId()
    {
        if(START==null)
        {
            System.out.println("No record found");
        }
        else
        {
            Student current = START;
            int id,age;
            String name;
            while(current.next!=null)
            {                
                Student current_next = current.next;                
                while(current_next !=null)
                {
                    if(current.Studentid>current_next.Studentid)
                    {
                        name=current.StudentName;
                        id=current.Studentid;
                        age=current.Studentage;
                        current.StudentName=current_next.StudentName;
                        current.Studentid=current_next.Studentid;
                        current.Studentage=current_next.Studentage;
                        current_next.StudentName=name;
                        current_next.Studentid=id;
                        current_next.Studentage=age;
                    }
                      
                    current_next=current_next.next;
                }
                current=current.next;
            }
        }
    }
    void SortedNodebyAge()
    {
        if(START==null)
        {
            System.out.println("No record found");
        }
        else
        {
            Student current = START;
            int id,age;
            String name;
            while(current.next!=null)
            {                
                Student current_next = current.next;                
                while(current_next !=null)
                {
                    if(current.Studentage>current_next.Studentage)
                    {
                        name=current.StudentName;
                        id=current.Studentid;
                        age=current.Studentage;
                        current.StudentName=current_next.StudentName;
                        current.Studentid=current_next.Studentid;
                        current.Studentage=current_next.Studentage;
                        current_next.StudentName=name;
                        current_next.Studentid=id;
                        current_next.Studentage=age;
                    }
                      
                    current_next=current_next.next;
                }
                current=current.next;
            }
        }
    }
    void traversenode()
    {
        if(START ==null)
        {
          System.out.println("No record found");
        }
        else
        {
            System.out.println("Enter 1 for sort by name");
            System.out.println("Enter 2 for sort by id");
            System.out.println("Enter 3 for sort by age");
            System.out.println("Enter any key for don't sort");
            Scanner sc4=new Scanner(System.in);
            int ch=sc4.nextInt();
            if(ch==1)
            {
                this.SortedNodebyName();  
            }
            else if(ch==2)
            {
                this.SortedNodebyAge();
            }
            else if(ch==3)
            {
                this.SortedNodebyId();
            }            
            Student current;
            System.out.print("   "+"ID");
            System.out.print("   "+"NAME");
            System.out.println("   "+"AGE");
            for (current = START;current.next != null;current=current.next)
            {
                System.out.print("   "+current.Studentid);
                System.out.print("   "+current.StudentName);
                System.out.println("   "+current.Studentage);
            }
            System.out.print("   "+current.Studentid);
            System.out.print("   "+current.StudentName);
            System.out.println("   "+current.Studentage);           
            
        }
    }
    void searchnode()
    {
        if(START == null)
        {
            System.out.println("No record found");
        }
        else
        {
            System.out.println("Enter student name");
            Scanner sc3 = new Scanner(System.in);
            String sea = sc3.nextLine();
            
            Student current;
            int count=0;
            for(current=START;current != null ;current=current.next)
            {
                if(sea.equalsIgnoreCase(current.StudentName))
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
    public static void main(String args[])
    {
        StudentInformation obj = new StudentInformation();
        while(true)
        {
            System.out.println("\npress 1 for add detail");
            System.out.println("press 2 for delete detail");            
            System.out.println("press 3 for see information");
            System.out.println("press 4 for search specific information");
            System.out.println("press 5 for Exit");
            
            System.out.println(".......Enter ur choice.......");
            Scanner sc = new Scanner(System.in);
            int ch = sc.nextInt();
            
            if(ch == 1)
            {
                obj.add_detail();
            }
            else if(ch == 2)
            {
                obj.Delete_detail();
            }
            else if(ch == 3)
            {
                obj.traversenode();
            }
            else if(ch == 4)
            {
                obj.searchnode();
            }
            else if(ch == 5)
            {
                System.exit(0);
            }
            else
            {
                System.out.println("......Wrong choice......");
            }
        }
    }
}

