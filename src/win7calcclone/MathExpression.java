package win7calcclone;
import java.util.ArrayList;

public class MathExpression {
    protected double value;
    protected ArrayList<MathProcessor.UnaryOperatorType> unaryOps;
    protected MathProcessor.BinaryOperatorType binaryOp;
    
    public MathExpression() {
        this(0, MathProcessor.BinaryOperatorType.Undefined);
    }
    public MathExpression(double value, MathProcessor.BinaryOperatorType binaryOp) {
        this.value = value;
        this.unaryOps = new ArrayList<>();
        this.binaryOp = binaryOp;
    }
    
    public void SetValue(double value) {
        this.value = value;
    }
    
    public void AddUnaryOperator(MathProcessor.UnaryOperatorType op) {
        unaryOps.add(op);
    }
    
    public void SetBinaryOperator(MathProcessor.BinaryOperatorType op) {
        binaryOp = op;
    }
    
    public MathProcessor.BinaryOperatorType GetBinaryOperator() {
        return binaryOp;
    }
    
    public double GetValue() {
        double result = value;
        for(int i = 0; i < unaryOps.size(); ++i) {
            MathProcessor.UnaryOperatorType op = unaryOps.get(i);
            switch(op) {
                case Negate:
                    result = -result;
                    break;
                case Reciproc:
                    result = 1 / result;
                    break;
                case Sqrt:
                    result = Math.sqrt(result);
                    break;
            }
        }
        return result;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        BuildUnaryExpression(0, sb);
        if(binaryOp != MathProcessor.BinaryOperatorType.Undefined) {
            switch(binaryOp) {
                case Add:
                    sb.append(" +");
                    break;
                case Subtract:
                    sb.append(" -");
                    break;
                case Multiply:
                    sb.append(" *");
                    break;
                case Divide:
                    sb.append(" /");
                    break;
            }
        }
        sb.append(" ");
        return sb.toString();
    }
    
    protected void BuildUnaryExpression(int idx, StringBuilder sb) {
        if(idx >= unaryOps.size()) {
            sb.append(NumberStorage.NumberFormat.format(value));
            return;
        }
        MathProcessor.UnaryOperatorType op = unaryOps.get(idx);
        sb.append(op.toString());
        sb.append("(");
        BuildUnaryExpression(idx + 1, sb);
        sb.append(")");
    }
}
