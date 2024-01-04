import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * SumOfTwoValues
 */
public class SumOfTwoValues {

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

    public static void main(String[] args) throws IOException{
        Reader r = new Reader();
        int n = r.nextInt();
        int target = r.nextInt();
        HashMap<Integer, Integer> hm = new HashMap<>(); 

        for(int i=0; i<n; i++) {
            int x = r.nextInt();
            if (hm.containsKey(x)) {
                System.out.println(hm.get(x)+" "+(i+1));
                return;
            } 
            hm.put(target-x, i+1);
        }
        System.out.println("IMPOSSIBLE");
    }
}