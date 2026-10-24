class Solution {
    private final int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String aA, String lA, String aB, String lB) {
        int sA = getDay(aA), eA = getDay(lA);
        int sB = getDay(aB), eB = getDay(lB);

        int start = Math.max(sA, sB);
        int end = Math.min(eA, eB);

        return start <= end ? end - start + 1 : 0;
    }

    private int getDay(String s) {
        int m = Integer.parseInt(s.substring(0, 2));
        int d = Integer.parseInt(s.substring(3, 5));
        
        int total = 0;
        for (int i = 0; i < m - 1; i++) {
            total += months[i];
        }
        return total + d;
    }
}
