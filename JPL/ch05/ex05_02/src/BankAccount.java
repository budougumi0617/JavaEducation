public class BankAccount {
	private long number;
	private long balance;
	private History history = new History();

	public class Action {
		private String act;
		private long amount;
		Action(String act, long amount){
			this.act = act;
			this.amount = amount;
		}
		public String toString(){
			return number + " : " + act + " " + amount;
		}
	}

	public class History {
		private int currentIndex=-1;
		private int index=0;
		private Action[] List = new Action[10];
		public Action next(){
			if(currentIndex++ < List.length -1)
				return List[currentIndex];
			else
				return null;
		}
		public void add(Action act){
			if(index < 10)
				List[index] = act;
			else{
				for(int i=0; i<List.length-1 ;i++){
					List[i] = List[i+1];
				}
				List[List.length-1]=act;
			}
			index++;
		}
		public void show(){
			System.out.println(this.next());
		}
	}

	public void deposit(long amount){
		balance += amount;
		this.history.add(new Action("deposit",amount));
	}

	public void withdraw(long amount){
		balance -= amount;
		this.history.add(new Action("withdraw",amount));
	}
	public History history(){
		return this.history;
	}
}