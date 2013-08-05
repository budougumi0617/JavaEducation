


public class LinkedList implements Cloneable{
  private Object data; //変更を許さない
  private LinkedList next;

  LinkedList (Object Obj, LinkedList NextData){
	  this.data = Obj;
	  this.next = NextData;
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
		
		Vehicle car = new Vehicle("Satoh");
		LinkedList arg3 = new LinkedList(car, null);

		car = new Vehicle("Mike");
		LinkedList arg2 = new LinkedList(car, arg3);

		car = new Vehicle("Bob");
		LinkedList arg1 = new LinkedList(car, arg2);

		LinkedList cloneArg1 = arg1.clone();
		car = new Vehicle("Suzuki");
		cloneArg1.SetCar(car);

		System.out.println("toString = " + arg1.toString());
		System.out.println("CountList = " + arg1.CountList());
		System.out.println("Clone List");
		System.out.println("toString = " + cloneArg1.toString());
		System.out.println("CountList = " + cloneArg1.CountList());
	}
}