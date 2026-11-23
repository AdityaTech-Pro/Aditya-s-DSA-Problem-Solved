class ProductOfNumbers {
    ArrayList<Integer> ans = new ArrayList();
    public ProductOfNumbers() {
    }
    
    public void add(int num) {
        ans.add(num);
    }
    
    public int getProduct(int k) {
        int pro=1;
        int n=ans.size();
        for(int i=n-k; i<n; i++){
            pro=pro*ans.get(i);
        }
        return pro;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */