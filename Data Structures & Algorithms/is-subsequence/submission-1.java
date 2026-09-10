class Solution {
    static int[][] dp;
    public boolean isSubsequence(String s, String t) {
        int m=s.length();
        int n=t.length();
        dp=new int[m+1][n+1];
        for(int[] t1:dp)
        Arrays.fill(t1,-1);
        return lcs(s,t,m,n)==m;
    }
    public int lcs(String s,String t,int m,int n){
        if(m==0 || n==0)
        return 0;
        if(dp[m][n]!=-1)
        return dp[m][n];
        if(s.charAt(m-1)==t.charAt(n-1))
        dp[m][n]= 1+ lcs(s,t,m-1,n-1);
        else
        dp[m][n]= Math.max(lcs(s,t,m-1,n),lcs(s,t,m,n-1));
        return dp[m][n];
    }
}