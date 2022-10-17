/*Question - A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

Example 1:

Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.
Example 2:

Input: sentence = "leetcode"
Output: false

*/


class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] freq = new int[26];
        
        char[] strArray = sentence.toCharArray();
        
        for(char c : strArray) {
            freq[c - 'a']++;
        }
        
        for(int val : freq){
            if(val == 0){
                return false;
            }
        }
        
        return true;
        
    }
}
