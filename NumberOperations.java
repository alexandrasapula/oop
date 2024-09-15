import java.util.ArrayList;
import java.util.Arrays;


public class NumberOperations
{
    public static void main(String[] args)
    {
        // Initial list
        ArrayList<Number> numberList  = new ArrayList<>(Arrays.asList(10, 20.5, 30, 40.7, 50, 60.3, 70, 80.1, 90, 100.9));

        // Task 1 and 2
        Integer integerNumber  = 23;
        Double doubleNumber  = 3.57;
        Byte byteNumber  = (byte) 4;
        Short shortNumber  = (short) 32;
        Long longNumber  = 40L;
        Float floatNumber  = 5.67F;

        numberList.addAll(Arrays.asList(integerNumber, doubleNumber, byteNumber, shortNumber, longNumber, floatNumber));

        // Task 4
        System.out.println("All numbers: " + numberList);

        // Task 5 and 6
        processNumbers(numberList);


        // Task 7
        splitByType(numberList);


        // My Task
        ArrayList<Number> initialNumberList  = new ArrayList<>(Arrays.asList(10, 20.5, 30, 40.7, 50, 60.3, 70, 80.1, 90, 100.9));
        extractIntegers(initialNumberList);
    }

    private static void processNumbers(ArrayList<Number> numbers)
    {
        // Function for task 5 and 6
        ArrayList<Integer> integers  = new ArrayList<>();
        ArrayList<String> formattedDoubles  = new ArrayList<>();
        ArrayList<Integer> roundedNumbers  = new ArrayList<>();

        for (Number num : numbers)
        {
            integers.add(num.intValue());
            formattedDoubles.add(String.format("%.2f", num.doubleValue()));
            roundedNumbers.add(Math.round(num.floatValue()));
        }

        System.out.println("Integers: " + integers);
        System.out.println("Doubles: [" + String.join(", ", formattedDoubles) + "]");
        System.out.println("Rounded numbers: " + roundedNumbers);
    }

    private static void splitByType(ArrayList<Number> numbers)
    {
        // Function for task 7
        ArrayList<Integer> onlyIntegers = new ArrayList<>();
        ArrayList<Double> onlyDoubles = new ArrayList<>();
        ArrayList<Float> onlyFloat = new ArrayList<>();

        for (Number num : numbers)
        {
            if (num instanceof Integer)
            {
                onlyIntegers.add(num.intValue());
            }
            else if (num instanceof Double)
            {
                onlyDoubles.add(num.doubleValue());
            }
            else if (num instanceof Float)
            {
                onlyFloat.add(num.floatValue());
            }
        }

        System.out.println("Array of integers: " + onlyIntegers);
        System.out.println("Array of doubles: " + onlyDoubles);
        System.out.println("Array of floats: " + onlyFloat);
    }

    private static void extractIntegers(ArrayList<Number> numbers)
    {
        // Function for my task
        ArrayList<Integer> intNumbers = new ArrayList<>();
        for (Number num : numbers)
        {
            if (num instanceof Integer)
            {
                intNumbers.add(num.intValue());
            }
        }
        System.out.println("Array of integers from the initial list: " + intNumbers);
    }
}
