import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StickLengths {
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

    static long findCost(List<Integer> sticks, int target) {
        long cost = 0;
        for (int x: sticks) {
            cost += Math.abs(x-target);
        }
        return cost;
    }

    public static void main(String[] args) throws IOException{
        Reader r = new Reader();
        List<Integer> sticks = new ArrayList<>();
        int n = r.nextInt();
        
        for (int i=0; i<n; i++) {
            int x = r.nextInt();
            sticks.add(x);
        }
        
        /*
         * 2 3 1 5 2
         * I have to find minimum
         * 1:8
         * 2:5
         * 3:6
         * 4:9
         * 5:12
         */

        long ans = Long.MAX_VALUE;
        int lo = Collections.min(sticks);
        int hi = Collections.max(sticks);
        while (lo<=hi) {
            int mid = (lo+hi)/2;
            long costLe = findCost(sticks, mid-1);
            long costRi = findCost(sticks, mid+1);
            long costMid = findCost(sticks, mid);
            if (costLe<=costMid && costMid<=costRi) {
                ans = Math.min(ans, costMid);
                hi = mid-1;
            } else {
                ans = Math.min(ans, costMid);
                lo = mid+1;
            }
        }
        System.out.println(ans);
    }
}
