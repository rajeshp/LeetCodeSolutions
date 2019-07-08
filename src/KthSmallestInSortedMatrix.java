import java.util.PriorityQueue;


/**
 *   378. Kth Smallest Element in a Sorted Matrix
 *      https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 *
 *  Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 *  find the kth smallest element in the matrix.
 *
 *  Input :
 *  matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 *  k = 8,
 *
 *  return 13.
 *
 *
 *  Solution : At first it looks like we can use binary search
 *  on the matrix to find the kth smallest element
 *  OR
 *  use the mod arithmetic but notice the matrix is not strictly sorted
 *  but only sorted row wise.
 *
 *  Simple solution here is to use minheap and insert all the
 *  matrix elements and get smallest kth element by polling (k-1) elements
 *
 *  Time complexity - O(n log(n)), space - O(n)
 */

public class KthSmallestInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                minheap.offer(matrix[i][j]);
            }
        }

        if(minheap.size() == 0)
            return 0;

        int i=0;
        while(i < k-1){
            minheap.poll();
            i++;
        }

        return minheap.peek();
    }

    public static void main(String[] args) {
        KthSmallestInSortedMatrix obj = new KthSmallestInSortedMatrix();

        int[][] case1 = new int[][]{ {1, 5, 9},{10, 11, 13},{12, 13, 15} };
        int k=8;
        System.out.println("kth smallest = " +obj.kthSmallest(case1, k));
    }
}

