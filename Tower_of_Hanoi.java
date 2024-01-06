public class Tower_of_Hanoi {
    static void Tower(int n,String Source, String Destination, String Helper){
        if(n==0) return;
        Tower(n-1,Source,Helper,Destination);
        System.out.println("Move dgitisk " + n + " from rod "
                + Source + " to rod "
                + Destination);
        Tower(n - 1,Helper, Destination,Source);

    }
    public static void main(String[] args) {
        int n=3;
        Tower(n,"A", "B","C");
    }
}
