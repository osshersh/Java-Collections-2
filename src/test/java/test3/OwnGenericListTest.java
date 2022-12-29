package test3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnGenericListTest {
    OwnList ownGenericList;

    @BeforeEach
    void init() {
        ownGenericList = new OwnGenericList();
        ownGenericList.add("Hello");
        ownGenericList.add("new");
        ownGenericList.add("world");
    }

    @Test
    void shouldReturnSize() {
        assertEquals(3, ownGenericList.size());
    }

    @Test
    void shouldReturnTrueWhenAddToList() {
        assertEquals(3, ownGenericList.size());
        boolean isAdd = ownGenericList.add("test");
        assertEquals(4, ownGenericList.size());
        assertTrue(isAdd);
    }

    @Test
    void shouldGetElement() {
        assertEquals("world", ownGenericList.get(2));
    }

    @Test
    void shouldRemoveE() {
        assertEquals(3, ownGenericList.size());
        boolean isRemove = ownGenericList.remove("world");
        assertTrue(isRemove);
        assertEquals(2, ownGenericList.size());

    }

    @Test
    void shouldCheckIndexOutOfBoundsException(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            ownGenericList.get(13);
        });
    }
}