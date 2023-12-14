package random.Dec23;

import java.util.ArrayList;

public class Test {
    private int z1 = 1, z2 = 2, z3 = 3, z4 = 4;

    public ArrayList<Integer> getValue(int a, int b, int c, int d, int e) {
        if (a == z1) {
            b = a + b;
        } else if (a == z2) {
            c = a + c;
        } else if (a == z3) {
            d = a + d;
        } else if (a == z4) {
            e = a + e;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);

        for (int i = 0; i < list.size(); i++) {
            int tmp = list.get(i);
            tmp = tmp / 2;
            list.set(i, tmp);
        }
        return list;
    }

    public static void main(String[] args) {
        Test t = new Test();
        ArrayList<Integer> list = t.getValue(1, 2, 3, 4, 5);
        String result = "参数的值分别是：";
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i);
            result += "、";
        }
        System.out.println(result);
    }
}
