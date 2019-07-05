package com.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Graph {
    private String[] node;
    private Integer[][] weight;
    private HashMap<String, String> link = new HashMap<>();
    private HashMap<String, Integer> linkAndWeight = new HashMap<>();

    public Graph(String[] node, Integer[][] weight) {
        this.node = node;
        this.weight = weight;
    }

    public Integer getNodeSize(){
        return this.getNode().length;
    }

    public Integer getWeightSize(){
        return this.getWeight().length;
    }

    /**
     *  输入节点集合与权重集合, 将节点配对, 再将节点拼成的String与权重配对
     * @param node
     * @param weight
     * @return
     */
    public HashMap<String, Integer> getLinkAndWeight(String[] node, Integer[][] weight){

        HashMap<String, Integer> linkAndWeightMap = new HashMap<>();

        // String[] combinedLinks = new String[node.length*node.length];
        String combinedLinks = "";

        for (int i = 0; i < this.getNodeSize(); i++){
            for (int j = 0; j < this.getNodeSize(); j++){
                if (node[i].equals(node[j])){
                    this.weight[i][j] = 0;
                }
                combinedLinks = node[i]+"-"+node[j];
                if (node.length == weight.length) {

                    //   System.out.println(combinedLinks);
                    //  System.out.println("------------------------");
                    // System.out.println(weight[i]);
                    linkAndWeightMap.put(combinedLinks, weight[i][j]);
                    //System.out.println(linkAndWeightMap);
                } else {
                    System.out.println("节点对数与权重数量不符合");
                }
            }
        }

        return linkAndWeightMap;
    }

    public String[] getNode() {
        return node;
    }

    public void setNode(String[] node) {
        this.node = node;
    }

    public Integer[][] getWeight() {
        return weight;

    }

    public void setWeight(Integer[][] weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Graph)) return false;
        Graph graph = (Graph) o;
        return node.equals(graph.node) &&
                weight.equals(graph.weight) &&
                link.equals(graph.link) &&
                linkAndWeight.equals(graph.linkAndWeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, weight, link, linkAndWeight);
    }

    @Override
    public String toString() {
        return "Graph{" +
                "node=" + Arrays.toString(node) +
                ", weight=" + Arrays.toString(weight) +
                ", link=" + link +
                ", linkAndWeight=" + linkAndWeight +
                '}';
    }
}
