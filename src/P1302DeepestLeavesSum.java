public class P1302DeepestLeavesSum {
    // 方法1:先求出最大深度，再根据最大深度去找所在的叶子节点
    int sum = 0;
    int maxdeep = 0;

    public int deepestLeavesSum1(TreeNode root) {// O(n)+O(1)
        helpDeep(root, 1);//传入1代表当前节点的深度////（root,0)父节点的深度
        helpSum(root, 1);
        return sum;
    }
    // dep is the depth of node's parent
    void helpDeep(TreeNode node, int dep) {// 求最大深度 
        if (node == null) return;
        
        if (node.left == null && node.right == null) {
            maxdeep = Math.max(dep, maxdeep);////传入0的时候这里的dep+1把当前叶子节点的深度给加进去
            return;
        }
        helpDeep(node.left, dep+1);
        helpDeep(node.right, dep+1);
    }

    void helpSum(TreeNode node, int dep) {// 求出为最大深度的节点并更新全局变量和
        if (node == null)
            return;
        if (dep == maxdeep) {
            sum += node.val;
        }
        helpSum(node.left, dep + 1);
        helpSum(node.right, dep + 1);
    }

    // 方法2，一次遍历
    int globalsum = 0;
    int globadeep = 0;

    public int deepestLeavesSum(TreeNode root) {
        helpSum_deep(root, 0);
        return globalsum;
    }

    void helpSum_deep(TreeNode node, int deep) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            if (globadeep == deep) {
                globalsum += node.val;
            }
            else if (deep > globadeep) {
                globadeep = deep;
                globalsum = node.val;
            }
        }

        helpSum_deep(node.left, deep + 1);
        helpSum_deep(node.right, deep + 1);
    }
}
