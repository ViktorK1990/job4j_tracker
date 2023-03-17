package ru.job4j.queue;

import java.util.Deque;
import java.util.LinkedList;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
      StringBuilder word = new StringBuilder();
        for (int i = 0; evenElements.size() > 0; i++) {
            word.append(evenElements.pollFirst());
            evenElements.pollFirst();
            }
        return word.toString();
    }

    private String getDescendingElements() {
        StringBuilder word = new StringBuilder();
        for (int i = 0; descendingElements.size() > 0; i++) {
            word.append(descendingElements.pollLast());
        }
        return word.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}