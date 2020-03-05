class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        for (int i = 0; candies != 0; i++) {
            int x = i+1;
            candies -= x;
            if (candies > 0)
                ans[i % num_people] += x;
            else {
                ans[i % num_people] += (x + candies);
                candies = 0;
            }
        }
        return ans;
    }
}