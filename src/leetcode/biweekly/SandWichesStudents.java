package leetcode.biweekly;

public class SandWichesStudents {
    public int countStudents(int[] students, int[] sandwiches) {
        /*if(sandwiches.length==0)
            return students.length;
        int flag = 0;
        int temp;
        int i =0,j;
        while(flag<students.length-i && i<students.length) {
            if(students[i]==sandwiches[i]) {
                i++;
                flag = 0;
            }
            else {
                temp = students[i];
                for(j = i+1; j<students.length; j++) {
                    students[j-1] = students[j];
                }
                students[j-1] = temp;
                flag++;
            }
        }
        return students.length-i;*/
        int oneCount = 0, zeroCount = 0;
        for(int i = 0; i<students.length; i++) {
            if(students[i]==0)
                zeroCount++;
            else
                oneCount++;
        }
        int i = 0;
        while(i<sandwiches.length){
            if (sandwiches[i] == 0) {
                zeroCount--;
            } else {
                oneCount--;
            }
            if(zeroCount==-1 || oneCount==-1)
                break;
            i++;
        }
        return sandwiches.length-i;
    }
}
