import java.util.Scanner;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read input
        String input = sc.nextLine();

        // Create LinkedList
        LinkedList<Character> list = new LinkedList<>();

        // Insert characters into linked list
        for (int i = 0; i < input.length(); i++) {
            list.add(input.charAt(i));
        }

        boolean isPalindrome = true;

        // Compare first and last elements
        while (list.size() > 1) {
            if (!list.removeFirst().equals(list.removeLast())) {
                isPalindrome = false;
                break;
            }
        }

        // Output
        System.out.println("Input : " + input);
        System.out.println("IsPalindrome : " + isPalindrome);
        System.out.println("--");

        sc.close();
    }
}