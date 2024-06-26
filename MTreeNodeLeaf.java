import java.util.List;

/**
 Clase concreta para nodos hojas.
 */
public class MTreeNodeLeaf implements IMTreeNode{

    //Entrada.
    private Entry entry;

    //Constructor.
    public MTreeNodeLeaf(Point point) {
        this.entry = new Entry(point);
    }

    //Getter.
    public Entry getEntry() {
        return entry;
    }

    @Override
    public void searchRecursive(MtreeCount count,Ball query, List<Point> result) {}
}
