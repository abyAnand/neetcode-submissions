class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int num: nums){
            hm.put(num, hm.getOrDefault(num, 0)+1);
        }

        Queue<Integer> minHeap = new PriorityQueue((a,b) -> hm.get(a)- hm.get(b));

        for(int num: hm.keySet()){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] res = new int[k];

        int index = 0;

        while(!minHeap.isEmpty()){
            res[index++] = minHeap.poll();
        }

        return res;
    }
}
