class Solution {
    public boolean isValid(String s) {
        if(s.length()==1){
            return false;
        }

        Map<String, String> par = new HashMap<>();
        par.put("(", ")");
        par.put("[", "]");
        par.put("{", "}");

        List<String> open = List.of("(","[","{");

        Deque<String> q = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++){
            String p = String.valueOf(s.charAt(i));

            if(open.contains(p)){
                q.push(p);
            }else{
                if(q.isEmpty()) return false;
                String pFromQ = q.pop();
                if(!p.equals(par.get(pFromQ))){
                    return false;
                }
            }
        }
        return q.isEmpty();
    }
}
