import java.io.DataInputStream;
import java.io.IOException;

public class CollectingNumbers {

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

    public static void main(String[] args) throws IOException {
        /*
         * 4 2 1 5 3
         * 2 1 4 0 3
         * r1 - 1 | 4 2 5 3
         * r2 - 2 3 | 4 5
         * r3 - 4 5 |
         */
        Reader r = new Reader();

        int n = r.nextInt();

        int[] nums = new int[n];
        int[] idx = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = r.nextInt();
            idx[nums[i] - 1] = i;
        }
        int count = 1;
        for (int i = 0; i < n - 1; i++) {
            if (idx[i] > idx[i + 1])
                count++;
        }

        System.out.println(count);
    }
}
