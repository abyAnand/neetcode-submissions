class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        int stringSize = s.length();

        Map<Character,Integer> charMap = new HashMap<>();
        

        for(int i = 0; i< stringSize; i++){
            charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i), 0) + 1);
            charMap.put(t.charAt(i), charMap.getOrDefault(t.charAt(i), 0) - 1);
        }

        for(char ch: charMap.keySet()){
            if(charMap.get(ch) != 0){
                return false;
            }
        }

        return true;

    }
}
