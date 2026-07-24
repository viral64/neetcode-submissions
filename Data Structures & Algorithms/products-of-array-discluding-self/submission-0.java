class Solution {
    public int[] productExceptSelf(int[] nums) {
       // 1 2 4 6
        int ans[]=new int[nums.length];
       int prefix[]=new int[nums.length];
       prefix[0]=nums[0];
       for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]*nums[i];
       }
       int suffix[]=new int[nums.length];
       int n=nums.length-1;
       suffix[n]=nums[n];
       for(int i=n;i>0;i--){
        suffix[i-1]=suffix[i]*nums[i-1];
       }
       for(int i=0;i<nums.length;i++){
        System.out.print(prefix[i]+" ");
       }
       System.out.println();
       for(int i=0;i<nums.length;i++){
        System.out.print(suffix[i]+" ");
       }
        ans[0]=suffix[1];
        ans[n]=prefix[n-1];

       for(int i=1;i<n;i++){
        ans[i]=prefix[i-1]*suffix[i+1];
       }
       return ans;

       // 1 2 8 16
       // 48 48 24 6
    }
}  
