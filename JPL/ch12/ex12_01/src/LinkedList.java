


public class LinkedList implements Cloneable{
  private Object data; //変更を許さない
  private LinkedList next;

  LinkedList (Object Obj, LinkedList NextData){
	  this.data = Obj;
	  this.next = NextData;
  }
  public Object find (Object obj )
  throws ObjectNotFoundException
  {
	  Object result;
	  if(obj.equals(this.data))
		  return this.data;
	  if(this.next == null){
		  throw new ObjectNotFoundException(obj);
	  }
	 result =  this.next.find(obj);
	  return result;
  }
	public Object GetObject()
	{
		return data;
	}

	public LinkedList GetLinkedList()
	{
		return next;
	}

	public int CountList()
	{
		int num = 1;
		LinkedList target = this;
		for( ; null !=target.next ; num++)
		{
			target = target.next;
		}

		return num;
	}

  public void show()
  {
	  if(data instanceof Vehicle){
		  Vehicle obj = (Vehicle)this.data;
		  obj.print();
	  }
	  if ( this.next != null){
		  next.show();
	  }
  }
  public String toString(){
	  String kaigyo = System.getProperty("line.separator");
	  String Buf;
	  Object Data = this.data;
	  Buf = kaigyo + Data.toString();
	  Object Next = this.next;
	  if(Next != null){
		  Buf += Next.toString() + kaigyo;
	  }
	  return Buf;
  }

  public void SetCar(Object obj){
	  this.data = obj;
  }

  public LinkedList clone() {
		try{
			LinkedList obj = (LinkedList)super.clone();
			LinkedList Next = obj.next;
			  if(Next != null){
				  Next.clone();
			  }
			return obj;
		}catch(CloneNotSupportedException e){
			throw new InternalError(e.toString());
		}
	}

	public static void main(String[] args) {
		try{
			LinkedList test2 = new LinkedList("test2", null);
			LinkedList test = new LinkedList("test", test2);
			System.out.println(test.find("test"));
			System.out.println(test.find("test2"));
			System.out.println(test.find("errorError"));
		}catch(ObjectNotFoundException e){
			System.out.println(e.objectData.toString());
		}


	}
}