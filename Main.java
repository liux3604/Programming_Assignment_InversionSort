/*
Programming assignment: Counting inversions.
An inversion in an array a[] is a pair of entries a[i] and a[j] such that i<j but a[i]>a[j].
Given an array, design a linearithmic algorithm to count the number of inversions.
*/

public class Main {
    private static int[] aux;

    public static int inverseMerge(int[] A)
    {
        return inverseMerge(A, 0, A.length-1);
    }


    public static int inverseMerge (int[] A, int k1, int k2)
    {
        int inversionCount =0;
        int mid = (k1+k2)/2-k1;
        int i = 0;
        int j = mid +1;

        if (k1 == k2)
            // base case
            return 0;

        int firstHalf = inverseMerge(A,k1,(k1+k2)/2);
        int secondHalf = inverseMerge(A, (k1+k2)/2+1, k2);

        aux = new int[k2-k1+1];
        for (int m=k1; m<= k2; m++)
            aux[m-k1]=A[m];

        for (int m=k1; m<= k2;m++)
        {
            if (i>mid)
            {
                A[m] = aux[j];
                j++;
            }
            else if (j>k2-k1)
            {
                A[m] = aux[i];
                i++;
            }
            else
            {
                if (aux[i]<=aux[j])
                {
                    A[m]=aux[i];
                    i++;
                }
                else
                {
                    A[m]=aux[j];
                    inversionCount+=(mid-i+1);
                    j++;
                }
            }
        }
        return inversionCount+firstHalf+secondHalf;
    }

    public static void main(String[] args)
    {   // write your code here

        int[] testArray = {2,3,1,0};
        System.out.println(inverseMerge(testArray));

    }
}
