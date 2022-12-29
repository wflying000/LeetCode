package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LC127 {
    private Map<String, Integer> word2id = new HashMap<>();
    private List<List<Integer>> edges = new ArrayList<>();
    private int id = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdges(word);
        }
        addEdges(beginWord);
        if (!word2id.containsKey(endWord)) {
            return 0;
        }
        int[] dist = new int[word2id.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int beginId = word2id.get(beginWord);
        int endId = word2id.get(endWord);
        dist[beginId] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(beginId);
        while (!queue.isEmpty()) {
            int curId = queue.poll();
            if (curId == endId) {
                return dist[curId] / 2 + 1;
            }
            for (int adjId : edges.get(curId)) {
                if (dist[adjId] == Integer.MAX_VALUE) {
                    dist[adjId] = dist[curId] + 1;
                    queue.offer(adjId);
                }
            }
        }
        return 0;
    }

    private void addWord(String word) {
        if (word2id.containsKey(word)) {
            return;
        }
        word2id.put(word, id);
        edges.add(new ArrayList<>());
        id++;
    }

    private void addEdges(String word) {
        addWord(word);
        int id1 = word2id.get(word);
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char temp = chs[i];
            chs[i] = '*';
            String newWord = new String(chs);
            addWord(newWord);
            chs[i] = temp;
            int id2 = word2id.get(newWord);
            edges.get(id1).add(id2);
            edges.get(id2).add(id1);
        }
    }

    public static void main(String[] args) {
        String beginWord = "hit"; 
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        String[] strs = {"hot","dot","dog","lot","log","cog"};
        for (String word : strs) {
            wordList.add(word);
        }
        LC127 sln = new LC127();
        int res = sln.ladderLength(beginWord, endWord, wordList);
        System.out.println(res);

    }
}