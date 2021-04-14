package prudential;

import java.util.List;

public class Result3 {
    public static int minDeletions(List<Integer> arr) {
        int result = 0;
        int[] tempList = new int[arr.size()];
        int listSize = arr.size();
        for (int i = 0; i < listSize; i++ )
            tempList[i] = 1;
        for (int i = 1; i < listSize; i++ )
            for (int j = 0; j < i; j++ )
                if ( arr.get(i) > arr.get(j) && tempList[i] < tempList[j] + 1)
                    tempList[i] = tempList[j] + 1;

        for (int i = 0; i < listSize; i++ )
            if (result < tempList[i])
                result = tempList[i];
        if(result == 0 || result ==1) {
            return 0;
        }
        return result-1;
    }
}
