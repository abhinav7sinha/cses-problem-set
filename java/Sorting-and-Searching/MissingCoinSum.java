import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MissingCoinSum {
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
     * 2 9 1 2 7
     * 1 2 2 7 9
     * If I am at an index i, with maximum number that I can form as x. 
     */
    public static void main(String[] args) throws IOException{
        Reader r = new Reader();
        int n = r.nextInt();

        List<Integer> coins = new ArrayList<>();
        for (int i=0; i<n; i++) {
            coins.add(r.nextInt());
        }
        Collections.sort(coins);

        long maxSoFar = 0;
        long ans = -1;
        for (int i=0; i<n; i++) {
            int cur = coins.get(i);
            if (cur<=(maxSoFar+1)) {
                maxSoFar += cur;
            } else {
                ans = maxSoFar+1;
                break;
            }
        }
        if (ans==-1) ans = maxSoFar+1;
        System.out.println(ans);
    }
}
