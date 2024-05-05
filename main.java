//import java.util.List;

public class main {
    public static void Main(String[] args) {
        Point pA = new Point(0, 1);
        Point pB= new Point(1, 0);
        Point pC = new Point(1,1);
        Point pD = new Point(1,5);
        Point pE = new Point(-1,0);
        Point pF = new Point(1,3);
        Point pG = new Point(2,7);
        //Point q = new Point(0,0);

        MTreeNodeLeaf hojaB = new MTreeNodeLeaf(pB); 
        MTreeNodeLeaf hojaC = new MTreeNodeLeaf(pC); 
        MTreeNodeLeaf hojaE = new MTreeNodeLeaf(pE); 
        MTreeNodeLeaf hojaG = new MTreeNodeLeaf(pG); 

        MTreeNodeInternal nodoA = new MTreeNodeInternal();
        MTreeNodeInternal nodoD = new MTreeNodeInternal();
        MTreeNodeInternal nodoF = new MTreeNodeInternal();


        nodoA.addEntry(hojaB.getEntry());
        nodoA.addEntry(hojaC.getEntry());
        nodoD.addEntry(hojaG.getEntry());
        nodoF.addEntry(hojaE.getEntry());

        Entry eA = new Entry(pA, 2, nodoA);
        Entry eD = new Entry(pD, 3, nodoD);

        nodoF.addEntry(eA);
        nodoF.addEntry(eD);
        
        Entry eTree = new Entry(pF, 4.2, nodoF);
        MTreeNodeInternal tree= new MTreeNodeInternal();
        tree.addEntry(eTree);

        System.err.println(hojaB.getEntry());
        

/* 
        Ball Q = new Ball(q, 1);
        MTreeSearcher searcher = new MTreeSearcher();
        List<Point> lista = searcher.search(tree, Q);
        System.err.println(lista);
*/
    }
}
