
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    // ==========================================
    // PART A: REMOVE DUPLICATES
    // ==========================================

    // A1. Brute Force Approach
    static List<Integer> removeDuplicatesBruteForce(int[] arr) {
        List<Integer> uniqueArr = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (uniqueArr.isEmpty() ||
                arr[i] != uniqueArr.get(uniqueArr.size() - 1)) {

                uniqueArr.add(arr[i]);
            }
        }

        return uniqueArr;
    }

    // A2. Optimized Two-Pointer Approach
    static int removeDuplicatesOptimized(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int slow = 0;

        for (int fast = 1; fast < arr.length; fast++) {
            if (arr[fast] != arr[slow]) {
                slow++;
                arr[slow] = arr[fast];
            }
        }

        return slow + 1;
    }

    // ==========================================
    // PART B: PAIR SUM
    // ==========================================

    // B1. Brute Force Approach
    static int[] pairSumBruteForce(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    // B2. Optimized Two-Pointer Approach
    static int[] pairSumOptimized(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int sum = arr[left] + arr[right];

            if (sum == target) {
                return new int[]{left, right};
            }
            else if (sum < target) {
                left++;
            }
            else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    // ==========================================
    // INPUT FUNCTION
    // ==========================================

    static int[] readArray() {

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Array size cannot be negative.");
            return new int[0];
        }

        int[] arr = new int[n];

        System.out.println("Enter elements in sorted order:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        return arr;
    }

    // ==========================================
    // PART A MENU
    // ==========================================

    static void runRemoveDuplicates() {

        int[] arr = readArray();

        System.out.println("\n1. Brute Force");
        System.out.println("2. Optimized (Two Pointers)");
        System.out.print("Choose approach: ");

        int choice = sc.nextInt();

        if (choice == 1) {

            List<Integer> result = removeDuplicatesBruteForce(arr);

            System.out.println("\nUnique elements: " + result);
            System.out.println("Number of unique elements: " + result.size());

        }
        else if (choice == 2) {

            int k = removeDuplicatesOptimized(arr);

            System.out.print("\nUnique elements: ");

            for (int i = 0; i < k; i++) {
                System.out.print(arr[i] + " ");
            }

            System.out.println("\nNumber of unique elements: " + k);

        }
        else {
            System.out.println("Invalid approach!");
        }
    }

    // ==========================================
    // PART B MENU
    // ==========================================

    static void runPairSum() {

        int[] arr = readArray();

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        System.out.println("\n1. Brute Force");
        System.out.println("2. Optimized (Two Pointers)");
        System.out.print("Choose approach: ");

        int choice = sc.nextInt();

        int[] result;

        if (choice == 1) {
            result = pairSumBruteForce(arr, target);
        }
        else if (choice == 2) {
            result = pairSumOptimized(arr, target);
        }
        else {
            System.out.println("Invalid approach!");
            return;
        }

        if (result[0] == -1) {
            System.out.println("\nNo valid pair found!");
        }
        else {
            System.out.println("\nPair found: "
                    + arr[result[0]] + " + "
                    + arr[result[1]] + " = " + target);

            System.out.println("Indices: ("
                    + result[0] + ", " + result[1] + ")");
        }
    }

    // ==========================================
    // MAIN PROGRAM
    // ==========================================

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n========== DSA-II ASSIGNMENT ==========");
            System.out.println("1. Remove Duplicates");
            System.out.println("2. Pair Sum");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    runRemoveDuplicates();
                    break;

                case 2:
                    runPairSum();
                    break;

                case 0:
                    System.out.println("\nProgram terminated.");
                    break;

                default:
                    System.out.println("\nInvalid choice! Try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
