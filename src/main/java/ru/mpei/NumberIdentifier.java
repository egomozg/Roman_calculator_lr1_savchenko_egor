package ru.mpei;

public class NumberIdentifier {

	public static boolean isArabicNumber(String number){
		// заодно еще проверяем, что число не больше 10
		return number.matches("^([1-9]|10)$");
	}

	public static boolean isRomanNumber(String number){
		return switch (number.toUpperCase()) {
			case "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" -> true;
			default -> false;
		};
		}
	}
