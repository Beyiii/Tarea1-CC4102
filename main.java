import java.util.ArrayList;
import java.util.List;

public class main {

    public static void procesarLista(List<Integer> L) {
        List<Integer> A = new ArrayList<>(L); // Creamos una copia de L en A

        // Removemos todos los elementos pares de L
        for (Integer num : A) {
            if (num % 2 == 0) {
                    L.remove(num); // Removemos el número par de L
            }
       }
    }
    public static void main(String[] args) {
        Point pA = new Point(0, 1);
        Point pB= new Point(1, 0);
        Point pC = new Point(1,1);
        Point pD = new Point(1,5);
        Point pE = new Point(-1,0);
        Point pF = new Point(1,3);
        Point pG = new Point(2,7);
        Point pH = new Point(3, 1);
        Point pI= new Point(4, 0);
        Point pJ = new Point(10,1);
        Point pK = new Point(5,6);
        Point pL = new Point(-1,7);
        Point pM = new Point(10,13);
        Point pN = new Point(25,70);
        Point q = new Point(10,9);

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

        //System.err.println((nodoA.getEntries()).get(0));
        

        Ball Q = new Ball(q, 1);
        MTreeSearcher searcher = new MTreeSearcher();
        List<Point> lista = searcher.search(tree, Q);
        //System.err.println(lista);
        //System.err.println(searcher.getCount().getCount());
        
        List<Point> puntos = new ArrayList<>();
        puntos.add(pA);
        puntos.add(pB);
        puntos.add(pC);
        puntos.add(pD);
        puntos.add(pE);
        puntos.add(pF);
        puntos.add(pG);
        puntos.add(pH);
        puntos.add(pI);
        puntos.add(pJ);
        puntos.add(pK);
        puntos.add(pL);
        puntos.add(pM);
        puntos.add(pN);
        BuilderCP1 treeCP1 = new BuilderCP1(3);
        NodePoint treetj = treeCP1.buildMTree(puntos);
        System.err.println(treetj.getListNodePoints());
        /*
        NodePoint nodePoint1 =  treetj.getListNodePoints().get(0);
        NodePoint nodePoint2 =  treetj.getListNodePoints().get(1);
        NodePoint nodePoint3 =  treetj.getListNodePoints().get(2);
        System.err.println(nodePoint1.getListNodePoints());
        System.err.println(nodePoint2.getListNodePoints());
        System.err.println(nodePoint3.getListNodePoints());
        System.err.println(nodePoint1.getListPoints());
        System.err.println(nodePoint2.getListPoints());
        System.err.println(nodePoint3.getListNodePoints());
         */
        
        

        
    }
}
