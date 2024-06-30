package com.jimmydomain.common.util;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Jimmy Hu
 * */

public class CollectionUtils {
    /**
     * Checks if a collection is empty (null or has no elements).
     */
    public static boolean isEmpty(Collection<?> collection) {
        return Objects.isNull(collection) || collection.isEmpty();
    }

    /**
     * Checks if a collection contains a specific element.
     */
    public static <T> boolean contains(Collection<T> collection, T element) {
        return collection != null && collection.contains(element);
    }

    /**
     * Adds all elements from the source collection to the target collection.
     */
    public static <T> void addAll(Collection<T> target, Collection<? extends T> source) {
        if (target != null && source != null) {
            target.addAll(source);
        }
    }

    /**
     * Removes all elements from the target collection that are contained in the source collection.
     */
    public static <T> void removeAll(Collection<T> target, Collection<? extends T> source) {
        if (target != null && source != null) {
            target.removeAll(source);
        }
    }

    /**
     * Creates an unmodifiable list from the given list.
     */
    public static <T> List<T> unmodifiableList(List<? extends T> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList<>(list));
    }

    /**
     * Reverses the order of elements in a list.
     */
    public static <T> void reverse(List<T> list) {
        if (list != null) {
            Collections.reverse(list);
        }
    }


    /**
     * Filters a collection based on a predicate.
     *
     * @param collection the collection to filter
     * @param predicate the predicate to apply
     * @param <T> the type of elements in the collection
     * @return a new list containing the elements that match the predicate
     */
    public static <T> List<T> filter(Collection<T> collection, Predicate<T> predicate) {
        if (isEmpty(collection)) {
            return Collections.emptyList();
        }
        return collection.stream().filter(predicate).collect(Collectors.toList());
    }

    /**
     * Finds the first element in a collection that matches a predicate.
     *
     * @param collection the collection to search
     * @param predicate the predicate to apply
     * @param <T> the type of elements in the collection
     * @return an optional containing the first matching element, or an empty optional if no match is found
     */
    public static <T> Optional<T> findFirst(Collection<T> collection, Predicate<T> predicate) {
        if (isEmpty(collection)) {
            return Optional.empty();
        }
        return collection.stream().filter(predicate).findFirst();
    }

    /**
     * Groups a collection of elements by a classifier function.
     *
     * @param collection the collection to group
     * @param classifier the classifier function
     * @param <T> the type of elements in the collection
     * @param <K> the type of the key
     * @return a map where the keys are the result of applying the classifier function and the values are lists of items
     */
    public static <T, K> Map<K, List<T>> groupBy(Collection<T> collection, Function<T, K> classifier) {
        if (isEmpty(collection)) {
            return Collections.emptyMap();
        }
        return collection.stream().collect(Collectors.groupingBy(classifier));
    }

    /**
     * Counts the number of elements in a collection that match a predicate.
     *
     * @param collection the collection to search
     * @param predicate the predicate to apply
     * @param <T> the type of elements in the collection
     * @return the number of matching elements
     */
    public static <T> long count(Collection<T> collection, Predicate<T> predicate) {
        if (isEmpty(collection)) {
            return 0;
        }
        return collection.stream().filter(predicate).count();
    }
}
