/**
 * User: guoxc
 * Date: 15-6-8
 * Time: 17:22
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaA = (C - A) * (D - B);
        int areaB = (G - E) * (H - F);
        int jointW = 0;
        if(E <= A && C <= G){ // E -- A -- C -- G
            jointW = C - A;
        }else if(A <= E && G <= C){ // A -- E -- G -- C
            jointW = G - E;
        }else if(A <= E && E <= C && C <= G){ // A -- E -- C -- G
            jointW = C - E;
        }else if(E <= A && A <= G && G <= C){ // E -- A -- G -- C
            jointW = G - A;
        }
        int jointH = 0;
        if(F <= B && D <= H){ // F -- B -- D -- H
            jointH = D - B;
        }else if(B <= F && H <= D){ // B -- F -- H -- D
            jointH = H - F;
        }else if(B <= F && F <= D && D <= H){ // B -- F -- D -- H
            jointH = D - F;
        }else if(F <= B && B <= H && H <= D){ // F -- B -- H -- D
            jointH = H - B;
        }
        return areaA + areaB - (jointW * jointH);
    }
}
