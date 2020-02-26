class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> r = new LinkedList<>();
        Arrays.sort(nums);
        for(int i=0; i< nums.length-2; i++) {
            int j=i+1,k= nums.length-1;
            if(nums[i]>0)
                break;
            if(i>0&&nums[i]==nums[i-1])//去重
                continue;
            while(j<k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    while (j < k && nums[j] == nums[++j]) ;//找到下一个不相同的数字
                } else if (sum > 0) {
                    while (j < k && nums[k] == nums[--k]) ;
                } else {
                    List<Integer> t = new LinkedList<>();
                    t.add(nums[i]);
                    t.add(nums[j]);
                    t.add(nums[k]);
                    r.add(t);
                    while (j < k && nums[j] == nums[++j]) ;
                    while (j < k && nums[k] == nums[--k]) ;
                }
            }
        }
        return r;
    }
}