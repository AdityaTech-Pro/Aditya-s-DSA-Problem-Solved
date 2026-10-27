class Solution {
    public String[] createGrid(int m, int n) {
        char[][] l=new char[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                l[i][j]='#';
            }
        }
        
        int i=0;
        int j=0;
        int count=0;
        while(i<m && j<n){
            l[i][j]='.';
            if(count%2==0){
                j++;
            }else{
                i++;
            }
            count++;
        }

        while(i<m){
            l[i][j-1]='.';
            i++;
        }
        while(j<n){
            l[i-1][j]='.';
            j++;
        }
        String[] ans=new String[m];
        for(int x=0; x<m; x++){
            String s="";
            for(int y=0; y<n; y++){
                s+=l[x][y];
            }
            ans[x]=s;
        }
        return ans;
    }
}