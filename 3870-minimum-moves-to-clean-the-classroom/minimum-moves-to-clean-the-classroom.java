import java.util.*;

class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int startR = 0;
        int startC = 0;

        // Give every litter a bit number
        Map<Integer, Integer> litterMap = new HashMap<>();
        int litterCount = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                char ch = classroom[r].charAt(c);

                if (ch == 'S') {
                    startR = r;
                    startC = c;
                }

                if (ch == 'L') {
                    litterMap.put(r * n + c, litterCount);
                    litterCount++;
                }
            }
        }

        int allCollected = (1 << litterCount) - 1;

        // best[state] = maximum energy with which
        // we have reached this position + mask.
        int states = m * n * (1 << litterCount);
        int[] best = new int[states];
        Arrays.fill(best, -1);

        /*
         * Encode:
         * position + mask + energy
         */
        Queue<int[]> queue = new ArrayDeque<>();

        int startState = startR * n + startC;
        int startMask = 0;

        best[startState * (1 << litterCount) + startMask] = energy;

        queue.offer(new int[]{startR, startC, startMask, energy});

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int[] curr = queue.poll();

                int r = curr[0];
                int c = curr[1];
                int mask = curr[2];
                int currEnergy = curr[3];

                // All litter collected
                if (mask == allCollected) {
                    return moves;
                }

                for (int[] dir : directions) {

                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    // Outside grid
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    // Obstacle
                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    // If energy is already 0,
                    // we cannot make another move.
                    if (currEnergy == 0) {
                        continue;
                    }

                    int newEnergy = currEnergy - 1;
                    int newMask = mask;

                    // Collect litter
                    if (classroom[nr].charAt(nc) == 'L') {

                        int bit = litterMap.get(nr * n + nc);

                        newMask = newMask | (1 << bit);
                    }

                    // Reset energy on R
                    if (classroom[nr].charAt(nc) == 'R') {
                        newEnergy = energy;
                    }

                    int position = nr * n + nc;

                    int stateIndex =
                        position * (1 << litterCount) + newMask;

                    /*
                     * If we have already reached this same
                     * position + mask with MORE energy,
                     * this state is useless.
                     */
                    if (best[stateIndex] >= newEnergy) {
                        continue;
                    }

                    best[stateIndex] = newEnergy;

                    queue.offer(new int[]{
                        nr, nc, newMask, newEnergy
                    });
                }
            }

            moves++;
        }

        return -1;
    }
}