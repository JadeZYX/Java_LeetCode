public class P1022BTreeBinaryNum {
    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        PreorderTraverse(root, "");
        return sum;
    }

    public void PreorderTraverse(TreeNode root, String result) {
        result += String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            sum += convertBinaryNumber(result);
            return;
        }
        
        if (root.left != null) {
            PreorderTraverse(root.left, result);
        }

        if (root.right != null) {
            PreorderTraverse(root.right, result);
        }
    }

    public int convertBinaryNumber(String num) {// 将二进制转十进制 从前往后
        int res = 0;
        for (int i = 0; i < num.length(); i++) {
            res *= 2;
            res = res + (num.charAt(i) - '0');
        }
        return Integer.valueOf(res);
    }
}

/*
        BinaryTree bt2=new BinaryTree(new Integer[]{1,1});
        P1022BTreeBinaryNum p1022 = new P1022BTreeBinaryNum();
        System.out.println(p1022.sumRootToLeaf(bt2.root));;
*/
