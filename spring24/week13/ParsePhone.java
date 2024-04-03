import java.io.File;
import java.util.Scanner;

/**
 * This challenge is inspired from LeetCode Problem 193.
 *
 * Given an input file called "inut.txt" that contains a list of potential
 * phone numbers on each line, determine if each line is a valid phone number.
 *
 * A valid phone number is defined as any sequence of digits that has the
 * following characteristics:
 * 1. It may contain a '+' at the start of the string, for the international
 *   dialing code. The '+' is optional.
 *
 * 2. It may contain a '-' in the string, to separate the country code, area
 *   code, and local number. The '-' is optional.
 *
 * 3. It may contain a '(' and ')' in the string, to enclose the area code.
 */
public class ParsePhone {
    private static boolean isValidNumber(String number) {
        return false; // TODO: Implement this method
    }

    public static void main(String[] args) {
        File input = new File("input.txt");

        if(input.exists() == false) {
            System.out.println("File not found");
            return;
        }

        try {
            Scanner sc = new Scanner(input);

            while(sc.hasNextLine()) {
                String number = sc.nextLine();
                System.out.println(isValidNumber(number) ? number : "Invalid");
            }

            sc.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
