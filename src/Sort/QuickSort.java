package Sort;

import java.util.Random;

public class QuickSort {
    public static void quickSort(int[] nums,int lo,int hi){
        if(lo >= hi) return;
        int pivot = partition(nums,lo,hi);
        quickSort(nums,lo,pivot-1);
        quickSort(nums,pivot+1,hi);
    }

    public static int partition(int[] nums,int lo,int hi){
        int random = new Random().nextInt(hi-lo+1)+lo;
        swap(nums,random,hi);
        int p = lo-1;
        for(int i = lo; i < hi; i++){
            if(nums[i] < nums[hi]){
                p++;
                swap(nums,i,p);
            }
        }
        p++;
        swap(nums,p,hi);
        return  p;
    }

    static void swap(int[] nums,int i, int j){
        if(i != j){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,2,1,2,3,4,7,5,4,9,3,5,11,7,6,5,8,9,9,3,};
        quickSort(a,0,a.length-1);
        for(int e : a){
            System.out.print(e + " ");
        }
    }
}
