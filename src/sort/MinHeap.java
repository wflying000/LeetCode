package sort;
import java.util.NoSuchElementException;

public class MinHeap {
    private int[] data;
    private int size;
    public MinHeap(int capacity) {
        this.data = new int[capacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return data[0];
    }

    public void offer(int val) {
        if (size == this.data.length) {
            throw new RuntimeException();
        }
        data[size] = val;
        size++;
        up(size - 1);
    }

    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int res = data[0];
        swap(data, 0, size - 1);
        size--;
        down(0);
        return res;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    private void down(int index) {
        while (2 * index + 1 < size) {
            int smallIndex = 2 * index + 1;
            if (smallIndex + 1 < size && data[smallIndex + 1] < data[smallIndex]) {
                smallIndex++;
            }
            if (data[smallIndex] < data[index]) {
                swap(data, index, smallIndex);
                index = smallIndex;
            } else {
                break;
            }
        }
    }

    private void up(int index) {
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (data[index] < data[parent]) {
                swap(data, index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(5);
        minHeap.offer(3);
        minHeap.offer(0);
        minHeap.offer(1);
        minHeap.offer(5);
        minHeap.offer(2);
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
    }
}