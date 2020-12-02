/*--- Part Two ---
The Elves in accounting are thankful for your help; one of them even offers you a starfish coin they had left over from a past vacation. They offer you a second one if you can find three numbers in your expense report that meet the same criteria.

Using the above example again, the three entries that sum to 2020 are 979, 366, and 675. Multiplying them together produces the answer, 241861950.

In your expense report, what is the product of the three entries that sum to 2020?
*/

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AOCDay1Part2 {

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

        for(int i = 0; i < numbers.length - 2; i++) {
            for(int j = i + 1; j < numbers.length - 1; j++) {
                for(int k = j + 1; k < numbers.length; k++) {

 
                    if((numbers[i] + numbers[j] + numbers[k]) == sumSought) {
                        System.out.println(numbers[i]);
                        System.out.println(numbers[j]);
                        System.out.println(numbers[k]);
                        answer = numbers[i] * numbers[j] * numbers[k];
                    }
                }
            }
        }

        if(answer == 0) {
            System.out.println("No three numbers add up to " + sumSought);
        } else {
            System.out.println("The result is " + answer);
        }
    }
}