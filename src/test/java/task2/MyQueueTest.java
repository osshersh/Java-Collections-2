package task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {
    MyQueue myQueue;

    @BeforeEach
    void init() {
        myQueue = new MyQueue();
        myQueue.add(43);
        myQueue.add(44);
        myQueue.add(45);
    }

    @Test
    void shouldReturnTrueWhenAddToMyQueue() {
        boolean isAdd = myQueue.add(87);
        assertTrue(isAdd);
    }

    @Test
    void shouldAddElement() {
        Integer value = myQueue.element();
        assertEquals(43, value);
    }

    @Test
    void shouldRemoveElement() {
        assertEquals(43, myQueue.remove());
    }

    @Test
    void shouldGetFirstElementInQueue() {
        assertEquals(43, myQueue.element());
    }

    @Test
    void shouldReturnNoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> {
            myQueue.remove();
            myQueue.remove();
            myQueue.remove();
            myQueue.remove();
        });
    }
}