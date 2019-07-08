import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  139. Word Break
 *
 *  https://leetcode.com/problems/word-break/
 *
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 *  Input :   s = "leetcode", wordDict = ["leet", "code"]
 *  return true;
 *
 *  Input : Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 *  return false;
 */

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet(wordDict);
        boolean[] temp = new boolean[s.length()];

        for(int i=0;i<s.length();i++){
            temp[i] = dict.contains(s.substring(0, i+1));
            if(!temp[i]){
                for(int j=1;j<=i;j++){
                    if(temp[j-1] && dict.contains(s.substring(j, i+1))){
                        temp[i] = true;
                        break;
                    }
                }
            }
        }

        return temp[temp.length-1];
    }

    public static void main(String[] args) {
        WordBreak obj = new WordBreak();
        System.out.println(obj.wordBreak("leetcode",
                Arrays.asList(new String[]{"leet", "code"})));

        System.out.println(obj.wordBreak("catsandog",
                Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"})));
    }

}
