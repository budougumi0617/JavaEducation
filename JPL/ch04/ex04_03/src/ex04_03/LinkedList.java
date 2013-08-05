package ex04_03;
public interface LinkedList<T> {
	void show();
	String toString();
	Object getObj();
	void setObj(Object obj);
	T getNextNode();
	void setNextNode(T nextNode);
	int countList();
}