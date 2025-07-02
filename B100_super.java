import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
class B100_super implements ActionListener
{
        char [][]a1 = new char[3][3];
        char [][]a2 = new char[3][3];
        char [][]a3 = new char[3][3];
        char [][]a4 = new char[3][3];
        char [][]a5 = new char[3][3];
        char [][]a6 = new char[3][3];
        char [][]a7 = new char[3][3];
        char [][]a8 = new char[3][3];
        char [][]a9 = new char[3][3];
        char [][]main_hash= new char[3][3];
        int mhn = 5;//main hash number
        char char_assginer;
        int npb[][] ={{0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0}}; 
        int turn_count = 0;

        
    JFrame f;
    JLayeredPane layer,layer2;
    ImageIcon bg,s_bg,game_over_popup;
    Image n_bg,game_over_img,scaled_img;
    JLabel bgl,message_layer;
    JLabel game_end_layer = new JLabel();
    JButton[]b1,b2,b3,b4,b5,b6,b7,b8,b9;
    JLabel[] l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JLabel tl1,tl2,tl3,tl4,tl5,tl6,tl7,tl8,tl9,g1,g2,g3,g4,g5,g6,g7,g8,g9,tl10;
    JLabel []wrapper = new JLabel[9];
    ArrayList<Integer> game_finished_list = new ArrayList<>();

     Supper_B100_rules game_rules = new Supper_B100_rules();
     Supper_B100_rules mini1 = new Supper_B100_rules();
     Supper_B100_rules mini2 = new Supper_B100_rules();
     Supper_B100_rules mini3 = new Supper_B100_rules();
     Supper_B100_rules mini4 = new Supper_B100_rules();
     Supper_B100_rules mini5 = new Supper_B100_rules();
     Supper_B100_rules mini6 = new Supper_B100_rules();
     Supper_B100_rules mini7 = new Supper_B100_rules();
     Supper_B100_rules mini8 = new Supper_B100_rules();
     Supper_B100_rules mini9 = new Supper_B100_rules();
     Supper_B100_rules main_hash_obj= new Supper_B100_rules();

    public static void main(String[] args) {
        B100_super obj = new B100_super();
        obj.B100_UI();
       
        
    
    }
    public void B100_UI(){
        f = new JFrame("B100 EXPERT");
        f.setSize(800, 800);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setLocation(400,20);
        f.setVisible(true);
        // layer
        layer = new JLayeredPane();
        layer.setSize(810,810);
        f.add(layer);
        layer2 = new JLayeredPane();
        layer2.setSize(810,810);
        layer.add(layer2,JLayeredPane.DRAG_LAYER);
        game_end_layer.setText("win");
        game_end_layer.setOpaque(true);
        game_end_layer.setBounds(80,230, 600,300);
        game_end_layer.setVisible(false);
        // background image 
        bg = new ImageIcon("super_hash_board.jpg");
        n_bg = bg.getImage().getScaledInstance(750,750,Image.SCALE_SMOOTH);
        s_bg = new ImageIcon(n_bg);
        bgl = new JLabel(s_bg);
        bgl.setBounds(-5, -19, 800, 800);
        // game end layer 
        game_over_popup = new ImageIcon("game_over_image.jpg");
        game_over_img = game_over_popup.getImage();
        scaled_img = game_over_img.getScaledInstance(600,300,Image.SCALE_SMOOTH);
        game_end_layer.setIcon(new ImageIcon (scaled_img));
        // massage part
        message_layer = new JLabel();
        message_layer.setBounds(80,230,600,300);
        message_layer.setOpaque(false);
        message_layer.setVisible(false);
        message_layer.setHorizontalAlignment(SwingConstants.CENTER);
        message_layer.setVerticalAlignment(SwingConstants.CENTER);
        message_layer.setFont(new Font("Arial",Font.BOLD,110));
        message_layer.setForeground(Color.WHITE);

        layer.add(bgl,JLayeredPane.DEFAULT_LAYER);
        layer2.add(game_end_layer,JLayeredPane.POPUP_LAYER);
        layer2.add(message_layer,JLayeredPane.DRAG_LAYER);
        b1= new JButton[9];
        b2 = new JButton[9];
        b3 = new JButton[9];
        b4 = new JButton[9];
        b5 = new JButton[9];
        b6 = new JButton[9];
        b7 = new JButton[9];
        b8 = new JButton[9];
        b9 = new JButton[9];

        // labels ------------------------
        l1 = new JLabel[9];
        l2 = new JLabel[9];
        l3 = new JLabel[9];
        l4 = new JLabel[9];
        l5 = new JLabel[9];
        l6 = new JLabel[9];
        l7 = new JLabel[9];
        l8 = new JLabel[9];
        l9 = new JLabel[9];

        // loading array ----------------------------
        game_rules.reset_game(a1);
        game_rules.reset_game(a2);
        game_rules.reset_game(a3);
        game_rules.reset_game(a4);
        game_rules.reset_game(a5);
        game_rules.reset_game(a6);
        game_rules.reset_game(a7);
        game_rules.reset_game(a8);
        game_rules.reset_game(a9);
        game_rules.reset_game(main_hash);

        //button set 1---------------------------
        for(int i = 0;i<9;i++){
            b1[i] = new JButton();
        }
        // button adding 
        B_location_cust(25, 15, b1,0,0,0,0,0,0);


        //button set 2----------------------------
        for(int i = 0;i<9;i++){
            b2[i] = new JButton();
        }
        // button adding 
        B_location_cust(280, 15, b2,0,0,0,2,4,0);

        // button set 3--------------------------
         for(int i = 0;i<9;i++){
            b3[i] = new JButton();
        }
        // button adding 
        B_location_cust(535, 15, b3,0,0,0,0,3,0);

        // set 4 ====================
        for(int i = 0;i<9;i++){
            b4[i] = new JButton();
        }
        // button adding 
        B_location_cust(25,270, b4,0,0,0,0,3,0);

        // set 5
         
          for(int i = 0;i<9;i++){
            b5[i] = new JButton();
        }
        // button adding 
        B_location_cust(280,270, b5,-2,-2,-2,0,3,0);
        
        // set 6
         
          for(int i = 0;i<9;i++){
            b6[i] = new JButton();
        }
        // button adding 
        B_location_cust(535,270, b6,0,0,0,0,3,0);

        // set 7
         for(int i = 0;i<9;i++){
            b7[i] = new JButton();
        }
        // button adding 
        B_location_cust(25,525, b7,0,0,0,0,3,0);

         // set 8
         for(int i = 0;i<9;i++){
            b8[i] = new JButton();
        }
        // button adding 
        B_location_cust(280,525, b8,0,0,0,0,3,0);

        //set 9 
        for(int i = 0;i<9;i++){
            b9[i] = new JButton();
        }
        // button adding 
        B_location_cust(535,525, b9,0,0,0,0,3,0);

   
       // JButton [][]btn_wrapper = {b1,b2,b3,b4,b5,b6,b7,b8,b9};

     // __________________________________________________________________________________

        // lables _______________

        for(int i = 0 ;i<9;i++){
            l1[i] = new JLabel();
        }
        label_loc(25,15,l1,0,0,0,0,0,0);
        

        
        for(int i = 0 ;i<9;i++){
            l2[i] = new JLabel();
        }
        label_loc(280, 15, l2,0,0,0,2,4,0);


        for(int i = 0 ;i<9;i++){
            l3[i] = new JLabel();
        }
        label_loc(535, 15, l3,0,0,0,0,3,0);

        
        for(int i = 0 ;i<9;i++){
            l4[i] = new JLabel();
        }
        label_loc(25,270,l4,0,0,0,0,3,0);

        for(int i = 0 ;i<9;i++){
            l5[i] = new JLabel();
        }
        label_loc(280,270, l5,-2,-2,-2,0,3,0);

         for(int i = 0 ;i<9;i++){
            l6[i] = new JLabel();
        }
        label_loc(535,270, l6,0,0,0,0,3,0);
        
        
         for(int i = 0 ;i<9;i++){
            l7[i] = new JLabel();
        }
        label_loc(25,525, l7,0,0,0,0,3,0);

         
         for(int i = 0 ;i<9;i++){
            l8[i] = new JLabel();
        }
        label_loc(280,525, l8,0,0,0,0,3,0);

        for(int i = 0 ;i<9;i++){
            l9[i] = new JLabel();
        }
        label_loc(535,525, l9,0,0,0,0,3,0);

        //game over layer __________

        g1 = new JLabel();
        game_over_layer_loc(g1, 26, 15);
        g2 = new JLabel();
        game_over_layer_loc(g2, 281, 15);
        g3 = new JLabel();
        game_over_layer_loc(g3, 536, 15);
         g5 = new JLabel();
        game_over_layer_loc(g5, 281, 270);
         g4 = new JLabel();
        game_over_layer_loc(g4, 26, 270);
         g6 = new JLabel();
        game_over_layer_loc(g6, 536,270);
         g7 = new JLabel();
        game_over_layer_loc(g7, 26, 525);
        g8 = new JLabel();
        game_over_layer_loc(g8, 281, 525);
         g9 = new JLabel();
        game_over_layer_loc(g9, 536, 525);

        // TURN LAYER 
        tl1 = new JLabel();
        turn_layer_loc(tl1,26,15);

        tl2 = new JLabel();
        turn_layer_loc(tl2,281,15);

        tl3 = new JLabel();
        turn_layer_loc(tl3,536,15);

        tl4 = new JLabel();
        turn_layer_loc(tl4, 26,270);

        tl5 = new JLabel();
        turn_layer_loc(tl5,281,270);

        tl6 = new JLabel();
        turn_layer_loc(tl6,536,270);

        tl7 = new JLabel();
        turn_layer_loc(tl7,26,525);

        tl8 = new JLabel();
        turn_layer_loc(tl8, 281,525);

        tl9 = new JLabel();
        turn_layer_loc(tl9,536,525);
        tl10 = new JLabel();
                turn_layer_loc(tl10,536,525);
                tl10.setOpaque(false);
               // tl1.setOpaque(false); tl1.repaint(); //------------------------------------------------------------------------------------------------------------
             JLabel [] turn_layer_wrapper = {tl1,tl2,tl3,tl4,tl5,tl6,tl7,tl8,tl9};

             for(int i = 0;i<turn_layer_wrapper.length;i++){
                wrapper[i] = turn_layer_wrapper[i];    
             }

             
          turn_layer_enabler(wrapper, mhn);
          button_disabling_check(mhn);
        

    }


    // button adder

     public void B_location_cust(int x , int y,JButton []br,int cx0,int cx,int cx2,int cy0,int cy,int cy2){
        int change = x;
        y = y+cy0;
        x = x + cx0;

        for(int i = 0;i<9;i++){
                 if(i==3){
                    y=y+77+cy;
                    x=change;
                    x= x+cx;
                 }
                 if(i==6){
                    y =y+77+cy2;
                    x= change;
                    x = x+cx2;
                 }

                   br[i].setBounds(x,y, 68, 68);
                   br[i].setBackground(Color.WHITE);
                 x = x+78;
                 br[i].addActionListener(this);
                 layer.add(br[i],JLayeredPane.PALETTE_LAYER);
        }
       
    }

    // label adder ======================

     public void label_loc(int x , int y,JLabel[]br,int cx0,int cx,int cx2,int cy0,int cy,int cy2){
        int change = x;
        y = y+cy0;
        x = x + cx0;

        for(int i = 0;i<9;i++){
                 if(i==3){
                    y=y+77+cy;
                    x=change;
                    x= x+cx;
                 }
                 if(i==6){
                    y =y+77+cy2;
                    x= change;
                    x = x+cx2;
                 }

                   br[i].setBounds(x,y, 68, 68);
                   br[i].setBackground(Color.WHITE);
                    br[i].setHorizontalAlignment(SwingConstants.CENTER);
                    br[i].setVerticalAlignment(SwingConstants.CENTER);
                    br[i].setFont(new Font("Arial",Font.BOLD,60));
                 x = x+78;
                 layer.add(br[i],JLayeredPane.MODAL_LAYER);
                 br[i].setOpaque(true);
                 br[i].setVisible(false);
                 
        }
       
    }

    public void game_over_layer_loc(JLabel t,int x, int y){
          t.setBounds(x,y,225,225);
        t.setBackground(Color.BLACK);
        layer.add(t,JLayeredPane.POPUP_LAYER);
        t.setOpaque(true);
        t.setVisible(false);
        

    }

    public void turn_layer_loc(JLabel t,int x, int y){
        t.setBounds(x,y,225,225);
        t.setBackground(new Color(0,0,0,100));
        layer2.add(t,JLayeredPane.DEFAULT_LAYER);
        t.setOpaque(true);
        t.setVisible(false);
        
    }

    public void button_disabler(JButton []btn){
        
        for(int i = 0 ; i<9;i++){
            btn[i].setEnabled(false);
          
        }         
            
   
    }
       public void button_enabler(JButton []b){
        for(int i = 0 ; i<9;i++){
            b[i].setEnabled(true);
        }         
   
    }
           
    // complete desable _______________________________________________________

    public void game_over_disable(JLabel l1,JLabel l2,JLabel l3,JLabel l4,JLabel l5,JLabel l6,JLabel l7,JLabel l8,JLabel l9){

          if(l1.isVisible()){
            for(int i = 0 ; i<9;i++){
                b1[i].setEnabled(false);
            }            

        }

        if(l2.isVisible()){
            for(int i = 0 ; i<9;i++){
                b2[i].setEnabled(false);
            }            

        }
         if(l3.isVisible()){
            for(int i = 0 ; i<9;i++){
                b3[i].setEnabled(false);
            }            

         }
           if(l4.isVisible()){
            for(int i = 0 ; i<9;i++){
                b4[i].setEnabled(false);
            }            

         }
           if(l5.isVisible()){
            for(int i = 0 ; i<9;i++){
                b5[i].setEnabled(false);
            }            

         }
         
           if(l6.isVisible()){
            for(int i = 0 ; i<9;i++){
                b6[i].setEnabled(false);
            }            

         }
         
          if(l7.isVisible()){
            for(int i = 0 ; i<9;i++){
                b7[i].setEnabled(false);
            }            

         }
           if(l8.isVisible()){
            for(int i = 0 ; i<9;i++){
                b8[i].setEnabled(false);
            }            

         }
           if(l9.isVisible()){
            for(int i = 0 ; i<9;i++){
                b9[i].setEnabled(false);
            }
           }            
        
    }
      public char X_or_O(){
              char cr;
              if(turn_count % 2 == 0){
                     cr = 'O';
              }
              else{
                     cr = 'X';
              }
              
              return cr;
       }

       // turn layer ___________________________________

       public void turn_layer_disabler_and_enable(boolean b){
        tl1.setVisible(b);
        tl2.setVisible(b);
        tl3.setVisible(b);
        tl4.setVisible(b);
        tl5.setVisible(b);
        tl6.setVisible(b);
        tl7.setVisible(b);
        tl8.setVisible(b);
        tl9.setVisible(b);
 
       }

// label enabler __________________________________________________________________________________________________

    public void turn_layer_enabler(JLabel []l,int n){
            for(int i = 0; i<9;i++){
                if(i+1 == n){
                    l[i].setVisible(false);
                  //  l[i].repaint();
                }
                else {
                    l[i].setVisible(true);
                }
            } 

    }
// button pressed ____________________________________________________________________________________________________________
       public int button_pressed(JButton b,JLabel l,char[][]a,int r,int c,int row,int column,int main_hash_no){
            b.setEnabled(false);
            a[r][c] = char_assginer;
            l.setText(String.valueOf(char_assginer));
            l.setVisible(true);
            npb[row][column] = 1;
            return main_hash_no;
            
       }
       


public void non_pressed_button_enabler(int[][]a,int row,JButton[] b){

    for(int i = 0 ; i<9 ; i++){
        if(a[row][i] == 0){
                b[i].setEnabled(true);
        }
        else {
            b[i].setEnabled(false);
        }
    }
   
}

// array loader _____________________________________________

public void array_loader(char[][]a){
    char chars = 'a';


     for(int r=0 ; r<9;r++){
              for(int j = 0;j<a[r].length;j++){

                    a[r][j] = chars;       
                     chars++;
              }
                 System.out.println();
        }

}
// repainter -----------------------------------------------------------
public void repainterr(int n){
            switch (n) {
                case 1 -> tl1.repaint();
                case 2 -> tl2.repaint();
                case 3 -> tl3.repaint();
                case 4 -> tl4.repaint();
                case 5 -> tl5.repaint();
                case 6 -> tl6.repaint();
                case 7 -> tl7.repaint();
                case 8 -> tl8.repaint();
                case 9 -> tl9.repaint();
                default -> {
                }
            }
}
// button disabler checker ____________________________________________

public void button_disabling_check(int n){
    if(n != 1){
        button_disabler(b1);
    }
    else {
       non_pressed_button_enabler(npb,0, b1);
    }
     if (n != 2){
        button_disabler(b2);
    }
    else {
        non_pressed_button_enabler(npb,1, b2);
    }
    if (n != 3){
        button_disabler(b3);
    }
    else {
        non_pressed_button_enabler(npb,2, b3);
    }
     if (n != 4){
        button_disabler(b4);
    }
    else {
        non_pressed_button_enabler(npb,3, b4);
    }
     if (n != 5){
        button_disabler(b5);
    }
    else {
         non_pressed_button_enabler(npb,4, b5);
    }
    if (n != 6){
        button_disabler(b6);
    }
    else {
         non_pressed_button_enabler(npb,5, b6);
    }
    if (n != 7){
        button_disabler(b7);
    }
    else {
        non_pressed_button_enabler(npb,6, b7);
    }
    if (n != 8){
        button_disabler(b8);
    }
    else {
        non_pressed_button_enabler(npb,7, b8);
    }
    if (n != 9){
        button_disabler(b9);
    }
    else {
      non_pressed_button_enabler(npb,8, b9);
    }
}

        @Override
    public void actionPerformed(ActionEvent e){
      // fake_win();
         dead_lock_check_and_remove(mhn);
        // repainterr(mhn);
            char_assginer = X_or_O();
           // System.out.println(mhn);
       
        
        // set 1____________________________________________________________________________-
        if(e.getSource() == b1[0]){
           mhn = button_pressed(b1[0],l1[0], a1,0,0,0,0,1);
           
        }           
        else if(e.getSource() == b1[1]){
            mhn = button_pressed(b1[1],l1[1], a1,0,1,0,1,2);
        } 

          else if(e.getSource() == b1[2]){
            mhn = button_pressed(b1[2],l1[2], a1,0,2,0,2,3);
        }

         else if(e.getSource() == b1[3]){
            mhn = button_pressed(b1[3],l1[3], a1,1,0,0,3,4);
        }  
         else if(e.getSource() == b1[4]){
            mhn = button_pressed(b1[4],l1[4], a1,1,1,0,4,5);
        } 
         else if(e.getSource() == b1[5]){
            mhn = button_pressed(b1[5],l1[5], a1,1,2,0,5,6);
        }
          else if(e.getSource() == b1[6]){
            mhn = button_pressed(b1[6],l1[6], a1,2,0,0,6,7);
        }  
         else if(e.getSource() == b1[7]){
            mhn = button_pressed(b1[7],l1[7], a1,2,1,0,7,8);
        }
        else if(e.getSource() == b1[8]){
            mhn = button_pressed(b1[8],l1[8], a1,2,2,0,8,9);
        } 
        // set 2 _________________________________________________________

        else if(e.getSource() == b2[0]){
            mhn = button_pressed(b2[0],l2[0], a2,0,0,1,0,1);
        }
          else if(e.getSource() == b2[1]){
            mhn = button_pressed(b2[1],l2[1], a2,0,1,1,1,2);
        }

          else if(e.getSource() == b2[2]){
            mhn = button_pressed(b2[2],l2[2], a2,0,2,1,2,3);
        }

          else if(e.getSource() == b2[3]){
            mhn = button_pressed(b2[3],l2[3], a2,1,0,1,3,4);
        }
          else if(e.getSource() == b2[4]){
            mhn = button_pressed(b2[4],l2[4], a2,1,1,1,4,5);
        }
          else if(e.getSource() == b2[5]){
            mhn = button_pressed(b2[5],l2[5], a2,1,2,1,5,6);
        }
          else if(e.getSource() == b2[6]){
            mhn = button_pressed(b2[6],l2[6], a2,2,0,1,6,7);
        }
          else if(e.getSource() == b2[7]){
            mhn = button_pressed(b2[7],l2[7], a2,2,1,1,7,8);
        }
          else if(e.getSource() == b2[8]){
            mhn = button_pressed(b2[8],l2[8], a2,2,2,1,8,9);
        }

        //set 3___________________________________________________
        else if(e.getSource() == b3[0]){
            mhn = button_pressed(b3[0],l3[0], a3,0,0,2,0,1);
        }
         else if(e.getSource() == b3[1]){
            mhn = button_pressed(b3[1],l3[1], a3,0,1,2,1,2);
        }
         else if(e.getSource() == b3[2]){
            mhn = button_pressed(b3[2],l3[2], a3,0,2,2,2,3);
        }
         else if(e.getSource() == b3[3]){
            mhn = button_pressed(b3[3],l3[3], a3,1,0,2,3,4);
        }
         else if(e.getSource() == b3[4]){
            mhn = button_pressed(b3[4],l3[4], a3,1,1,2,4,5);
        }
         else if(e.getSource() == b3[5]){
            mhn = button_pressed(b3[5],l3[5], a3,1,2,2,5,6);
        }
         else if(e.getSource() == b3[6]){
            mhn = button_pressed(b3[6],l3[6], a3,2,0,2,6,7);
        }
         else if(e.getSource() == b3[7]){
            mhn = button_pressed(b3[7],l3[7], a3,2,1,2,7,8);
        }
         else if(e.getSource() == b3[8]){
            mhn = button_pressed(b3[8],l3[8], a3,2,2,2,8,9);
        }
        // set 4 -------------------------------------------------------------------------
        else if(e.getSource() == b4[0]){
            mhn = button_pressed(b4[0],l4[0], a4,0,0,3,0,1);
        }
        else if(e.getSource() == b4[1]){
            mhn = button_pressed(b4[1],l4[1], a4,0,1,3,1,2);
        }
        else if(e.getSource() == b4[2]){
            mhn = button_pressed(b4[2],l4[2], a4,0,2,3,2,3);
        }
        else if(e.getSource() == b4[3]){
            mhn = button_pressed(b4[3],l4[3], a4,1,0,3,3,4);
        }
        else if(e.getSource() == b4[4]){
            mhn = button_pressed(b4[4],l4[4], a4,1,1,3,4,5);
        }
        else if(e.getSource() == b4[5]){
            mhn = button_pressed(b4[5],l4[5], a4,1,2,3,5,6);
        }
        else if(e.getSource() == b4[6]){
            mhn = button_pressed(b4[6],l4[6], a4,2,0,3,6,7);
        }
        else if(e.getSource() == b4[7]){
            mhn = button_pressed(b4[7],l4[7], a4,2,1,3,7,8);
        }
        else if(e.getSource() == b4[8]){
            mhn = button_pressed(b4[8],l4[8], a4,2,2,3,8,9);
        }

        // set 5 __________________________________________________________--------------------
        else if(e.getSource() == b5[0]){
            mhn = button_pressed(b5[0],l5[0], a5,0, 0, 4,0,1);
        }
          else if(e.getSource() == b5[1]){
            mhn = button_pressed(b5[1],l5[1], a5,0, 1, 4,1,2);
        }
          else if(e.getSource() == b5[2]){
            mhn = button_pressed(b5[2],l5[2], a5,0, 2, 4,2,3);
        }
          else if(e.getSource() == b5[3]){
            mhn = button_pressed(b5[3],l5[3], a5,1, 0, 4,3,4);
        }
          else if(e.getSource() == b5[4]){
            mhn = button_pressed(b5[4],l5[4], a5,1, 1, 4,4,5);
        
        }
          else if(e.getSource() == b5[5]){
            mhn = button_pressed(b5[5],l5[5], a5,1, 2, 4,5,6);
        }
          else if(e.getSource() == b5[6]){
            mhn = button_pressed(b5[6],l5[6], a5,2, 0, 4,6,7);
        }
          else if(e.getSource() == b5[7]){
            mhn = button_pressed(b5[7],l5[7], a5,2, 1, 4,7,8);
        }
          else if(e.getSource() == b5[8]){
            mhn = button_pressed(b5[8],l5[8], a5,2, 2, 4,8,9);
        }
        // set 6 ______________________________________________________________________
        else if (e.getSource() == b6[0]){
            mhn = button_pressed(b6[0],l6[0], a6, 0, 0, 5,0,1);
        }
         else if (e.getSource() == b6[1]){
            mhn = button_pressed(b6[1],l6[1], a6, 0, 1, 5,1,2);
        }
         else if (e.getSource() == b6[2]){
            mhn = button_pressed(b6[2],l6[2], a6, 0, 2, 5,2,3);
        }
         else if (e.getSource() == b6[3]){
            mhn = button_pressed(b6[3],l6[3], a6, 1, 0, 5,3,4);
        }
         else if (e.getSource() == b6[4]){
            mhn = button_pressed(b6[4],l6[4], a6, 1, 1, 5,4,5);
        }
         else if (e.getSource() == b6[5]){
            mhn = button_pressed(b6[5],l6[5], a6, 1, 2, 5,5,6);
        }
         else if (e.getSource() == b6[6]){
            mhn = button_pressed(b6[6],l6[6], a6, 2, 0, 5,6,7);
        }
         else if (e.getSource() == b6[7]){
            mhn = button_pressed(b6[7],l6[7], a6, 2, 1, 5,7,8);
        }
         else if (e.getSource() == b6[8]){
            mhn = button_pressed(b6[8],l6[8], a6, 2, 2, 5,8,9);
        }
        // set 7 ---------------------------------------------------------
        else if (e.getSource() == b7[0]){
            mhn = button_pressed(b7[0], l7[0], a7, 0, 0, 6, 0,1);
        }
           else if (e.getSource() == b7[1]){
            mhn = button_pressed(b7[1], l7[1], a7, 0, 1, 6, 1,2);
        }
           else if (e.getSource() == b7[2]){
            mhn = button_pressed(b7[2], l7[2], a7, 0, 2, 6, 2,3);
        }
           else if (e.getSource() == b7[3]){
            mhn = button_pressed(b7[3], l7[3], a7, 1, 0, 6, 3,4);
        }
           else if (e.getSource() == b7[4]){
            mhn = button_pressed(b7[4], l7[4], a7, 1, 1, 6, 4,5);
        }
           else if (e.getSource() == b7[5]){
            mhn = button_pressed(b7[5], l7[5], a7, 1, 2, 6, 5,6);
        }
           else if (e.getSource() == b7[6]){
            mhn = button_pressed(b7[6], l7[6], a7, 2, 0, 6, 6,7);
        }
           else if (e.getSource() == b7[7]){
            mhn = button_pressed(b7[7], l7[7], a7, 2, 1, 6, 7,8);
        }
           else if (e.getSource() == b7[8]){
            mhn = button_pressed(b7[8], l7[8], a7, 2, 2, 6, 8,9);
        }
        // set 8 ------------------------------------------------------------------
        else if(e.getSource() == b8[0]){
            mhn = button_pressed(b8[0], l8[0], a8, 0, 0, 7,0,1);
        }
          else if(e.getSource() == b8[1]){
            mhn = button_pressed(b8[1], l8[1], a8, 0, 1, 7,1,2);
        }
          else if(e.getSource() == b8[2]){
            mhn = button_pressed(b8[2], l8[2], a8, 0, 2, 7,2,3);
        }
          else if(e.getSource() == b8[3]){
            mhn = button_pressed(b8[3], l8[3], a8, 1, 0, 7,3,4);
        }
          else if(e.getSource() == b8[4]){
            mhn = button_pressed(b8[4], l8[4], a8, 1, 1, 7,4,5);
        }
          else if(e.getSource() == b8[5]){
            mhn = button_pressed(b8[5], l8[5], a8, 1, 2, 7,5,6);
        }
          else if(e.getSource() == b8[6]){
            mhn = button_pressed(b8[6], l8[6], a8, 2, 0, 7,6,7);
        }
          else if(e.getSource() == b8[7]){
            mhn = button_pressed(b8[7], l8[7], a8, 2, 1, 7,7,8);
        }
          else if(e.getSource() == b8[8]){
            mhn = button_pressed(b8[8], l8[8], a8, 2, 2, 7,8,9);
        }

        // set 9 -------------------------------------------------------
        else if (e.getSource() == b9[0]){
            mhn = button_pressed(b9[0], l9[0], a9, 0, 0, 8, 0, 1);
        }
        else if (e.getSource() == b9[1]){
            mhn = button_pressed(b9[1], l9[1], a9, 0, 1, 8, 1, 2);
        }
        else if (e.getSource() == b9[2]){
            mhn = button_pressed(b9[2], l9[2], a9, 0, 2, 8, 2, 3);
        }
        else if (e.getSource() == b9[3]){
            mhn = button_pressed(b9[3], l9[3], a9, 1, 0, 8, 3, 4);
        }
        else if (e.getSource() == b9[4]){
            mhn = button_pressed(b9[4], l9[4], a9, 1, 1, 8, 4, 5);
        }
        else if (e.getSource() == b9[5]){
            mhn = button_pressed(b9[5], l9[5], a9, 1, 2, 8, 5, 6);
        }
        else if (e.getSource() == b9[6]){
            mhn = button_pressed(b9[6], l9[6], a9, 2, 0, 8, 6, 7);
        }
        else if (e.getSource() == b9[7]){
            mhn = button_pressed(b9[7], l9[7], a9, 2, 1, 8, 7, 8);
        }
        else if (e.getSource() == b9[8]){
            mhn = button_pressed(b9[8], l9[8], a9, 2, 2, 8, 8, 9);
        }

        turn_layer_enabler(wrapper,mhn);
        button_disabling_check(mhn);

       

        //win checking _____________________
        mini1.win_check(a1);
        mini2.win_check(a2);
        mini3.win_check(a3);
        mini4.win_check(a4);
        mini5.win_check(a5);
        mini6.win_check(a6);
        mini7.win_check(a7);
        mini8.win_check(a8);
        mini9.win_check(a9);

        if(mini1.gameover && !g1.isVisible()){
            g1.setVisible(true);
            button_disabler(b1);
            game_over_font(g1);
            game_finished_list.add(1);
            if(mini1.win){
                main_hash[0][0] = char_assginer;
                g1.setText(String.valueOf(char_assginer));
            }
            else if(mini1.draw_declare){
                g1.setText("/");
            }
            
            

        }
        if(mini2.gameover && !g2.isVisible()){
            g2.setVisible(true);
            button_disabler(b2);
            game_over_font(g2);
            game_finished_list.add(2);
             if(mini2.win){
                main_hash[0][1] = char_assginer;
                g2.setText(String.valueOf(char_assginer));
            }
            else if(mini2.draw_declare){
                g2.setText("/");
            }

        }
        if(mini3.gameover && !g3.isVisible()){
            g3.setVisible(true);
            button_disabler(b3);
            game_over_font(g3);
            game_finished_list.add(3);
             if(mini3.win){
                main_hash[0][2] = char_assginer;
                g3.setText(String.valueOf(char_assginer));
            }
            else if(mini3.draw_declare){
                g3.setText("/");
            }

        }
        if(mini4.gameover && !g4.isVisible()){
            g4.setVisible(true);
            button_disabler(b4);
            game_over_font(g4);
            game_finished_list.add(4);
             if(mini4.win){
                main_hash[1][0] = char_assginer;
                g4.setText(String.valueOf(char_assginer));
            }
            else if(mini4.draw_declare){
                g4.setText("/");
            }

        }
        if(mini5.gameover && !g5.isVisible()){
            g5.setVisible(true);
            button_disabler(b5);
            game_over_font(g5);
            game_finished_list.add(5);
             if(mini5.win){
                main_hash[1][1] = char_assginer;
                g5.setText(String.valueOf(char_assginer));
            }
            else if(mini5.draw_declare){
                g5.setText("/");
            }

        }
        if(mini6.gameover && !g6.isVisible()){
            g6.setVisible(true);
            button_disabler(b6);
            game_over_font(g6);
            game_finished_list.add(6);
             if(mini6.win){
                main_hash[1][2] = char_assginer;
                g6.setText(String.valueOf(char_assginer));
            }
            else if(mini6.draw_declare){
                g6.setText("/");
            }

        }
        if(mini7.gameover && !g7.isVisible()){
            g7.setVisible(true);
            button_disabler(b7);
            game_over_font(g7);
            game_finished_list.add(7);
             if(mini7.win){
                main_hash[2][0] = char_assginer;
                g7.setText(String.valueOf(char_assginer));
            }
            else if(mini7.draw_declare){
                g7.setText("/");
            }

        }
        if(mini8.gameover && !g8.isVisible()){
            g8.setVisible(true);
            button_disabler(b8);
            game_over_font(g8);
            game_finished_list.add(8);
             if(mini8.win){
                main_hash[2][1] = char_assginer;
                g8.setText(String.valueOf(char_assginer));
            }
            else if(mini8.draw_declare){
                g8.setText("/");
            }

        }
        if(mini9.gameover && !g9.isVisible()){
            g9.setVisible(true);
            button_disabler(b9);
            game_over_font(g9);
            game_finished_list.add(9);
             if(mini9.win){
                main_hash[2][2] = char_assginer;
                g9.setText(String.valueOf(char_assginer));
            }
            else if(mini9.draw_declare){
                g9.setText("/");
            }

        }
            // main win check
            main_hash_obj.win_check(main_hash);


            if(main_hash_obj.gameover || (mini1.gameover && mini2.gameover && mini3.gameover && mini4.gameover && mini5.gameover && mini6.gameover && mini7.gameover && mini8.gameover && mini9.gameover)){
                game_end_layer.setVisible(true);
                message_layer.setVisible(true);
                array_printer(main_hash);
                System.out.println("main game over ");
                button_disabler(b1);
                button_disabler(b2);
                button_disabler(b3);
                button_disabler(b4);
                button_disabler(b5);
                button_disabler(b6);
                button_disabler(b7);
                button_disabler(b8);
                button_disabler(b9);
                if(main_hash_obj.win){
                    
                   
                    message_layer.setText(char_assginer + " "+"WON!");
                }
                else{
              
                    message_layer.setText("DRAW!!");
                }
            }

        
    
    
     //   array_printer(main_hash);
       //  System.out.println(mhn);
        
        turn_count++;  
        //System.out.println("list " + game_finished_list); 
       // System.out.println(mhn);
        dead_lock_check_and_remove(mhn);
        game_over_disable(g1, g2, g3, g4, g5, g6, g7, g8, g9);

                  
    }

    // array printer _____________________
    public void array_printer( char [][]a){
         for(int r=0 ; r<a.length;r++){
              for(int j = 0;j<a[r].length;j++){

                     System.out.print(a[r][j] + " ");       
                     
              }
                 System.out.println();
        }
    }

    public void game_over_font(JLabel ly){
        ly.setHorizontalAlignment(SwingConstants.CENTER);
        ly.setVerticalAlignment(SwingConstants.CENTER);
        ly.setFont(new Font("Arial",Font.BOLD,200));
        ly.setForeground(Color.WHITE);
    }
   // dead lock ---------------------------------------
    public void dead_lock_remov(){
     non_pressed_button_enabler(npb,0, b1);
     non_pressed_button_enabler(npb,1, b2);
     non_pressed_button_enabler(npb,2, b3);
     non_pressed_button_enabler(npb,3, b4);
     non_pressed_button_enabler(npb,4, b5);
     non_pressed_button_enabler(npb,5, b6);
     non_pressed_button_enabler(npb,6, b7);
     non_pressed_button_enabler(npb,7, b8);
     non_pressed_button_enabler(npb,8, b9);

        
    }

    // dead lock checker ---------------------------
    public void dead_lock_check_and_remove(int n){
        
            if(game_finished_list.contains(n)){
              //  System.err.println(" dead lock ditected ");
                    turn_layer_disabler_and_enable(false);
                    dead_lock_remov();
            }
        
    }
    public void fake_win(){
        main_hash[0][0]= 'X';
        main_hash[0][1]= 'X';
        main_hash[0][2]= 'X';
    }

    
}
