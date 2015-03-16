import java.util.*;

/**
 * Created by Administrator on 2015/3/16.
 */
class Rational{
    int a;
    int b;
    boolean isInfi = false;
    public Rational(int a0, int b0){
        if(a0 == 0){
            a = 0;
            b = 1;
            return;
        }else if(b0 == 0){
            a = a0;
            isInfi = true;
            return;
        }
        if(b0 < 0){
            a0 = -a0;
            b0 = -b0;
        }
        int g = gcd(Math.abs(a0), b0);
        this.a = a0 / g;
        this.b = b0 / g;
    }
    public Rational(){
        a = 0;
        b = 1;
    }
    private int gcd(int x, int y){
        if(y == 1) return 1;
        if(x < y){
            int t = y;
            y = x;
            x = t;
        }
        while( y != 0){
            int t = y;
            y = x % y;
            x = t;
        }
        return x;
    }
    @Override
    public boolean equals(Object y){
        Rational yr = (Rational) y;
        if(this.isInfi && yr.isInfi) return true;
        if(this.a == 0 && yr.a == 0) return true;
        return this.a == yr.a && this.b == yr.b;
    }
    public Rational multiply(int x){
        if(x == 0){
            return new Rational();
        }
        return new Rational(x * a, b);

    }
    public Rational add(int x){
        return new Rational(x*b + a, b);
    }
    public Rational add(Rational x){
        int newa = a * x.b + x.a * b;
        int newb = b * x.b;
        return new Rational(newa, newb);
    }

    @Override
    public int hashCode() {
        return a * 33 + b;
    }
}
class Line{
    Rational k;
    Rational b;
    public Line(Point a0, Point b0){
        if(a0.x == b0.x){
            k = new Rational(1,1);
            k.isInfi = true;
            b = new Rational(a0.x,1);
            return;
        }
        k = new Rational(a0.y - b0.y, a0.x - b0.x);
        b = k.multiply(a0.x).add(-a0.y);
        b.a = -b.a;
    }
    public boolean inLine(Point x){
        if(k.isInfi){
            return x.x == b.a;
        }
        return k.multiply(x.x).add(b).a == x.y;
    }

    @Override
    public boolean equals(Object y){
        Line yl = (Line) y;
        return k.equals(yl.k) && b.equals(yl.b);
    }

    @Override
    public int hashCode() {
        return k.hashCode() * 33 + b.hashCode();
    }
}
public class MaxPointsOnALine {

    public int maxPoints(Point[] points){
        HashMap<Line, Integer> m = new HashMap<Line, Integer>();
        int n = points.length;
        if(n <= 2) return n;
        ArrayList<Point> duplicates = new ArrayList<Point>();
        boolean[] dup = new boolean[n];
        for(int i = 0; i < n - 1; i += 1){
            if(dup[i]) continue;
            for(int j = i + 1; j < n; j += 1){
                if(points[i].x == points[j].x && points[i].y == points[j].y){
                    duplicates.add(points[j]);
                    dup[j] = true;
                }
            }
        }
        for(int i = 0; i < n - 1; i += 1){
            if(dup[i]) continue;
            for(int j = i + 1; j < n; j += 1){
                if(dup[j]) continue;
                Line l = new Line(points[i], points[j]);
                if(m.containsKey(l)){
                    continue;
                }else {
                    int c = 2;
                    for(int k = j + 1; k < n; k += 1){
                        if(dup[k]) continue;
                        Line l2 = new Line(points[i], points[k]);
                        if(l2.equals(l)){
                            c += 1;
                        }
                    }
                    m.put(l, c);
                }
            }
        }
        for(Point x: duplicates){
            for(Line l : m.keySet()){
                if(l.inLine(x)){
                    m.put(l, m.get(l) + 1);
                }
            }
        }

        int max_l = 0;
        if(m.size() == 0){
            return n;
        }
        for(Line l : m.keySet()){
            if(m.get(l) > max_l){
                max_l = m.get(l);
            }
        }
        return max_l;
    }
    public static void test(){
        Point a1 = new Point(0,-12);
        Point a2 = new Point(5,2);
        Point a3 = new Point(2,5);
        Point a4 = new Point(0,-5);
        Point a5 = new Point(1,5);
        Point a6 = new Point(2,-2);
        Point a7 = new Point(5,-4);
        Point a8 = new Point(3,4);
        Point a9 = new Point(-2,4);
        Point a10 = new Point(-1,4);
        Point a11 = new Point(0,-5);
        Point a12 = new Point(0,-8);
        Point a13 = new Point(-2,-1);
        Point a14 = new Point(0,-11);
        Point a15 = new Point(0,-9);
        MaxPointsOnALine m = new MaxPointsOnALine();
        System.out.println(m.maxPoints(new Point[]{a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15}));
    }
}
