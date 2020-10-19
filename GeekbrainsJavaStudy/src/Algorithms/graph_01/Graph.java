package Algorithms.graph_01;

//класс в котором реализуются ребра для связи вершин и матрица смежности
class Graph {
    private Vertex[] vertexList;//список вершин
    private int[][] adjMatrix;//матрица смежности которая хранит связи
    private int sizeCurrentVertx; //
    private Stack stack;

    public Graph() {
        final int MAX_VERTS = 32;
        stack = new Stack(MAX_VERTS);
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

    private int getAdjUnvisitedVertex(int vertexIndex) {
        for (int i = 0; i < sizeCurrentVertx; i++) {
            if (adjMatrix[vertexIndex][i] == 1 && !vertexList[i].wasVisited) {
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
            if (v == 1) {
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        for (int i = 0; i <sizeCurrentVertx; i++) {
            vertexList[i].wasVisited = false;
        }
    }
}