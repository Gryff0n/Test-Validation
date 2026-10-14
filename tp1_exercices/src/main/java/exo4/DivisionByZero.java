package exo4;

class DivisionByZero{
    public static void main(String[] args){
        if(args.length == 0) throw new ArithmeticException("nb arguments null");
        int i = 10/args.length;
        System.out.println("i = " + i);
    }
}
