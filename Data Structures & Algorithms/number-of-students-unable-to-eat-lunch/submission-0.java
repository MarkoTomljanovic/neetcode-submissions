class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int count = 0;

        for (int sandwich : sandwiches) {
            boolean matched = false;
            for (int i = 0; i < students.length; i++) {
                if (students[i] == sandwich) {
                    count++;
                    students[i] = -1;
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                break;
            }
        }

        return students.length - count;
    }
}