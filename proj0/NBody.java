public class NBody {
    public static double readRadius(String s){
        In in=new In(s);
        int N=in.readInt();
        double R=in.readDouble();
        return R;
    }

    public static Planet[] readPlanets(String s){
        In in=new In(s);
        int N=in.readInt();
        double R= in.readDouble();
        Planet[] ArrayPLanet=new Planet[N];
        for(int i=0;i<N;i+=1){
            double xxPos= in.readDouble();
            double yyPos= in.readDouble();
            double xxVel= in.readDouble();
            double yyVel= in.readDouble();
            double mass= in.readDouble();
            String img= in.readString();
            ArrayPLanet[i]=new Planet(xxPos,yyPos,xxVel,yyVel,mass,img);
        }
        return ArrayPLanet;
    }

    public static void main(String[] args){
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        filename="./data/"+filename;
        Planet[] p=readPlanets(filename);
        double R=readRadius(filename);
        StdDraw.setScale(-R,R);
        StdDraw.picture(0,0,"images/starfield.jpg",2*R,2*R);
        for(int i=0;i<p.length;i+=1){
            p[i].draw();
        }
        StdDraw.enableDoubleBuffering();
        double t=0;
        while(t<T){
            double[] xForces=new double[p.length];
            double[] yForces=new double[p.length];
            for(int i=0;i<p.length;i+=1){
                xForces[i]=p[i].calcNetForceExertedByX(p);
                yForces[i]=p[i].calcNetForceExertedByY(p);
            }
            for(int i=0;i< p.length;i+=1){
                p[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.picture(0,0,"images/starfield.jpg",2*R,2*R);
            for(int i=0;i<p.length;i+=1){
                p[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            t+=dt;
        }
        StdOut.printf("%d\n", p.length);
        StdOut.printf("%.2e\n", R);
        for (int i = 0; i < p.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    p[i].xxPos, p[i].yyPos, p[i].xxVel,
                    p[i].yyVel, p[i].mass, p[i].imgFileName);
        }
    }
}
