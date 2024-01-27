public class QuickSort {
    static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    static int partition(int[] arr, int start, int end){
        int pivot=arr[end];
        int i=start-1;
        while(start<end){
            if(arr[start]<pivot){
                i++;
                swap(arr,i,start);
            }
            start++;
        }
        swap(arr,i+1,end);
        return i+1;
    }
    static void quicksort(int[] arr, int start, int end){
        if(start>=end) return;
        int pivot=partition(arr,start,end);
        quicksort(arr,start,pivot-1);
        quicksort(arr,pivot+1,end);
    }

    public static void main(String[] args) {
        int[] arr={1,5,3,4};
        quicksort(arr,0,arr.length-1);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

}
