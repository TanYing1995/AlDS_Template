package Sort;

import java.util.Arrays;

public class BubbleSort {
    //TODO： 核心：每次遍历确定一个最大值到数组末尾
    public static void bubbleSort(int[] nums){
        int n = nums.length;
        int flag = 1;
        for(int i = 0; i < n && flag == 1; i++){
            flag = 0;//所有元素均已排序
            for(int j = 0; j < n-1-i; j++){
                if(nums[j] > nums[j+1]){
                    swap(nums,j,j+1);
                    flag = 1;
                }
            }
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
        bubbleSort(a);
    }
}
