import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean checkPalindrome(String str);
}

// Stack Strategy
class StackStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String str) {

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Deque Strategy
class DequeStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String str) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {

            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}

// Context Class
class PalindromeContext {

    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String str) {
        return strategy.checkPalindrome(str);
    }
}

// Main Class
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Palindrome Checker using Strategy Pattern");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");

        System.out.print("Choose strategy: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter a word: ");
        String input = sc.nextLine();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        PalindromeContext context = new PalindromeContext(strategy);

        if (context.executeStrategy(input)) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is Not a Palindrome");
        }

        sc.close();
    }
}