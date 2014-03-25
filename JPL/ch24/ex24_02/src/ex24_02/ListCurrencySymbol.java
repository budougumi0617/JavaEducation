/*
 * @file
 * @par File Name:
 * ListCurrencySymbol.java
 * @author budougumi0617
 * @date Created on 2014/03/25
 * @par Copyright:
 * Ricoh IT Solutions, LTD.
 */

package ex24_02;

import java.util.Currency;
import java.util.Locale;

/**
 * @author budougumi0617
 * 
 */
public class ListCurrencySymbol {
	static Locale[] locales = { Locale.JAPAN, Locale.US, Locale.UK,
			Locale.FRANCE, Locale.GERMANY, Locale.CHINA };

	public static String getCurrencySymbol(Currency currency, Locale locale) {
		return currency.getSymbol(locale);
	}

	public static String getCurrencySymbolAtSixLocale(Currency currency) {
		String result = "";
		for (Locale locale : locales) {
			result += currency.getSymbol(locale) + "\t|\t";
		}
		return result;
	}

	public static void main(String args[]) {
		String result = "input\t|\t";
		for (Locale locale : locales) {
			result += locale.getDisplayCountry() + "\t|\t";
		}
		System.out.println(result);
		for (Locale locale : locales) {
			System.out
					.println(Currency.getInstance(locale)
							+ "\t|\t"
							+ getCurrencySymbolAtSixLocale(Currency
									.getInstance(locale)));
		}
	}
}
