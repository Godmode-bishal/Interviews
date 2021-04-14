package Oracle;

public class Rotate {
    void RotateByOne(int[] arr, int k) {
        int temp;
        int size = arr.length;
        temp = arr[0];
        for(int i = 0; i<k; i++)
        {
            for(int j = 1; j<size; j++) {
                arr[j-1] = arr[j];
            }
            arr[size-1] = temp;
        }
    }

    public static void main(String[] args) {
        Rotate obj = new Rotate();
        obj.RotateByOne(new int[]{1,2,3,4,5,6,7}, 2);

    }
}
