package java8inaction;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author KangShan
 * @date 2019/11/15 22:46
 */
public class Stream implements List {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 3, 23, 2, 34);
        integers.stream().collect(
                Collectors.toMap(HashMap:: new, Integer::byteValue));
        Map<Boolean, List<Integer>> collect =
                integers.stream().collect(Collectors.groupingBy(i -> i > 0));

        /**
         * 实现类可以直接调用接口的默认方法,
         * 同时，默认方法也可以被实现类给复写。
         */
        new Stream().sort(Comparator.naturalOrder());
    }

    /***
     * As a default method defined in interface, it could be override in class
     *
     * @author  KangShan
     * @date    2019/11/17 20:37
     */
    @Override
    public void sort(Comparator c) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
