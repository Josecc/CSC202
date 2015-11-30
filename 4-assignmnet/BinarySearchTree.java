public class BinarySearchTree<T extends Comparable<T>> 
             implements BSTInterface<T>
{
  protected BSTNode<T> root;

  boolean found;
  
  //Used for traversing the tree, make sure you reset THEN get. (and reset/get in the same #)
  protected LinkedUnbndQueue<T> inOrderQueue;
  protected LinkedUnbndQueue<T> preOrderQueue;
  protected LinkedUnbndQueue<T> postOrderQueue; 

  public BinarySearchTree()
  {
    root = null;
  }

  //returns if the tree is empty
  public boolean isEmpty()
  {
    return (root == null);
  }

  private int recSize(BSTNode<T> tree)
  {
    if (tree == null)    
      return 0;
    else
      return recSize(tree.getLeft()) + recSize(tree.getRight()) + 1;
  }

  //returns the size of the tree
  public int size()
  {
    return recSize(root);
  }

  public int size2()
  {
    int count = 0;
    if (root != null)
    {
      LinkedStack<BSTNode<T>> hold = new LinkedStack<BSTNode<T>>();
      BSTNode<T> currNode;
      hold.push(root);
      while (!hold.isEmpty())
      {
        currNode = hold.top();
        hold.pop();
        count++;
        if (currNode.getLeft() != null)
          hold.push(currNode.getLeft());
        if (currNode.getRight() != null)
          hold.push(currNode.getRight());
      }
    }
    return count;
  }

  private boolean recContains(T element, BSTNode<T> tree)
  {
    if (tree == null)
      return false;       // element is not found
    else if (element.compareTo(tree.getInfo()) < 0)
      return recContains(element, tree.getLeft());   // Search left subtree
    else if (element.compareTo(tree.getInfo()) > 0)
      return recContains(element, tree.getRight());  // Search right subtree
    else
      return true;        // element is found
  }

  //Returns if it has the element in the tree
  public boolean contains (T element)
  {
    return recContains(element, root);
  }
  
  private T recGet(T element, BSTNode<T> tree)
  {
    if (tree == null)
      return null;             // element is not found
    else if (element.compareTo(tree.getInfo()) < 0)
      return recGet(element, tree.getLeft());          // get from left subtree
    else
    if (element.compareTo(tree.getInfo()) > 0)
      return recGet(element, tree.getRight());         // get from right subtree
    else
      return tree.getInfo();  // element is found
  }

  public T get(T element)
  {
    return recGet(element, root);
  }

  private BSTNode<T> recAdd(T element, BSTNode<T> tree)
  {
    if (tree == null)
      // Addition place found
      tree = new BSTNode<T>(element);
    else if (element.compareTo(tree.getInfo()) <= 0)
      tree.setLeft(recAdd(element, tree.getLeft()));    // Add in left subtree
    else
      tree.setRight(recAdd(element, tree.getRight()));   // Add in right subtree
    return tree;
  }

  public void add (T element)
  {
    root = recAdd(element, root);
  }

  private T getPredecessor(BSTNode<T> tree)
  {
    while (tree.getRight() != null)
      tree = tree.getRight();
    return tree.getInfo();
  }

  private BSTNode<T> removeNode(BSTNode<T> tree)
  {
    T data;

    if (tree.getLeft() == null)
      return tree.getRight();
    else if (tree.getRight() == null) 
      return tree.getLeft();
    else
    {
      data = getPredecessor(tree.getLeft());
      tree.setInfo(data);
      tree.setLeft(recRemove(data, tree.getLeft()));  
      return tree;
    }
  }

  private BSTNode<T> recRemove(T element, BSTNode<T> tree)
  {
    if (tree == null)
      found = false;
    else if (element.compareTo(tree.getInfo()) < 0)
      tree.setLeft(recRemove(element, tree.getLeft()));
    else if (element.compareTo(tree.getInfo()) > 0)
      tree.setRight(recRemove(element, tree.getRight()));
    else  
    {
      tree = removeNode(tree);
      found = true;
	 }
    return tree;
  }

  public boolean remove (T element)
  {
    root = recRemove(element, root);
    return found;
  }

  private void inOrder(BSTNode<T> tree)
  {
    if (tree != null)
    {
      inOrder(tree.getLeft());
      inOrderQueue.enqueue(tree.getInfo());
      inOrder(tree.getRight());
    }
  }

  private void preOrder(BSTNode<T> tree)
  {
    if (tree != null)
    {
      preOrderQueue.enqueue(tree.getInfo());
      preOrder(tree.getLeft());
      preOrder(tree.getRight());
    }
  }

  private void postOrder(BSTNode<T> tree)
  {
    if (tree != null)
    {
      postOrder(tree.getLeft());
      postOrder(tree.getRight());
      postOrderQueue.enqueue(tree.getInfo());
    }
  }

  //Resets the tree, imperative before a 'get'
  public int reset(int orderType)
  {
    int numNodes = size();

    if (orderType == INORDER)
    {
      inOrderQueue = new LinkedUnbndQueue<T>();
      inOrder(root);
    }
    else
    if (orderType == PREORDER)
    {
      preOrderQueue = new LinkedUnbndQueue<T>();
      preOrder(root);
    }
    if (orderType == POSTORDER)
    {
      postOrderQueue = new LinkedUnbndQueue<T>();
      postOrder(root);
    }
    return numNodes;
  }

  public T getNext (int orderType)
  {
    if (orderType == INORDER)
      return inOrderQueue.dequeue();
    else
    if (orderType == PREORDER)
      return preOrderQueue.dequeue();
    else
    if (orderType == POSTORDER)
      return postOrderQueue.dequeue();
    else return null;
  }
}