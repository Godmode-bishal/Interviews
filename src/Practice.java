import amazon.TreeNode;
public class Practice {
    public void rotate(int[] nums, int k) {
        if(nums.length==0 || nums == null) {
            return;
        }
        int len = nums.length, temp = 0;
        int gcd = findGCD(len, k);
        for(int i = 0; i<len-gcd; i++) {
            for(int j = 0; j*k<len; j++) {
                temp = nums[i+j*k];
                nums[i+j*k] = nums[i+(j-1)*k];
            }
            nums[i] = temp;
        }
    }

    private int findGCD(int len, int k) {
        int ret = 1;
        for(int i = len<k?len:k; i>=2; i--) {
            if(len%i==0 && k%i==0) {
                return i;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        Practice obj = new Practice();
        obj.rotate(nums,3);
    }
}
