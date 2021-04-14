package goldman;

public class ProductDigit {
    static boolean checkIfUnEqual(int n, int q) {
        String s1 = Integer.toString(n);
        int[] nums = new int[10];
        for(int i = 0; i<s1.length(); i++) {
            nums[s1.charAt(i)-'0']++;
        }
        int prod = n*q;
        String s2 = Integer.toString(prod);
        for(int i = 0; i<s2.length(); i++) {
            if(nums[s2.charAt(i)-'0']>0)
                return false;
        }
        return true;
    }
    static int countInRange(int l, int r, int q) {
        int count = 0;
        for(int i = l; i<=r; i++) {
            if(checkIfUnEqual(i,q))
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(ProductDigit.countInRange(5,15,2));
    }
}
