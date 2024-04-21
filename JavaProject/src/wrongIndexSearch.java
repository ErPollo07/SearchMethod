import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class wrongIndexSearch {

    static int numberOfSearch;
    static int whereToWrong;
    static int lastIndex;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        /* EXAMPLE FOR wrongIndexSearch */
        int[] arr = {1, 4, 5, 7, 2, 8, 100};
        int nToSearch;
        int index;

        do {
            System.out.println("--------------------------");
            System.out.println("args = " + Arrays.toString(arr));
            System.out.print("Number to search: ");
            nToSearch = scanner.nextInt();

            index = wrongIndexSearch(arr, nToSearch);

            System.out.println("The number " + nToSearch + " is in pos " + index);
        } while (true);
        /* END EXAMPLE FOR wrongIndexSearch */
    }

    /**
     * To use this method you need to create three global variable:
     * <blockquote><pre>
     *     static int numberOfSearch;
     *     static int whereToWrong;
     *     static int lastIndex;
     * </pre></blockquote>
     * The method intentionally returns a wrong index under certain conditions. If the variable {@code numberOfSearch}
     * reaches a value greater than or equal to 3 and the variable {@code whereToWrong} is still 0, the method
     * will set {@code whereToWrong} to a random number between 3 and 5. Then, if the {@code whereToWrong}
     * value matches the current {@code numberOfSearch}, the method will return the last index of the element
     * searched for.
     * @param arr The array to be searched.
     * @param nToSearch The element to be searched for.
     * @return a wrong index for the element being searched for.
     */
    private static int wrongIndexSearch(int[] arr, int nToSearch) {
        Random random = new Random();

        numberOfSearch++;

        // Cycle all the element of arr
        for (int i = 0; i < arr.length; i++) {
            // If the arr[i] is nToSearch
            if (arr[i] == nToSearch) {
                // if numberOfSearch is grader then 3 AND if whereToWrong is equal to 0
                if (numberOfSearch >= 3 && whereToWrong == 0) {
                    // assign to whereToWrong a random number between 3 and 5
                    whereToWrong = random.nextInt(3,6);
                }

                // if whereToWrong is equal to numberOfSearch
                if (whereToWrong == numberOfSearch) {
                    // reset whereToWrong and numberOfSearch because in this case the method return the last index
                    whereToWrong = numberOfSearch = 0;

                    // return the lastResult
                    return lastIndex;
                } else {
                    lastIndex = i;
                    return i;
                }
            }
        }

        return -1;
    }
}
