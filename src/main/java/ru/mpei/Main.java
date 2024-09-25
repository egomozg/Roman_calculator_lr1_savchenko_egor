package ru.mpei;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		System.out.println("---------Пример использования калькулятора--------");
		System.out.println("*******   можно вводить либо только римские (напр. X + V) *********''");
		System.out.println("*******   либо только арабские цифры (напр. 10 + 5) *********");
		System.out.println("*******   Пробелы в выражениях и регистр в римских цифрах игнорируются ******");
		System.out.println("*******   Поддерживается только одно действие ******");
		System.out.println("*******   Числа вводятся в диапазоне от 1 до 10 ******");
		System.out.println("Введите арифметическое выражение: ");
		// считывание выражения из консоли
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine().replaceAll("\\s+", ""); // Удаляем все пробелы

		// Парсинг выражения
		// Поиск оператора
		String[] operators = {"+", "-", "*", "/"};
		String operator = "";
		int operatorIndex = -1;

		for (String op : operators) {
			operatorIndex = input.indexOf(op);
			if (operatorIndex != -1) {
				operator = op;
				break;
			}
		}

		// Если оператор не найден
		if (operatorIndex == -1) {
			System.out.println("Неверный формат выражения. Оператор не найден.");
			return;
		}

		// Извлечение операндов
		String operand1 = input.substring(0, operatorIndex);
		String operand2 = input.substring(operatorIndex + operator.length());

		// Проверка наличия операндов
		if (operand1.isEmpty() || operand2.isEmpty()) {
			System.out.println("Неверный формат выражения. Отсутствуют операнды.");
			return;
		}

		// Определение системы исчисления
		NumberIdentifier numberIdentifier = new NumberIdentifier();
		boolean isArabic1 = numberIdentifier.isArabicNumber(operand1);
		boolean isArabic2 = numberIdentifier.isArabicNumber(operand2);
		boolean isRoman1 = numberIdentifier.isRomanNumber(operand1);
		boolean isRoman2 = numberIdentifier.isRomanNumber(operand1);

		if (isArabic1 && isArabic2) {
			// Арабские числа
			int num1 = Integer.parseInt(operand1);
			int num2 = Integer.parseInt(operand2);

			ArabicCalcs calculator = new ArabicCalcs(num1, num2, operator);
			String result = calculator.calculate();
			System.out.println("Результат: " + result);

		} else if (isRoman1 && isRoman2) {
			// Римские числа
			RomanCalcs calculator = new RomanCalcs(operand1, operand2, operator);
			String result = calculator.calculate();
			System.out.println("Результат: " + result);

		} else {
			System.out.println("Ошибка: операнды должны быть в одной системе счисления и в диапазоне от 1 до 10.");
		}
	}
}