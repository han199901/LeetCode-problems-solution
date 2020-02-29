## 43-字符串相乘详解

### 1、普通竖式法

**思路**

竖式运算思想，以 num1 为 123，num2 为 456 为例分析：

![](https://pic.leetcode-cn.com/d24bf3174a878890e1273fbe35426ecdfa932c33efb464ed3602f4d149ed343a)

实现：

```java
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
```
### 2、优化竖式法
**思路**

该算法是通过两数相乘时，乘数某位与被乘数某位相乘，与产生结果的位置的规律来完成。具体规律如下：

乘数 num1 位数为 MM，被乘数 num2 位数为 NN， num1 x num2 结果 res 最大总位数为 M+N
num1[i] x num2[j] 的结果为 tmp(位数为两位，"0x","xy"的形式)，其第一位位于 res[i+j]，第二位位于 res[i+j+1]。
结合下图更容易理解
<img src="https://pic.leetcode-cn.com/171cad48cd0c14f565f2a0e5aa5ccb130e4562906ee10a84289f12e4460fe164-image.png" style="zoom:50%;" />

实现：

```java
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
```