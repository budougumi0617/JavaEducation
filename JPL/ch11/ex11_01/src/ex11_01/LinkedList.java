/*
 * @file
 * @par File Name:
 * LinkedList.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/27
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */


package ex11_01;

/*
 * 練習問題2.2で始めたLinkedListクラスを見直して、ジェネリッククラスとして書き直しなさい。
 */
public class LinkedList <E>{
  public E data;
  public LinkedList <E>next;
}