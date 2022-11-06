class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return cSum(candidates, target, 0, candidates.length, new ArrayList<>(), new ArrayList<List<Integer>>());
    }
    
    private List<List<Integer>> cSum(int[] candidates, int target, int index, int length, List<Integer> ds , List<List<Integer>> answer) {
        if(index == length) {
            if(target == 0) {
                answer.add(new ArrayList<>(ds));
            }
            return answer;
        }
        
        if(candidates[index] <= target) {
            ds.add(candidates[index]);
            cSum(candidates, target-candidates[index], index, length, ds, answer);
            ds.remove(ds.size()-1);
        }
        
        cSum(candidates, target, index+1, length, ds, answer);
        
        return answer;
    }
    
}
