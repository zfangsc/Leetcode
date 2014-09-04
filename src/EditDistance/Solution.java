package EditDistance;

/**
 * Author: fangzhou
 * Date:   9/3/14.
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) {
            return 0;   // for simplicity
        }
        if(word1.isEmpty()) {
            return word2.length();
        }
        if(word2.isEmpty()) {
            return word1.length();
        }
        int[][] m = new int[word1.length()+1][word2.length()+1];
        for(int i = 0; i < word1.length(); i++) {
            m[i][word2.length()] = word1.length()-i;
        }
        for(int i = 0; i < word2.length(); i++) {
            m[word1.length()][i] = word2.length()-i;
        }
        m[word1.length()][word2.length()] = 0;
        for(int i = word1.length()-1; i >= 0; i--) {
            for(int j = word2.length()-1; j >= 0; j--) {
                m[i][j] = Math.min(m[i+1][j], m[i][j+1]);
                m[i][j] = Math.min(m[i][j], m[i+1][j+1]);
                m[i][j]++;
                if(word1.charAt(i) == word2.charAt(j)) {
                    m[i][j] = Math.min(m[i][j], m[i+1][j+1]);
                }
            }
        }
        return m[0][0];
    }
}
