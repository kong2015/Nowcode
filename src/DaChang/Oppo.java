package DaChang;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dxd
 * @create 2021-10-10 12:01
 */
public class Oppo {


    /**
     * 一个字符能有几个oppoyes，大写当两个字符用。
     * @param msg
     * @return
     */
    public static int getCount (String msg) {
        // write code here
        char[] arr = msg.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : arr) {
            if (c != 'o' && c != 'O' && c != 'p' && c != 'P' && c != 'y' && c != 'Y' && c != 'e' && c != 'E' && c != 's' && c != 'S'){
                continue;
            }
            if (c > 'Z'){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }else {
                char tem = (char)(c + 32);
                map.put(tem, map.getOrDefault(tem, 0) + 2);
            }
        }
        if (map.size() < 5){
            return 0;
        }
        if (map.size() == 5){
            if (map.get('o') < 2 || map.get('p') < 2 || map.get('y') < 1 || map.get('e') < 1 || map.get('s') < 1){
                return 0;
            }
        }
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            Character key = entry.getKey();
            if (key == 'o' || key == 'p'){
                if (min1 > value){
                    min1 = value;
                }
            }else {
                if (min2 > value){
                    min2 = value;
                }
            }
        }
        return min1 >= 2 * min2 ? min2 : min1 / 2;
    }

    public static void main(String[] args) {
        System.out.println(getCount("OPPOYESo"));
    }

    /**
     * 层序遍历，偶数行为偶数，奇数行为奇数。
     * @param root
     * @return
     */
//    public boolean isBeautyTree (TreeNode root) {
//        // write code here
//        if(root == null)
//            return false;
//        Queue<TreeNode>queue = new LinkedList<>();
//        queue.offer(root);
//        boolean flag = true;
//        while(!queue.isEmpty()){
//            if (flag){
//                int size = queue.size();
//                int last = Integer.MIN_VALUE;
//                while (size > 0){
//                    TreeNode poll = queue.poll();
//                    if (poll.left != null && !"#".equals(poll.left.val)){
//                        queue.offer(poll.left);
//                    }
//                    if (poll.right != null && !"#".equals(poll.right.val)){
//                        queue.offer(poll.right);
//                    }
//                    int tem = poll.val;
//                    if (tem % 2 != 0 || last >= tem){
//                        return false;
//                    }else {
//                        last = tem;
//                    }
//                    size--;
//                }
//                flag = !flag;
//            }else {
//                int size = queue.size();
//                int last = Integer.MIN_VALUE;
//                while (size > 0){
//                    TreeNode poll = queue.poll();
//                    if (poll.left != null && !"#".equals(poll.left.val)){
//                        queue.offer(poll.left);
//                    }
//                    if (poll.right != null && !"#".equals(poll.right.val)){
//                        queue.offer(poll.right);
//                    }
//                    int tem = poll.val;
//                    if (tem % 2 == 0 || last >= tem){
//                        return false;
//                    }else {
//                        last = tem;
//                    }
//                    size--;
//                }
//                flag = !flag;
//            }
//        }
//        return true;
//    }
    public boolean checkReach (int[] nums, int begin) {
        // write code here
        boolean[] visit = new boolean[nums.length];
        for (int i = begin; i < nums.length; i++) {
            if (visit[i]){
                return false;
            }
            int index = (nums[i] + i) % nums.length;
            if (nums[index] == 0){
                return true;
            }else if (nums[(i - nums[i]) % nums.length] == 0){
                return true;
            }
            visit[i] = true;
        }
        return false;
    }
}
