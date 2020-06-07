public class ReplaceSpace {

    public static void main(String[] arg) {

    }

    public String replaceSpace(StringBuffer str){
        int p = str.length()-1;
        for (int i=0;i<=p; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int q = str.length()-1;
        for (; p>=0&&q>p;) {
            char c = str.charAt(p);

            if (c != ' ') {
                str.setCharAt(q, c);
                p--;
                q--;
            } else {
                str.setCharAt(q--, '0');
                str.setCharAt(q--, '2');
                str.setCharAt(q--, '%');
                p--;
            }
        }
        return str.toString();
    }
}
