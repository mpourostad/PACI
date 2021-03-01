// used the code shared in the class website. I just overloaded the method "add". 
public class ArrayList<E> implements List<E> {
	 public static final int CAPACITY=1000; 
	 private E[ ] data; 
	 private int size = 0; 
	 // constructors
	 public ArrayList() { 
		 this(CAPACITY);
	 }
	 public ArrayList(int capacity) { 
	 data = (E[ ]) new Object[capacity]; 
	 }
	 // public methods
	 public int size( ) { 
		 return size; 
 	 }
	 public boolean isEmpty( ) {
		 return size == 0;
	 }
	 public E get(int i) throws IndexOutOfBoundsException {
		 checkIndex(i, size);
		 return data[i];
	 }
	 public E set(int i, E e) throws IndexOutOfBoundsException {
		 checkIndex(i, size);
		 E temp = data[i];
		 data[i] = e;
		 return temp;
	 }
	 public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
		 checkIndex(i, size + 1);
		 if (size == data.length){// not enough capacity
			 throw new IllegalStateException("Array is full");
		 }
		 for (int k = size - 1; k >= i; k--) {
				 data[k+1] = data[k];
				 data[i] = e; // ready to place the new element
				 size++;
		 }
	 }
	 public void add(E e) throws IndexOutOfBoundsException, IllegalStateException {
		 if (size == data.length){// not enough capacity
			 throw new IllegalStateException("Array is full");
		 }
		 data[size] = e;
		 size++;
	 }
	 public E remove(int i) throws IndexOutOfBoundsException {
		 checkIndex(i, size);
		 E temp = data[i];
		 for (int k=i; k < size-1; k++) // shift elements to fill hole
		 data[k] = data[k+1];
		 data[size-1] = null; // help garbage collection
		 size--;
		 return temp;
	 }
	 // utility method
	 protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
		 if (i < 0 || i >= n)
		 throw new IndexOutOfBoundsException("Illegal index: " + i);
	 }
 }
