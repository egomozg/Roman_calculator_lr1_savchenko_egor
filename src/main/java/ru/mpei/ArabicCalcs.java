package ru.mpei;

public class ArabicCalcs extends Calculations{

	private int operand1;
	private int operand2;
	private String operator;
	private boolean isValid;

	public ArabicCalcs(int operand1, int operand2, String operator) {
		if (operand1 < 1 || operand1 > 10 || operand2 < 1 || operand2 > 10) {
			this.isValid = false;
		} else {
			this.isValid = true;
			this.operand1 = operand1;
			this.operand2 = operand2;
		}
		this.operator = operator;
	}

	@Override
	public String addition(){
		if (!isValid){
			return "Ошибка: число должно быть в диапазоне от 1 до 10";
		}
		int result = operand1 + operand2;
		return String.valueOf(result);
	}

	@Override
	public String subtraction(){
		if (!isValid){
			return "Ошибка: число должно быть в диапазоне от 1 до 10";
		}
		int result = operand1 - operand2;
		if (result < 0){
			return "Ошибка: результат меньше нуля";
		}
		return String.valueOf(result);
	}

	@Override
	public String multiplication(){
		if (!isValid){
			return "Ошибка: число должно быть в диапазоне от 1 до 10";
		}
		int result = operand1 * operand2;
		return String.valueOf(result);
	}

	@Override
	public String division(){
		if (!isValid){
			return "Ошибка: число должно быть в диапазоне от 1 до 10";
		}
		if (operand2 == 0){
			return "Ошибка: деление на 0";
		}
		int result = operand1 / operand2;
		return String.valueOf(result);
	}

	@Override
	public String calculate(){
		return switch (operator){
			case "+" -> addition();
			case "-" -> subtraction();
			case "*" -> multiplication();
			case "/" -> division();
			default -> "неверный оператор";
		};
	}
}
