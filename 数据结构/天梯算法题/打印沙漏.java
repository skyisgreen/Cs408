import java.util.Scanner;

public class 打印沙漏 {
    public static void main(String argc[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        if (s.length() == 1 && n > 0 && n <= 1000) {
            char c = s.charAt(0);
            int row = 0, rest = 0;
            int tmp = n, num = 1;
            boolean flag;
            while (true) {
                if (row == 0) {
                    tmp -= num;
                    row += 1;
                    num += 2;
                } else {
                    tmp -= 2 * num;
                    if (tmp <= 0) {
                        if (tmp == 0) {
                            flag = true;
                            row += 2;
                            break;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                    row += 2;
                    num += 2;
                }
            }
            if (flag) {
                rest = 0;
            } else {
                rest = tmp += 2 * num;
            }
            int blank = 0;
            for (int i = 0, j = row, k = 3; i < row; i++) {
                if (j > 0) {
                    System.out.print(String(blank, ' '));
                    System.out.println(String(j, c));
                    j -= 2;
                    blank++;
                } else {
                    if (k == 3) {
                        blank -= 2;
                    } else {
                        blank--;
                    }
                    System.out.print(String(blank, ' '));
                    System.out.println(String(k, c));
                    k += 2;
                }
            }
            System.out.println(rest);
        }
    }

    private static char[] String(int i, char c) {
        char[] ch = new char[i];
        for (int j = 0; j < i; j++) {
            ch[j] = c;
        }
        return ch;
    }
}
