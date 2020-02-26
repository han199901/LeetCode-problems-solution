class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> r = new LinkedList<List<Integer>>();
        for (int i = 0; i < nums.length - 3; ) {
            for (int j = i + 1; j < nums.length - 2; ) {
                int start = j + 1, end = nums.length - 1;
                int t = nums[i] + nums[j] + nums[start] + nums[end] - target;
                while (start < end) {
                    t = nums[i] + nums[j] + nums[start] + nums[end] - target;
                    if (t == 0) {
                        LinkedList<Integer> bingo = new LinkedList<Integer>();
                        bingo.add(nums[i]);
                        bingo.add(nums[j]);
                        bingo.add(nums[start]);
                        bingo.add(nums[end]);
                        r.add(bingo);
                        while (start < end && nums[start] == nums[++start]) ;
                    } else if (t > 0)
                        while (start < end && nums[end] == nums[--end]) ;
                    else
                        while (start < end && nums[start] == nums[++start]) ;
                }
                while (j < nums.length - 2 && nums[j] == nums[++j]) ;
            }
            while (i < nums.length - 3 && nums[i] == nums[++i]) ;
        }
        return r;
    }
}