/*
 * @file
 * @par File Name:
 * ClassContents.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/11/02
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex16_05;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ClassContents {
	private static int depth;

	private static Map<String, Void> methods = new HashMap<String, Void>();

	static void printMemberts(Member[] member) {
		for (Member m : member) {
			if (m.getDeclaringClass() == Object.class) {
				continue;
			}

			StringBuilder annotationStrinbBuilder = new StringBuilder();

			if (m instanceof Method) {
				Method method = (Method) m;

				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(method.getName());

				for (Class<?> c : method.getParameterTypes()) {
					stringBuilder.append(":" + c.getName());
				}
				if (methods.containsKey(stringBuilder.toString())) {
					continue;
				} else {
					methods.put(stringBuilder.toString(), null);
				}

				for (Annotation annotation : method.getAnnotations()) {
					annotationStrinbBuilder.append(" @");
					annotationStrinbBuilder.append(annotation.annotationType()
							.getSimpleName());

				}
			} else if (m instanceof Field) {
				Field field = (Field) m;
				for (Annotation annotation : field.getAnnotations()) {
					annotationStrinbBuilder.append(" @");
					annotationStrinbBuilder.append(annotation.annotationType()
							.getSimpleName());
				}
			}

			String decl = m.toString() + annotationStrinbBuilder.toString();
			for (int i = 0; i < depth + 1; i++) {
				System.out.print(" ");
			}
			System.out.println(strip(decl, "jaba.lang"));
		}
	}

	private static String strip(String decl, String pattern) {
		return decl.replaceFirst(pattern, "");
	}

	private static void contentsValue(Class<?> classObject)
			throws ClassNotFoundException {
		if (classObject == null) {
			throw new ClassNotFoundException();
		}
		for (int i = 0; i < depth; i++) {
			System.out.print(" ");
		}
		System.out.println(classObject);
		printMemberts(classObject.getFields());
		printMemberts(classObject.getConstructors());
		printMemberts(classObject.getMethods());

		depth++;
		if (classObject.getGenericSuperclass() != Object.class) {
			if (classObject.getGenericSuperclass() instanceof Class<?>) {
				contentsValue((Class<?>) classObject.getGenericSuperclass());
			}
		}

	}

	public static void main(String[] args) {
		depth = 0;
		if (args.length == 0) {
			args = new String[] { "java.lang.String" };
		}
		try {
			Class<?> c = Class.forName(args[0]);
			contentsValue(c);
		} catch (ClassNotFoundException e) {
			System.out.println("unknown class: " + args[0]);
		}
	}

}
