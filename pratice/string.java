package pratice;

/**
 * @Author：wuwei
 * @name：string
 * @Date：2023/1/3 10:41
 */
public class string {
    public void reverseString(char[] s,int left, int right) {
        while (left++ < right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

    public String reverseStr(String s, int k) {
        char[] s1 = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            if (s.length() - i >= k) {
                reverseString(s1, i, i + k - 1);
                continue;
            }
            reverseString(s1, i, s.length() - 1);
        }
        return new String(s1);
    }
}
