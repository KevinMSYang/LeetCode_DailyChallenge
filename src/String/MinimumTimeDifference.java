//Question:539
//Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.
//		 
//
//Example 1:
//
//Input: timePoints = ["23:59","00:00"]
//Output: 1
//Example 2:
//
//Input: timePoints = ["00:00","23:59","00:00"]
//Output: 0

package String;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int[] minutes = new int[timePoints.size()];
        int index = 0;
        for (String timePoint : timePoints) {
            int h = Integer.parseInt(timePoint.substring(0, 2));
            int m = Integer.parseInt(timePoint.substring(3));
            minutes[index++] = (h * 60) + m;
        } 

        Arrays.sort(minutes);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < minutes.length - 1; i++) {
            ans = Math.min(ans, minutes[i+1] - minutes[i]);
        }
        return Math.min(ans, 24 * 60 - minutes[minutes.length -1] + minutes[0]);
    }
}
