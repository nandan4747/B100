
import javax.swing.JButton;
class Supper_B100_rules
{ 
    
    @SuppressWarnings("unused")
    public boolean win = false;
    public boolean gameover = false;
    public boolean  draw_declare = false;
    int draw_count = 1;
    public char[][] win_check(char arr[][]){
        if((arr[0][0]==arr[0][1] && arr[0][1] == arr[0][2])||(arr[1][0] == arr[1][1] && arr[1][1] == arr[1][2]) || (arr[2][0] == arr[2][1] && arr[2][1] == arr[2][2])||(arr[0][0] == arr[1][1] && arr[1][1]==arr[2][2]) || (arr[2][0]==arr[1][1] && arr[1][1] == arr[0][2]) || (arr[0][0] == arr[1][0] && arr[1][0] == arr[2][0]) || (arr[0][1] == arr[1][1] && arr[1][1] == arr[2][1]) || (arr[0][2] == arr[1][2] && arr[1][2] == arr[2][2])){
                //System.out.println("game won : " );
                win = true;
                gameover = true;
        }
           if((arr[0][0] == 'O' || arr[0][0] == 'X') && (arr[0][1] == 'O' || arr[0][1] == 'X') && (arr[0][2] == 'O' || arr[0][2] == 'X') && (arr[1][0] == 'O' || arr[1][0] == 'X') && (arr[1][2] == 'O' || arr[1][2] == 'X') && (arr[1][1] == 'O' || arr[1][1] == 'X') && (arr[2][0] == 'O' || arr[2][0] == 'X') && (arr[2][1] == 'O' || arr[2][1] == 'X') && (arr[2][2] == 'O' || arr[2][2] == 'X')){
            gameover = true;
            draw_declare = true;
          //  System.out.println("draw");
           }
        
        return  arr;
    }
    // super B100 changes --------------------------------
    
    public void draw_check(){
        if(draw_count == 10 && win != true){
            gameover = true;
            System.out.println("game has been declared draw");
          //  System.out.println("-------------------------------");
        }

       
    }
    public char[][] reset_game(char arr[][]){
        arr[0][0] = 'a'; arr[0][1] = 'b'; arr[0][2] = 'c';
    arr[1][0] = 'd'; arr[1][1] = 'e'; arr[1][2] = 'f';
    arr[2][0] = 'g'; arr[2][1] = 'h'; arr[2][2] = 'i';
        return arr;
    }

    public void close_all_options(JButton j1,JButton j2,JButton j3, JButton j4, JButton j5, JButton j6, JButton j7, JButton j8, JButton j9){
    j1.setEnabled(false);
    j2.setEnabled(false);
    j3.setEnabled(false);
    j4.setEnabled(false);
    j5.setEnabled(false);
    j6.setEnabled(false);    
    j7.setEnabled(false);
    j8.setEnabled(false);
    j9.setEnabled(false);
    }
}