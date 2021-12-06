import java.util.*;

public class Equals {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String exp = in.nextLine();

        System.out.println(calculate(exp));
    }


    public static double calculate(String exp) {
        String[] expSplit = exp.split(""); // Arrays.toString()

        String[] operations = {};
        String[] numbers = {};

        String number = "";
        for (int i = 0; i < expSplit.length; i++) {
            //System.out.println(expSplit.length + " " + i + " " + expSplit[i]);
            String x = expSplit[i];
            if (!(x.equals("+") || x.equals("-") || x.equals("/") || x.equals("*"))) {
                number += x;
            } else {
                if (!(i + 1 == expSplit.length || i == 0)) {
                    operations = addToEnd(operations, x);
                    numbers = addToEnd(numbers, number);
                    number = "";
                }
            }
        }
        numbers = addToEnd(numbers, number);

        if (numbers.length == 1) {
            return Double.parseDouble(numbers[0]);
        } else if (numbers.length < 1) {
            return 0;
        }

        for (int i = 0; i < operations.length; i++) {
            String x = operations[0];
            String result;
            switch (x) {
                case "+":
                    result = String.valueOf(Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]));
                    numbers = removeWithIndex(numbers, 0);
                    numbers = removeWithIndex(numbers, 0);
                    numbers = addToStart(numbers, result);
                    operations = removeWithIndex(operations, 0);
                    break;
                case "-":
                    result = String.valueOf(Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]));
                    numbers = removeWithIndex(numbers, 0);
                    numbers = removeWithIndex(numbers, 0);
                    numbers = addToStart(numbers, result);
                    operations = removeWithIndex(operations, 0);
                    break;
                case "*":
                    result = String.valueOf(Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]));
                    numbers = removeWithIndex(numbers, 0);
                    numbers = removeWithIndex(numbers, 0);
                    numbers = addToStart(numbers, result);
                    operations = removeWithIndex(operations, 0);
                    break;
                case "/":
                    result = String.valueOf(Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]));
                    numbers = removeWithIndex(numbers, 0);
                    numbers = removeWithIndex(numbers, 0);
                    numbers = addToStart(numbers, result);
                    operations = removeWithIndex(operations, 0);
                    break;
            }
        }
        return Double.parseDouble(numbers[0]);
    }


    public static String[] addToEnd(String[] arr, String x) {
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        list.add(x);
        return list.toArray(arr);
    }


    public static String[] addToStart(String[] arr, String x) {
        Deque<String> deque = new LinkedList<String>();
        deque.addAll(Arrays.asList(arr));
        deque.addFirst(x);
        return deque.toArray(arr);
    }


    public static String[] removeWithIndex(String[] arr, int index) {
        List<String> list = new ArrayList<>(Arrays.asList(arr));
        list.remove(index);
        return list.toArray(arr);
    }
}
