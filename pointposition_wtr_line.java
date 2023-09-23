import java.util.Scanner;

class Main{
    
    static double x0,x1,x2,y0,y1,y2,k;
    
    
    static void getdata(){
        Scanner ob = new Scanner(System.in);
        x0=ob.nextDouble();
        y0=ob.nextDouble();
        x1=ob.nextDouble();
        y1=ob.nextDouble();
        x2=ob.nextDouble();
        y2=ob.nextDouble();
    }
    static void ftln(){
        if(k>0){
            System.out.printf("(%.1f, %.1f) is on the left side of the line\nfrom (%.1f, %.1f) to (%.1f, %.1f)", x2,y2,x0,y0,x1,y1);
        }
    }
    static void onln(){
        if(k==0){
            System.out.printf("(%.1f, %.1f) is on the same line from (%.1f, %.1f) to (%.1f, %.1f)", x2,y2,x0,y0,x1,y1);
        }
    }
    static void rgln(){
        if(k<0){
            System.out.printf("(%.1f, %.1f) is on the right side of the line\nfrom (%.1f, %.1f) to (%.1f, %.1f)", x2,y2,x0,y0,x1,y1);
        }
    }
    
    public static void main(String... args){
        char p0, p1, p2;
        
        getdata();
        k = (x1-x0)*(y2-y0) - (x2-x0)*(y1-y0);
        ftln();
        onln();
        rgln();
        
    }
}
