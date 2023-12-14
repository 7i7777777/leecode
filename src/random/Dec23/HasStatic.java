package random.Dec23;

public class HasStatic {
    private static int x = 100;

    public static void main(String[] args) {
        HasStatic hs1 = new HasStatic();
        hs1.x++;
        HasStatic hs2 = new HasStatic();
        hs2.x++;
        hs1 = new HasStatic();
        hs1.x++;
        HasStatic.x++;
        System.out.println("x=" + x);
    }

//    public Object m(){
//        Object o = new Float(3.14F);
//        Object[] oa = new Object[1];
//        oa[0] = o;
//        o=null;
//        oa[0]=null;
//        print 'return 0';
//    }
}
