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
    }
}
