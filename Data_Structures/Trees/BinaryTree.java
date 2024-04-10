package Data_Structures.Trees;

import Exceptions.StackQueueExceptions;

import java.util.Scanner;

private class Node
{
	private Key key;
	private Value val;
	private Node left;
	private Node right;
	
	public Node(Key key, Value val)
	{
		this.key = key;
		this.val = val;
	}
}

public class BinarySearchTree<Key extends Comparable<Key>>, <Value>
{
	private Node root;
	
	private Node set(Node x, Key key, Value val)
	{
		if (x == null)
		{
			return new Node(key, val);
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
		{
			x.left = set(x.left, key, val);
		}
		else if (cmp > 0)
		{
			x.right = set(x.right, key, val);
		}
		else
		{
			x.val = val;
		}
		return x;
	}
	
	public void set(Key key, Value val)
	{
		root = set(root, val);
	}
	
	public Value get(Key key)
	{
		Node x =root;
		while (x != null)
		{
			int cmp = key.copareTo(x.key);
			if (cmp < 0)
			{
				x = x.left;
			}
			else if (cmp > 0)
			{
				x = x.right;
			}
			else
			{
				return x.val;
			}
		}
		return null;
	}
	
	public void delete(Key key)
	{
	}
	
	public Iterable<Key> iterator()
	{
	}
	
}
