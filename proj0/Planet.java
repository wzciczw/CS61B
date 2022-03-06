import java.security.PublicKey;
import java.math.*;

public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    static double G=6.67e-11;

    public Planet(double xP,double yP, double xV,
                  double yV,double m, String img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    }

    public Planet(Planet p){
        xxPos=p.xxPos;
        yyPos=p.yyPos;
        xxVel=p.xxVel;
        yyVel=p.yyVel;
        mass=p.mass;
        imgFileName= p.imgFileName;
    }

    public double calcDistance(Planet p){
        double r;
        double dx=xxPos-p.xxPos;
        double dy=yyPos-p.yyPos;
        r=Math.sqrt(dx*dx+dy*dy);
        return r;
    }

    public double calcForceExertedBy(Planet p){
        return G*mass*p.mass/(calcDistance(p)*calcDistance(p));
    }

    public double calcForceExertedByX(Planet p){
        return calcForceExertedBy(p)*(p.xxPos-xxPos)/calcDistance(p);
    }

    public double calcForceExertedByY(Planet p){
        return calcForceExertedBy(p)*(p.yyPos-yyPos)/calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] p){
        int count=0;
        double netforceexertedbyx=0;
        while(count<p.length){
            if(this.equals(p[count])!=true){
                netforceexertedbyx+=calcForceExertedByX(p[count]);
            }
            count+=1;
        }
        return netforceexertedbyx;
    }

    public double calcNetForceExertedByY(Planet[] p){
        int count=0;
        double netforceexertedbyy=0;
        while(count<p.length){
            if(this.equals(p[count])!=true){
                netforceexertedbyy+=calcForceExertedByY(p[count]);
            }
            count+=1;
        }
        return netforceexertedbyy;
    }

    public void update(double dt,double fx,double fy){
        double ax=fx/mass;
        double ay=fy/mass;
        xxVel+=ax*dt;
        yyVel+=ay*dt;
        xxPos+=xxVel*dt;
        yyPos+=yyVel*dt;
    }

    public void draw(){
        StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
    }
}
