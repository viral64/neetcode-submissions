class Solution {
    public int longestConsecutive(int[] nums) {
        // 0 1 2 3 4 5 6
        // -1 -1 0 1 3 4 5 6 7 8 9
       HashSet<Integer>set=new HashSet<>();
       for(int i=0;i<nums.length;i++){
        set.add(nums[i]);
       }
        int len=0;
        for(int val :set){
            if(!set.contains(val-1)){
                int count=1;
                while(set.contains(val+count)){
                    count++;
                }
                len=Math.max(count,len);
            }
        }
        return len;
    }
}
