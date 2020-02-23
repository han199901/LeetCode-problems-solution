import java.util.regex.Pattern;
class Solution {
    public boolean isMatch(String s, String p) {
        return Pattern.matches(p,s);
    }
}

//开玩笑啦

class Solution {
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) 
        	return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
        	//分别对第一个字符不匹配和第一个字符匹配进行讨论
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
        	//匹配一个字符继续向后匹配
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}

