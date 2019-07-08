import java.util.LinkedList;
import java.util.List;


/**
 * 131. Palindrome Partitioning
 *
 * https://leetcode.com/problems/palindrome-partitioning/
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 *
 * Solution : Use backtracking to generate all possible paritions:
 *
 * Trick is to backtrack for partitions which are NOT palindromes.
 *
 *
 */
public class PalidromePartition {


    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        List<String> current = new LinkedList<>();

        partition(s, current, result);
        return result;
    }

    public void partition(String s, List<String> current,
                          List<List<String>> result) {
        if(s == null || s.length() == 0){
            List<String> currentCopy = new LinkedList<>(current);
            result.add(currentCopy);
            return;
        }

        for(int i=0;i<s.length();i++){
            if(isPalindrome(s, 0, i)){
                //List<String> currentCopy = new LinkedList<>(current);
                current.add(s.substring(0, i+1));
                partition(s.substring(i+1), current, result);
                current.remove(current.size()-1);
            }
        }
    }

    boolean isPalindrome(String s, int start, int end){
        if(s.length() < 2)
            return true;

        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }


    public static void main(String[] args) {
        PalidromePartition obj = new PalidromePartition();

        /*List<List<String>> result = obj.partition("aab");

        for(List<String> res : result){
            res.stream().forEach(s -> System.out.print(s + ","));
            System.out.println();
        }*/

        List<List<String>> result = obj.partition("aabab");

        for(List<String> res : result){
            res.stream().forEach(s -> System.out.print(s + ","));
            System.out.println();
        }
    }
}
