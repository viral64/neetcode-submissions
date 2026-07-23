class Solution {
    public int characterReplacement(String s, int k) {
        // xyyxyy k=2
        HashMap<Character,Integer>map=new HashMap<>();
        int maxLen=0;
        int maxFreq=0;
        int j=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
           map.put(ch,map.getOrDefault(ch,0)+1);
            maxFreq=Math.max(maxFreq,map.get(ch));
            if((i-j+1)-maxFreq>k){
                char left = s.charAt(j);
                map.put(left, map.get(left) - 1);
                j++;
            }
            maxLen=Math.max(maxLen,i-j+1);
            
        }
        return maxLen;
    }
}
