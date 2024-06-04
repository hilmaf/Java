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

            int byteCnt = 0;
            while(byteCnt < x && pnt < str.length()) {
                // 한글 / 영문, 숫자 구분해서 byteCnt 다르게 증가
                String tempStr = str.substring(pnt, pnt + 1);

                if (tempStr.getBytes(StandardCharsets.UTF_8).length == 3) { //한글
                    sb.append(tempStr);
                    byteCnt += 2;
                    pnt += 1;
                } else { // 영문, 숫자, 공백
                    sb.append(tempStr);
                    byteCnt += 1;
                    pnt += 1;
                }
            }

            strArr[idx] = sb.toString();
            idx++;
        }


        for (String x : strArr) {
            System.out.println(x);
        }
    } // psvm
} // class