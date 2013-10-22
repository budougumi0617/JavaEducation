
public class MakeThread {
	private  String currentGroupname;
	public ThreadGroup current;
	public String getCurrentGroupname() {
		return currentGroupname;
	}

	public void setCurrentGroupname(String name) {
		this.currentGroupname = name;
	}

	public void makeThreadGroupTree(ThreadGroup current){
		current = new ThreadGroup(this.getCurrentGroupname());
		ThreadGroup second = new ThreadGroup(current, "second");
		new ThreadGroup(second, "Third");
	}

	public int countThreadGroupLevel(ThreadGroup target){
		if(target.getParent() != null)
			return 1 + this.countThreadGroupLevel(target.getParent());
		else
			return 0;
	}

	public void printAllThread(ThreadGroup targetGroup){
		ThreadGroup[] memberGroup = new ThreadGroup[targetGroup.activeGroupCount()];
		this.printThreadGroup(targetGroup);
		targetGroup.enumerate(memberGroup, true);
		for (ThreadGroup th : memberGroup)
			this.printThreadGroup(th);
	}

	public void printThreadGroup(ThreadGroup targetGroup){
		System.out.println("ThreadGroup : " + targetGroup.getName() +
				" ThreadGroup Level : " + countThreadGroupLevel(targetGroup) );
		printMember(targetGroup);
	}

	public void printMember(ThreadGroup targetGroup){
		Thread[] memberThread = new Thread[targetGroup.activeCount()];
		targetGroup.enumerate(memberThread, false);
		for (Thread th : memberThread){
			if(th != null)
				System.out.println("\t Thread name :" + th.getName());
		}
	}

	public static void main(String[] args) {
		MakeThread threadA = new MakeThread();
		threadA.setCurrentGroupname("First");
		ThreadGroup current = new ThreadGroup(threadA.getCurrentGroupname());
		threadA.makeThreadGroupTree(current);
		ThreadGroup level2 = new ThreadGroup(current, "testLevel2");
		ThreadGroup level3 = new ThreadGroup(level2, "testLevel3");
		new ShortLifeThread(current, "threadB").start();
		new ShortLifeThread(current, "threadC").start();
		new ShortLifeThread(level2, "threadD").start();
		threadA.printAllThread(current);
	}

}
