import java.util.Arrays;
import java.util.Scanner;

public class biBinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = {1, 4, 2, 7, 10, 9, 12, 15, 18, 17};

        System.out.println("Array = " + Arrays.toString(evenOddSearch((arr))));
        System.out.println("Insert the number to search: ");
        int n = scanner.nextInt();

        int index = biBinarySearch(arr, n);

        System.out.println("The number " + n + " is in pos " + index);
    }

    /**
     * This method is a modified version of the binary search.
     * @param arr the array where we want find nToSearch
     * @param nToSearch the number which we want to find.
     * @return index of {@code nToSearch} param if it's contained, else returns -1.
     */
    private static int biBinarySearch(int[] arr, int nToSearch) {
        int[] orderedArr = evenOddSearch(arr);
        int start = 0, end = orderedArr.length - 1;
        boolean even = nToSearch % 2 == 0;

        // cycle while end - start == 1
        while (end - start != 1) {
            // verify if arr[start] or arr[end] are equals to nToSearch
            if (orderedArr[start] == nToSearch)
                return start;
            else if (orderedArr[end] == nToSearch)
                return end;

            if (even) {
                // verify if arr[end] is odd or grader then nToSearch
                if (orderedArr[end] % 2 != 0 || orderedArr[end] > nToSearch) {
                    // verify if the number in the middle of start and end is even and minor then nToSearch
                    if (orderedArr[end - (end - start) / 2] % 2 == 0 && orderedArr[end - (end - start) / 2] < nToSearch) {
                        // put start in the middle of start and end
                        start = end - (end - start) / 2;
                    } else {
                        // put end in the middle of start and end
                        end = end - (end - start) / 2;
                    }
                }
            } else {
                // verify if arr[start] is even or grader then nToSearch
                if (orderedArr[start] % 2 == 0 || orderedArr[start] > nToSearch) {
                    // verify if the number in the middle of start and end is odd and minor then nToSearch
                    if (orderedArr[end - (end - start) / 2] % 2 != 0 && orderedArr[end - (end - start) / 2] < nToSearch) {
                        // put end in the middle of start and end
                        end = end - (end - start) / 2;
                    }
                    else {
                        // put start in the middle of start and end
                        start = end - (end - start) / 2;
                    }
                }
            }
        }

        if (orderedArr[start] == nToSearch)
            return start;
        else if (orderedArr[end] == nToSearch)
            return end;

        return -1;
    }

    private static int[] evenOddSearch(int[] arr) {
        int[] finalArray = new int[arr.length]; // Array where there is first even and last odd numbers
        int[] evenArray = new int[arr.length]; // Array to store the even numbers
        int[] oddArray = new int[arr.length]; // Array to store the odd numbers

        int indexEven = 0, indexOdd = 0;

        // Cycle through all the elements arr
        for (int j : arr) {
            // Check if the num in pos i is even or odd
            // If even put it into evenArray
            if (j % 2 == 0) {
                evenArray[indexEven++] = j;
                // If odd put it into oddArray
            } else {
                oddArray[indexOdd++] = j;
            }
        }

        // Order the arrays with 2 calls of the method oderArray
        orderUpArray(evenArray, indexEven);
        orderDownArray(oddArray, indexOdd);

        // put the arrays, evenArray and oddArray, together.
        finalArray = mergeArrays(evenArray, indexEven, oddArray, indexOdd);

        return finalArray;
    }

    private static int[] mergeArrays(int[] arr1, int indexArr1, int[] arr2, int indexArr2) {
        int[] finalArray = new int[indexArr1 + indexArr2];
        int indexFinal = 0;

        for (int i = 0; i < indexArr1; i++) {
            finalArray[indexFinal++] = arr1[i];
        }

        for (int i = 0; i < indexArr2; i++) {
            finalArray[indexFinal++] = arr2[i];
        }

        return finalArray;
    }

    private static void orderUpArray(int[] arr, int index) {
        int numMin, posOfnMin, temp;

        for (int i = 0; i < index; i++) {
            numMin = arr[i];
            posOfnMin = i;
            // Get the minimum number
            for (int j = i; j < index; j++){
                if (arr[j] < numMin) {
                    numMin = arr[j];
                    posOfnMin = j;
                }
            }

            // switch position of the numMin with even[i]
            temp = arr[i];
            arr[i] = numMin;
            arr[posOfnMin] = temp;
        }
    }

    private static void orderDownArray(int[] arr, int index) {
        int numMax, posOfnMax = 0, temp;

        for (int i = 0; i < index; i++) {
            numMax = arr[i];
            posOfnMax = i;
            // Get the minimum number
            for (int j = i; j < index; j++){
                if (arr[j] > numMax) {
                    numMax = arr[j];
                    posOfnMax = j;
                }
            }

            // switch position of the numMin with even[i]
            temp = arr[i];
            arr[i] = numMax;
            arr[posOfnMax] = temp;
        }
    }
}
