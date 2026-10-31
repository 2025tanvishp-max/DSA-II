
#include <iostream>
#include <vector>
#include <utility>
using namespace std;

// ==========================================
// PART A: REMOVE DUPLICATES
// ==========================================

// A1. Brute Force Approach
vector<int> removeDuplicatesBruteForce(const vector<int>& arr) {
    vector<int> uniqueArr;

    for (int i = 0; i < arr.size(); i++) {
        if (uniqueArr.empty() || arr[i] != uniqueArr.back()) {
            uniqueArr.push_back(arr[i]);
        }
    }

    return uniqueArr;
}

// A2. Optimized Two-Pointer Approach
int removeDuplicatesOptimized(vector<int>& arr) {
    if (arr.empty()) {
        return 0;
    }

    int slow = 0;

    for (int fast = 1; fast < arr.size(); fast++) {
        if (arr[fast] != arr[slow]) {
            slow++;
            arr[slow] = arr[fast];
        }
    }

    return slow + 1;
}

// ==========================================
// PART B: PAIR SUM IN SORTED ARRAY
// ==========================================

// B1. Brute Force Approach
pair<int, int> pairSumBruteForce(const vector<int>& arr, int target) {
    for (int i = 0; i < arr.size(); i++) {
        for (int j = i + 1; j < arr.size(); j++) {
            if (arr[i] + arr[j] == target) {
                return {i, j};
            }
        }
    }

    return {-1, -1};
}

// B2. Optimized Two-Pointer Approach
pair<int, int> pairSumOptimized(const vector<int>& arr, int target) {
    int left = 0;
    int right = arr.size() - 1;

    while (left < right) {
        int sum = arr[left] + arr[right];

        if (sum == target) {
            return {left, right};
        }
        else if (sum < target) {
            left++;
        }
        else {
            right--;
        }
    }

    return {-1, -1};
}

// ==========================================
// INPUT FUNCTION
// ==========================================

vector<int> readArray() {
    int n;

    cout << "Enter number of elements: ";
    cin >> n;

    vector<int> arr(n);

    cout << "Enter elements in sorted order: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    return arr;
}

// ==========================================
// PART A MENU
// ==========================================

void runRemoveDuplicates() {
    vector<int> arr = readArray();

    cout << "\n1. Brute Force\n";
    cout << "2. Optimized (Two Pointers)\n";
    cout << "Choose approach: ";

    int choice;
    cin >> choice;

    if (choice == 1) {
        vector<int> result = removeDuplicatesBruteForce(arr);

        cout << "\nUnique elements: ";
        for (int x : result) {
            cout << x << " ";
        }

        cout << "\nNumber of unique elements: " << result.size();
    }
    else if (choice == 2) {
        int k = removeDuplicatesOptimized(arr);

        cout << "\nUnique elements: ";
        for (int i = 0; i < k; i++) {
            cout << arr[i] << " ";
        }

        cout << "\nNumber of unique elements: " << k;
    }
    else {
        cout << "\nInvalid approach!";
    }

    cout << "\n";
}

// ==========================================
// PART B MENU
// ==========================================

void runPairSum() {
    vector<int> arr = readArray();

    int target;
    cout << "Enter target sum: ";
    cin >> target;

    cout << "\n1. Brute Force\n";
    cout << "2. Optimized (Two Pointers)\n";
    cout << "Choose approach: ";

    int choice;
    cin >> choice;

    pair<int, int> result;

    if (choice == 1) {
        result = pairSumBruteForce(arr, target);
    }
    else if (choice == 2) {
        result = pairSumOptimized(arr, target);
    }
    else {
        cout << "\nInvalid approach!\n";
        return;
    }

    if (result.first == -1) {
        cout << "\nNo valid pair found!";
    }
    else {
        cout << "\nPair found: "
             << arr[result.first] << " + "
             << arr[result.second] << " = "
             << target;

        cout << "\nIndices: ("
             << result.first << ", "
             << result.second << ")";
    }

    cout << "\n";
}

// ==========================================
// MAIN PROGRAM
// ==========================================

int main() {
    int choice;

    do {
        cout << "\n========== DSA-II ASSIGNMENT ==========\n";
        cout << "1. Remove Duplicates\n";
        cout << "2. Pair Sum\n";
        cout << "0. Exit\n";
        cout << "Enter your choice: ";

        cin >> choice;

        switch (choice) {
            case 1:
                runRemoveDuplicates();
                break;

            case 2:
                runPairSum();
                break;

            case 0:
                cout << "\nProgram terminated.\n";
                break;

            default:
                cout << "\nInvalid choice! Try again.\n";
        }

    } while (choice != 0);

    return 0;
}
