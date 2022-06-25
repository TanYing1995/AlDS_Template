package Sort;

public class InsertionSort {

    public void insertionSort(int[] nums){
        int n = nums.length;
        // 将nums[i]插入到左侧有序部分
        for(int i = 1; i < n; i++){
            for(int j = i; j > 0 && nums[j] < nums[j-1]; j--){
                swap(nums,j-1,j);
            }
        }
    }

    void swap(int[] nums,int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,2,1,2,3,4,7,5,4,9,3,5};
        InsertionSort ob = new InsertionSort();
        ob.insertionSort(a);
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }
    }
}
