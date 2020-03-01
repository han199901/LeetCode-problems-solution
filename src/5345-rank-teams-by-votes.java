class Solution {
    public String rankTeams(String[] votes) {
        int length = votes[0].length();
        int[][] sum = new int[26][length];
        int[] flag = new int[26];
        for (int i = 0; i < votes.length; i++) {
            for (int j = 0; j < length; j++) {
                sum[votes[i].charAt(j) - 'A'][j]++;
                flag[votes[i].charAt(j) - 'A'] = 1;
            }
        }
        StringBuilder t = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int who = -1, pSum = -1;
            for (int j = 0; j < 26; j++) {
                if (flag[j] == 0)
                    continue;
                for (int k = 0; k < length; k++) {
                    if (who == -1) {
                        who = j;
                        pSum = sum[j][k];
                    } else if (sum[j][k] == sum[who][k])
                        continue;
                    else if (sum[j][k] > sum[who][k]) {
                        who = j;
                        pSum = sum[j][i];
                    } else
                        break;
                }
            }
            flag[who]--;
            char a = (char) (who + 65);
            t.append(String.valueOf(a));
        }
        return t.toString();
    }
}