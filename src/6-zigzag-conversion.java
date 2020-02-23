class Solution {
    public static String convert(String s, int numRows) {
        if(numRows<2)
            return s;
        String r[] = new String[numRows+1];
        for(int i=0; i<r.length; i++)
            r[i]="";
        int flag = 1, j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (flag == 1)
                r[j++] += s.charAt(i);
            else
                r[j--] += s.charAt(i);

            if(j>=numRows-1||j==0)
                flag*=-1;
        }
        for(int i=1; i<r.length; i++) {
            r[0] += r[i];
        }
        return r[0];
    }
}