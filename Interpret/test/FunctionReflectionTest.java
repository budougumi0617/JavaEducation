import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/*
 * @file
 * @par File Name:
 * FunctionReflectionTest.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/11/19
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

/**
 * @author z00s000723
 * 
 */
public class FunctionReflectionTest {

	private FunctionReflection targetClass;

	@Before
	public void setUp() throws Exception {
		targetClass = new FunctionReflection();
	}

	/**
	 * {@link FunctionReflection#FunctionReflection()} のためのテスト・メソッド。
	 */
	@Test
	public void testFunctionReflection() {
		try {
			targetClass = new FunctionReflection();
		} catch (Exception e) {
			e.getCause();
			fail("Constructor Failed.");
		}

	}

	/**
	 * {@link FunctionReflection#methodInvoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testMethodInvoke() {
		String targetObjectString = new String("test");
		Method executeMethod = null;
		Object resultObject = null;
		try {
			executeMethod = String.class.getDeclaredMethod("charAt", int.class);
			assertNotNull(executeMethod);
			executeMethod.setAccessible(true);
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchMethodException e) {
			fail();
		}
		try {
			resultObject = targetClass.methodInvoke(targetObjectString,
					executeMethod, 1);
		} catch (Throwable e) {
			e.printStackTrace();
			fail();
		}
		
		assertEquals(resultObject, targetObjectString.charAt(1));
		
		try {
			executeMethod = String.class.getDeclaredMethod("toString");
			assertNotNull(executeMethod);
			executeMethod.setAccessible(true);
		} catch (SecurityException e) {
			fail();
		} catch (NoSuchMethodException e) {
			fail();
		}
		try {
			resultObject = targetClass.methodInvoke(targetObjectString,
					executeMethod);
		} catch (Throwable e) {
			e.printStackTrace();
			fail();
		}
		assertEquals(resultObject, targetObjectString.toString());
	}

	/**
	 * {@link FunctionReflection#setMethodMap(java.lang.reflect.Method[])}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testSetMethodMap() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link FunctionReflection#getMethodMap(java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testGetMethodMap() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link FunctionReflection#getFieldList(java.lang.Object)} のためのテスト・メソッド。
	 */
	@Test
	public void testGetFieldList() {
		Integer targetObjString = new Integer(10);
		List<String> result = targetClass.getFieldList(targetObjString);
		for (String string : result) {
			System.out.println(string);
		}

	}

	/**
	 * {@link FunctionReflection#setField(java.lang.Object, java.lang.String, java.lang.String)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testSetField() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link FunctionReflection#getField(java.lang.Object, java.lang.String)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testGetField() {
		fail("まだ実装されていません");
	}

	/**
	 * {@link FunctionReflection#changeType(java.lang.reflect.Type, java.lang.String)}
	 * のためのテスト・メソッド。
	 */
	@Test
	public void testChangeType() {
		fail("まだ実装されていません");
	}

}
