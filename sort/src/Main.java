import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 배열 생성
        int[] arr = new int[N];

        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        QuickSort quickSort = new QuickSort();
        quickSort.quickSortByLeftPivot(arr, 0, arr.length-1);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

} // class