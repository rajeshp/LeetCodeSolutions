import java.util.*;

/**
 * 582. Kill Process
 * https://leetcode.com/problems/kill-process/
 *
 * Given n processes, each process has a unique PID (process id) and its PPID (parent process id).
 * kill the process and all its children
 *
 * Solution : The structure is like a n-ary tree
 * where process with parent as 0 is the root. Each node can have multiple child nodes
 *
 * Approach 1 : Build the N-ary tree and for killing the process
 * use a recursive function to find child and remove the subtree.
 *
 * Approach 2 : Since we have pids & parentIds as list, we can avoid
 * building the tree and Building a map of Node -> List of Children
 *
 *
 */
public class KillProcess {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        //Map<Integer, Integer> parentMap = new HashMap<>();
        Map<Integer, List<Integer>> children =  new HashMap<>();

        for(int i=0;i<pid.size();i++){
            //parentMap.put(pid.get(i), ppid.get(i));

            List<Integer> childlist = children.getOrDefault(ppid.get(i), new LinkedList<Integer>());
            childlist.add(pid.get(i));

            children.put(ppid.get(i), childlist);

        }

        // for(Integer id : children.keySet()){
        //     System.out.print(id + " -> ");
        //     children.get(id).forEach(item -> System.out.print(item + " "));
        //     System.out.println();
        // }

        List<Integer> result = new LinkedList<>();

        killProcessHelper(kill, children, result);

        return result;
    }

    void killProcessHelper(int pid, Map<Integer, List<Integer>> childmap, List<Integer> result){
        result.add(pid);

        if(childmap.containsKey(pid)){

            for(Integer cid : childmap.get(pid)){
                killProcessHelper(cid, childmap, result);
            }
        }
    }

    public static void main(String[] args) {

        KillProcess obj = new KillProcess();
        List<Integer> result = obj.killProcess(Arrays.asList(new Integer[]{1, 3, 10, 5}),
                Arrays.asList(new Integer[]{3, 0, 5, 3}), 5);
        result.stream().forEach(el -> System.out.print(el + " "));
    }
}
