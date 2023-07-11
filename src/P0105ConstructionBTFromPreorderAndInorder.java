import java.util.HashMap;

public class P0105ConstructionBTFromPreorderAndInorder {
  public TreeNode buildTree(int[]preorder,int[]inorder){
    HashMap<Integer,Integer>in_map = new HashMap<>();
    for(int i = 0;i<inorder.length;i++){
      in_map.put(inorder[i], i);//因为需要查找root节点在中序遍历的位置，所以要把中序遍历的pair加入map
    }
    return dfs(preorder,in_map,0,preorder.length-1,0,inorder.length-1);//因为传入了map，所以不需要传入inorder
  }

  private TreeNode dfs(int[]preorder,HashMap<Integer,Integer>in_map,int preL,int preR, int inL, int inR){
    if(inL>inR) return null;//根据中序遍历来划分的
    TreeNode root = new TreeNode(preorder[preL]);
    int root_position = in_map.get(root.val);//inorder里的位置
    int left_subtree_len = root_position - inL;

    root.left = dfs(preorder,in_map,preL+1,left_subtree_len+preL,inL,root_position-1);
    root.right = dfs(preorder,in_map, left_subtree_len+preL+1,preR,root_position+1,inR);
    return root;
  }
}

/*  1 取preorder的第一个元素创建当前的root 因为preorder是root，left，right，而inorder是left，root，right
 *  2 在 inorder中找到root的位置，然后其左侧元素就是left subtree，右侧元素就是right subtree
 *     如何找？HashMap存{element:index} 每次需要O(1)的时间复杂度
 *  3 把preorder和inorder中对应的左子树和右子树的subarray分离出来
 *     怎么分离？ inorder中的root左侧是左子树，右侧是右子树，preorder按照同理划分
 *               根据inorder中左右子树长度来限定preorder里的左右子树
 *     分离形式是什么？ 直接复制subarray，base case是empty array，每次O(N)    用two pointer来划分边界O(1)，base case：left pointer 大于 right pointer
 *  4 递归左子树
 *  5 递归右子树
 *  6 Base Case：当要处理的子树为空(preorder=inorder=[])
 */