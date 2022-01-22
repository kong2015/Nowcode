/**
 * @author dingxudong
 * @create 2021-09-22 11:28
 * @Description
 * NC81 二叉搜索树的第k个结点
 */
public class NC81 {
//    TreeNode res = null;
//    int i = 0;
//    TreeNode KthNode(TreeNode pRoot, int k) {
//        if(pRoot == null)
//            return null;
//        inOeder(pRoot, k);
//        return res;
//    }
//    private void inOeder(TreeNode node, int k){
//        if(node == null)
//            return;
//        inOeder(node.left, k);
//        if(k == ++i){
//            res = node;
//        }
//        inOeder(node.right, k);
//    }

//    public class Solution_1027_1 {
//        TreeNode KthNode(TreeNode pRoot, int k)
//        {
//            if(pRoot == null || k <= 0){
//                return null;
//            }
//            Stack<TreeNode> stack = new Stack<>(); //建立栈
//            TreeNode cur = pRoot;
//            //while 部分为中序遍历
//            while(!stack.isEmpty() || cur != null){
//                if(cur != null){
//                    stack.push(cur); //当前节点不为null，应该寻找左儿子
//                    cur = cur.left;
//                }else{
//                    cur = stack.pop();//当前节点null则弹出栈内元素，相当于按顺序输出最小值。
//                    if(--k == 0){ //计数器功能
//                        return cur;
//                    }
//                    cur = cur.right;
//                }
//            }
//            return null;
//        }
//    }
}