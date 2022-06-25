package Sort;

public class SelectionSort {

    // N^2/2 次比较，N次交换
    public void selectSort(int[] nums){
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int min = i;
            for(int j = i+1; j < n; j++)
                if(nums[j] < nums[min]) min = j;
            swap(nums,i,min);
        }
    }

    void swap(int[] nums,int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,2,1,2,3,4,7,5,4,9,3,5};
        SelectionSort ob = new SelectionSort();
        ob.selectSort(a);
        //selectSort(a);
        boolean flag = true;
        for(int i = 0; i < a.length; i++){
            /*if(i+1 < a.length && a[i+1] < a[i]){
                flag = false;
                break;
            }*/
            System.out.print(a[i]+" ");
        }
        //System.out.println(flag);
    }
}
