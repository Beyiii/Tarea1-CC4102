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
    public Entry getEntries() {
        return entry;
    }

    @Override
    public void searchRecursive(MtreeCount count,Ball query, List<Point> result) {
        Point p = entry.getPoint();
        if (query.contains(p)) {
            result.add(p);
        }
        count.addCount();
    }
}
