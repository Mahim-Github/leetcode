// 131. Palindrome Partitioning
// Solved
// Medium
// Topics
// Companies
// Given a string s, partition s such that every 
// substring
//  of the partition is a 
// palindrome
// . Return all possible palindrome partitioning of s.

 

// Example 1:

// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]
// Example 2:

// Input: s = "a"
// Output: [["a"]]
 

// Constraints:

// 1 <= s.length <= 16
// s contains only lowercase English letters.

class Solution {
    private boolean isPalindrom(String s){
        int n = s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-i-1)) return false;
        }
        return true;
    }
    private void makePartitions(List<List<String>>ans,String s,int index,int n,List<String>list){

        if(index==s.length()){
            ans.add(new ArrayList(list));
            return;
        }
        for(int i=index;i<n;i++){
            String str = s.substring(index,i+1);
            if(isPalindrom(str)){
                list.add(str);
                makePartitions(ans,s,i+1,n,list);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>>ans = new ArrayList<>();
        makePartitions(ans,s,0,n,new ArrayList<String>());
        return ans;
    }
}