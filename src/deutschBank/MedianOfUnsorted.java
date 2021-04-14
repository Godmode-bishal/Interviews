package deutschBank;

public class MedianOfUnsorted {
    static int a,b;

    //Utility function to swap elements
    static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    static int partition(int[] arr, int l, int r) {
        int lst =arr[r],i = 1,j=1;
        while(j<r) {
            if(arr[j]<lst) {
                arr = swap(arr,i,j);
                i++;
            }
            j++;
        }
        arr = swap(arr,i,r);
        return i;
    }

    /**
     * Picks a random pivot element between l and r and partitions arr[l...r] around the randomly picked element using partition()
     */
    static int randomPartition(int arr[], int l, int r) {
        int n = r-l + 1;
        int pivot = (int) Math.random()%n;
        arr = swap(arr, l+pivot, r);
        return partition(arr, l, r);
    }

    //Utility function to find median
    static int medianUtil(int arr[], int l, int r, int k) {
        if(l<=r) {
            int partitionIndex = randomPartition(arr,l,r);
            // If partion index = k, then
            // we found the median of odd
            // number element in arr[]
            if(partitionIndex==k) {
                b = arr[partitionIndex];
                if(a!=-1)
                    return Integer.MIN_VALUE;
            }
            // If index = k - 1, then we get
            // a & b as middle element of
            // arr[]
            else if(partitionIndex == k-1) {
                a = arr[partitionIndex];
                if(b!=-1)
                    return Integer.MIN_VALUE;
            }
            // If partitionIndex >= k then
            // find the index in first half
            // of the arr[]
            if(partitionIndex >= k)
                return medianUtil(arr, l, partitionIndex-1, k);
            // If partitionIndex <= k then
            // find the index in second half
            // of the arr[]
            else
                return medianUtil(arr, partitionIndex+1, r, k);
        }
        return Integer.MIN_VALUE;
    }

    static void findMedian(int[] arr, int n) {
        int ans;
        a = -1;
        b = -1;
        if(n%2==1) {
            medianUtil(arr, 0, n-1, n/2);
            ans = b;
        }
        else {
            medianUtil(arr,0,n-1,n/2);
            ans = (a+b)/2;
        }
        System.out.println("Median = "+ans);
    }

    public static void main(String[] args)
    {
        int arr[] = { 12, 3, 5, 7, 4, 19, 26 };
        int n = arr.length;
        findMedian(arr, n);
    }
}
