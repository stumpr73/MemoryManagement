package MemoryManagement;


public class Tree {
	private Tree left;
	private Tree right;
	private int size;
	private Process lp;
	private Tree parent;

	public Tree(int s, Tree p){
		size = s;
		left = null;
		right = null;
		parent = p;
	}
	public void allocate(Process p){
		Tree c = null;
		if(p.getSize()<= size/2){
			if(left.equals(null) && right.equals(null)){
				generateChildren();
			}
			c = findSuitableChild(p);
			c.allocate(p);
		}
		else
			assingProcess(p);
	}

	public void generateChildren(){
		left = new Tree(size/2,this);
		right = new Tree(size/2,this);
	}
	public Tree findSuitableChild(Process p){
		Tree child = null;
		
		return child;
	}
	public void assingProcess(Process p){
		if(left.getSize() <= right.getSize() && p.getSize() <= left.getSize()){
			left.lp = p;
			size = 0;
		}
		else if(left.getSize() > right.getSize() && p.getSize() >= left.getSize()){
			right.lp = p;
			size = 0;
		}
		else
			System.out.println("Add another condition");
		//need to make this
	}

	public void deallocate(Process p){
		Tree n = find(p);
		n.setLp(null);
		update(p);
	}

	public void update(Process p){
		updateSizes(p);
		//This if statements 
		if((parent.getLeft().getLp() == null) && (parent.getRight().getLp() == null)){
			parent.left = null;
			parent.right = null;
		}
	}

	public Tree find(Process p){
		if(lp.equals(p)){
			return this;
		}
		else{
			if(left == null && right == null)
				return null;
			else{
				Tree node1;
				Tree node2;
				node1=right.find(p);
				node2 = left.find(p);
				if(node1 != null)
					return node1;
				else if (node2 != null)
					return node2;
				else
					return null;
			}
		}
	}



	//As of right now this method is only used for allocate method
	//if we want to use this method for deallocated as well, then
	//we change this method
	public void updateNumbers(Process p){
		size = size - p.getSize();
		if(!(parent.equals(null)))
			parent.updateNumbers(p);
			else{
				//indicator
			}
	}

	public void updateSizes(Process p){
		size = size - p.getSize();
		if(!(parent.equals(null)))
			parent.updateSizes(p);
			else{
				//indicator
			}
	}
	public Tree getLeft() {
		return left;
	}
	public void setLeft(Tree left) {
		this.left = left;
	}
	public Tree getRight() {
		return right;
	}
	public void setRight(Tree right) {
		this.right = right;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Process getLp() {
		return lp;
	}
	public void setLp(Process lp) {
		this.lp = lp;
	}
	public void setParent(Tree parent) {
		this.parent = parent;
	}

}
