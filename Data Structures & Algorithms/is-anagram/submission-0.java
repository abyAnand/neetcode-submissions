class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        int stringSize = s.length();

        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();

        for(int i = 0; i< stringSize; i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        for(char ch: sMap.keySet()){
            if(!sMap.get(ch).equals(tMap.get(ch))){
                return false;
            }
        }

        return true;

    }
}
