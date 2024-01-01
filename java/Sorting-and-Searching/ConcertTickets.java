import java.io.DataInputStream;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ConcertTickets {
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
      // Scanner s = new Scanner(System.in);
      Reader r = new Reader();
      int n = r.nextInt();
      int m = r.nextInt();

      TreeMap<Integer, Integer> ticketMap = new TreeMap<>();
      StringBuffer sb = new StringBuffer();

      for (int i = 0; i < n; i++) {
         int x = r.nextInt();
         ticketMap.put(x, ticketMap.getOrDefault(x, 0) + 1);
      }

      for (int i = 0; i < m; i++) {
         int x = r.nextInt();
         Entry<Integer, Integer> entry = ticketMap.floorEntry(x);
         if (ticketMap.isEmpty() || entry == null)
            sb.append(-1).append("\n");
         else {
            int key = entry.getKey();
            int val = entry.getValue() - 1;

            if (val == 0)
               ticketMap.remove(key);
            else
               ticketMap.put(key, val);
            sb.append(key).append("\n");
         }
      }
      System.out.println(sb);
   }
}