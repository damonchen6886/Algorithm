package OA.eBay;

public class CheckOperation {

    public boolean check(int[] a, char[] b, int[] c, int[] d){
        for(int i = 0; i< a.length;i++){
            int operator = b[i];
            int result = 0;
            if(operator == '+'){
                result = a[i]+c[i];
            }
            if(operator == '-'){
                result = a[i] -c[i];
            }
            if(operator == '*'){
                result = a[i] * c[i];
            }
            if(operator == '/'){
                result = a[i]/c[i];
            }
            if(result != d[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {3,4,5,6};
        char[] b = {'+','-','*','/'};
        int[] c = {3,4,5,6};
        int[] d = {6,0,25,1};
        int[] e = {6,0,25,3};
        CheckOperation checkOperation=  new CheckOperation();
        System.out.println(checkOperation.check(a,b,c,d));
        System.out.println(checkOperation.check(a,b,c,e));
    }
}

