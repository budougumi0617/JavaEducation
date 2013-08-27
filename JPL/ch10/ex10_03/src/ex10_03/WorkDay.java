/*
 * @file
 * @par File Name:
 * WeekDay.java
 * @author Yoichiro Shimizu
 * @date Created on 2013/08/27
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */


package ex10_03;

public class WorkDay {

	public boolean isBreak(Object day){
		boolean result;
		if(day.equals(Week.SUNDAY)){
			result = true;
		}else if(day.equals(Week.SATURDAY)){
			result = true;
		}else{
			result = false;
		}
		return result;
	}
	
	public boolean isWeekDay(Week day){
		switch(day){
		case SUNDAY:
		case SATURDAY:
			return false;
		default:
			return true;
		}
	}
	
	public static void main(String[] args) {
		Week day = Week.FRIDAY;
		WorkDay workDay= new WorkDay();
		if(workDay.isBreak(day))
			System.out.println("二度寝する！");
		else
			System.out.println("行きたくない");
		if(workDay.isWeekDay(day))
			System.out.println("行きたくない");
		else
			System.out.println("二度寝する！");
			
		
	}

}
