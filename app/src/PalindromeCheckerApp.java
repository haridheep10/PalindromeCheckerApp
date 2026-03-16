import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        String input = sc.nextLine();

        char[] arr = input.toCharArray();

        int start = 0;
        int end = arr.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (arr[start] != arr[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        System.out.println("Input : " + input);
        System.out.println("IsPalindrome : " + isPalindrome);

        sc.close();
    }
}