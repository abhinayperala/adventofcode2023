
/*--- Day 1: Trebuchet?! ---
Something is wrong with global snow production, and you've been selected to take a look. The Elves have even given you a map; on it, they've used stars to mark the top fifty locations that are likely to be having problems.

You've been doing this long enough to know that to restore snow operations, you need to check all fifty stars by December 25th.

Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!

You try to ask why they can't just use a weather machine ("not powerful enough") and where they're even sending you ("the sky") and why your map looks mostly blank ("you sure ask a lot of questions") and hang on did you just say the sky ("of course, where do you think snow comes from") when you realize that the Elves are already loading you into a trebuchet ("please hold still, we need to strap you in").

As they're making the final adjustments, they discover that their calibration document (your puzzle input) has been amended by a very young Elf who was apparently just excited to show off her art skills. Consequently, the Elves are having trouble reading the values on the document.

The newly-improved calibration document consists of lines of text; each line originally contained a specific calibration value that the Elves now need to recover. On each line, the calibration value can be found by combining the first digit and the last digit (in that order) to form a single two-digit number.

For example:

1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet
In this example, the calibration values of these four lines are 12, 38, 15, and 77. Adding these together produces 142.

Consider your entire calibration document. What is the sum of all of the calibration values?*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class main {
    public static void main(String[] args) {
        // Specify the path to your .txt file
        String filePath = "testcase.txt";

        // Create an ArrayList to store the strings
        ArrayList<String> stringList = new ArrayList<>();

        try {
            // Open the file using BufferedReader
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            // Read each line and add it to the ArrayList
            String line;
            while ((line = reader.readLine()) != null) {
                stringList.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int sum = 0;
        for (int i = 0; i < stringList.size(); i++) {
            String s1 = new String();
            s1 = stringList.get(i);
            ArrayList<Integer> arr = new ArrayList<Integer>();
            for (int j = 0; j < s1.length(); j++) {
                String str = new String();
                if (Character.isDigit(s1.charAt(j))) {
                    str += s1.charAt(j);
                    arr.add(Integer.parseInt(str));
                }
            }
            if (arr.size() == 1) {
                String sr = new String();
                sr += Integer.toString(arr.get(0));
                sr += Integer.toString(arr.get(0));
                sum += Integer.parseInt(sr);
                continue;
            }
            String stre = new String();
            stre += Integer.toString(arr.get(0)) + Integer.toString(arr.get(arr.size() - 1));
            sum += Integer.parseInt(stre);

        }
        System.out.println(sum);
    }
}

// Solution is : 55834