package win7calcclone;

public class Calc {
    private NumberStorage numStorage;
    private MathProcessor mathProc;
    
    public Calc() {
        mathProc = new MathProcessor();
        numStorage = new NumberStorage(mathProc);
        mathProc.SetStorage(numStorage);
        MainWindow w = new MainWindow(numStorage, mathProc);
        w.setVisible(true); 
    }
    
    public static void main(String[] args) {
        Calc calc = new Calc();
    }
}
