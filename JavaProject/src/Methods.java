public class Methods {
    public static void main(String[] args) {

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

        // Cycle through all the elemnts arr
        for (int i = 0; i < arr.length; i++) {
            // Check if the num in pos i is even or odd
            // If even put it into evenArray
            if (arr[i] % 2 == 0) {
                evenArray[indexEven++] = arr[i];
            // If odd put it into oddArray
            } else {
                oddArray[indexOdd++] = arr[i];
            }
        }

        // Order the arrays with 2 calls of the method oderArray
        orderArray(evenArray, indexEven);
        orderArray(oddArray, indexOdd);

        // put the arrays, evenArray and oddArray, together.

        return finalArray;
    }

    private static void orderArray(int[] arr, int index) {
        int numMin, posOfnMin, temp;

        for (int i = 0; i < index; i++) {
            numMin = arr[i];
            // Get the minimum number
            for (int j = i; j < index; j++){
                if (arr[i] < numMin) {
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

    private static void biBinarySearch() {

    }
}
