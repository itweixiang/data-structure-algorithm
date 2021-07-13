package top.itweixiang;

public class NC68 {
    public int jumpFloor(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;
        int[] arr = new int[target];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < target; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[target - 1];
    }
}
