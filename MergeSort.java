import java.util.Arrays;

class MergeSort {
    static void conquer(int[] arr, int start, int mid, int end){
        int[] temp=new int[end-start+1];
        int i=start;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=end){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
                k++;
            }
            else{
                temp[k]=arr[j];
                j++;
                k++;
            }

        }
        while(i<=mid){
            temp[k]=arr[i];
            i++;
            k++;
        }
        while(j<=end){
            temp[k]=arr[j];
            j++;
            k++;
        }
        for(int l=start; l<=end; l++){
            arr[l]=temp[l-start];
        }

    }

    static void divide(int[] arr, int start, int end){
        if(start>=end) return;
        int mid=(start+end)/2;
        divide(arr, start, mid);
        divide(arr, mid+1, end );
        conquer(arr,start,mid,end);
    }
    public static void main(String[] args) {
        int[] arr={5,1,3,4,10,9,0};
        divide(arr, 0, arr.length-1);
//        conquer(arr,0,(arr.length-1)/2, arr.length-1 );
        System.out.println(Arrays.toString(arr));


    }
}
