import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: TE162141
 * Date: 10/24/12
 * Time: 3:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class StairClimbing {

static HashMap<Integer,Integer>  results = new HashMap<Integer, Integer>();

    public static int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if(!results.containsKey(n))
        {

            int res = climbStairs(n-1)+climbStairs(n-2);

            results.put(n,res);

            return res;

        }
        else
            return results.get(n);


    }



    public static void main(String[] args)
    {
        results.put(0,0);
        results.put(1,1);
        results.put(2,2);

        for(int i=0;i<10;i++)
        {
            System.out.println(i+"="+climbStairs(i));
        }
    }


}
