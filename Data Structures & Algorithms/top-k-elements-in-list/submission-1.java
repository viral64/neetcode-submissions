class Solution {
    static class Pair implements Comparable<Pair>{
        int num;
        int freq;
        public Pair(int num,int freq){
            this.num=num;
            this.freq=freq;
        }
        @Override
        public int compareTo(Pair p){
           return p.freq-this.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        List<Integer>list=new ArrayList<>();
        for(int val:nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        Pair p[]=new Pair[map.size()];
        int ind=0;
        for(int val:map.keySet()){
            p[ind++]=new Pair(val,map.get(val));
        }
        Arrays.sort(p);
        int ans[]=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=p[i].num;
        }
        return ans;
    }
}
