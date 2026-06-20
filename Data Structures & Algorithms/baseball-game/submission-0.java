class Solution {
    public int calPoints(String[] operations) {
        List<Integer> record = new ArrayList<>();

        for (String op : operations) {
            if ("+".equals(op)) {
                add(record);
            } else if ("C".equals(op)) {
                cancel(record);
            } else if ("D".equals(op)) {
                doublee(record);
            } else {
                record.add(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for (int score : record) {
            sum += score;
        }
        return sum;
    }

    private void add(List<Integer> record) {
        int last = record.get(record.size() - 1);
        int secondLast = record.get(record.size() - 2);
        record.add(last + secondLast);
    }

    private void cancel(List<Integer> record) {
        record.remove(record.size() - 1);
    }

    private void doublee(List<Integer> record) {
        int last = record.get(record.size() - 1);
        record.add(last * 2);
    }
}