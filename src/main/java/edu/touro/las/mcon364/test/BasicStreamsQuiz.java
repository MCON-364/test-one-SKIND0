package edu.touro.las.mcon364.test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class BasicStreamsQuiz {

    private final Map<String, List<Integer>> scoresByCourse;

    public BasicStreamsQuiz() {
        scoresByCourse = new LinkedHashMap<>();
        scoresByCourse.put("Algorithms", List.of(91, 84, 96, 88));
        scoresByCourse.put("Databases", List.of(77, 81, 79, 85));
        scoresByCourse.put("Networks", List.of(68, 73, 70, 75));
        scoresByCourse.put("Java", List.of(95, 92, 90, 98));
    }

    /**
     * Problem 6
     * Return all course names sorted alphabetically.
     */
    public List<String> getSortedCourseNames() {
        //return stream().sort().toString();
        //return scoresByCourse.keySet().stream().sorted().toList();
        // professor i get that you want me to use collections somehow, but i don't get how. and i really did study this

        Map<String, List<Integer>> result = scoresByCourse.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue()));
        return result.keySet().stream().collect(Collectors.toList());
    }

    /**
     * Problem 7
     * Across all courses, count how many scores are greater than or equal to threshold.
     */
    public long countScoresAtLeast(int threshold) {
        // scoresByCourse.stream().filter(count -> count >= threshold).count();
        //return x -> x.stream().filter(count -> count >= threshold).count();

    }
    //fyi there's no groupingby or tomap which is mostly what i practiced. this is all with a map where value is a list which i see now i practiced the least and don't know the syntax very well at all.

    /**
     * Problem 8
     * Return the first word whose length is greater than minLength.
     * If none exists, return Optional.empty().
     */
    public Optional<String> firstLongWord(List<String> words, int minLength) {
        return Optional.of(words.stream().filter(x -> x.length() > minLength).findFirst());
    }
    /**
     * Problem 9
     * Return a new list containing the square of each number.
     * Use streams.
     */
    public List<Integer> squareAll(List<Integer> numbers) {
        return numbers.stream().map(x -> x^2).toList();
        //i might be doing the math wrong. the math.pow isn't working either if that's what i'm meant to do even.

    }

    /**
     * Problem 10
     * Return the average of all passing scores across all courses.
     * A passing score is 70 or above.
     *
     * Return 0.0 if there are no passing scores.
     */
    public double averagePassingScore() {
        //List<Double> scores = scoresByCourse.stream().filter(score -> score >= 70).toList().;
        //int count = scoresByCourse.size();
        //return (double) count / (double) scores.size();



    }
}
