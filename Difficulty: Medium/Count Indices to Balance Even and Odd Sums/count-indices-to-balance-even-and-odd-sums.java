class Solution {
    public int cntWays(int[] arr) {
        int n=arr.length;
        int evenSuffix=0;
        int oddSuffix=0;
        int evenPrefix=0;
        int oddPrefix=0;
        int count=0;
        
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                evenSuffix+=arr[i];
            }
            else oddSuffix+=arr[i];
        }
        
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                evenSuffix-=arr[i];
                
                if(evenSuffix+oddPrefix==oddSuffix+evenPrefix)count++;
                
                evenPrefix+=arr[i];
            }
            else
            {
                oddSuffix-=arr[i];
                
                if(evenSuffix+oddPrefix==oddSuffix+evenPrefix)count++;
                
                oddPrefix+=arr[i];                
            }
        }
        
        return count;
        
    }
}