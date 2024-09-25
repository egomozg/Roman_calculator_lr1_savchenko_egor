package ru.mpei;

public class RomanCalcs extends Calculations {

	private String operand1;
	private String operand2;
	private String operator;

	public RomanCalcs(String operand1, String operand2, String operator) {
		this.operand1 = operand1.toUpperCase();
		this.operand2 = operand2.toUpperCase();
		this.operator = operator;
	}

	@Override
	public String addition(){
		int num1 = romanToInt(operand1);
		int num2 = romanToInt(operand2);
		if (num1 == -1 || num2 == -1) {
			return "Ошибка: некорректное римское число";
		}
		int result = num1 + num2;
		return intToRoman(result);
	}

	@Override
	public String subtraction(){
		int num1 = romanToInt(operand1);
		int num2 = romanToInt(operand2);
		if (num1 == -1 || num2 == -1) {
			return "Ошибка: некорректное римское число";
		}
		int result = num1 - num2;
		if (result < 1){
			return "Ошибка: результат меньше I.";
		}
		return intToRoman(result);
	}

	@Override
	public String multiplication(){
		int num1 = romanToInt(operand1);
		int num2 = romanToInt(operand2);
		if (num1 == -1 || num2 == -1) {
			return "Ошибка: некорректное римское число";
		}
		int result = num1 * num2;
		return intToRoman(result);
	}

	@Override
	public String division(){
		int num1 = romanToInt(operand1);
		int num2 = romanToInt(operand2);
		if (num1 == -1 || num2 == -1) {
			return "Ошибка: некорректное римское число";
		}
		if (num2 == 0){
			return "Ошибка: деление на 0";
		}
		int result = num1 / num2;
		if (result < 1){
			return "Ошибка: результат меньше 1";
		}
		return intToRoman(result);
	}

	@Override
	public String calculate(){
		return switch (operator) {
			case "+" -> addition();
			case "-" -> subtraction();
			case "*" -> multiplication();
			case "/" -> division();
			default -> "Неверный оператор";
		};
	}

	private int romanToInt(String num){
		return switch(num.toUpperCase()) {
			case "I" -> 1;
			case "II" -> 2;
			case "III" -> 3;
			case "IV" -> 4;
			case "V" -> 5;
			case "VI" -> 6;
			case "VII" -> 7;
			case "VIII" -> 8;
			case "IX" -> 9;
			case "X" -> 10;
			default -> -1; // типа exit code, -1 если число введено неверно, в методах будет проверка на это
		};
	}

	private String intToRoman(int num) {
		if (num < 1 || num > 100) {
			return "Ошибка: результат выходит за пределы допустимых значений.";
		}

		StringBuilder sb = new StringBuilder();

		while (num >= 100) {
			sb.append("C");
			num -= 100;
		}
		while (num >= 90) {
			sb.append("XC");
			num -= 90;
		}
		while (num >= 50) {
			sb.append("L");
			num -= 50;
		}
		while (num >= 40) {
			sb.append("XL");
			num -= 40;
		}
		while (num >= 10) {
			sb.append("X");
			num -= 10;
		}
		while (num >= 9) {
			sb.append("IX");
			num -= 9;
		}
		while (num >= 5) {
			sb.append("V");
			num -= 5;
		}
		while (num >= 4) {
			sb.append("IV");
			num -= 4;
		}
		while (num >= 1) {
			sb.append("I");
			num -= 1;
		}

		return sb.toString();
	}


}
