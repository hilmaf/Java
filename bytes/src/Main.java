import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {

        String str = "11111111111123456789123테슬라                                  12";

        String[] strArr = new String[5];
        int[] lens = new int[]{11, 12, 40, 1, 1};
        int pnt = 0;
        int idx = 0;

        for (int x : lens) {
            StringBuilder sb = new StringBuilder();

            int byteCnt = 0; // 각 필드의 byte 누적 카운트 값
            while(pnt < str.length() && byteCnt < x) {
                String tempStr = str.substring(pnt, pnt + 1);

                int increase = 0;
                try {
                    byte[] tempBytes = tempStr.getBytes("EUC-KR");
                    increase = tempBytes.length;
                } catch (UnsupportedEncodingException e) {
                    byte[] tempBytes = tempStr.getBytes(StandardCharsets.UTF_8);
                    increase = tempBytes.length == 3 ? 2 : 1;
                }

                sb.append(tempStr);
                byteCnt += increase;
                pnt += 1;
            }

            strArr[idx] = sb.toString();
            idx++;
        }


        for (String x : strArr) {
            System.out.println(x);
        }
    } // psvm
} // class