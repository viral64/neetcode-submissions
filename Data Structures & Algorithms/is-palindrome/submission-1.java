class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                sb.append(s.charAt(i));
            }
            else if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
                sb.append(s.charAt(i));
            }
            else if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                sb.append(s.charAt(i));
            }
        }
        String s1=sb.toString().toLowerCase();
        return check(s1);
    }
    private boolean check(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
