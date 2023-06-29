import java.util.LinkedList;
import java.util.Queue;

public class P0104MaximumDepthOfBTree {
    int maxdepth = 0;

    public int maxDepth1(TreeNode root) {
        helpmaxDepth(root, 0);
        return maxdepth;
    }

    private void helpmaxDepth(TreeNode root, int depth) {
        if (root == null) {
            maxdepth = Math.max(maxdepth, depth);
            return;
        }
        helpmaxDepth(root.left, depth + 1);
        helpmaxDepth(root.right, depth + 1);
    }

    public int maxDepth(TreeNode root) {// 自下而上
        if (root == null)
            return 0;
        // 这里如果判断是叶子节点可以减少调用递归函数取叶子节点的左右节点，但要注意，到了叶子节点要返回1，而不是0，因为叶子节点是存在的
        if (root.left == null && root.right == null)
            return 1;
        int leftSubtree = maxDepth(root.left);
        int rightSubtree = maxDepth(root.right);
        return Math.max(leftSubtree, rightSubtree) + 1;
    }
    /*
     * 上述代码解释： 求最大深度，可以考虑求以root为节点的left subtree的深度和right
     * subtree的最大深度，然后取较大值，加上root节点本身的深度。比如3为节点的左右子树，肯定是右子树的高度2更高，所以就是2+1=3.
     * maxDepth(3)：左子树高度是1，右是2，所以当前取2+本身节点三也就是最大深度3
     * subTreeL: maxDepth(9) ：返回 1 左右子树高度都是0 返回给3 作为3的左子树高度 下一步到求3的右子树 30行
     * subTreeL: maxDepth(null) : 0 结束 返回给上层9作为其left高度
     * subTreeR: maxDepth(null) :0 结束 返回，作为9的right 子树高度
     * subTreeR:maxDepth(20) :
     * 经过31行返回了20左子树的高度1，现在求20的右子树高度，进入34行，经过34行得出右子树也是1，所以当前20节点最终是1+1 = 2
     * 返回给她的上层3，作为3的右子树高度，第26行
     * subTreeL: maxDepth(15)：求出15左右子树高度后，取1 ，返回给上层20
     * subTreeL:maxDepth(null):0 结束 返回，作为15左子树高度 接下来求其右子树高度
     * subTreeR:maxDepth(null):0 结束，作为15右子树高度
     * subTreeR:maxDepth(7) : 它的左右子树高度都是0，所以这里返回1给20作为20的右子树高度
     * subTreeL:maxDepth(null):0
     * subTreeL:maxDepth(null):0
     */

    int maxdep = Integer.MIN_VALUE;

    public int maxDep2(TreeNode root) {
        if (root == null)
            return 0;
        helpmaxDepth2(root, 1);// 传入1
        return maxdep;
    }

    private void helpmaxDepth2(TreeNode node, int dep) {//传入参数是当前节点的深度
        if (node == null) {
            return;
        } // 当为叶节点的时候进行对比且更新全局变量，且node==null返回，所以传入的dep是当前node的深度
        if (node.left == null && node.right == null) {
            maxdep = Math.max(maxdep, dep);
            return;
        }
        helpmaxDepth2(node.left, dep + 1);
        helpmaxDepth2(node.right, dep + 1);
    }

    int res = 0;
    int curDepth = 0;// 记录遍历到的节点的深度

    public int maxDepth3(TreeNode root) {// 自上而下 前序遍历
        traverse(root);
        return res;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;// void 只需要返回
        }
        curDepth++;// 当前节点有效
        if (root.left == null && root.right == null) {// 到达叶子节点更新值
            res = Math.max(curDepth, res);
            // return;这里不能写return，因为一旦写了，没法做到回溯-1，curDepth是全局变量
        }
        traverse(root.left);
        traverse(root.right);
        curDepth--;// 离开一个节点的时候，depth 记录当前递归到的节点深度
        // 这里的当前深度是全局变量，用遍历的方式，从上到下遍历到当前节点就会增加1，但题目用的preorder，比如3，20，15，7这里，遍历到15时候当前深度是3了，此时是20的left，接下来要遍历20的右节点，curDepth却仍然为3，算上了15这个节点，则到了7就是4了。
    }

    public int maxDepth4(TreeNode root) {//BFS O(n)
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;//添加root节点，等到删除root的时候会加1
        while(!queue.isEmpty()){
            int levelNum = queue.size();//统计当前层节点的个数
            for(int i = 0;i<levelNum;i++){//删除当前层的所有节点，同时把删除节点下层的孩子们都入对
                TreeNode popE = queue.poll();
                if(popE.left != null){
                    queue.offer(popE.left);
                }
                if(popE.right != null){
                    queue.offer(popE.right);
                }
            }
            level++;//把当前层都操作完毕了再加加
        }
        return level;
    }
    /* 当root= 3添加进队，队列里仅有3，只需要删除一个元素，同时添加了3的左右节点，level=1
       queue里有了9，20，队列size是2，所以删除当前层的2个，同时添加了20的左右节点15，7， level=2
       queue里是15，7，队列size是2，所以只需要删除这两个，因为15，7 都没有孩子，所以队列不需要加入任何 level=3
       此时队列为空，退出
    */
}
/*
 * 求一棵树的最大深度，也就是求其左subtree的深度和右subtree的深度，然后取左右深度的较大值+1，这里的加1指本身的跟节点
 * 而求左右subtree的深度这个可以用递归。
 * 这是一种自下而上的做法，也就是需要知道最下面的一层结果，然后不断的用递归从而得出最上面的结果。
 * //自上而下求max深度 设置一个全局变量用来记录最大深度。辅助函数里从上到下记录深度，遍历每个节点，且将当前的深度返回给下一层
 * 下一层如果存在节点就+1，如果为空节点就不需要+1，所以进入辅助函数的值是0开始。如果跟节点存在就+1，然后遍历leftchild。
 *
 * 总结一下，二叉树解题的思维模式分两类：
 *
 * 1、是否可以通过遍历一遍二叉树得到答案？如果可以，用一个 traverse 函数配合外部变量来实现，这叫「遍历」的思维模式。
 *
 * 2、是否可以定义一个递归函数，通过子问题（子树）的答案推导出原问题的答案？如果可以，写出这个递归函数的定义，并充分利用这个函数的返回值，这叫「分解问题」
 * 的思维模式。
 *
 * 无论使用哪种思维模式，你都需要思考：
 *
 * 如果单独抽出一个二叉树节点，它需要做什么事情？需要在什么时候（前/中/后序位置）做？其他的节点不用你操心，递归函数会帮你在所有节点上执行相同的操作。
 *
 * 111 题求最短路径 类似，但是不同
 *
 */