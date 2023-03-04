import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CustomLinkedListTest {

    private CustomLinkedList<String> list;

    @Before
    public void setUp() {
        list = new CustomLinkedList<>();
        list.add("first");
        list.add("second");
        list.add("third");
    }

    // Test 1: проверим, что последний добавленный элемент является последним элементом списка
    @Test
    public void testAdd() {
        list.add("forth");
        assertEquals("forth", list.last.item);
    }

    // Test 2: проверим, что вызов метода get существующего индекса работает корректно
    @Test
    public void testGet() {
        String item = list.get(1);
        assertEquals("second", item);
    }

    // Test 3: проверим, что вызов метода get для несуществующего индекса приводит к выбросу IndexOutOfBoundsException
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetInvalidIndex() {
        list.get(5);
    }

    // Test 4: проверим, что вызов метода remove удаляет элемент из списка и верный элемент возвращается
    @Test
    public void testRemove() {
        String item = list.remove(1);
        assertEquals("second", item);
        assertFalse(list.last.item.equals(item));
    }

    // Test 5: проверим, что вызов метода remove(E) удаляет элемент из списка, когда элемент существует
    @Test
    public void testRemoveElement() {
        String item = list.remove("second");
        assertEquals("second", item);
        assertFalse(list.last.item.equals(item));
    }

    // Test 6: проверим, что вызов метода remove(E) приводит к выбросу NoSuchElementException, если элемент отсутствует в списке
    @Test(expected = NoSuchElementException.class)
    public void testRemoveInvalidElement() {
        String item = list.remove("forth");
    }
}
