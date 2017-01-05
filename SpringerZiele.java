public class Springer {
    int x;
    int y;
    String[][] brett;

    public Springer(String start) {
        x = (int) start.charAt(1) - 96;
        y =Integer.parseInt(String.valueOf(start.charAt(0)) );
        x -=1;
        y-=1;
        brett = new String[8][8];
        for (int i = 7; i>=0;i--){
            for (int j = 0; j<brett[i].length;j++){
                brett[i][j] =""+String.valueOf(i+1)+String.valueOf(Character.toChars(97+j));
            }
        }
    }

    public String ermittleZiele() {
        StringBuilder sb = new StringBuilder();
            for (int i = 0 , p = 1 ; i<2 ; i++ , p = -p) {
                for (int j = 0, upDown = 2, leftRight = 1; j < 2; j++, leftRight = -leftRight) {
                    try{
                        sb.append(brett[y + upDown*p][x + leftRight*p]);
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        continue;
                    }
                    sb.append(" ");
                }
                for (int k = 0, leftRight = 2, upDown = 1; k < 2; k++, leftRight = -leftRight) {
                    try{
                        sb.append(brett[y + upDown*p][x + leftRight*p]);
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        continue;
                    }
                    sb.append(" ");
                }
            }
        return sb.toString();
    }
}

public class SpringerTest {
    public static void main(String[]args){
        String start = "5e";
        Springer s = new Springer(start);
        System.out.println("Startfeld: "+start);
        System.out.println("Mögliche Züge: " + s.ermittleZiele());
    }
}