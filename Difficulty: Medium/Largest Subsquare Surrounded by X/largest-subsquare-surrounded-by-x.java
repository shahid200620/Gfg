class Solution {

  public int largestSubsquare(char a[][]) {

      int n=a.length;

      int[][]preR=new int[n][n];

      int[][]preC=new int[n][n];

 for(int i=0;i<n;i++){

     for(int j=0;j<n;j++){

preR[i][j]=(a[i][j]=='X'?(j==0?1:preR[i][j-1]+1):0);

preC[j][i]=(a[j][i]=='X'?(j==0?1:preC[j-1][i]+1):0);



     }

 }

 int max=0;

 for(int i=n-1;i>=0;i--){

     for(int j=n-1;j>=0;j--){

    int size=Math.min(preR[i][j],preC[i][j]);

    while(size>max){

     if(preR[i-size+1][j]>=size&&preC[i][j-size+1]>=size){

         max=size;

         break;

     }

     else 

     size--;

    }

    }

 }

 return max;

    }

};