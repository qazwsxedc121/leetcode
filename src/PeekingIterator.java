import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> raw;
    private Integer cache;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        raw = iterator;
        if(iterator.hasNext()){
            cache = iterator.next();
        }else{
            cache = null;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return cache;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res = cache;
        if(raw.hasNext()){
            cache = raw.next();
        }else{
            cache = null;
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        return cache != null;
    }

    @Override
    public void remove() {
        return;
    }
}