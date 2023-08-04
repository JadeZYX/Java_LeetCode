import java.util.HashMap;

public class P0105ConstructionBTFromPreorderAndInorder {
  public TreeNode buildTree0(int[]preorder,int[]inorder){
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


  public TreeNode buildTree(int[] preorder, int[] inorder) {
    //preorder : root, left, right , this is the entrance
    //inorder : left, root, right
    //因为通过前序遍历找到root，它在中序遍历中的位置是index，这样index的左侧就是左子树，右侧就是右子树
    //所以需要用hashmap记录每个节点的位置
    HashMap<Integer,Integer>in_map = new HashMap<>();
    for(int i = 0;i<inorder.length;i++){
        in_map.put(inorder[i],i);
    }
    return buildTreeHelper(in_map,preorder,0,0,inorder.length-1);//树根位置(通过preorder确定)和当前节点的左右子树的范围(inorder确定)
    //in_map就是inorder数组，preorder数组，当前跟节点在preorder的位置(所以初始值是index为0的位置),当前这棵树的左右子树boundary
    //左右子树的范围是不断缩小的，起初是整个inorder，然后随着root不断的改变，左右子树范围也逐渐缩小，所以当inStart>inEnd时候越界
}
private TreeNode  buildTreeHelper(HashMap<Integer,Integer>map,int[]preorder,int preIndex, int inStart,int inEnd){
    if(preIndex > preorder.length || inStart > inEnd) return null;
    TreeNode root = new TreeNode(preorder[preIndex]);
    int rootPos = map.get(root.val);//找到root在inorder中的位置，从而确定其左子树范围和右子树范围
    int leftSubtreeLen = rootPos-inStart;//通过root在inorder位置及start位置确定左子树长度,不要+1，不包含最后一个root元素
    root.left = buildTreeHelper(map,preorder,preIndex+1,inStart,rootPos-1);
    root.right = buildTreeHelper(map,preorder,preIndex+leftSubtreeLen+1,rootPos+1,inEnd);
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
 *
 *
 P0105ConstructionBTFromPreorderAndInorder p105 = new P0105ConstructionBTFromPreorderAndInorder();
 System.out.println(p105.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
 */