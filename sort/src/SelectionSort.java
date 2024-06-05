public class SelectionSort {

    private void selectionSort(int[] arr) {
        // 최소값을 찾아 정렬하는 방법
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIdx] > arr[j]) {
                    int temp = arr[minIdx];
                    arr[minIdx] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
