package gp.binarysearch;

public class WoodCut {
    public static void main(String[] args) {
        int[] L = {232, 124, 456};
        System.out.println(new WoodCut().woodCut(L, 7));
    }

    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) {
            return 0;
        }
        int start = 1;
        int end = getMax(L);
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            int pieces = getPieces(L, mid);
            if (pieces >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (getPieces(L, end) >= k) {
            return end;
        }
        if (getPieces(L, start) >= k) {
            return start;
        }
        return 0;
    }

    public int getMax(int[] L) {
        int max = L[0];
        for (int i = 1; i < L.length; i++) {
            if (max < L[i]) {
                max = L[i];
            }
        }
        return max;
    }

    public int getPieces(int[] L, int woodLength) {
        int pieces = 0;
        for (int wood : L) {
            pieces += wood / woodLength;
        }
        return pieces;
    }
}
