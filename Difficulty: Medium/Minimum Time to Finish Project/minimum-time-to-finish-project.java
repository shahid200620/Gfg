import java.util.*;



class Solution {

    public int minTime(int[] duration, int[][] dependencies) {

        int n = duration.length;



        ArrayList<Integer>[] graph = new ArrayList[n];

        int[] indegree = new int[n];



        for (int i = 0; i < n; i++) {

            graph[i] = new ArrayList<>();

        }



        // Build graph

        for (int[] edge : dependencies) {

            int u = edge[0];

            int v = edge[1];



            graph[u].add(v);

            indegree[v]++;

        }



        Queue<Integer> queue = new ArrayDeque<>();



        // Modules with no dependencies can start immediately

        for (int i = 0; i < n; i++) {

            if (indegree[i] == 0) {

                queue.offer(i);

            }

        }



        // Earliest completion time of each module

        int[] dp = new int[n];



        for (int i = 0; i < n; i++) {

            dp[i] = duration[i];

        }



        int processed = 0;

        int answer = 0;



        while (!queue.isEmpty()) {

            int u = queue.poll();

            processed++;



            answer = Math.max(answer, dp[u]);



            for (int v : graph[u]) {

                // v can start only after u is completed

                dp[v] = Math.max(dp[v], dp[u] + duration[v]);



                indegree[v]--;



                if (indegree[v] == 0) {

                    queue.offer(v);

                }

            }

        }



        // If not all modules were processed, there is a cycle

        if (processed != n) {

            return -1;

        }



        return answer;

    }

}

