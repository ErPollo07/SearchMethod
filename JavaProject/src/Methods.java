import java.util.Arrays;
import java.util.Scanner;

public class Methods {

    static int numberOfSearch = 0;
    static int whereToWrong;
    static int lastIndex;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        /* EXAMPLE FOR wrongIndexSearch */
        int[] arr = {1, 4, 5, 7, 2, 8, 100};
        int continueToInsert = 0;
        int nToSearch;
        int index;

        do {
            System.out.println("args = " + Arrays.toString(arr));
            System.out.println("Number to search: ");
            nToSearch = scanner.nextInt();

            index = wrongIndexSearch(arr, nToSearch);

            System.out.println("Press 1 to continue: ");
            continueToInsert = scanner.nextInt();
        } while (continueToInsert == 1);
        /* END EXAMPLE FOR wrongIndexSearch */
    }

    private static int wrongIndexSearch(int[] arr, int nToSearch) {


        // Cycle all the element of arr
            // If the arr[i] is nToSearch
                // if numberOfSearch is grader then 3 AND if whereToWrong is different from 0
                    // assign to a random number between 3 and 5
                // if whereToWrong is equal to numberOfSearch
                    // return lastIndex
                // else
                    // return i

        return 0;
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
        int numMin, posOfnMin = 0, temp;

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

    private static int biBinarySearch(int[] arr, int nToSearch) {
        arr = evenOddSearch(arr);
        int start = 0, end = arr.length - 1;
        boolean even = nToSearch % 2 == 0;


        // cycle while end - start == 1
        while (end - start != 1) {
            // verify if arr[start] or arr[end] are equals to nToSearch
            if (arr[start] == nToSearch)
               return start;
            else if (arr[end] == nToSearch)
                return end;

            if (even) {
                // verify if arr[end] is odd or grader then nToSearch
                if (arr[end] % 2 != 0 || arr[end] > nToSearch) {
                    // verify if arr[end - ((end - start) / 2)] is even and minor then nToSearch
                    if (arr[end - (end - start) / 2] % 2 == 0 && arr[end - (end - start) / 2] < nToSearch) {
                        // put start = end - ((end - start) / 2)
                        start = end - (end - start) / 2;
                    } else {
                        // put end = end - ((end - start) / 2)
                        end = end - (end - start) / 2;
                    }
                }
            } else {
                // verify if arr[start] is even or grader then nToSearch
                if (arr[start] % 2 == 0 || arr[start] > nToSearch) {
                    // verify if arr[end - ((end - start) / 2)] is odd and minor then nToSearch
                    if (arr[end - (end - start) / 2] % 2 != 0 && arr[end - (end - start) / 2] < nToSearch) {
                        // put end = end - ((end - start) / 2)
                        end = end - (end - start) / 2;
                    }
                    else {
                        // put start = end - ((end - start) / 2)
                        start = end - (end - start) / 2;
                    }
                }
            }
        }

        if (arr[start] == nToSearch)
            return start;
        else if (arr[end] == nToSearch)
            return end;

        return -1;
    }
}
