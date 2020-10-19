package Algorithms.graph_01;

//класс создания вершин
class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label;//метка обозначения вершины
        this.wasVisited = false;//метка были в этой вершине или нет
    }
}
