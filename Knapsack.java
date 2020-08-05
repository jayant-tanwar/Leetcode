Coin Change
1. Using 1D DP:
    public int coinChange(int[] c, int a) {
        
        int[] DP=new int[a+1];
        Arrays.fill(DP,a+1);
        DP[0]=0;
        for(int i=1;i<=c.length;i++){
            for(int j=1;j<=a;j++){
                int v=c[i-1];
                if(j>=v) DP[j]=Math.min(DP[j],DP[j-v]+1);
                
            }
        }
        if(DP[a]==a+1) return -1;
        return DP[a]; 
     }
     
2. Using 2D DP:

   public int coinChange(int[] c, int a) {
     
         int[][] DP=new int[coins.length+1][amount+1];
        for(int[] A:DP){
            Arrays.fill(A,amount+2);
        }
        DP[0][0]=0;
        for(int i=0;i<coins.length;i++) DP[i+1][0]=0;
        
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                int v=coins[i-1];
                DP[i][j]=DP[i-1][j];
                if(j>=v){
                    DP[i][j]=Math.min(DP[i][j],DP[i][j-v]+1);
                }
            }
        }
        if(DP[coins.length][amount]==amount+2) return -1;
        return DP[coins.length][amount];
        
    }
