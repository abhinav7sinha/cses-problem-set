import java.io.DataInputStream;
import java.io.IOException;
import java.util.*;

public class RestaurantCustomers {
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }
    }

    /*
     [[5,8], [2,4], [3,9]]
     [[2,4], [3,9], [5,8]]
     */
    public static void main(String[] args) throws IOException {
        Reader r = new Reader();
        int n = r.nextInt();
        List<List<Integer>> li = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int maxCustomers = 0;

        for (int i = 0; i < n; i++) {
            List<Integer> inner = new ArrayList<>();
            inner.add(r.nextInt());
            inner.add(r.nextInt());
            li.add(inner);
        }

        // Sort by arrival time then by departure time
        Collections.sort(li,
                (List<Integer> a, List<Integer> b) -> {
                    if (a.get(0) == b.get(0)) return a.get(1).compareTo(b.get(1));
                    else return a.get(0).compareTo(b.get(0));
                }
        );

        for (List<Integer> x : li) {
            int arrival = x.get(0);
            int departure = x.get(1);

            while (!minHeap.isEmpty() && minHeap.peek()<arrival) {
                minHeap.remove();
            }
            minHeap.add(departure);
            maxCustomers = Math.max(maxCustomers, minHeap.size());
        }
        System.out.println(maxCustomers);
    }
}