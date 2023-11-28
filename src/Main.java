import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args)  {
        System.out.println("Введите пример формата a + b, a - b, a * b, a / b");
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println (calc(scan.nextLine()));
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e) {
            System.out.println("throws Exception //т.к. строка не является математической операцией");
        }
        catch (NoSuchElementException e) {
            System.out.println("throws Exception //т.к. строка не соответсвует формату математической операции (два операнда и оператор)");
        }
    }
    public static String calc (String input) throws FileNotFoundException {

        Scanner scanner = new Scanner(input);
        int number1 = 0;
        int number2 = 0;
        String operators = "+ - / *";
        String operator = "";
        String resultOfOperation = "";

        String operand1 = scanner.next();
        operator = scanner.next();

        if (!operators.contains(operator)) {
            //исключение о том, что операция не является математической
            throw new FileNotFoundException("throws Exception //т.к. строка не является математической операцией");
        }

        String operand2 = scanner.next();

        if (operand1.matches("-?\\d+") && operand2.matches("-?\\d+")) {

            number1 = Integer.parseInt(operand1);
            //проверка на совпадение с условием задачи о приёме на вход чисел от 1 до 10 включительно
            if (number1 > 10 || number1 < 1)
                throw new FileNotFoundException("throws Exception //т.к. число не удовлетворяет условиям задания (значение от 1 до 10 включительно)");

            number2 = Integer.parseInt(operand2);
            //проверка на совпадение с условием задачи о приёме на вход чисел от 1 до 10 включительно
            if (number2 > 10 || number2 < 1)
                throw new FileNotFoundException("throws Exception //т.к. число не удовлетворяет условиям задания (значение от 1 до 10 включительно)");

        }

        if (scanner.hasNext())
            throw new FileNotFoundException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

        switch (operator) {
            case "+" -> resultOfOperation = String.valueOf(number1 + number2);
            case "-" -> resultOfOperation = String.valueOf(number1 - number2);
            case "*" -> resultOfOperation = String.valueOf(number1 * number2);
            case "/" -> resultOfOperation = String.valueOf(number1 / number2);
        }


        return resultOfOperation;

    }
}