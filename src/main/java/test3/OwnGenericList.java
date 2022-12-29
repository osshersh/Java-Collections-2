package test3;

public class OwnGenericList<E> implements OwnList<E> {
    private Object[] table;
    private int size;

    public OwnGenericList() {
        table = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E element) {
        table[size] = element;
        size++;
        Object[] newTable = new Object[table.length + 1];
        for (int i = 0; i < table.length; i++) {
            newTable[i] = table[i];
        }
        table = newTable;
        return true;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) table[index];
    }

    @Override
    public boolean remove(E element) {
        int searchIndex = -1;
        for (int i = 0; i < size; i++) {
            if (element.equals(table[i])) {
                searchIndex = i;
                break;
            }
        }
        if (searchIndex != -1) {
            removeByIndex(searchIndex);
            return true;
        }
        return false;
    }

    private void removeByIndex(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            table[i] = table[i + 1];
        }
        size--;
    }

    private void checkIndex(int index) {
        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bound");
        }
    }
}
