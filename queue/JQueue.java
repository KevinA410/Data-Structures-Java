package queue;

/**
 * The JQueue class represents a first-in-first-out (FIFO) queue of objects.
 * The usual offer and poll operations are provided, as well as a method to peek at the top item on the queue,
 * a method to test for whether the stack is empty, a method to test if an specified item exist, and a method to remove all items in the queue.
 * @author Kevin Arias
 *
 */
public class JQueue<T> {
	private T item;
	private JQueue<T> next, last = this;
	private int size = 0;
	
	/**
	 * Creates an empty queue
	 */
	public JQueue() {
		item = null;
		next = null;
	}
	
	/**
	 * Insert the specified item into this queue.
	 * @param item
	 */
	public void offer(T item) {
		if(this.item == null) {
			this.item = item;
		}else {
			JQueue<T> node =  new JQueue<>();
			node.item = item;
			
			last.next = node;
			last = node;
		}
		size++;
	}
	
	/**
	 * Retrieves and remove the object at the head of this queue.
	 * @return
	 */
	public T poll() {
		if(item == null) return null;
		if(next == null) next = new JQueue<T>();
		
		T poll = item;
		item = next.item;
		next = next.next;
		size--;
		
		return poll;
	}
	
	/**
	 * Looks at the item at the top of this queue without remove it.
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
	 * Remove all items of this queue.
	 */
	public void clear() {
		item = null;
		next = null;
		last = this;
		size = 0;
	}
	
	/**
	 * Retrieves the number of items that is containing in the queue.
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Returns if exist an specified item into the queue.
	 * @param item
	 * @return
	 */
	public boolean exist(T item) {
		if(this.item == null) return false;
		else if(this.item == item) return true;
		else return next.exist(item);
	}
}