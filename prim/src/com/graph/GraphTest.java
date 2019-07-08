package com.graph;

import org.junit.Test;

import java.util.HashMap;

public class GraphTest {


    @Test
    public void testGraph(){
        /**
         * 模型 1，城市距离图, 单位km, 有向等权图, 除反斜率对角线外, 其他都满足a[i][j] + a[j][i]
         */
        String[] nodes = {"Shanghai", "BeiJing", "Auckland", "Urbana Champaign", "Sydney", "FrankFurt"};
        Integer[][] weights = {{0, 3000, 12000, 17000, 10000, 11000},
                               {3000, 0, 14000, 17000, 12000, 10000},
                               {12000, 14000, 0, 8000, 3000, 14000},
                               {17000, 17000, 8000, 0, 10000, 15000},
                               {10000, 12000, 3000, 10000, 0, 12000},
                               {11000, 10000, 14000, 15000, 12000, 0}
                              };

        Graph graph = new Graph(nodes, weights);

        HashMap<String, Integer> combinedLinks = graph.getLinkAndWeight(graph.getNode(), (Integer[][]) graph.getWeight());
        combinedLinks.forEach((k, v)-> System.out.println(k + "=" + v));
    }
    @Test
    public void testGraph2(){
        /**
         * 模型 2: Dota2中路英雄对线胜率, 有向但权重不一致图, 设计规律: 除反斜率对角线外, 其他都满足a[i][j] + a[j][i] = 1
         */
        String[] mid_lane_heros = {"Shadow Fiend", "Temper Assassin", "Viper", "Invoker", "Brood Mother", "Kunka", "Ember Spirit", "Storm Spirit", "Huskar"};
        Double[][] weights = {{0.0, 0.2, 0.5, 0.6, 0.4, 0.45, 0.7, 0.7, 0.55},
                            {0.8, 0.0, 0.3, 0.8, 0.55, 0.45, 0.5, 0.7, 0.3},
                            {0.5, 0.7, 0.0, 0.6, 0.01, 0.5, 0.6, 0.65, 0.7},
                            {0.4, 0.2, 0.4, 0.0, 0.001, 0.3, 0.6, 0.6, 0.4},
                            {0.6, 0.45, 0.99, 0.999, 0.0, 0.3, 0.55, 0.6, 9.9},
                            {0.55, 0.55, 0.5, 0.7, 0.7, 0.0, 0.7, 0.7, 0.2},
                            {0.3, 0.5, 0.4, 0.4, 0.45, 0.3, 0.0, 0.45, 0.1},
                            {0.3, 0.3, 0.35, 0.4, 0.4, 0.3, 0.55, 0.0, 0.4},
                            {0.45, 0.7, 0.3, 0.6, 0.1, 0.8, 0.9, 0.6, 0.0}};

        Graph graph = new Graph(mid_lane_heros, weights);

        HashMap<String, Double> mid_solo_win_rate = graph.getLinkAndWeight2(graph.getNode(), (Double[][]) graph.getWeight());
        mid_solo_win_rate.forEach((k, v)-> System.out.println(k + "=" + v));
    }
}
