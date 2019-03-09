public class NwdNww {
    public static int metodaLiczaca(int x, int y) {
        while (x != y) {
            if (x > y) {
                x = x - y;
            } else {
                y = y - x;
            }

        }
        return x;
    }
    public static int metodaMnozaca(int x, int y){
        int nwd= metodaLiczaca(x,y);
        return (x * y)/nwd;
    }


    public static void main(String[] args) {
        System.out.println(metodaLiczaca(98,56));
        System.out.println(metodaMnozaca(98,56));
    }
}
