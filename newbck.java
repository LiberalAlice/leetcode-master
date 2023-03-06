import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author：wuwei
 * @Date：2023/2/27
 */
public class newbck {
    ArrayList<Integer> list = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {

    }

    //组合总数
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        caculate(candidates, target, 1);
        return result;
    }

    private void caculate(int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            target -= candidates[i];
            list.add(candidates[i]);
            caculate(candidates, target, i);
            target += candidates[i];
            list.remove(list.size() - 1);
        }
    }


    //分发饼干
    public int findContentChildren(int[] g, int[] s) {
        int len = g.length;
        int cookies = s.length;
        int index = 0;
        int result = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0; i < len; i++) {
            if (s[index] > g[i]) {
                result++;
                if (index < cookies) {
                    index++;
                }
            }
        }
        return result;
    }
    //组合总和 III
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracing(k, n, 0);
        return result;
    }

    private void backtracing(int k, int n, int index) {
        if (list.size() == k) {
            if (n == 0) {
                result.add(new ArrayList<>(list));
            }
            else {return;}
        }
        for (int i = index; i <= 9 && n - i >= 0; i++) {
            n -= i;
            list.add(i);
            backtracing(k, n, i + 1);
            n += i;
            list.remove(list.size() - 1);
        }
    }

    //电话号码的字母组合
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        char[] array = digits.toCharArray();
        return backtracing(array, result,0);
    }

    StringBuffer buffer = new StringBuffer();
    String[] num = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz",
    };
    private List<String> backtracing(char[] array, ArrayList<String> result,int index) {
        if (buffer.length() == array.length) {
            result.add(buffer.toString());
            return result;
        }
        int digit = array[index] - '0';
        String arrchar = num[digit];
        for (int i = 0; i < arrchar.length(); i++) {
            buffer.append(arrchar.charAt(i));
            backtracing(array, result, index + 1);
            buffer.deleteCharAt(buffer.length()- 1) ;
        }
        return result;
    }


}
