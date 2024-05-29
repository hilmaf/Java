import java.io.*;

public class Print {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // System.out.println
        System.out.println("StringBuilder 사용 X ::: ");

        try {
            int num = Integer.parseInt(br.readLine());

            for (int i = 0; i < num; i++) {
                System.out.println(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("StringBuilder 사용 ::: \n");

        try {
            int num = Integer.parseInt(br.readLine());

            for (int i = 0; i < num; i++) {
                sb.append(br.readLine()).append('\n');
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // 출력 스트림
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            bw.write("출력 스트림 사용 ::: \n");

            int num = Integer.parseInt(br.readLine());

            for (int i = 0; i < num; i++) {
                bw.write(br.readLine());
                bw.write("\n");
            }

            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}