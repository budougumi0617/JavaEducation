
public class ObjectNotFoundException extends Exception{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public final Object objectData;
	ObjectNotFoundException(Object obj){
		super("Not Found named \"" + obj.toString() + "\" found");
		objectData = obj;
	}

}
