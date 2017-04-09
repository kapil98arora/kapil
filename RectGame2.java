//This will create a game operated by keyboard arrow keys and after compilation click on the display area before you start to play.
//javac RectGame2.java
//appletviewer RectGame2.java
//<applet code="RectGame2" width=800 height=600></applet>
import java.awt.*;
import java.util.*;
import java.applet.*;
import java.awt.event.*;
public class RectGame2 extends Applet implements KeyListener
{
Random ob;
boolean flag=true;

//here we have to define all the function to overwrite their defination.
//we have picked up the x and y coordinates of display area and passed to draw line.

int i=0,y=0,key=0,count=0;
int xb=0,yb=350;

public void init()
{ ob=new Random();
//as init method is called before  paint so intially ball will be generated
i=ob.nextInt(350);
//As we Are overwritting the KeyListener class method in our class 
//so "this" will tell the object of our class
addKeyListener(this);
}
public void keyTyped(KeyEvent ke)
{

}
public void keyPressed(KeyEvent ke)
{
//getKeyCode give the Ascii Code of the keyboard key
//37 -LEFT 38-UP 39-RIGHT 40-DOWN
key=ke.getKeyCode();
if(key==37)
{
xb=xb-5;
if(xb<=0)
xb=0;
}
else if(key==39)
{
xb=xb+5;
if(xb>=300)
xb=300;
}
}
public void keyReleased(KeyEvent ke)
{
}
public void paint(Graphics g)
{
//If flag is true ball will come down if ball touch in the range if our rect then it will move back as flag is set to false in that case.
if(flag)
y=y+1;
else
y=y-1;
g.setColor(Color.red);
g.fillRect(0,0,400,400);
g.setColor(Color.blue);
g.fillRect(xb,350,100,50);
g.setColor(Color.green);
g.fillArc(i+0,y+0,50,50,0,360);
if(i>=xb&i<=xb+100&y>=301)
{
flag=false;
count=count+1;
}

try
{
Thread.sleep(5);
}
catch(InterruptedException e)
{
System.out.println("Exception");
}
//Now ball will move back up and when it reach the top then we have to generate new ball and change flag so y++ start ball come down again
if(y<0)
{
y=0;
i=ob.nextInt(350);
flag=true;
}
//beside all this if ball do not fall in the range of rectangle then Game Over
if(y>350)
{

Font f1=new Font("Century",Font.BOLD,20);
g.setFont(f1);
g.setColor(Color.green);
g.drawString("Game_Over",200,200);
g.drawString("Score:- ",300,50);
g.drawString("("+count+" "+")",360,50);
count=0;
}
else
repaint();
}

}




