import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MovieFestival {

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
        /*
         [[3,5], [4,9], [5,8]]
         [3,5] [2,6] [5,8] [4,9]
         */

        Reader r = new Reader();
        int n = r.nextInt();

        List<List<Integer>> movies = new ArrayList<>();

        for (int i=0; i<n; i++) {
            List<Integer> inner = new ArrayList<>();
            inner.add(r.nextInt());
            inner.add(r.nextInt());
            movies.add(inner);
        }

        // Custom sort
        Collections.sort(movies, 
            (a,b) -> {
                if (a.get(1)==b.get(1)) return a.get(0).compareTo(b.get(0));
                else return a.get(1).compareTo(b.get(1));
            }
        );

        int ans = 0;
        int prevEnd = -1;
        for (List<Integer> movie: movies) {
            int start = movie.get(0);
            int end = movie.get(1);
            if (start>=prevEnd) {
                ans++;
                prevEnd = end;
            }
        }
        System.out.println(ans);
    }

}
