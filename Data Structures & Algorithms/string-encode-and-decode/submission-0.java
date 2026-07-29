class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString(); 
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int i = 0;

        while(i < str.length()){
            
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }

            int len = Integer.parseInt(str.substring(i,j));

            int start = j+1;
            int end = start+len;
            
            String word = str.substring(start, end);
            result.add(word);

            i = end;

        }

        return result;
    }
}
