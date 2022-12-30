package task5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class SortGenericTest {
    SortGeneric sortGeneric;
    Integer[] numbers;
    String[] strings;
    Character[] characters;
    Double[] doubles;

    @BeforeEach
    void init() {
        sortGeneric = new SortGeneric();
    }

    @Test
    void shouldSortStringType() {
        strings = new String[]{"winter", "autumn", "spring"};
        sortGeneric.sortGenericArray(strings);
        assertEquals("[autumn, spring, winter]", Arrays.toString(strings));
    }

    @Test
    void shouldSortIntegerType() {
        numbers = new Integer[]{4, 333, 44};
        sortGeneric.sortGenericArray(numbers);
        assertEquals("[4, 44, 333]", Arrays.toString(numbers));
    }

    @Test
    void shouldSortCharacterType() {
        characters = new Character[]{'w', 's', 'a'};
        sortGeneric.sortGenericArray(characters);
        assertEquals("[a, s, w]", Arrays.toString(characters));
    }

    @Test
    void shouldSortDoubleType() {
        doubles = new Double[]{55.45, 45.09, 45.45};
        sortGeneric.sortGenericArray(doubles);
        assertEquals("[45.09, 45.45, 55.45]", Arrays.toString(doubles));
    }
}