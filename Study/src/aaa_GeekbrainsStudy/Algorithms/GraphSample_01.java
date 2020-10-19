package aaa_GeekbrainsStudy.Algorithms;

/*Граф - это абстрактный математический объект, представляющий собой множество
 * вершин и ребер их соединяющих
 * Матрица смежности - представляет собой двумерный массив в котором значения обозначают
 * связи между вершинами
 * Список смежности - структура позволяющая хранить отношения между вершинами, такой
 *   структурой может выступать массив, элементы которого являются связанные списки
 */

public class GraphSample_01 {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdges(0, 1);
        graph.addEdges(1, 2);
        graph.addEdges(0, 3);
        graph.addEdges(3, 4);

        graph.displayVertex(4);

    }


    //класс создания вершин
    static class Vertex {
        public char label;
        public boolean wasVisited;

        public Vertex(char label) {
            this.label = label;//метка обозначения вершины
            this.wasVisited = false;//метка были в этой вершине или нет
        }
    }

    //класс в котором реализуются ребра для связи вершин и матрица смежности
    static class Graph {
        private final int MAX_VERTS = 32;
        private Vertex[] vertexList;//список вершин
        private int[][] adjMatrix;//матрица смежности которая хранит связи
        private int sizeCurrentVertx; //

        public Graph() {
            vertexList = new Vertex[MAX_VERTS];
            adjMatrix = new int[MAX_VERTS][MAX_VERTS];
            sizeCurrentVertx = 0;
            for (int i = 0; i < MAX_VERTS; i++) {
                for (int j = 0; j < MAX_VERTS; j++) {
                    adjMatrix[i][j] = 0;//инициализация показывающая что связей нет
                }

            }
        }

        //добавление вершины в список вершин
        public void addVertex(char label) {
            vertexList[sizeCurrentVertx++] = new Vertex(label);
        }

        //после добавления вершин вручную добавлять связи (ребра) между ними
        public void addEdges(int start, int end) {
            adjMatrix[start][end] = 1; //связь A->B
            adjMatrix[end][start] = 1; //связь B->A
        }

        //отображение вершины по индексу
        public void displayVertex(int vertex) {
            System.out.println(vertexList[vertex].label);
        }
    }

}
