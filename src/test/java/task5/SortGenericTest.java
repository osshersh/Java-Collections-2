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
        numbers = new Integer[]{4, 333, 44};
        strings = new String[]{"winter", "autumn", "spring"};
        characters = new Character[]{'w', 's', 'a'};
        doubles = new Double[]{55.45, 45.09, 45.45};

        sortGeneric.sortGenericArray(numbers);
        sortGeneric.sortGenericArray(strings);
        sortGeneric.sortGenericArray(characters);
        sortGeneric.sortGenericArray(doubles);
    }

    @Test
    void shouldSortStringType() {
        assertEquals("[autumn, spring, winter]", Arrays.toString(strings));
    }

    @Test
    void shouldSortIntegerType() {
        assertEquals("[4, 44, 333]", Arrays.toString(numbers));
    }

    @Test
    void shouldSortCharacterType() {
        assertEquals("[a, s, w]", Arrays.toString(characters));
    }

    @Test
    void shouldSortDoubleType() {
        assertEquals("[45.09, 45.45, 55.45]", Arrays.toString(doubles));
    }
}