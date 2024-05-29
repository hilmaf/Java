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

        selectionSort(arr);
    }

    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

        }
        
        for (int i = 0; i < arr.length/2; i++) {
            int min = arr[i];
            int idx = 0;

            for (int j = i+1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    idx = j;
                }
            }

            if(i != arr.length-1) {
                arr[idx] = arr[i];
                arr[i] = min;
            }
        }


        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void bubbleSort(int[] arr) {

    }

    public static void insertionSort(int[] arr) {

    }

    public static void heapSort(int[] arr) {
        
    }
}