import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JPanel{
    int BoardWidth=600;
    int BoardHeight=550;
     
    JFrame frame=new JFrame("TicTacToe");
    JLabel label=new JLabel();
    JPanel panel=new JPanel();
    JPanel tpanel=new JPanel();
    JPanel jpanel=new JPanel();
    
    JButton[][] JB=new JButton[3][3];
    String PlayerX="x";
    String PlayerO="O";
    String currentPlayer=PlayerX;
    boolean gameover=false;

    TicTacToe(){
       frame.setVisible(true);
       frame.setSize(BoardWidth,BoardHeight);
       frame.setLocationRelativeTo(null);
       frame.setResizable(false);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setLayout(new BorderLayout());
       
       label.setBackground(Color.BLACK);
       label.setForeground(Color.WHITE);
       label.setFont(new Font("Arial",Font.BOLD,45));
       label.setHorizontalAlignment(JLabel.CENTER);
       label.setText("Tic-Tac-Toe");
       label.setOpaque(true);

       panel.setLayout(new BorderLayout());
       panel.add(label);
       frame.add(panel,BorderLayout.NORTH);
       
       JButton RB=new JButton("Reset");
       RB.setBackground(Color.green);
       RB.setFont(new Font("Arial",Font.BOLD,45));
       RB.setFocusable(false);
       RB.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
            resetGame();
        }
       });
       jpanel.add(RB,BorderLayout.SOUTH);
       frame.add(jpanel,BorderLayout.SOUTH);

       tpanel.setLayout(new GridLayout(3,3));
       tpanel.setBackground(Color.black);
       frame.add(tpanel);

       for(int r=0;r<3;r++){
        for(int c=0;c<3;c++){
            JButton tile=new JButton();
            JB[r][c] = tile;
            tpanel.add(tile);
            tile.setBackground(Color.BLACK);
            tile.setForeground(Color.WHITE);
            tile.setFont(new Font("Arial",Font.BOLD,45));
            tile.setFocusable(false);

            tile.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                   if(gameover)
                   {
                   return;
                   }
                   JButton tile=(JButton)e.getSource();
                   if(tile.getText()==""){
                   tile.setText(currentPlayer);
                   checkWinner();
                   if(!gameover){
                   currentPlayer=currentPlayer == PlayerX ? PlayerO : PlayerX;
                   label.setText(currentPlayer+"'s turn");
                }}}
            });
        }
       } 
       
    }
    void checkWinner()
    {
        //vertical
        for(int r=0;r<3;r++)
         {

            if(JB[r][0].getText()=="")
            continue;
                if(JB[r][0].getText()==JB[r][1].getText()&&
                JB[r][1].getText()==JB[r][2].getText())
                 {
                  for(int i=0;i<3;i++)
                  {
                    setWinner(JB[r][i]);
                  }
                  gameover=true;
                  return;  
                 }
        }
                //horizontal
                for(int c=0;c<3;c++)
                {
       
                   if(JB[0][c].getText()=="")
                       continue;
                       if(JB[0][c].getText()==JB[1][c].getText()&&
                       JB[1][c].getText()==JB[2][c].getText())
                       {
                         for(int i=0;i<3;i++)
                         {
                           setWinner(JB[i][c]);
                         }
                         gameover=true;
                        return;  
                       }
                }
             //diaganolly
                 if(JB[0][0].getText()==JB[1][1].getText()&&
                    JB[1][1].getText()==JB[2][2].getText()&&
                    JB[0][0].getText()!="")
                 {
                   for(int i=0;i<3;i++)
                   {
                    setWinner(JB[i][i]);
                   }
                gameover=true;
                return;  
                 }
            //anti diaganolly
                 if(JB[0][2].getText()==JB[1][1].getText()&&
                 JB[1][1].getText()==JB[2][0].getText()&&
                 JB[0][2].getText()!="")
                 {
                 
                 setWinner(JB[0][2]);
                 setWinner(JB[1][1]);
                 setWinner(JB[2][0]);
                gameover=true;
                return;  
                 }
      boolean draw = true;
      for (int r = 0; r < 3; r++) {
        for (int c = 0; c < 3; c++) {
            if (JB[r][c].getText().equals("")) {
                draw = false;
                break;
            }
        }
    }

    if (draw) {
    
        label.setText("It's a draw!");
        gameover = true;
    }
               
    }
    
    void setWinner(JButton tile)
         {
            tile.setBackground(Color.darkGray);
            tile.setForeground(Color.green);
            label.setText(currentPlayer+"'s winner");
           
         }
    void resetGame()
    {
        gameover=false;
        currentPlayer=PlayerX;
        label.setText("TicTacToe");
        for(int r=0;r<3;r++)
        {
            for(int c=0;c<3;c++){
                JB[r][c].setText("");
                JB[r][c].setBackground(Color.black);
                JB[r][c].setForeground(Color.white);
            }
        }
    }
}