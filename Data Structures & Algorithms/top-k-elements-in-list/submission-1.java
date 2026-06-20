class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] occur = new List[nums.length+1];
        Map<Integer,Integer> occurPerValue = new HashMap<>();


        for (int i = 0; i < occur.length; i++) {
            occur[i] = new ArrayList<>();
        }

        for(int i=0;i<nums.length;i++){
            if(occurPerValue.containsKey(nums[i])){
                Integer value =occurPerValue.get(nums[i]);
                Integer inc = value+=1;
                occurPerValue.put(nums[i],inc);
            }else{
                occurPerValue.put(nums[i],1);
            }
        }

        for(Map.Entry<Integer,Integer> element: occurPerValue.entrySet()){
            occur[element.getValue()].add(element.getKey());
        }
        int[] result = new int[k];
        int step = 0;
        for(int i= occur.length-1;i>0;i--){
            if(occur[i].isEmpty()){
                continue;
            }
            if(step>=k){
                break;
            }
            List<Integer> elements = occur[i];
            for(int element:elements){
                result[step] = element;
                step++;
            }
        }
        return result;
    }
}
