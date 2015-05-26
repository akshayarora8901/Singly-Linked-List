import java.util.Scanner;

class Node
{
	int data;
	Node link;
	public Node()
	{
		data=0;
		link=null;
	}
	public Node(int data,Node link)
	{
		this.data=data;
		this.link=link;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getLink() {
		return link;
	}
	public void setLink(Node link) {
		this.link = link;
	}
	
	
}
class LinkedList
{
	Node start;
	Node end;
	int size;
	
	public LinkedList()
	{
		start=null;
		end=null;
		size=0;
	}
	public boolean isEmpty()
	{
		return start==null;
	}
	public int getSize()
	{
		return size;
	}
	public void InsertAtStart(int val)
	{
		Node nptr=new Node(val,null);
		size++;
		if(start==null)
		{
			start=nptr;
			end=start;
		}
		else
		{
			nptr.setLink(start);
			start=nptr;
		}
	}
	public void InsertAtEnd(int val)
	{
		Node nptr=new Node(val,null);
		size++;
		if(start==null)
		{
			start=nptr;
			end=start;
		}
		else
		{
			end.setLink(nptr);
			end=nptr;
		}
	}
	public void InsertAtPos(int val,int pos)
	{
		Node nptr=new Node(val,null);
		Node ptr=start;
		pos=pos-1;
		for(int i=1;i<size;i++)
		{
			if(i==pos)
			{
				Node tmp=ptr.getLink();
				nptr.setLink(ptr);
				ptr.setLink(tmp);
				break;
			}
			ptr=ptr.getLink();
		}
		size++;
	}
	public void DeleteAtPos(int pos)
	{
		if(pos==1)
		{
			start=start.getLink();
			size--;
			return;
		}
		if(pos==size)
		{
			Node s=start;
			Node t=start;
			while(s!=end)
			{
				t=s;
				s=s.getLink();
			}
			end=t;
			end.setLink(null);
			size--;
			return;
		}
		Node ptr=start;
		pos=pos-1;
		for(int i=1;i<size-1;i++)
		{
			if(i==pos)
			{
			Node tmp=ptr.getLink();
			tmp=tmp.getLink();
			ptr.setLink(tmp);
			break;
			}
			ptr=ptr.getLink();
		}
		size--;
	}
	public void Display()
	{
		System.out.print("\n Singly Linked list:");
		
		if(start==null)
		{
			System.out.print("Empty\n");
			return;
		}
		if(start.getLink()==null)
		{
			System.out.println(start.getData());
			return;
		}
		Node ptr=start;
		System.out.print(ptr.getData()+"->");
		ptr=start.getLink();
		while(ptr.getLink()!=null)
		{
			System.out.print(ptr.getData()+"->");
			ptr=ptr.getLink();
		}
		System.out.print(ptr.getData()+"\n");
	}
}

public class MySinglyLinkedList {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		LinkedList list=new LinkedList();
		char ch;
		do
		{
			System.out.println("\nSingly Linked List Operations\n");
            System.out.println("1. insert at begining");
            System.out.println("2. insert at end");
            System.out.println("3. insert at position");
            System.out.println("4. delete at position");
            System.out.println("5. check empty");
            System.out.println("6. get size");
            int choice=scan.nextInt();
            switch(choice)
            {
            case 1: 
            	System.out.println("Enter Element to be inserted at start:");
            	list.InsertAtStart(scan.nextInt());
            	break;
            case 2:
            	System.out.println("Enter element to be inserted at end:");
            	list.InsertAtEnd(scan.nextInt());
            	break;
            case 3:
            	System.out.println("Enter element to be inserted:");
            	int num= scan.nextInt();
            	System.out.println("Enter position to insert:");
            	int pos=scan.nextInt();
            	if(pos<1 || pos>list.getSize())
            		System.out.println("\nInvalid Position!");
            	else
            		list.InsertAtPos(num, pos);
            	break;
            case 4:
            	System.out.println("Enter Position to delete element:");
            	int p=scan.nextInt();
            	if(p<1 || p>list.getSize())
            		System.out.println("\nInvalid Position!");
            	else
            		list.DeleteAtPos(p);
            	break;
            case 5:
            	System.out.println("\nEmpty Status :"+list.isEmpty());
            	break;
            case 6:
            	System.out.println("Size is: "+list.getSize()+"\n");
            	break;
            	default:
            		System.out.println("Invalid Choice! Please try again!");
            		break;
            }
            list.Display();
            System.out.println("Do ypu want to continue? Yes(y) or No(n)! Choose y or n.\n");
            ch=scan.next().charAt(0);
		}while(ch=='y' || ch=='Y');

	}

}
