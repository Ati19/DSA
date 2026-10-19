class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0,n=s.length(),max=0;
        if(n<=1)return n;
        Set<Character> seen=new HashSet<>();
        while(j<n){
            char cur=s.charAt(j);
            if(!seen.contains(cur)){
                seen.add(cur);
                j++;
                max=Math.max(max,j-i);
            }
            else{
                seen.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}
