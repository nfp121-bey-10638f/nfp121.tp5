package question1;

import java.util.*;

public class Ensemble<T> extends AbstractSet<T> {

    protected java.util.Vector<T> table = new java.util.Vector<T>();

    public int size() {
        return table.size();
    }

    public Iterator<T> iterator() {
        return table.iterator();
    }

    public boolean add(T t) {
        if(table.contains(t))
            return false; 
        table.add(t); 
        return true;      
    }

    public Ensemble<T> union(Ensemble<? extends T> e) {
        Ensemble <T> res = new Ensemble <T>();
        res.addAll(this.table);
        res.addAll(e.table);
        return res;
    }

    public Ensemble<T> inter(Ensemble<? extends T> e) {
        Ensemble <T> res = new Ensemble <T>();
        res.table.addAll(table);
        res.table.retainAll(e.table);
        return res;
    }

    public Ensemble<T> diff(Ensemble<? extends T> e) {
        Ensemble <T> res = new Ensemble <T>();
        res.table.addAll(table);
        res.table.removeAll(e.table);
        return res;
    }

    Ensemble<T> diffSym(Ensemble<? extends T> e) {
        Ensemble <T> res = new Ensemble <T>();
        Ensemble <T> union = this.union(e);
        Ensemble <T> inter = this.inter(e);
        res = union.diff(inter);
        return res;
    }
    
}
