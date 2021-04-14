package leetcode.backtrack;

import leetcode.treeGraphs.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length==0 || nums == null)
            return null;
        List<List<Integer>> output =new ArrayList<>();
        List<Integer> intermediate = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permute(output, intermediate, nums, visited);
        return output;
    }

    private void permute(List<List<Integer>> output, List<Integer> intermediate, int[] nums, boolean[] visited) {
        if(intermediate.size()==nums.length) {
            output.add(new ArrayList<>(intermediate));
            return;
        }
        for(int i = 0; i<nums.length; i++) {
            if(visited[i])
                continue;
            intermediate.add(nums[i]);
            visited[i] = true;
            permute(output, intermediate, nums, visited);
            intermediate.remove(intermediate.size()-1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) {
        Permutations obj = new Permutations();
        int[] nums = {1,2,3};
        obj.permute(nums);
    }
}
