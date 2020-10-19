package Algorithms.graph_01;

import java.util.LinkedList;
import java.util.Queue;

//класс в котором реализуются ребра для связи вершин и матрица смежности
class Graph {
    private Vertex[] vertexList;//список вершин
    private int[][] adjMatrix;//матрица смежности которая хранит связи
    private int size; //
    private Stack stack;

    public Graph() {
        final int MAX_VERTS = 32;
        stack = new Stack(MAX_VERTS);
        vertexList = new Vertex[MAX_VERTS];
        adjMatrix = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMatrix[i][j] = 0;//инициализация показывающая что связей нет
            }

        }
    }

    //добавление вершины в список вершин
    public void addVertex(char label) {
        vertexList[size++] = new Vertex(label);
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

    private int getAdjUnvisitedVertex(int vertexIndex) {
        for (int i = 0; i < size; i++) {
            if (adjMatrix[vertexIndex][i] == 1 && vertexList[i].wasVisited==false) {
                return 1;
            }

        }
        return -1;
    }

    //метод обхода в глубину
    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public void dfsRecursive(int i) {
        vertexList[i].wasVisited = true;
        for (int j = 0; j < size; j++) {
            int v = getAdjUnvisitedVertex(i);
            if (!vertexList[j].wasVisited && v != -1) {
                fullDisplayVertex(i, v);
                displayVertex(i);
            }

        }
    }

    private void fullDisplayVertex(int vertex1, int vertex2) {
        System.out.println("Вершины" + vertexList[vertex1].label + " - " + vertexList[vertex2].label);
    }

    //метод обхода в ширину
    public void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.add(0);
        int v2;
        while (!queue.isEmpty()) {
            int v1 = queue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                queue.add(v2);
            }
        }
        //сброс флагов
        for (int i = 0; i <size ; i++) {
            vertexList[i].wasVisited = false;

        }
    }

    public void bfsRecursive(int v) {
        //реализация очереди через массив
        int[] queue = new int[size];
        int qH = 0;//голова
        int qT = 0;//хвост
        //установили первое посещенное значение
        vertexList[0].wasVisited = true;
        queue[qT++] = v;
        displayVertex(0);

        int v2;
        while (qH < qT) {
            v = queue[qH++];

            for (int i = 0; i < size; i++) {
                v2 = getAdjUnvisitedVertex(v);
                if (!vertexList[i].wasVisited && v2 != -1) {
                    vertexList[i].wasVisited = true;
                    displayVertex(qT);
                    queue[qT++] = i;
                }

            }
        }
        //сброс флагов
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }

    }
}