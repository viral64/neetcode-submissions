class Solution {
    public int longestConsecutive(int[] nums) {
        // 0 1 2 3 4 5 6
        // -1 -1 0 1 3 4 5 6 7 8 9
        if(nums.length==0){
            return 0;
        }
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        ArrayList<Integer>list=new ArrayList<>();
        for(int val:set){
            list.add(val);
        }
        Collections.sort(list);
        int count=1;
        int max=1;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i+1)-list.get(i)!=1){
                count=0;
            }
            count++;
            max=Math.max(max,count);
        }
        return max;
    }
}
