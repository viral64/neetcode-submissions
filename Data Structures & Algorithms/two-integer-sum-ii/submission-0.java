class Solution {
    public int[] twoSum(int[] num, int target) {
        int i=0;
        int j=num.length-1;
        while(i<j){
            int sum=num[i]+num[j];
            if(sum>target){
                j--;
            }
            else if(target>sum){
                i++;
            }
            if(sum==target){
                return new int[]{i+1,j+1};
            }
        }
        return new int[]{-1,-1};
    }
}
