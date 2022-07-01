package Sort;

import java.util.Arrays;

public class MergeSort {

    private static int[] temp;

    public static void mergeSort(int[] nums){
        temp = new int[nums.length];
        sort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums,int lo, int hi){
        if(hi <= lo) return;
        int mid = lo+(hi-lo)/2;
//        if(r-l+1<INSERT_BOUND){
//            //这里在下面的划分递归中，只要满足了条件，就会进入插入排序
//            insertSort(arr,l,r);
//        }
        sort(nums,lo,mid);
        sort(nums,mid+1,hi);
        //if(nums[mid] <= nums[mid+1]) continue;
        merge(nums,lo,mid,hi);
    }

    //将两部分归并
    public static void merge(int[] nums,int lo ,int mid, int hi){
        int i = lo,j = mid+1;
        for(int k = lo; k <= hi; k++)
            temp[k] = nums[k];
        for(int k = lo; k <= hi; k++){
            if(i > mid) nums[k] = temp[j++];
            else if(j > hi) nums[k] = temp[i++];
            else if(temp[j] < temp[i]) nums[k] = temp[j++];
            else nums[k] = temp[i++];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,2,1,2,3,4,7,4,5,12,13,13,14,15,6,-1,0,2,5,4,9,3,5};
        //int[] a = new int[]{1,1,1,1,1,1,11,1,11,1,1,1,11,1,1,11,1,1,11,1,1};
        mergeSort(a);
    }
}
