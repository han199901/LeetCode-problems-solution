class Solution {
    public int maxArea(int[] height) {
        int max=0;
        for(int i=0; i<height.length-1; i++) {
            for(int j=i+1; j<height.length; j++) {
                int t = Math.min(height[i],height[j])*(j-i);
                if(t>max)
                    max = t;
            }
        }
        return max;
    }
}