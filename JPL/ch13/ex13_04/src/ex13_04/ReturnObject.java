package ex13_04;

public enum ReturnObject {
	INTEGER("Integer") {
		@Override
		public void crateObject(String value) {
			/*TODO それぞれで作成したいオブジェクトは異なる。
			 * abstract "Object"メソッドで返しても平気？ｓ
			 */
			
			
		}
	},
	DOUBLE("Double") {
		@Override
		public void crateObject(String value) {
			// TODO 自動生成されたメソッド・スタブ
			
		}
	},
	BYTE("Byte") {
		@Override
		public void crateObject(String value) {
			// TODO 自動生成されたメソッド・スタブ
			
		}
	},
	SHORT("Short") {
		@Override
		public void crateObject(String value) {
			// TODO 自動生成されたメソッド・スタブ
			
		}
	},
	LONG("Long") {
		@Override
		public void crateObject(String value) {
			// TODO 自動生成されたメソッド・スタブ
			
		}
	},
	FLOAT("Float") {
		@Override
		public void crateObject(String value) {
			// TODO 自動生成されたメソッド・スタブ
			
		}
	},
	CHARACTER("Chracter") {
		@Override
		public void crateObject(String value) {
			// TODO 自動生成されたメソッド・スタブ
			
		}
	},
	BOOLEAN("Boolean") {
		@Override
		public void crateObject(String value) {
			// TODO 自動生成されたメソッド・スタブ
			
		}
	};
	@SuppressWarnings("unused")
	private final String className;
	
	private ReturnObject(String className){
		this.className = className;
	}
	public abstract void crateObject(String value);

}
