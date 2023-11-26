import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panel extends JPanel implements MouseListener{
    
    int x;
    int y;
    boolean b = true;
    int[] slotState = new int[9];

    public Panel(){
        this.setPreferredSize(new Dimension(600, 600));
        this.addMouseListener(this);
    }

    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D)g;
        g2D.setStroke(new BasicStroke(5));
        g2D .drawLine(200, 50, 200, 550);
        g2D .drawLine(400, 50, 400, 550);
        g2D.drawLine(50, 200, 550, 200);
        g2D.drawLine(50, 400, 550, 400);
    }

    public void repaint(Graphics g, int x, int y, int w, int h){
        Graphics2D g2D = (Graphics2D)g;
        g2D.setStroke(new BasicStroke(10));
        if(b==true){
            g2D.setPaint(Color.BLUE);
            g2D.drawOval(x, y, w, h);
            b = false;
        }else{
            g2D.setPaint(Color.RED);
            g2D.drawLine(x, y, x+w, y+h);
            g2D.drawLine(x+w, y, x, y+h);
            b = true;
        }
    }

    public void repaint(Graphics g, int x, int y, int direction){
        Graphics2D g2D = (Graphics2D)g;
        g2D.setStroke(new BasicStroke(10));
        if(direction==0){
            g2D.drawLine(x, y, x+500, y);
        }else if(direction==1){
            g2D.drawLine(x, y, x, y+500);
        }else if(direction==2){
            g2D.drawLine(x, y, x+500, y+500);
        }else{
            g2D.drawLine(x, y, x-500, y+500);
        }
    }

    public void mouseClicked(MouseEvent e){
        x = e.getX();
        y = e.getY();
        
        if(x>50 && x<200 && y>50 && y<200){
            if(slotState[0]==0){
                repaint(getGraphics(), 75, 75, 100, 100);
                if(b==false){
                    slotState[0] = 1;
                }else{
                    slotState[0] = 2;
                }
            } 
        }else if(x>200 && x<400 && y>50 && y<200){
            if(slotState[1]==0){
                repaint(getGraphics(), 250, 75,100, 100);
                if(b==false){
                    slotState[1] = 1;
                }else{
                    slotState[1] = 2;
                }
            }
        }else if(x>400 && x<550 && y>50 && y<200){
            if(slotState[2]==0){
                repaint(getGraphics(), 425, 75, 100, 100);
                if(b==false){
                    slotState[2] = 1;
                }else{
                    slotState[2] = 2;
                }
            }
        }else if(x>50 && x<200 && y>200 && y<400){
            if(slotState[3]==0){
                repaint(getGraphics(), 75, 250, 100, 100);
                if(b==false){
                    slotState[3] = 1;
                }else{
                    slotState[3] = 2;
                }
            }
        }else if(x>200 && x<400 && y>200 && y<400){
            if(slotState[4]==0){
                repaint(getGraphics(), 250, 250, 100, 100);
                if(b==false){
                    slotState[4] = 1;
                }else{
                    slotState[4] = 2;
                }
            }
        }else if(x>400 && x<550 && y>200 && y<400){
            if(slotState[5]==0){
                repaint(getGraphics(), 425, 250, 100, 100);
                if(b==false){
                    slotState[5] = 1;
                }else{
                    slotState[5] = 2;
                }
            }
        }else if(x>50 && x<200 && y>400 && y<550){
            if(slotState[6]==0){
                repaint(getGraphics(), 75, 425, 100, 100);
                if(b==false){
                    slotState[6] = 1;
                }else{
                    slotState[6] = 2;
                }
            }
        }else if(x>200 && x<400 && y>400 && y<550){
            if(slotState[7]==0){
                repaint(getGraphics(), 250, 425, 100, 100);
                if(b==false){
                    slotState[7] = 1;
                }else{
                    slotState[7] = 2;
                }
            }
        }else if(x>400 && x<550 && y>400 && y<550){
            if(slotState[8]==0){
                repaint(getGraphics(), 425, 425, 100, 100);
                if(b==false){
                    slotState[8] = 1;
                }else{
                    slotState[8] = 2;
                }
            }
        }

        //Win Check
        if(slotState[0]==slotState[1] && slotState[1]==slotState[2] && slotState[0]!=0){
            repaint(getGraphics(), 50, 125, 0);
            TicTacToe.restartFrame.setVisible(true);
            if(slotState[0]==1){
                TicTacToe.winnerLabel.setForeground(Color.BLUE);
                TicTacToe.winnerLabel.setText("Blue Wins!");
            }else{
                TicTacToe.winnerLabel.setForeground(Color.RED);
                TicTacToe.winnerLabel.setText("Red Wins!");
            }
        }else if(slotState[3]==slotState[4] && slotState[4]==slotState[5] && slotState[3]!=0){
            repaint(getGraphics(), 50, 300, 0);
            TicTacToe.restartFrame.setVisible(true);
            if(slotState[3]==1){
                TicTacToe.winnerLabel.setForeground(Color.BLUE);
                TicTacToe.winnerLabel.setText("Blue Wins!");
            }else{
                TicTacToe.winnerLabel.setForeground(Color.RED);
                TicTacToe.winnerLabel.setText("Red Wins!");
            }
        }else if(slotState[6]==slotState[7] && slotState[7]==slotState[8] && slotState[6]!=0){
            repaint(getGraphics(), 50, 475, 0);
            TicTacToe.restartFrame.setVisible(true);
            if(slotState[6]==1){
                TicTacToe.winnerLabel.setForeground(Color.BLUE);
                TicTacToe.winnerLabel.setText("Blue Wins!");
            }else{
                TicTacToe.winnerLabel.setForeground(Color.RED);
                TicTacToe.winnerLabel.setText("Red Wins!");
            }
        }else if(slotState[0]==slotState[3] && slotState[3]==slotState[6] && slotState[0]!=0){
            repaint(getGraphics(), 125, 50, 1);
            TicTacToe.restartFrame.setVisible(true);
            if(slotState[0]==1){
                TicTacToe.winnerLabel.setForeground(Color.BLUE);
                TicTacToe.winnerLabel.setText("Blue Wins!");
            }else{
                TicTacToe.winnerLabel.setForeground(Color.RED);
                TicTacToe.winnerLabel.setText("Red Wins!");
            }
        }else if(slotState[1]==slotState[4] && slotState[4]==slotState[7] && slotState[1]!=0){
            repaint(getGraphics(), 300, 50, 1);
            TicTacToe.restartFrame.setVisible(true);
            if(slotState[1]==1){
                TicTacToe.winnerLabel.setForeground(Color.BLUE);
                TicTacToe.winnerLabel.setText("Blue Wins!");
            }else{
                TicTacToe.winnerLabel.setForeground(Color.RED);
                TicTacToe.winnerLabel.setText("Red Wins!");
            }
        }else if(slotState[2]==slotState[5] && slotState[5]==slotState[8] && slotState[2]!=0){
            repaint(getGraphics(), 475, 50, 1);
            TicTacToe.restartFrame.setVisible(true);
            if(slotState[2]==1){
                TicTacToe.winnerLabel.setForeground(Color.BLUE);
                TicTacToe.winnerLabel.setText("Blue Wins!");
            }else{
                TicTacToe.winnerLabel.setForeground(Color.RED);
                TicTacToe.winnerLabel.setText("Red Wins!");
            }
        }else if(slotState[0]==slotState[4] && slotState[4]==slotState[8] && slotState[0]!=0){
            repaint(getGraphics(), 50, 50, 2);
            TicTacToe.restartFrame.setVisible(true);
            if(slotState[0]==1){
                TicTacToe.winnerLabel.setForeground(Color.BLUE);
                TicTacToe.winnerLabel.setText("Blue Wins!");
            }else{
                TicTacToe.winnerLabel.setForeground(Color.RED);
                TicTacToe.winnerLabel.setText("Red Wins!");
            }
        }else if(slotState[2]==slotState[4] && slotState[4]==slotState[6] && slotState[2]!=0){
            repaint(getGraphics(), 550, 50, 3);
            TicTacToe.restartFrame.setVisible(true);
            if(slotState[2]==1){
                TicTacToe.winnerLabel.setForeground(Color.BLUE);
                TicTacToe.winnerLabel.setText("Blue Wins!");
            }else{
                TicTacToe.winnerLabel.setForeground(Color.RED);
                TicTacToe.winnerLabel.setText("Red Wins!");
            }
        }

    }

    public void mousePressed(MouseEvent e){
    }

    public void mouseReleased(MouseEvent e){
    }

    public void mouseEntered(MouseEvent e){
    }

    public void mouseExited(MouseEvent e){
    }

    
    

}
