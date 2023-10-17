package DivideAndConquer;
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int []arr = {50,40,20,100,30,99};

        System.out.println("Before Sorting: "+Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("After Sorting: "+Arrays.toString(arr));
    }


    static void mergeSort(int []mainArray){
        int length = mainArray.length;
        if (length < 2){  // empty array or array of one element
            return;
        }

        int mid = length/2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[length - mid];

        for (int i = 0;i < mid; i++ ){
            leftArray[i] = mainArray[i];
        }

        for (int i = mid; i<length; i++){
            rightArray[i - mid] = mainArray[i];
        }

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(mainArray,leftArray,rightArray);

    }

    static void merge(int []mainArray, int []leftArray, int []rightArray){
        int i = 0, j = 0, k = 0;
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;

        while (i < leftSize && j < rightSize){

            if (leftArray[i] <= rightArray[j]){
                mainArray[k++] = leftArray[i++];
            }else {
                mainArray[k++] = rightArray[j++];
            }
        }

        while (i < leftSize){
            mainArray[k++] = leftArray[i++];
        }

        while (j< rightSize){
            mainArray[k++] = rightArray[j++];
        }
    }
}
