package Sort;

import java.util.Arrays;

public class BubbleSort_I {

    static void bubbleSort_I(int[] nums){
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            //正向冒泡，确定最大值
            for(int i = left; i < right; i++){
                if(nums[i] > nums[i+1]){
                    swap(nums,i,i+1);
                }
            }
            --right;

            //反向冒泡，确定最小值
            for(int j = right; j > left; j--){
                if (nums[j] < nums[j-1])
                    swap(nums,j,j-1);
            }
            ++left;
        }
        System.out.println(Arrays.toString(nums));
    }

    static void swap(int[] nums,int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,2,1,2,3,4,7,5,4,9,3,5};
        bubbleSort_I(a);
    }
}
