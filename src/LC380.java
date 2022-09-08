import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LC380 {
    Map<Integer, Integer> val2id;
    Map<Integer, Integer> id2val;
    int idx;
    Random rand;
    /** Initialize your data structure here. */
    public LC380() {
        val2id = new HashMap<>();
        id2val = new HashMap<>();
        idx = 0;
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (val2id.containsKey(val)) {
            return false;
        }
        val2id.put(val, idx);
        id2val.put(idx, val);
        idx++;
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!val2id.containsKey(val)) {
            return false;
        }
        int id = val2id.get(val);

        int lastVal = id2val.get(idx - 1);

        val2id.put(lastVal, id);
        id2val.put(id, lastVal);

        val2id.remove(val);
        id2val.remove(idx - 1);

        idx--;
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int randidx = rand.nextInt(idx);
        return id2val.get(randidx);
    }
}
