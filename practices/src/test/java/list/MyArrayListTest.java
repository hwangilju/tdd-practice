package list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyArrayListTest {

    @Test
    public void testMyArrayListTest() {
        List<String> myArrayList = new MyArrayList();
        assertThat(myArrayList).isInstanceOf(MyArrayList.class);
        assertThat(myArrayList).isInstanceOf(List.class);
    }

    @Test
    public void testAdd() {
        List<String> myArrayList = new MyArrayList();
        for (int i = 0; i < 10; i++) {
            myArrayList.add("String " + i);
        }
        assertThat(myArrayList.size()).isEqualTo(10);
    }

    @Test
    public void testAddAllCollection() {
        List<String> myArrayList = new MyArrayList();

        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("Java 12");

        myArrayList.addAll(list);

        assertThat(myArrayList.size()).isEqualTo(3);
    }

    @Test
    public void testClear() {
        List<String> myArrayList = new MyArrayList();
        myArrayList.add("Hello");
        myArrayList.add("World");
        myArrayList.add("Java 12");
        myArrayList.clear();
        assertThat(myArrayList.size()).isEqualTo(0);
    }

    @Test
    public void testContains() {
        List<String> myArrayList = new MyArrayList();
        myArrayList.add("Hello");
        myArrayList.add("World");
        myArrayList.add("Java 12");
        assertThat(myArrayList.contains("Hello")).isEqualTo(true);
        assertThat(myArrayList.contains("World")).isEqualTo(true);
        assertThat(myArrayList.contains(null)).isEqualTo(false);
        myArrayList.add(null);
        assertThat(myArrayList.contains(null)).isEqualTo(true);
    }

    @Test
    public void testContainsAll() {
        List<String> myArrayList = new MyArrayList();
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("Java 12");
        myArrayList.addAll(list);
        assertThat(myArrayList.containsAll(list)).isEqualTo(true);
    }
    @Test
    public void testIndexOf() {
        List<String> myArrayList = new MyArrayList();
        myArrayList.add("Hello");
        myArrayList.add("World");
        myArrayList.add("Java 12");
        assertThat(myArrayList.indexOf("Hello")).isEqualTo(0);
        assertThat(myArrayList.indexOf("World")).isEqualTo(1);
        assertThat(myArrayList.indexOf("Java 12")).isEqualTo(2);
    }

    @Test
    public void testRemove() {
        List<String> myArrayList = new MyArrayList();
        myArrayList.add("Hello");
        myArrayList.add("World");
        myArrayList.add("Java 12");
        assertThat(myArrayList.remove(2)).isEqualTo("Java 12");
        assertThat(myArrayList.remove(1)).isEqualTo("World");
        assertThat(myArrayList.remove(0)).isEqualTo("Hello");
    }

    @Test
    public void testRemoveAll() {
        List<String> myArrayList = new MyArrayList();
        myArrayList.add("Hello");
        myArrayList.add("Hello");
        myArrayList.add("Hello");
        myArrayList.add("Hello");
        myArrayList.add("World");
        myArrayList.add("World");
        myArrayList.add("Java 12");

        List<String> exList = new ArrayList();
        exList.add("Hello");
        exList.add("World");
        myArrayList.removeAll(exList);
        assertThat(myArrayList.get(0)).isEqualTo("Java 12");
    }
}