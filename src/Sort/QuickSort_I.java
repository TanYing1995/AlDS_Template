package Sort;

public class QuickSort_I {
    public static void QuickSort(int[] nums,int lo, int hi){
        if(hi <= lo) return;
        int pivot = partition(nums,lo,hi);
        QuickSort(nums,lo,pivot-1);
        QuickSort(nums,pivot+1,hi);
    }

    public static int partition(int[] nums,int lo, int hi) {
        //随机选择未排定的元素索引
        swap(nums,lo,(int)Math.random()*(hi-lo+1)+lo);
        int v = nums[lo];
        int i = lo;int j = hi+1;
        while(true){
            //找到左侧大于等于V的元素停止
            while(nums[++i] < v) if(i == hi) break;
            //找到右侧小于等于V的元素停止
            while(v < nums[--j]) if(j == lo) break;
            if(i >= j) break;
            swap(nums,i,j);
        }
        swap(nums,lo,j);
        return j;
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
        QuickSort(a,0,a.length-1);
        for(int e : a){
            System.out.print(e + " ");
        }
    }
}
