package com.company.graphic;

abstract class Graphic {
    void draw(){}
}

class Os extends Graphic
{
    int x0;
    int y0;
    int x1;
    int y1;
    Os(int x0,int x1,int y0,int y1){ this.x0 = x0; this.x1 = x1; this.y0 = y0; this.y1 = y1;}
    @Override
    void draw(){System.out.printf("x0=%d x1=%d y0=%d y1=%d\n",x0,x1,y0,y1);}
}

class Net extends Graphic
{
    int scaleX;
    int scaleY;
    Net(int scaleX, int scaleY) {this.scaleX=scaleX; this.scaleY=scaleY;}
    @Override
    void draw(){System.out.printf("ScaleX=%d ScaleY=%d\n",scaleX,scaleY);}
}

class Curve extends Graphic
{
    int x;
    int y;
    Comments com;
    Curve(int x, String s){this.x=x; this.y=x*x; com = new Comments(s);}
    Curve(){x=0;y=0;}
    @Override
    void draw(){System.out.printf("Кривая c x=%d y=%d ", x,y); getCom();}
    void addCom(String a) {com.setCom(a);}
    void getCom() {com.printInf();}
}

class Comments extends Curve
{
    String comment="";
    Comments(String s){comment=s;}

    public void setCom(String a)
    {
        comment=a;
    }
    void printInf(){System.out.println(comment);}
}

public class Graph
{
    int x0;
    int x1;
    int y0;
    int y1;
    int scaleX;
    int scaleY;
    Os os;
    Net net;
    Curve curve;
    public Graph(int x0, int x1, int y0, int y1, int scaleX, int scaleY, String s)
    {
        this.x0=x0;
        this.x1=x1;
        this.y0=y0;
        this.y1=y1;
        this.scaleX=scaleX;
        this.scaleY=scaleY;
        os = new Os(x0,x1,y0,y1);
        net = new Net(scaleX,scaleY);
        curve = new Curve(x0,s);
    }

    public void drawPlosk(){ os.draw(); net.draw();}
    public void drawFunc(){ curve.draw();}
}