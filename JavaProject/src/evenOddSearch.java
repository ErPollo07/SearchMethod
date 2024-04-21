import java.util.Arrays;

public class evenOddSearch {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 7, 10, 9, 12, 15, 18, 17};
        int[] dest;

        dest = evenOddSearch(arr);

        System.out.println("Final array = " + Arrays.toString(dest));
    }

    public static int[] evenOddSearch(int[] arr) {
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
