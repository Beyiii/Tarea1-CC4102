import java.util.List;

/**
 Interfaz para los nodos de un árbol.
 */
public interface IMTreeNode {

/**
 Busca recursivamente los puntos del árbol que pertenecen a la bola.
 */
    void searchRecursive(MtreeCount count, Ball query, List<Point> result);
}