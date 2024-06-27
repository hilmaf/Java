import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionSort {

    private void collectionSort(int[] arr) {
        List<Integer> list = new ArrayList<>();

        for (int x : arr) {
            list.add(x);
        }

        Collections.sort(list);

    }

    private void arraySort(int[] arr) {
        Arrays.sort(arr);
    }
}
