package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main1 {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[] combInter = new int[2];
        Arrays.fill(combInter, -1);

        ArrayList<int[]> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (combInter[0] == -1) {
                if (newInterval[0] < intervals[i][0])
                    combInter[0] = newInterval[0];
                else if (newInterval[0] < intervals[i][1])
                    combInter[0] = intervals[i][0];
            }

            if (combInter[1] == -1) {
                if (newInterval[1] < intervals[i][0])
                    combInter[1] = newInterval[1];
                else if (newInterval[1] < intervals[i][1])
                    combInter[1] = intervals[i][1];
            }

            if (combInter[0] == -1 && combInter[1] == -1) {
                ans.add(intervals[i]);
            }
            if (combInter[0] != -1 && combInter[1] != -1) {
                ans.add(combInter);
                for (int j = i + 1; j < intervals.length; j++) {
                    ans.add(intervals[j]);
                }
                break;
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.deepToString(insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
    }
}