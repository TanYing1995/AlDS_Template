package Sort;

import java.util.Arrays;

public class InsertionSort_I {
    //二分插入排序
    public static void insertionSort_I(int[] nums){
        int n = nums.length;
        for(int i = 1; i < n; i++){
            if(nums[i] < nums[i-1]){
                int target = nums[i];
                int left = 0;
                int right = i-1;
                while(left <= right){
                    int mid = (right-left)/2 + left;
                    if(nums[mid] <= target){
                        left = mid+1;
                    }
                    else{
                        right = mid-1;
                    }
                }
                //向后覆盖
                for(int j = i; j > left; j--){
                    nums[j] = nums[j-1];
                }
                nums[left] = target;
            }
        }
    }

    void swap(int[] nums,int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        //int[] a = new int[]{1,2,3,4,2,1,2,3,4,7,4,5,12,13,13,14,15,6,-1,0,2,5,4,9,3,5};
        int[] a = new int[]{1,1,1,1,1,1,11,1,11,1,1,1,11,1,1,11,1,1,11,1,1};
        InsertionSort_I ob = new InsertionSort_I();
        ob.insertionSort_I(a);
        System.out.println(Arrays.toString(a));
    }
}
