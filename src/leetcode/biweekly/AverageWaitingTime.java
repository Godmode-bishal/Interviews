package leetcode.biweekly;

public class AverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        /*java.util.Arrays.sort(customers, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                int result = Integer.compare(a[0],b[0]);
                if(result==0)
                    result = Integer.compare(a[1],b[1]);
                return result;
            }
        });*/

        int numOfCustomers = customers.length;
        int endTime = customers[0][0];
        int waitTime = 0;
        for(int i = 0; i<numOfCustomers; i++) {
            if(customers[i][0]<=endTime) {
                endTime +=  customers[i][1];
            }
            else {
                endTime = customers[i][0] + customers[i][1];
            }
            waitTime += (endTime-customers[i][0]);
        }
        return ((double)waitTime/(double)numOfCustomers);
    }
}
