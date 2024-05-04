import java.util.ArrayList;
import java.util.List;

public class MTreeNode {
    private List<Entry> entries;
    private boolean isLeaf;

    public MTreeNode() {
        this.entries = new ArrayList<>();
        this.isLeaf = true;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void addEntry(Entry entry) {
        entries.add(entry);
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }
}
