public class Methods {
    public static void main(String[] args) {
        int[] testArr = {1, 2, 3, 7, 5, 6, 4};
        int[] destArray = new int[testArr.length];

        destArray = evenOddSearch(testArr);
    }

    private static void wrongIndexSearch() {

    }

    /*
    Creare il metodo evenOddSearch che dato un vettore,
    ordini i numeri pari in modo crescente e i dispari in modo decrescente,
    disposti nella sequenza:
    - pari crescente
    - dispari decrescente
    Esempio del contenuto dell'array: 3,4,2,5,6,1,7,8,9 --> 2,4,6,8,9,7,5,3,1
    */
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

    private static void biBinarySearch(int[] arr, int nToSearch) {
        // e = end
        // s = start

        // cycle while end - start == 1
            // verify if arr[s] or arr[e] are the nToSearch

            // verify if arr[e] is odd or grader then nToSearch
                // verify if arr[e - ((e - s) / 2)] is eve n and minor then nToSearch
                    // put s = e - ((e - s) / 2)
                // else
                    // put e = e - ((e - s) / 2)
    }
}
