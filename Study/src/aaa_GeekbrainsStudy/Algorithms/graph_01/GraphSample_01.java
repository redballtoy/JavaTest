package aaa_GeekbrainsStudy.Algorithms.graph_01;

/*Граф - это абстрактный математический объект, представляющий собой множество
 * вершин и ребер их соединяющих
 * Матрица смежности - представляет собой двумерный массив в котором значения обозначают
 * связи между вершинами
 * Список смежности - структура позволяющая хранить отношения между вершинами, такой
 *   структурой может выступать массив, элементы которого являются связанные списки
 * Обход - это посещение всех вершин связанных с заданной
 *  - метод обхода в глубину - идти вглубь, вершинам графа присваиваются номера а ребра помечаются
 *      - использовать стек для занесения посещенной вершины что бы можно было вернуться
 *      - для реализации метода необходимо найти непосещенную смежную вершину
 *  - метод обхода в ширину
 */

import aaa_GeekbrainsStudy.Algorithms.graph_01.Vertex;
import aaa_GeekbrainsStudy.Algorithms.graph_01.Graph;


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





    

}
