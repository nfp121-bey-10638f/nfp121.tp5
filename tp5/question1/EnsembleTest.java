package question1;

public class EnsembleTest extends junit.framework.TestCase {

    public void testUnion() {
        question1.Ensemble<Integer> e1, e2;
        e1 = new question1.Ensemble<Integer>();
        assertEquals(true, e1.add(2));
        assertEquals(true, e1.add(3));

        e2 = new question1.Ensemble<Integer>();
        assertEquals(true, e2.add(3));
        assertEquals(true, e2.add(4));

        question1.Ensemble<Integer> union = e1.union(e2);
        assertEquals(3, union.size());
        assertTrue(union.contains(2));
        assertTrue(union.contains(3));
        assertTrue(union.contains(4));
    }
    public void testAdd()
    {
        question1.Ensemble<Integer> e1 = new question1.Ensemble<Integer>();
        question1.Ensemble<String> e2 = new question1.Ensemble<String>();
        
        assertTrue(e1.add(1));
        assertTrue(e1.add(2));
        assertFalse(e1.add(1));
        assertEquals(2, e1.size());
        
        assertTrue(e2.add("a"));
        assertFalse(e2.add("a"));
        assertTrue(e2.add("b"));
        assertEquals(2, e1.size());
        

    }
    
    public void testInter(){
        question1.Ensemble<Integer> e1 = new question1.Ensemble<Integer>();
        question1.Ensemble<Integer> e2 = new question1.Ensemble<Integer>();
        question1.Ensemble<Integer> res = new question1.Ensemble<Integer>();
        
        assertTrue(e1.add(1));
        assertTrue(e1.add(2));
        
        assertTrue(e2.add(1));
        assertTrue(e2.add(2));
        assertTrue(e2.add(3));
        assertTrue(e2.add(4));
        
        res =  e1.inter(e2);
        
        assertTrue(res.contains(1));
        assertTrue(res.contains(2));
        assertFalse(res.contains(3));
        assertFalse(res.contains(4));
        
        assertEquals(2,res.size());
    }
    public void testDiff(){
        question1.Ensemble<Integer> e1 = new question1.Ensemble<Integer>();
        question1.Ensemble<Integer> e2 = new question1.Ensemble<Integer>();
        question1.Ensemble<Integer> res = new question1.Ensemble<Integer>();
        
        assertTrue(e1.add(1));
        assertTrue(e1.add(2));
        assertTrue(e1.add(5));
        
        assertTrue(e2.add(1));
        assertTrue(e2.add(2));
        assertTrue(e2.add(3));
        assertTrue(e2.add(4));
        
        res =  e1.diff(e2);
        
        assertTrue(res.contains(5));
        assertFalse(res.contains(1));
        assertFalse(res.contains(2));
        
        assertEquals(1,res.size());
    }
    public void testDiffSym(){
        question1.Ensemble<Integer> e1 = new question1.Ensemble<Integer>();
        question1.Ensemble<Integer> e2 = new question1.Ensemble<Integer>();
        question1.Ensemble<Integer> res = new question1.Ensemble<Integer>();
        
        assertTrue(e1.add(1));
        assertTrue(e1.add(2));
        assertTrue(e1.add(5));
        
        assertTrue(e2.add(1));
        assertTrue(e2.add(2));
        assertTrue(e2.add(3));
        assertTrue(e2.add(4));
        
        res =  e1.diffSym(e2);
        
        assertTrue(res.contains(3));
        assertTrue(res.contains(4));
        assertTrue(res.contains(5));
        
        assertEquals(3,res.size());
    }
    
}
