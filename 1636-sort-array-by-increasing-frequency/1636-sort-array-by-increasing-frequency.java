class Solution {
    
    Map<Integer, Integer> map = new HashMap<>();
    
    public int[] frequencySort(int[] nums) {
    
        int length = nums.length;;
        
        int ele;
        for(int i=0;i<length;i++) {
            ele = nums[i];
            if(map.containsKey(ele)) {
                map.put(ele, map.get(ele)+1);
            } else {
                map.put(ele, 1);
            }
        }
        
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i:nums){
            list.add(i);
        }
        
        System.out.println(list.toString());
        
        
        list.sort(new Comparator<Integer>(){
            
             public int compare(Integer i1, Integer i2) {
                    int a= i1.intValue();
                    int b = i2.intValue();
        
                    if(map.get(a) == map.get(b)) {
                        return b-a;
                    }

                    return map.get(a) - map.get(b);        
             }
        });
        
        
        for(int i=0;i<length;i++) {
            nums[i] = list.get(i);
        }
        
        return nums;
        
    }
}