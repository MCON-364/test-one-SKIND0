package edu.touro.las.mcon364.test;

import java.util.*;

import static java.lang.Double.parseDouble;

public class StudyTracker {

    private final Map<String, List<Integer>> scoresByLearner = new HashMap<>();
    private final Deque<UndoStep> undoStack = new ArrayDeque<>();
    // Helper methods already provided for tests and local inspection.
    public Optional<List<Integer>> scoresFor(String name) {
        return Optional.ofNullable(scoresByLearner.get(name));
    }

    public Set<String> learnerNames() {
        return scoresByLearner.keySet();
    }
    /**
     * Problem 11
     * Add a learner with an empty score list.
     *
     * Return:
     * - true if the learner was added
     * - false if the learner already exists
     *
     * Throw IllegalArgumentException if name is null or blank.
     */
    public boolean addLearner(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        scoresByLearner.put(name, new ArrayList<>());
        return !name.equals(scoresByLearner.keySet().iterator().next());
    }

    /**
     * Problem 12
     * Add a score to an existing learner.
     *
     * Return:
     * - true if the score was added
     * - false if the learner does not exist
     *
     * Valid scores are 0 through 100 inclusive.
     * Throw IllegalArgumentException for invalid scores.
     *
     * This operation should be undoable.
     */
    public boolean addScore(String name, int score) {
        if (score > 100 || score < 0) {
            throw new IllegalArgumentException();
        }
        scoresByLearner.get(name).add(score);
        return !name.equals(scoresByLearner.keySet().iterator().next());

    }

    /**
     * Problem 13
     * Return the average score for one learner.
     *
     * Return Optional.empty() if:
     * - the learner does not exist, or
     * - the learner has no scores
     */
    public Optional<Double> averageFor(String name) {
        var learner = scoresByLearner.get(name);
        if (learner == null || learner.isEmpty()) {
            return Optional.empty();
        }
        Double sum = scoresByLearner.get(name).stream().mapToDouble(l -> l).sum();
        Double count = (double) learner.size();
        return Optional.of(sum / count);
    }

    /**
     * Problem 14
     * Convert a learner average into a letter band.
     *
     * A: 90+
     * B: 80-89.999...
     * C: 70-79.999...
     * D: 60-69.999...
     * F: below 60
     *
     * Return Optional.empty() when no average exists.
     */
    public Optional<String> letterBandFor(String name) {
        if (averageFor(name).isEmpty()) {
            return Optional.empty();
        }
        var av = averageFor(name);
        if (av >= 90)
            return "A";
        else if (av >= 80)
            return "B";
        else if (av >=70)
            return "C";
        else if (av >=60)
            return "D";
        else
            return "F";
    }
    //it's like this cuz the switch gave me so many errors i want to leave it like this for a second. i'll get back

    /**
     * Problem 15
     * Undo the most recent state-changing operation.
     *
     * Return true if something was undone.
     * Return false if there is nothing to undo.
     */
    public boolean undoLastChange() {
        UndoStep undoStep = undoStack.pollLast();
        assert undoStep != null;
        undoStep.undo();
        return !undoStack.isEmpty();
    }


}
