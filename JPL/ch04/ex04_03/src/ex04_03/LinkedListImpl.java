package ex04_03;

public class LinkedListImpl implements Cloneable, LinkedList<LinkedListImpl> {
	private Object obj;
	private LinkedListImpl nextNode;

	public LinkedListImpl(Object Obj, LinkedListImpl nextNode) {
		this.obj = Obj;
		this.nextNode = nextNode;
	}

	public LinkedListImpl(Object obj) {
		this(obj, null);
	}

	public void show() {
		System.out.println(obj.getClass());
		if (obj instanceof Vehicle) {
			Vehicle tmpVehicle = (Vehicle) obj;
			tmpVehicle.print();
		}
		if (nextNode != null)
			nextNode.show();
	}

	public String toString() {
		if (obj instanceof Vehicle) {
			String tmpv;
			Vehicle tmpVehicle = (Vehicle) obj;
			tmpv = tmpVehicle.toString();
			if (nextNode != null)
				tmpv += nextNode.toString();
			return tmpv;
		}
		return null;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object Obj) {
		this.obj = Obj;
	}

	public LinkedListImpl getNextNode() {
		return nextNode;
	}

	public void setNextNode(LinkedListImpl nextNode) {
		this.nextNode = nextNode;
	}

	public int countList() {
		if (nextNode == null)
			return 1;
		else
			return 1 + nextNode.countList();
	}

	public LinkedListImpl clone() {
		try {
			LinkedListImpl ls = (LinkedListImpl) super.clone();
			if (ls.nextNode != null)
				ls.nextNode = nextNode.clone();
			return ls;
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
}
