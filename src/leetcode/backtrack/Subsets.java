package leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        permute(output, nums, new ArrayList<Integer>(), 0);
        return output;
    }

    private void permute(List<List<Integer>> output, int[] nums, ArrayList<Integer> current, int index) {
        output.add(new ArrayList<>(current));
        for(int i = index; i<nums.length; i++) {
            current.add(nums[i]);
            permute(output, nums, current, i+1);
            current.remove(current.size()-1);
        }
    }



    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Subsets obj = new Subsets();
        obj.subsets(nums);
    }

}
