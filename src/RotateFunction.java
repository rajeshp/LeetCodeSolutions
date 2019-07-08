/**
 * 396. Rotate Function
 *
 * Given an array of integers A and let n to be its length.
 *
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:
 *
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 *
 * Calculate the maximum value of F(0), F(1), ..., F(n-1)
 *
 *
 * Solution:
 *
 * The first thought is to generate f0, f1...,fn-1 by rotating the array
 *
 * But the trick here is to see if we can calculate
 * f1 from f0, f2 from f1 etc.
 *
 * write expanded version of f0,f1..fn on paper and
 * notice the pattern
 *
 *
 *  f1 = f0 + (sum - A.length * A[A.length -1 -i]
 *  f2 = f1 + (sum - A.length * A[A.length -1 -i]
 *  ..
 *  ..
 *  and so on
 *
 *  i.e
 *
 *  fi = f(i-1) + (sum - A.length * A[A.length-1 -i]
 *
 *  The code for this is super simple
 *
 */

public class RotateFunction {

    public int maxRotateFunction(int[] A) {

        int sum=0,fi=0;

        for(int i=0;i<A.length;i++){
            sum += A[i];
            fi += i * A[i];
        }

        int max=fi;
        for(int i=1;i<A.length;i++){
            fi = fi + sum - (A.length * A[A.length-i]);
            max = Math.max(max, fi);
        }

        return max;
    }

}
