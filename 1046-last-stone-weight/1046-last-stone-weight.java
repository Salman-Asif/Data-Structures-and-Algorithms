class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int stone:stones) {
            heap.offer(stone);
        }
        
        while(heap.size()!=1) {
            int largest = heap.poll();
            int secondLargest = heap.poll();
            heap.offer(largest-secondLargest);
        }
        
        return heap.poll();
        
    }
}