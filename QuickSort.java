public class QuickSort {
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void quicksort(int[] arr, int start, int end){
        if(start>=end) return;
        int pivot=arr[end];
        int pivot_index=start;
        for(int i=start;i<end;i++){
            if(arr[i]<pivot){
                swap(arr,i,pivot_index);
                pivot_index++;
            }
        }
        swap(arr,pivot_index,end);
        quicksort(arr,start,pivot_index-1);
        quicksort(arr,pivot_index+1,end);
    }

    public static void main(String[] args) {
        int[] arr={1,5,3,2,7,0};
        quicksort(arr,0,arr.length-1);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

}
