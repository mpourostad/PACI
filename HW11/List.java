// from the classe's website with minor adjustments. ( added line 8).
public interface List<E> {
	int size( );
	boolean isEmpty( );
	E get(int i) throws IndexOutOfBoundsException;
	E set(int i, E e) throws IndexOutOfBoundsException;
	void add(int i, E e) throws IndexOutOfBoundsException;
	void add(E e) throws IndexOutOfBoundsException;
	E remove(int i) throws IndexOutOfBoundsException;
}
