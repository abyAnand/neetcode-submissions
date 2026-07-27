class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<Integer, List<List<String>>> gMap = new HashMap<>();

        for(String str : strs){
            int len = str.length();
            if(!gMap.containsKey(len)){
                List<List<String>> outer = new ArrayList<>();

                List<String> inner = new ArrayList<>();
                inner.add(str);
                outer.add(inner);

                gMap.put(len, outer);
            }else{
                List<List<String>> outerList = gMap.get(len);
                boolean matchFound = false;
                for(List<String> innerList: outerList){
                    String firstWord = innerList.get(0);
                    if(isAnagram(firstWord,str)){
                        innerList.add(str);
                        matchFound = true;
                        break;
                    }
                }
                if(!matchFound){
                    List<String> inner = new ArrayList<>();
                    inner.add(str);
                    outerList.add(inner);
                }
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (List<List<String>> outerList: gMap.values()){
            result.addAll(outerList);
        }

        return result;
        
    }

    public  boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        int stringSize = s.length();

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();

        for (int i = 0; i < stringSize; i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
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
