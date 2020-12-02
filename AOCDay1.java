import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AOCDay1 {

    /**
     * Reads the input file of expenses.
     * 
     * @param filename name of file to read
     * @return an array of input values
     */
    public static Integer[] readFile(String fileName) {

        ArrayList<Integer> numList = new ArrayList<>();
        Scanner inFile = null;

        try {
            inFile = new Scanner(new File(fileName));
            
            while (inFile.hasNextInt()) {
                numList.add(inFile.nextInt());
            }

        } catch (IOException e) {
            System.out.println("Error reading input file: " + fileName);
            System.exit(0);

        } finally {
            if (inFile != null) {
                inFile.close();
            }
        }

        Integer[] numArray = new Integer[numList.size()]; 
        numArray = numList.toArray(numArray); 
        return numArray;     
    }
    
    public static void main(String[] args) {
        String fileName = "AOCDay1Input.txt";
        Integer[] numbers = readFile(fileName);
        int answer = 0;
        int sumSought = 2020; 

        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                if((numbers[i] + numbers[j]) == sumSought) {
                    System.out.println(numbers[i]);
                    System.out.println(numbers[j]);
                    answer = numbers[i] * numbers[j];
                }
            }
        }

        if(answer == 0) {
            System.out.println("No two numbers add up to " + sumSought);
        } else {
            System.out.println("The result is " + answer);
        }
    }
}