package fall23.Week2;

/**
 * Sum of Multiples of 3 or 5.
 *
 * In this week's club challenge, find the sum of each multiple of either 3 or 5, with the condition that the multiple is less than 1000.
 *      eg. For multiples of 3 or 5 below 10, the answer would be the 3 + 5 + 6 + 9 = 23.
 *
 * Credit: Project Euler Problem 1.
 */
public class Week2 {

    /**
     * HINT: Solution 1 uses 1000 iterations in 1 loop. 
     */
    public static int problem1() {
        int sum = 0;

        for(int i = 0; i < 1000; i++) {
            if(i % 5 == 0 || i % 3 == 0) sum += i;
        }

        return sum;
    }

    /**
     * BONUS CHALLENGE: Find a more efficient solution for problem 1 (ie. a solution that uses less than 1000 iterations).
     */
    public static int problem2() {
        int sum = 0;
        for(int i = 5; i < 1000; i+=5)
            sum += i;

        for(int i = 3; i < 1000; i+=3) 
            if(i % 5 != 0) sum += i;

        return sum;
    }

    /**
     * Test driver should not be edited!
     */
    public static void main(String[] args) {
        int sum1 = problem1();
        int sum2 = problem2();

        System.out.println(sum1 == 233168 ? "Problem 1 is correct!" : "Problem 1 (" + sum1 + ") is not correct...");
        System.out.println(sum2 == 233168 ? "Problem 2 is correct!" : "Problem 2 (" + sum2 + ") is not correct...");
    }
}
