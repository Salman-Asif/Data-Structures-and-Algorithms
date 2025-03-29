class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        if (points.length == 1)
            return 0;

        int totalDistance = 0;

        int nextX, nextY, prevX, prevY;
        for (int i = 1; i < points.length ; i++) {
            nextX = points[i][0];
            nextY = points[i][1];

            prevX = points[i-1][0];
            prevY = points[i-1][1];

            int distanceX = Math.abs(nextX - prevX);
            int distanceY = Math.abs(nextY - prevY);
            int distance = Math.max(distanceX, distanceY);

            totalDistance += distance;
        }

        return totalDistance;

    }
}