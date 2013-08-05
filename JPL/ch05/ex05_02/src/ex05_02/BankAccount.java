/*
 * @file
 * @par File Name:
 * BankAccount.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/05
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex05_02;

public class BankAccount {
	private long number;
	private long balance;
	private History history = new History();

	public class Action {
		private String act;
		private long amount;

		Action(String act, long amount) {
			this.act = act;
			this.amount = amount;
		}

		public String toString() {
			return number + " : " + act + " " + amount;
		}
	}

	public class History {
		private int currentIndex = -1;
		private int index = 0;
		private Action[] List = new Action[10];

		public Action next() {
			if (currentIndex++ < List.length - 1)
				return List[currentIndex];
			else
				return null;
		}

		public void add(Action act) {
			if (index < 10)
				List[index] = act;
			else {
				for (int i = 0; i < List.length - 1; i++) {
					List[i] = List[i + 1];
				}
				List[List.length - 1] = act;
			}
			index++;
		}

		public void show() {
			System.out.println(this.next());
		}
	}

	/**
	 * @return balance
	 */
	public long getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 *            セットする balance
	 */
	public void setBalance(long balance) {
		this.balance = balance;
	}

	public void deposit(long amount) {
		setBalance(getBalance() + amount);
		this.history.add(new Action("deposit", amount));
	}

	public void withdraw(long amount) {
		setBalance(getBalance() - amount);
		this.history.add(new Action("withdraw", amount));
	}

	public History history() {
		return this.history;
	}
}