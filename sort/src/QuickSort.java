public class QuickSort {

    public int[] quickSortByLeftPivot(int[] arr, int low, int high) {
        // StackOverflow 방지 return 코드
        if(low > high) return arr;

        // 피벗은 시작 인덱스로 지정
        int pivot = arr[low];

        // 배열 위를 움직일 투포인터 준비
        int lt = low+1; int rt = high;

        while(lt <= rt) {
            // 왼쪽에서부터 포인터가 움직인다
            // 포인터가 가리키는 값이 pivot보다 작으면 문제 없음. 포인터는 계속 오른쪽으로 이동.
            // 포인터가 가리키는 값이 pivot보다 크면, 그 자리에서 멈춘다
            while(lt <= rt && arr[lt] <= pivot) {
                lt++;
            }

            // 오른쪽에서부터 포인터가 움직인다
            // 포인터가 가리키는 값이 pivot보다 크면 문제 없음. 포인터는 계속 왼쪽으로 이동.
            // 포인터가 가리키는 값이 pivot보다 작으면, 그 자리에서 멈춘다
            while(lt <= rt && arr[rt] >= pivot) {
                rt--;
            }

            // lt, rt 투포인터가 이동이 필요한 인덱스에 멈춘 상태로 대기 중인 상태
            // 두 인덱스의 값을 swap해준다
            if (lt <= rt) {
                int temp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = temp;
            }
        }

        // 위의 while문이 다 돌고 난 후
        // 포인터와 피벗이 swap 됨으로써 파티셔닝 완료
        int temp = arr[rt];
        arr[rt] = arr[low];
        arr[low] = temp;

        // 재귀호출
        quickSortByLeftPivot(arr, low, rt-1);
        quickSortByLeftPivot(arr, rt+1, high);

        return arr;

    } // quickSortByLeftPivot
}
