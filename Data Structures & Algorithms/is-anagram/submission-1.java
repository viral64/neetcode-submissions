class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer>map=new HashMap<>();
        HashMap<Character,Integer>map1=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch:t.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        if(map.size()!=map1.size()){
            return false;
        }
        for(char ch:map1.keySet()){
            if(map.containsKey(ch)&&map.get(ch).equals(map1.get(ch))){
                continue;
            }
            return false;
        }
        // for(char ch:map.keySet()){
        //     if(map1.containsKey(ch)&&map1.get(ch)==map.get(ch)){
        //         continue;
        //     }
        //     return false;
        // }
        return true;
    }
}
