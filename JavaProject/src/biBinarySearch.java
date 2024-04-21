import java.util.Arrays;
import java.util.Scanner;

public class biBinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = {1, 4, 2, 7, 10, 9, 12, 15, 18, 17};

        System.out.println("Array = " + Arrays.toString(evenOddSearch.evenOddSearch((arr))));
        System.out.println("Insert the number to search: ");
        int n = scanner.nextInt();

        int index = biBinarySearch(arr, n);

        System.out.println("The number " + n + " is in pos " + index);
    }

    private static int biBinarySearch(int[] arr, int nToSearch) {
        int[] orderedArr = evenOddSearch.evenOddSearch(arr);
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
}
