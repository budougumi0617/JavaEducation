import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class FunctionReflection {
	Map<String, Object> objectMap;
	Map<String, Object[]> arrayMap;
	Map<String, Method> methodMap;
	List<String> methodSortedList;
	DefaultListModel objListModel;
	DefaultListModel arrayListModel;
	DefaultTableModel cstParamTableModel;
	DefaultTableModel methodParamTableModel;
	DefaultTableModel fieldParamTableModel;
	DefaultTableModel arrayParamTableModel;

	FunctionReflection() {
		objectMap = new HashMap<String, Object>();
		methodMap = new HashMap<String, Method>();
		arrayMap = new HashMap<String, Object[]>();
		objListModel = new DefaultListModel();
		arrayListModel = new DefaultListModel();
		methodSortedList = new ArrayList<String>();
		String[] columnNames = { "Type", "Value" };
		cstParamTableModel = new DefaultTableModel(columnNames, 0);
		methodParamTableModel = new DefaultTableModel(columnNames, 0);
		String[] fieldNames = { "Field Type", "Value" };
		fieldParamTableModel = new DefaultTableModel(fieldNames, 0);
		String[] arrayLabel = { "array No.", "Value" };
		arrayParamTableModel = new DefaultTableModel(arrayLabel, 0);
	}

	public Object methodInvoke(Object targetObject, Method executeMethod,
			Object... args) throws Throwable {
		Throwable failureReason = null;
		Object resultObject = null;
		try {
			executeMethod.setAccessible(true);
			resultObject = executeMethod.invoke(targetObject, (Object[]) args);
		} catch (InvocationTargetException e) {
			failureReason = e.getCause();
		} catch (IllegalArgumentException e) {
			failureReason = e.getCause();
		} catch (IllegalAccessException e) {
			failureReason = e.getCause();
		}
		if (failureReason != null) {
			throw failureReason;
		}
		return resultObject;

	}

	@SuppressWarnings("rawtypes")
	public Constructor[] getClassConstractor(Class<?> c) {
		try {
			return c.getDeclaredConstructors();
		} catch (SecurityException e) {
			e.getCause();
		}
		return null;
	}

	public Method[] getClassMethod(Class<?> c) {
		try {
			return c.getMethods();
		} catch (SecurityException e) {
			e.getCause();
		}
		return null;

	}

	public Type[] getMethodParamType(Method method) {
		method.setAccessible(true);
		Type[] results = method.getParameterTypes();
		for (Type t : results) {
			System.out.println(t.toString());
		}
		return results;
	}

	public <T> Type[] getConstructorParamType(Constructor<T> constructor) {
		constructor.setAccessible(true);
		Type[] results = constructor.getParameterTypes();
		for (Type t : results) {
			System.out.println(t.toString());
		}
		return results;
	}

	public String splitMethodName(Method method) {
		System.out.println(method.toString());
		String[] methodNames = method.toString().split("\\(");
		String foo = methodNames[0];
		String[] bar = foo.toString().split("\\.");
		System.out.println(bar[bar.length - 1] + "("
				+ methodNames[methodNames.length - 1]);
		return bar[bar.length - 1] + "(" + methodNames[methodNames.length - 1];
	}

	public void setMethodMap(Method[] methods) {
		methodMap.clear();
		methodSortedList.clear();
		for (Method method : methods) {
			method.setAccessible(true);
			String methodName = splitMethodName(method);
			if (!methodMap.containsKey(methodName)) {
				methodMap.put(methodName, method);
				methodSortedList.add(methodName);
			}
		}
		Collections.sort(methodSortedList);
	}

	public Method getMethodMap(String methodName) {
		Method resultMethod = methodMap.get(methodName);
		if (resultMethod == null) {
			throw new NullPointerException();
		}
		return resultMethod;
	}

	public List<String> getFieldList(Object targeObject) {
		List<String> resultList = new ArrayList<String>();
		Field[] fields = targeObject.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			resultList.add(field.getName());
		}
		return resultList;
	}

	public void setField(Object targetObject, String fieldName, Object value)
			throws Throwable {
		Throwable failureReason = null;
		try {
			Field targetField = targetObject.getClass().getDeclaredField(
					fieldName);
			targetField.setAccessible(true);
			Object inputValue = changeType(targetField.getType(),
					(String) value);
			targetField.set(targetObject, inputValue);

		} catch (SecurityException e) {
			failureReason = e.getCause();
		} catch (NoSuchFieldException e) {
			failureReason = e.getCause();
		}
		if (failureReason != null) {
			throw failureReason;
		}
	}

	public Object getField(Object targetObject, String fieldName)
			throws Throwable {
		Throwable failureReason = null;
		try {
			Field targetField = targetObject.getClass().getDeclaredField(
					fieldName);
			targetField.setAccessible(true);
			return targetField.get(targetObject);
		} catch (SecurityException e) {
			failureReason = e.getCause();
		} catch (NoSuchFieldException e) {
			failureReason = e.getCause();
		}
		throw failureReason;

	}

	public Object changeType(Type objectType, String value)
			throws NullPointerException {
		Object resultObject = null;
		System.out.println("in changeType Type: " + objectType + ", value : "
				+ value);
		if (int.class.equals(objectType)) {
			resultObject = new Integer(value);
		} else if (double.class.equals(objectType)) {
			resultObject = new Double(value);
		} else if (float.class.equals(objectType)) {
			resultObject = new Float(value);
		} else if (long.class.equals(objectType)) {
			resultObject = new Long(value);
		} else if (byte.class.equals(objectType)) {
			resultObject = new Byte(value);
		} else if (short.class.equals(objectType)) {
			resultObject = new Short(value);
		} else if (char.class.equals(objectType)) {
			resultObject = new Character(value.charAt(0));
		} else if (boolean.class.equals(objectType)) {
			resultObject = new Boolean(value);
		} else if (String.class.equals(objectType)) {
			resultObject = new String(value);
		} else {
			resultObject = objectMap.get(value);
			if (resultObject == null) {
				throw new NullPointerException("No found object");
			}
		}
		return resultObject;
	}

	public Object makeInstanceByConstructor(Constructor<?> c, Object... args)
			throws Throwable {
		Throwable failureReason = null;
		Object resultObject = null;
		try {
			resultObject = c.newInstance(args);
		} catch (IllegalArgumentException e) {
			failureReason = e;
		} catch (InstantiationException e) {
			failureReason = e;
		} catch (IllegalAccessException e) {
			failureReason = e;
		} catch (InvocationTargetException e) {
			failureReason = e;
		}
		if (failureReason != null) {
			throw failureReason;
		}
		return resultObject;
	}

	@SuppressWarnings("unchecked")
	public Object[] makeArrayNewInstance(Class<?> arrayClass, int dim) {
		System.out.println("Array type : " + arrayClass);
		return (Object[]) Array.newInstance(arrayClass, dim);
	}

	@SuppressWarnings("unchecked")
	public <T> T makeArrayNewInstance(Object array, int dim, int dim2) {
		Class<?> type = array.getClass();
		T grown = (T) Array.newInstance(type, dim, dim2);
		return grown;
	}

	public void putObject(String key, Object value) {
		objectMap.put(key, value);
		objListModel.addElement(key);
	}

	public void putArray(String key, Object[] value) {
		arrayMap.put(key, value);
		arrayListModel.addElement(key);
	}

	public Object[] getArgs(DefaultTableModel paramTableModel) {
		Object args[] = new Object[paramTableModel.getRowCount()];
		for (int i = 0; i < args.length; i++) {
			args[i] = changeType((Type) paramTableModel.getValueAt(i, 0),
					(String) paramTableModel.getValueAt(i, 1));
		}
		return args;
	}
}
