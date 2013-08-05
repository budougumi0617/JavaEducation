public interface LinkedList<T> {
	void show();
	String toString();
	Object getObj();
	void setObj(Object Obj);
	T getNextNode();
	void setNextNode(T nextNode);
	int countList();
}