public class QuickSort {

    private void quickSort(int[] arr, int lt, int rt) {
        if(lt < rt) {
            int pivotIdx = partition(arr, lt, rt);
            quickSort(arr, lt, pivotIdx - 1);
            quickSort(arr, pivotIdx + 1, rt);
        }
    }

    private int partition(int[] arr, int lt, int rt) {
        int pivot = arr[lt];

        int i = lt; int j = rt; // 움직일 포인터들

        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }

            while (i < j && arr[i] <= pivot) {
                i++;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[lt];
        arr[lt] = arr[i];
        arr[i] = temp;

        return i;
    }
}
