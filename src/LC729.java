import java.util.TreeMap;

public class LC729 {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    public LC729() {

    }
    
    public boolean book(int start, int end) {
        Integer prev = map.floorKey(start);
        Integer next = map.ceilingKey(start);
        if ((prev == null || map.get(prev) <= start) && 
            (next == null || next >= end)) {
            map.put(start, end);
            return true;
        }
        return false;
    }
}
