package task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MyMapTest {
    MyMap myMap;

    @BeforeEach
    void initMap() {
        myMap = new MyMap();
    }

    @Test
    void shouldTrueWhenPutToMyMap() {
        assertTrue(myMap.put("one", "1"));
    }

    @Test
    void shouldFalseWhenKeyAlreadyExist() {
        myMap.put("one", "1");
        assertFalse(myMap.put("one", "2"));
    }

    @Test
    void shouldReturnTrueWhenContainsKey() {
        myMap.put("one", "1");
        assertTrue(myMap.containsKey("one"));
    }

    @Test
    void shouldReturnFalseWhenKeyNotContains() {
        myMap.put("one", "1");
        assertFalse(myMap.containsKey("two"));
    }

    @Test
    void shouldReturnTrueIfValuePresent() {
        myMap.put("one", "1");
        myMap.put("two", "2");
        myMap.put("three", "3");

        boolean isContains = myMap.containsValue("3");
        assertTrue(isContains);
    }

    @Test
    void shouldReturnFalseIfValueNotPresent() {
        myMap.put("one", "1");
        myMap.put("two", "2");
        myMap.put("three", "3");

        boolean isContains = myMap.containsValue("4");
        assertFalse(isContains);
    }

    @Test
    void shouldGetKeyValue() {
        myMap.put("one", "1");
        myMap.put("two", "2");
        myMap.put("three", "3");

        assertEquals("2", myMap.get("two"));
    }

    @Test
    void shouldDoesNotExistKey() {
        myMap.put("one", "1");
        myMap.put("two", "2");
        myMap.put("three", "3");
        String checkKey = myMap.getKey("four");

        assertEquals("key: four does not exist", checkKey);
    }

    @ParameterizedTest
    @MethodSource("provideKeyAndValueToCheckRemoveMethod")
    void shouldRemoveKey(String key, String value) {
        myMap.put(key, value);
        String keyAdded = myMap.getKey(key);
        String keyRemove = myMap.remove(key);
        assertEquals(keyAdded, keyRemove);
    }

    private static Stream<Arguments> provideKeyAndValueToCheckRemoveMethod() {
        return Stream.of(
                Arguments.of("one", "1"),
                Arguments.of("two", "2"),
                Arguments.of("three", "3"),
                Arguments.of("four", "4"),
                Arguments.of("five", "5"),
                Arguments.of("six", "6"),
                Arguments.of("seven", "7"),
                Arguments.of("eight", "8"));
    }
}