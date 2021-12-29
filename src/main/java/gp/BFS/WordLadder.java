package gp.BFS;

import java.util.*;

class Solution1 {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        int steps = 1;
        if (dict == null) {
            return 0;
        }
        dict.add(end);
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> duplicate = new HashSet<>();
        duplicate.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                List<String> nextWords = getNext(word, dict);
                for (String next: nextWords) {
                    if (duplicate.contains(next)) {
                        continue;
                    }
                    if (next.equals(end)) {
                        return steps;
                    }
                    duplicate.add(next);
                    queue.offer(next);
                }
            }
        }
        return -1;
    }
    
    public List<String> getNext(String word, Set<String> dict) {
        List<String> next = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            for (int j = 0; j < word.length(); j++) {
                String potentialNext = changedWord(word, i, j);
                if (dict.contains(potentialNext)) {
                    next.add(potentialNext);
                }
            }
        }
        return next;
    }
    
    public String changedWord(String word, char c, int i) {
        char[] words = word.toCharArray();
        words[i] = c;
        return new String(words);
    }
    
}