public class Test {
    public static void main(String[] args) {
        String w = new String("CSE11");
        String x = new String("CSE11");
        String y = "CSE11";
        String z = "CSE11";
        System.out.print(" " + y.equals(z));
        System.out.print(" " + (w==x));
        System.out.print(" " + w.equals(x));
        System.out.print(" " + (x==y));
        System.out.print(" " + (y==z));
        System.out.println(" " + x.equals(y));

        System.out.println(countOccurrences("Hello", 'e'));
    }
    public static int countOccurrences(String str, char c){
        if(str.length() == 0){
            return 0;
        }
        if(str.charAt(0) == c){
            return 1 + countOccurrences(str.substring(1), c);
        }
        return countOccurrences(str.substring(1), c);
    }

}
