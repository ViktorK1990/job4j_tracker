package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double total = 0;
        int count = 0;
        for (Pupil list : pupils) {
            for (Subject bal : list.subjects()) {
                total += bal.score();
                count++;
            }
        }
        return total / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        int size = 0;
        double total = 0;
        String name = "";
        for (int i = 0; i < pupils.size(); i++) {
            name = pupils.get(i).name();
            for (Subject subject : pupils.get(i).subjects()) {
                total += subject.score();
                size++;
            }
            total /= size;
            list.add(new Label(name, total));
            size = 0;
            total = 0;
        }
        ;
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> list = new ArrayList<>();
        int score = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (map.get(subject.name()) != null) {
                    score = map.get(subject.name());
                }
                map.put(subject.name(), (score + subject.score()));
            }

        }
        for (Map.Entry<String, Integer> element : map.entrySet()) {
            list.add(new Label(element.getKey(), element.getValue() / pupils.size()));
        }

        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        double score = 0;
        String name = "";
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            name = pupil.name();
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            list.add(new Label(name, score));
        }
        Collections.sort(list);
        return list.get(0);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int score = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (map.get(subject.name()) != null) {
                    score = map.get(subject.name());
                }
                map.put(subject.name(), (score + subject.score()));
            }
        }
        for (Map.Entry<String, Integer> element : map.entrySet()) {
            list.add(new Label(element.getKey(), element.getValue()));
        }
        Collections.sort(list);
        return list.get(list.size() - 1) ;
    }
}