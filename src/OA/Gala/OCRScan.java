package OA.Gala;

public class OCRScan {

    public boolean scanChar(String s1, String s2){
       String a = parseString(s1);
       String b = parseString(s2);
       if(a.length() != b.length()){
           return false;
       }
       for(int i = 0; i< a.length();i++){
           char curA = a.charAt(i);
           char curB = b.charAt(i);
           if(curA == '?' || curB == '?'){
               continue;
           }
           if(curA != curB){
               return false;
           }
       }
       return true;
    }
    private String parseString(String s){
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        for(char c: s.toCharArray()){
            if(c >='0' && c<= '9'){
                if(cur != 0){
                    cur*=10;
                }
                cur+= c - '0';
            }
            else{
                while(cur>0){
                    sb.append('?');
                    cur--;
                }
                sb.append(c);
            }
        }
        while (cur != 0){
            sb.append('?');
            cur--;
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        OCRScan o = new OCRScan();

//        System.out.println(o.scanChar("A2Le", "2pL1"));
//        System.out.println(o.scanChar("A12Le", "12pL1"));
//        System.out.println(o.scanChar("ba1", "1Ad"));
//        System.out.println(o.scanChar("3x2x", "8"));
//        System.out.println(o.scanChar("a10", "10a"));
//        System.out.println(o.scanChar("bbb", "3"));
        System.out.println((int)('0'));
        System.out.println((int)('z'-'0'));
        System.out.println((int)('D'-'0'));
        System.out.println((int)('6'-'0'));
    }
}
