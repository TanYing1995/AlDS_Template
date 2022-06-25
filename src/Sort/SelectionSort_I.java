package Sort;

public class SelectionSort_I {

    private void selectionSort_I(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n/2; i++){
            int min = i,max = n-1-i;
            for(int j = i; j <= n-1-i; j++){
                if(nums[j] < nums[min]){
                    min = j;
                }
                else if(nums[j] > nums[max]){
                    max = j;
                }
            }
            if(max == i && min == n-1-i){
                swap(nums,max,min);
            }
            else if(max == i){
                swap(nums,max,n-1-i);
                swap(nums,min,i);
            }
            else if(min == n-i-1){
                swap(nums,min,i);
                swap(nums,max,n-1-i);
            }
            else{
                swap(nums,i,min);
                swap(nums,n-i-1,max);
            }
        }
    }

    void swap(int[] nums,int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,2,1,2,3,4,7,5,4,9,3,5,11,12,13,13,24,43,12,31};
        SelectionSort_I ob = new SelectionSort_I();
        ob.selectionSort_I(a);
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }
    }
}
