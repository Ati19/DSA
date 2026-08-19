class Solution {
    public String minWindow(String s, String t) {
        if(s==null || t==null || s.length()<t.length())
        return "";

        int[] map=new int[128];
        for(char c:t.toCharArray()){
            map[c]++;
        }
        int left=0,right=0,minStart=0,count=t.length();
        int minLen=Integer.MAX_VALUE;
        while(right<s.length()){
            char rightChar=s.charAt(right);
            if(map[rightChar]>0){
                count--;
            }
            map[rightChar]--;
            right++;
            while(count ==0){
                if(minLen>right-left){
                    minLen=right-left;
                    minStart=left;
                }
                char leftChar=s.charAt(left);
                map[leftChar]++;
                if(map[leftChar]>0){
                    count++;
                }
                left++;
            }
        }

        return minLen==Integer.MAX_VALUE?"":s.substring(minStart,minStart+minLen);

    }
}
