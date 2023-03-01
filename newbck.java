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
        caculate(candidates, target, 0);
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


}
