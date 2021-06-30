import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class traverseBinTree {
	List<Integer> treenodes = new ArrayList<>();
	public traverseBinTree() {
		// TODO Auto-generated constructor stub
	}
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                curLevel.add(cur.val);
                if(cur.left != null) 
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.add(cur.right);
            }
            ans.add(curLevel);
        }
        return ans;
	}
	public List<Integer> inOrder(TreeNode root) {
		if(root != null) {
			if(root.left != null) 
				inOrder(root.left);
			treenodes.add(root.val);
			if(root.right != null)
				inOrder(root.right);
		}
		return treenodes;
		
	}

}
