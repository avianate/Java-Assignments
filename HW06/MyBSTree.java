// Nate Graham	A00305171



/*
 	Sources:
	http://www.algolist.net/Data_structures/Binary_search_tree
	http://www.brilliantsheep.com/a-complete-binary-search-tree-implementation-in-java/
	http://programming4interviews.wordpress.com/2011/08/06/4-check-if-the-given-binary-tree-is-balanced/

 */




public class MyBSTree implements BSTree {

	private boolean enableDuplicates = false;
	private Node root;
	
	// default constructor
	public MyBSTree() {};
	
	
	public MyBSTree(boolean bool)
	{
		enableDuplicates = bool;
	}


	
	
	public void insert(int value)
	{
		// create new node then call recursive method to insert the node into the tree
		Node newNode = new Node(value, null, null);
		insert(newNode);

	}

	public void insert(Node nodeToInsert)
	{
		Node parentNode = null;
		Node nodeToCompare = root;

		while (nodeToCompare != null)
		{
			// start by comparing with the root node
			parentNode = nodeToCompare;

			// if nodeToIsert is less than the root compare the left child
			if (nodeToInsert.getValue() < nodeToCompare.getValue())
			{
				nodeToCompare = nodeToCompare.getLeft();
			}
			// else check the right child
			else
			{
				nodeToCompare = nodeToCompare.getRight();
			}
		}

		// now set the inserted node's parent
		nodeToInsert.setParent(parentNode);

		if (parentNode == null)
			root = nodeToInsert;

		// if node is a duplicate and duplicates aren't allowed then return
		else if (!enableDuplicates && nodeToInsert.getValue() == parentNode.getValue())
			return;
		
		// otherwise if inserted node is < parent, insert node to the left
		else if (nodeToInsert.getValue() < parentNode.getValue())
			parentNode.setLeft(nodeToInsert);
		
		// node is greater than the parent so insert to the right
		else
			parentNode.setRight(nodeToInsert);
	}


	
	
	public void remove(int value) {
		remove(root, value);
	}

	public void remove(Node node, int value)
	{
		// node to delete not found
		if (node == null)
		{
			return;
		}
		

		// node to delete is found
		else if (value == node.value)
		{
			// if no left subtree then place right subtree where the node to delete is
			if (node.left == null)
			{
				swap(node, node.right);
			}

			// if no right subtree then place the left subtree where the node to delete is
			else if (node.right == null)
			{
				swap(node, node.left);
			}

			// node has left & right subtrees. Find smallest node in the right subtree and exchange values between node to delete
			else
			{
				Node minNode = node.right;

				while(minNode.left != null)
				{
					minNode = minNode.left;
				}

				if (minNode.parent != node)
				{
					swap(minNode, minNode.right);
					minNode.right = node.right;
					minNode.right.parent = minNode;
				}

				swap(node, minNode);
				minNode.left = node.left;
				minNode.left.parent = minNode;
			}
		}

		// continue search in the left subtree
		else if (value < node.value)
		{
			remove(node.left, value);
		}

		// continue search in the right subtree
		else
		{
			remove(node.right, value);
		}
	}
	
	
	


	public void inorderTraversal()
	{
		inorderTraversal(root);
	}


	private void inorderTraversal(Node node)
	{
		if(node != null) 
		{
			inorderTraversal(node.left);
			System.out.print(node.value + " ");
			inorderTraversal(node.right);
		}
	}

	
	// swap nodes to keep tree balanced
	public void swap(Node nodeToMoveDown, Node nodeToMoveUp)
	{

		if (nodeToMoveDown.parent == null)
			root = nodeToMoveUp;
		

		else if (nodeToMoveDown == nodeToMoveDown.parent.left)
			nodeToMoveDown.parent.left = nodeToMoveUp;
		
	
		else
			nodeToMoveDown.parent.right = nodeToMoveUp;

		if (nodeToMoveUp != null)
		{
			nodeToMoveUp.parent = nodeToMoveDown.parent;
		}
	}


	public int sumDepth()
	{
		return sumDepth(root, 0);
	}


	private int sumDepth(Node node, int depth)
	{
		if (node == null)
			return 0;

		return depth + sumDepth(node.getLeft(), depth+1) + sumDepth(node.getRight(), depth+1);
	}



	public int maxDepth()
	{
		return maxDepth(root);
	}



	private int maxDepth(Node node)
	{
		if( node == null ) 
			return 0;

		int leftDepth = maxDepth( node.left );
		int rightDepth = maxDepth( node.right );

		return leftDepth < rightDepth ? rightDepth + 1 : leftDepth + 1;
	}


	public int minDepth()
	{
		return minDepth(root);
	}


	private int minDepth(Node node)
	{
		if( node == null ) 
			return 0;

		int leftDepth = maxDepth( node.left );
		int rightDepth = maxDepth( node.right );

		return leftDepth < rightDepth ? leftDepth + 1 : rightDepth + 1;
	}



	public boolean isBalanced()
	{
		return (maxDepth() - minDepth() <= 1);
	}



	public void preOrderTraversal() {

		preOrderTraversal(root, null);
	}


	public void preOrderTraversal(Node node, Node previous)
	{
		if (node != null)
		{
			System.out.print(node.value + " ");

			preOrderTraversal(node.left, node);
			preOrderTraversal(node.right, node);
		}

	}



	private static class Node
	{
		private int value;
		private Node parent;
		private Node left;
		private Node right;

		public Node(int value, Node left, Node right)
		{
			this.setValue(value);
			this.setLeft(left);
			this.setRight(right);
		}

		public void setValue(int value)
		{
			this.value = value;
		}


		public int getValue()
		{
			return value;
		}


		public void setParent(Node parent)
		{
			this.parent = parent;
		}


		@SuppressWarnings("unused")
		public Node getParent()
		{
			return parent;
		}


		public void setLeft(Node left)
		{
			this.left = left;
		}


		public void setRight(Node right)
		{
			this.right = right;
		}

		public Node getLeft()
		{
			return left;
		}


		public Node getRight()
		{
			return right;
		}
	}



}
