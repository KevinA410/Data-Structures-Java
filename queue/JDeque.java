package queue;

/**
 * The JDeque class represents a queue that supports elements insertions and removal at both ends.
 * @author Kevin Arias
 * @param <T>
 */
public class JDeque<T>{
	private T item;
	private JDeque<T> next, back;
	private JDeque<T> last = this;
	private int size = 0;
	
	/**
	 * Creates an empty deque.
	 */
	public JDeque() {
		item = null;
		next = null;
		back = null;
	}
	
	/**
	 * Insert an specified item in the top of this deque.
	 * @param item
	 */
	public void offerFront(T item) {
		if(this.item == null) {
			this.item = item;
		}else {
			JDeque<T> node = new JDeque<>();
			node.item = this.item;
			node.next = next;
			
			this.item = item;
			next = node;
			
			node.back = this;
		}
		size++;
	}
	
	/**
	 * Insert an specified item in the last position of this deque.
	 * @param item
	 */
	public void offerBack(T item) {
		if(this.item == null) {
			this.item = item;
		}else {
			JDeque<T> node = new JDeque<>();
			node.item = item;
			node.back = last;
			
			last.next = node;
			last = node;
		}
		size++;
	}
	
	/**
	 * Returns and removes the first item of this deque.
	 * @return The head of the deque
	 */
	public T pollFront() {
		if(item == null) return null;
		if(next == null) next = new JDeque<T>();
		
		T poll = item;
		item = next.item;
		next = next.next;
		size--;
		
		return poll;
	}
	
	/**
	 * Returns and removes the last item of this deque.
	 * @return The tail of the deque
	 */
	public T pollBack() {
		if(last.item == null) return null;
		if(back == null) back = new JDeque<T>();
		
		T poll = last.item;
		last = last.back;
		size--;
		
		return poll;
	}
	
	/**
	 * Looks at the item at the top of this deque without remove it.
	 * @return The head of the deque
	 */
	public T peekFirst() {
		return item;
	}
	
	/**
	 * Looks at the last item from this deque without remove it.
	 * @return The tail of the deque
	 */
	public T peekLast() {
		return last.item;
	}
	
	/**
	 * Returns the number of items that is containing in the deque.
	 * @return The number of items of the deque
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Test if this deque has no items.
	 * @return True if the deque is empty
	 */
	public boolean isEmpty() {
		return (item == null);
	}
	
	/**
	 * Test if exist an specified item into the deque.
	 * @param item
	 * @return True if exist the specified item
	 */
	public boolean exist(T item) {
		if(this.item == null) return false;
		else if(this.item == item) return true;
		else return next.exist(item);
	}
	
	/**
	 * Remove all of the items from this deque.
	 */
	public void clear() {
		item = null;
		next = null;
		back = null;
		last = null;
		size = 0;
	}
}
