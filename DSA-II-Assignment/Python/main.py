
# ==========================================
# PART A: REMOVE DUPLICATES
# ==========================================

# A1. Brute Force Approach
def remove_duplicates_brute_force(arr):
    unique_arr = []

    for num in arr:
        if not unique_arr or num != unique_arr[-1]:
            unique_arr.append(num)

    return unique_arr


# A2. Optimized Two-Pointer Approach
def remove_duplicates_optimized(arr):
    if len(arr) == 0:
        return 0

    slow = 0

    for fast in range(1, len(arr)):
        if arr[fast] != arr[slow]:
            slow += 1
            arr[slow] = arr[fast]

    return slow + 1


# ==========================================
# PART B: PAIR SUM
# ==========================================

# B1. Brute Force Approach
def pair_sum_brute_force(arr, target):

    for i in range(len(arr)):
        for j in range(i + 1, len(arr)):

            if arr[i] + arr[j] == target:
                return (i, j)

    return (-1, -1)


# B2. Optimized Two-Pointer Approach
def pair_sum_optimized(arr, target):

    left = 0
    right = len(arr) - 1

    while left < right:

        total = arr[left] + arr[right]

        if total == target:
            return (left, right)

        elif total < target:
            left += 1

        else:
            right -= 1

    return (-1, -1)


# ==========================================
# INPUT FUNCTION
# ==========================================

def read_array():

    n = int(input("Enter number of elements: "))

    if n < 0:
        print("Array size cannot be negative.")
        return []

    arr = list(map(int, input(
        "Enter elements in sorted order: "
    ).split()))

    if len(arr) != n:
        print("Please enter exactly", n, "elements.")
        return read_array()

    return arr


# ==========================================
# PART A MENU
# ==========================================

def run_remove_duplicates():

    arr = read_array()

    print("\n1. Brute Force")
    print("2. Optimized (Two Pointers)")

    choice = int(input("Choose approach: "))

    if choice == 1:

        result = remove_duplicates_brute_force(arr)

        print("\nUnique elements:", result)
        print("Number of unique elements:", len(result))

    elif choice == 2:

        k = remove_duplicates_optimized(arr)

        print("\nUnique elements:", arr[:k])
        print("Number of unique elements:", k)

    else:
        print("Invalid approach!")


# ==========================================
# PART B MENU
# ==========================================

def run_pair_sum():

    arr = read_array()

    target = int(input("Enter target sum: "))

    print("\n1. Brute Force")
    print("2. Optimized (Two Pointers)")

    choice = int(input("Choose approach: "))

    if choice == 1:
        result = pair_sum_brute_force(arr, target)

    elif choice == 2:
        result = pair_sum_optimized(arr, target)

    else:
        print("Invalid approach!")
        return

    if result[0] == -1:
        print("\nNo valid pair found!")

    else:
        i, j = result

        print("\nPair found:", arr[i], "+", arr[j], "=", target)
        print("Indices:", result)


# ==========================================
# MAIN PROGRAM
# ==========================================

def main():

    while True:

        print("\n========== DSA-II ASSIGNMENT ==========")
        print("1. Remove Duplicates")
        print("2. Pair Sum")
        print("0. Exit")

        choice = input("Enter your choice: ")

        if choice == "1":
            run_remove_duplicates()

        elif choice == "2":
            run_pair_sum()

        elif choice == "0":
            print("\nProgram terminated.")
            break

        else:
            print("\nInvalid choice! Try again.")


# PROGRAM EXECUTION
if __name__ == "__main__":
    main()
