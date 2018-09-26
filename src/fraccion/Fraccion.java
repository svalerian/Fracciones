package fraccion;
/*@Author
    Sergio Valerian
 */

public class Fraccion {
    private int num;
    private int den;

    public Fraccion(){
        num = 1;
        den = 1;
    }

    public Fraccion(int a){
        num = a;
        den = 1;
    }

    public Fraccion(int a, int b){
        if (denValido(b)) {
            num = a;
            den = b;
        }
    }

    public Fraccion(Fraccion f){
        num = f.getNum();
        den = f.getDen();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDen() {
        return den;
    }

    public void setDen(int den) {
        if (denValido(den)){
            this.den = den;
        }
    }

    public Fraccion suma(Fraccion f){
        int n = (this.getNum() * f.getDen()) + (f.getNum() * this.getDen());
        int d = (f.getDen() * this.getDen());

        return new Fraccion(n,d);
    }

    public Fraccion resta(Fraccion f){
        int n = (this.getNum() * f.getDen()) - (f.getNum() * this.getDen());
        int d = (f.getDen() * this.getDen());

        return new Fraccion(n,d);
    }

    public Fraccion multiplicar(Fraccion f){
        int n = (this.getNum() * f.getNum());
        int d = (f.getDen() * this.getDen());

        return new Fraccion(n,d);
    }

    public Fraccion division(Fraccion f){
        int n = (this.getNum() * f.getDen());
        int d = (this.getDen() * f.getNum());

        return new Fraccion(n,d);
    }

    @Override
    public String toString() {
        return "Fraccion{" +
                 + num +
                "/" + den +
                '}';
    }

    public double reducir(){
        double d = ((float) getNum()/this.getDen());
        return d;
    }

    public boolean es_irreducible(){
        return(this.mcd() != 1);
    }

    public boolean es_equivalente(Fraccion f){
        return ((double) num / (double) f.getNum() == (double) den / (double) f.getDen());
    }

    public void simplificar(){
        int n = this.mcd();
        num = num / n;
        den = den / n;
    }

    //Metodos privados
    private int mcd(){
        int n = Math.abs(num);
        int d = Math.abs(den);

        if (d == 0){
            return n;
        }

        int r;

        while (d!=0){
            r = n % d;
            n = d;
            d = r;
        }
        return n;
    }

    private boolean denValido(int d){
        return (d != 0);
    }
}
