# Java8 Stream Library Methods Practices

source article link: https://technologyconversations.com/2014/11/04/java-8-streams-micro-katas/

This kata is composed of multiple small katas for `java.util.stream.Stream` interface usage practice, 
and each small kata contains a business method and a corresponding test method.

I integrated them into two class files in type of **stream conversions** and **stream terminations** operations,
then I add a **stream generations** class, and some other conversion operations base on *CoreJava book*, 
a total of 3 BO classes with 2 test classes (can't write tests for some stream generation operations).
Since they are not in a gradual evolutionary relationship,
there is no numbered files to show steps.
The stream construction class I added is more like a use case than kata 
because there is no corresponding test, but I am still willing to add it for a complete practice.

## Description

Practise stream interface's methods by calling them, and achieve certain goal in each test.

## Practice contents

1. Stream constructions
    1. Use `java.util.Collection.stream()` to generate a stream from an existing collection.
    2. Use `Stream.of()` to generate a string stream from an existing string array.
        * (for getting boxed basic type stream such as `Stream<Integer>`, use `Arrays.stream(array).boxed()`, 
            this method can also generate stream from object type array, e.g. `Arrays.stream(T[] array)`)
    3. Use `java.nio.file.Files.lines()` to generate a string stream from an existing file.
    4. Use `Stream.generate()` with Math.random() to generate a random number stream.
    5. Use `Stream.iterate()` to generate an arithmetic sequence stream.
     
2. Stream conversions
    1. Use `Stream.map()` to convert elements of a string list to upper case.
    2. Use `Stream.mapToInt()` to make a string length list (**`List<Integer>` type**) from string list.
        * (`IntStream` have `.boxed()` method to let `IntStream` -> `Stream<Interger>`)
    3. Use `Stream.filter()` to get string elements less than given letters.
    4. Use `Stream.flatMap()` to flatten a multidimensional list.
    5. Use `Stream.sorted()` with a custom comparator to generate a sorted list.
    6. Use `Stream.distinct()` to remove duplicate elements in list.
    
    You can use `Stream.limit()`, `Stream.skip()` to get a part of stream you want,
        and use `Stream.concat()` to attach two streams.

3. Stream terminations
    1. Use `Stream.max()` with a custom comparator to get the longest string.
    2. Use `Stream.reduce()` to get sum of elements in an integer list.
    3. Use `Stream.anyMatch()` to know if there is an element less than given letters in the list.
    4. Use `Stream.toArray()` with `array cunstructors` to generate one **exact type** array.
        * (no parameter will generate an **Object** type array).
    5. Use `Stream.collect()` with `Collectors.toCollection()` to generate an **exact type** collection.
        * (There are also have Collectors.toList|toSet() to generate an interface level collection.)
    6. Use `Stream.collect()` with `Collectors.partitioningBy()` to generate a **Map<Boolean, List<ElementType>>** map,
        divide string elements into 2 group via a length classifier lambda function.
    7. Use `Stream.collect()` with `Collectors.groupingBy()` to generate a **Map<ChosenField, CollectorResult>** map,
        divide string elements into many group via a length classifier lambda function.
    
    There are many other convenient collection methods in `java.util.stream.Collectors`