package backtracing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class back77 {
    ArrayList<List<Integer>> relist = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracing(n,k,1);
        for (List l: relist
        ) {
            System.out.print("relist :");
            printList((ArrayList<Integer>) l);
        }
        return relist;
    }

    private void backtracing(int n, int k, int index) {
        if (list.size() == k) {
            relist.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n; i++) {
            list.add(i);
            printList(list);
            System.out.println();

            backtracing(n, k, i + 1);
            list.remove(list.size() - 1);
            printList(list);
            System.out.println();

        }
    }

    private void printList(ArrayList<Integer> list) {
        for (int a: list
             ) {
            System.out.print(a + " ");
        }
    }

    public static void main(String[] args) {
        back77 back77 = new back77();
        back77.combine(1, 1);
    }
}
