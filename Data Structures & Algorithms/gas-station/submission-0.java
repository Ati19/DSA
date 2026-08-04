class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startStation=0,currentGas=0,totalGas=0;
        for(int i=0;i<gas.length;i++){
            int diff= gas[i]-cost[i];
            currentGas+=diff;
            totalGas+=diff;
            if(currentGas<0){
                currentGas=0;
                startStation=i+1;
            }
        }
        return totalGas>=0?startStation:-1;
    }
}
