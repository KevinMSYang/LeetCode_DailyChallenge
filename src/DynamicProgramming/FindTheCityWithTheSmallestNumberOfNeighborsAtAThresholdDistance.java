//Question:1334
//There are n cities numbered from 0 to n-1. Given the array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge between cities fromi and toi, and given the integer distanceThreshold.
//
//Return the city with the smallest number of cities that are reachable through some path and whose distance is at most distanceThreshold, If there are multiple such cities, return the city with the greatest number.
//
//Notice that the distance of a path connecting cities i and j is equal to the sum of the edges' weights along that path.

package DynamicProgramming;

import java.util.Arrays;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        
        for (int i = 0; i < n; i++) {
        	Arrays.fill(dist[i], Integer.MAX_VALUE);
        	dist[i][i] = 0;
        }
        
        for (int[] edge : edges) {
        	int from = edge[0];
        	int to = edge[1];
        	int weight = edge[2];
        	dist[from][to] = weight;
        	dist[to][from] = weight;
        }
        floydWarshall(n, dist);
        
        int ans = -1;
        int minCityCount = n;
        for (int i = 0; i < n; i++) {
        	int cityCount = 0;
        	for (int j = 0; j < n; j++) {
        		if (i == j) {
        			continue;
        		}
        		if (dist[i][j] <= distanceThreshold) {
        			cityCount++;
        		}
        	}
        	if (cityCount <= minCityCount) {
        		ans = i;
        		minCityCount = cityCount;
        	}
        }
        return ans;      
    }
    
    private void floydWarshall (int n, int[][] dist) {
    	for (int k = 0; k < n; k++) {
    		for (int i = 0; i < n; i++) {
    			for (int j = 0; j < n; j++) {
    				dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
    			}
    		}
    	}
    }
}
