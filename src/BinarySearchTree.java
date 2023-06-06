public class BinarySearchTree extends BinaryTree {
    public BinarySearchTree(int[] nums) {
        super();
        this.batchInsert(nums);
    }

    public static TreeNode findLeftSuccessor(TreeNode node) {// 找临近值
        if (node.left != null) {
            TreeNode curr = node.left;
            while (curr.right != null) {
                curr = curr.right;
            }

            return curr;
        }

        return null;
    }

    public static TreeNode findRightSuccessor(TreeNode node) {
        if (node.right != null) {
            TreeNode curr = node.right;
            while (curr.left != null) {
                curr = curr.left;
            }

            return curr;
        }

        return null;
    }

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
            return;// 默认返回什么也不做
        }
        TreeNode current = root;// 不断改变的当前指针，要插入的位置
        TreeNode parent;// 当前指针的父节点
        while (true) {
            parent = current;
            if (parent.val > value) {
                current = parent.left;
                if (current == null) {
                    parent.left = new TreeNode(value);
                    return;
                }
            } else if (parent.val < value) {
                current = parent.right;
                if (current == null) {
                    parent.right = new TreeNode(value);
                    return;
                }
            } else {
                return;// BST does't allow nodes with the same value;//如果相等什么都不用做直接退出
            }
        }
    }// 因为当前指针为null的时候是没有意义的默认节点，就如所有的Leaf节点都会指向null，
     // 既然是空的没意义的节点，就不能直接的赋值；
     // 需借助父节点的帮助来决定需要添加left child还是right child

    public void batchInsert(int[] vals) { // 批量插入
        for (int v : vals) {
            insert(v);// 每个元素都要调用一次插入函数
        }
    }

    public boolean get(int value) {
        if (root == null) {
            return false;
        }
        TreeNode current = root;// current指针从root开始寻找
        while (current != null && current.val != value) {// 循环跳出条件：current指针还没有迭代完且current值不等于目标值
            if (current.val > value) {
                current = current.left;
            } else if (current.val < value) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;// 若迭代结束还没找到
    }

    public boolean delete(int key) {
        TreeNode parent = root;
        TreeNode current = root;
        boolean isLeftChild = false;
        while (current != null && current.val != key) {
            parent = current;
            if (current.val > key) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
        }

        if (current == null) {
            return false;
        }

        // case1:if node to be deleted has no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else {
            current.val = getSuccessor(current);
        }
        return true;
    }

    public int getSuccessor(TreeNode node) {
        if (node.left != null) {
            // find most right of left
            TreeNode current = node.left;
            TreeNode parent = node;
            while (current.right != null) {
                parent = current;
                current = current.right;
            }

            int res = current.val;
            if (parent == node) {
                if (current.left != null) {
                    node.left = current.left;
                } else {
                    node.left = null;
                }
            } else {
                if (current.left != null) {
                    parent.right = current.left;
                } else {
                    parent.right = null;
                }
            }

            return res;
        }

        // find most left node of right
        TreeNode current = node.right;
        TreeNode parent = node;
        while (current.left != null) {
            parent = current;
            current = current.left;
        }

        int res = current.val;
        if (parent == node) {
            if (current.right != null) {
                node.right = current.right;
            } else {
                node.right = null;
            }

        } else {
            if (current.right != null) {
                parent.left = current.right;
            } else {
                parent.left = null;
            }
        }

        return res;
    }
}
/*
 * BinarySearchTree bst = new BinarySearchTree(); bst.insert(10);
 * bst.batchInsert(new int[] { 2, 5, 8, 12, 16, 20 }); bst.print();
 * 
 * for (int v = 0; v <= 20; v++) { System.out.println("Delete " + v + ": " +
 * bst.delete(v)); bst.print(); }
 * 
 * bst.batchInsert(new int[] { 2, 5, 8, 12, 16, 20 }); bst.print();
 * 
 * for (int v = 20; v >= 0; v--) { System.out.println("Delete " + v + ": " +
 * bst.delete(v)); bst.print(); }
 * 
 * bst.printPre(); //BinarySearchTree.PreOrder(bst.root);
 */
