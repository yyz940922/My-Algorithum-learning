package com.graph;

import org.junit.Test;

import java.util.HashMap;

public class GraphTest {

    @Test
    public void testGraph(){
        String[] nodes = {"Shanghai", "BeiJing", "Auckland", "Urbana Champaign", "Sydney", "FrankFurt"};
        Integer[][] weights = {{0, 3000, 12000, 17000, 10000, 11000},
                            {3000, 0, 14000, 17000, 12000, 10000},
                            {3000, 12000, 0, 8000, 3000, 14000},
                            {17000, 17000, 8000, 0, 10000, 15000},
                            {10000, 12000, 3000, 10000, 0, 12000},
                            {11000, 10000, 14000, 15000, 12000, 0}
                              };

        Graph graph = new Graph(nodes, weights);

        HashMap<String, Integer> combinedLinks = graph.getLinkAndWeight(graph.getNode(), graph.getWeight());
        combinedLinks.forEach((k, v)-> System.out.println(k + "=" + v));
    }
}
