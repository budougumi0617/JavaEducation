/*
 * @file
 * @par File Name:
 * PrintAllAnnotation.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/11/02
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex16_04;

import java.lang.annotation.Annotation;
@Deprecated
public class PrintAllAnnotation {
	public static void main(String[] args) {
		if (args.length == 0) {
			args = new String[] { "ex16_04.PrintAllAnnotation","test" };
		}
		
		try {
			Class<?> classObject = Class.forName(args[0]);
			for(Annotation annotation : classObject.getAnnotations()){
				System.out.println(annotation);
			}
		}catch(ClassNotFoundException e){
			System.out.println("unknown class: " + args[0]);
		}

	}

}
