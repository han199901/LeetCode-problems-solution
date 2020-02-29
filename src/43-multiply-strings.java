//普通竖式法
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0"))
            return "0";
        String res = "";
        for (int i = num1.length() - 1; i >= 0; i--) {
            String temp = "";
            int x = Integer.parseInt(String.valueOf(num1.charAt(i)));
            int carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int y = Integer.parseInt(String.valueOf(num2.charAt(j)));
                if (carry == 0)
                    y = y * x;
                else
                    y = x * y + Integer.parseInt(String.valueOf(carry));
                if (y >= 10) {
                    carry = y / 10;
                    temp = String.valueOf(y % 10) + temp;
                } else {
                    carry = 0;
                    temp = String.valueOf(y) + temp;
                }
            }
            if (carry >= 1) {
                temp = String.valueOf(carry) + temp;
            }
            if (i == num1.length() - 1)
                res = temp;
            else {
                int n = num1.length() - i - 1;
                while (n-- != 0)
                    temp += "0";
                res = add(temp, res);
            }
        }
        return res;
    }

    private static String add(String num1, String num2) {
        String res = "";
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int x = 0;
            if (i >= 0)
                x = Integer.parseInt(String.valueOf(num1.charAt(i)));
            int y = 0;
            if (j >= 0)
                y = Integer.parseInt(String.valueOf(num2.charAt(j)));
            x += y;
            if (carry == 1) {
                x++;
                carry = 0;
            }
            if (x >= 10) {
                carry = 1;
                x -= 10;
            }
            res = x + res;
            i--;
            j--;
        }
        if (carry == 1)
            res = "1" + res;
        return res;
    }
}


//优化竖式法
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }
}