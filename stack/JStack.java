package stack;

/**
 * The JStack class represents a last-in-first-out (LIFO) stack of objects.
 * The usual push and pop operations are provided, as well as a method to peek at the top item on the stack, 
 * a method to test for whether the stack is empty, a method to test if an specified item exist, and a method to remove all items in the stack.
 * @author Kevin Arias
 *
 */
public class JStack<T> {
	private T item;
	private JStack<T> next;
	private int size = 0;
	
	/**
	 * Creates an empty stack.
	 */
	public JStack(){
		item = null;
		next = null;
	}
	
	/**
	 * Pushes an item onto the top of this stack.
	 * @param item
	 */
	public void push(T item) {
		if(this.item == null) {
			this.item = item;
		}else {
			JStack<T> node = new JStack<>();
			node.item = this.item;
			node.next = next;
			
			this.item = item;
			next = node;
		}
		size++;
	}
	
	/**
	 * Removes the object at the top of this stack.
	 * @return
	 */
	public T pop() {
		if(item == null ) return null;
		if(next == null) next = new JStack<T>();
		
		T pop = item;
		item = next.item;
		next = next.next;
		size--;
		
		return pop;
	}
	
	/**
	 * Looks at the item at the top of this stack without remove it.
	 * @return
	 */
	public T peek() {
		return item;
	}
	
	/**
	 * Test if this stack has no items.
	 * @return
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
	
	/**
	 * Remove all items of this stack.
	 */
	public void clear() {
		item = null;
		next = null;
		size = 0;
	}
	
	/**
	 * Returns the number of items that is containing in the stack.
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Returns if exist an specified item into the stack.
	 * @param item
	 * @return
	 */	
	public boolean exist(T item) {
		if(this.item != item && next == null) return false;
		else if(this.item == item) return true;
		else return next.exist(item);
	}
}