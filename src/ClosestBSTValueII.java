import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 *
 * Note:
 *
 * Given target value is a floating point.
 * You may assume k is always valid, that is: k ≤ total nodes.
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 *
 *
 * Solution:
 * Add the nodes to minheap, use a special comparator with distance function
 *
 *
 */

public class ClosestBSTValueII {

     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    class PQItem{
        double dist;
        TreeNode root;

        PQItem(TreeNode root, double target){
            dist = Math.abs(target - root.val);
            this.root = root;
        }
    }


    PriorityQueue<PQItem> pq ;

    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        pq = new PriorityQueue<PQItem>(k, (PQItem i1, PQItem i2) -> {
            if(i1.dist > i2.dist)
                return 1;
            else
            if(i1.dist < i2.dist)
                return -1;
            else
                return 0;
        });

        addToPQ(root, target);

        List<Integer> result = new LinkedList<>();
        int i=0;

        System.out.println("pqsize=" + pq.size());
        while(i < k && pq.size() > 0){
            //System.out.println(pq.poll().root.val);
            if(pq.peek().root != null)
                result.add(pq.poll().root.val);
            i++;
        }

        return result;
    }

    void addToPQ(TreeNode root, double target){
        if(root == null)
            return ;
        // System.out.println("adding root="+root.val);
        PQItem pqitem = new PQItem(root, target);
        pq.add(pqitem);
        addToPQ(root.left, target);
        addToPQ(root.right, target);
    }

}
