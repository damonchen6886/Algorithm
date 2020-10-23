package 友富作业;

public class bubbleSort {
   static class BubbleSort
    {
        void bubbleSort(int arr[])
        {
            int n = arr.length;
            for (int i = 0; i < n-1; i++){
                for (int j = 0; j < n-i-1; j++){
                    if (arr[j] > arr[j+1])
                    {
                        // swap arr[j+1] and arr[j]
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            printArray(arr);
            }
        }

        /* Prints the array */
        void printArray(int arr[])
        {
            int n = arr.length;
            for (int i=0; i<n; ++i)
                System.out.print(arr[i] + " ");
            System.out.println();
        }

        // Driver method to test above
        public static void main(String args[])
        {
            BubbleSort ob = new BubbleSort();
            int arr[] = {43,7,10,23,18,4,19,5,66,14};
            ob.bubbleSort(arr);
            System.out.println("Sorted array");
            ob.printArray(arr);
        }
    }
}
