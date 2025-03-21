public class tr {
    public static void printItems(int n){
        for(int i=0;i<n;i++){
            for(int j = 0 ; j <  n ; j++){
                System.out.println(i + " " + j);
            }
        }
    }
    public static void main(String[] args) {
        printItems(5);
    }
    
}
