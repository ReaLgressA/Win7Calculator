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

    public MathExpression(double value, MathProcessor.UnaryOperatorType unaryOp) {
        this.value = value;
        this.unaryOps = new ArrayList<>(1);
        unaryOps.add(unaryOp);
        this.binaryOp = MathProcessor.BinaryOperatorType.Undefined;
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
        for (int i = 0; i < unaryOps.size(); ++i) {
            MathProcessor.UnaryOperatorType op = unaryOps.get(i);
            switch (op) {
                case Negate:
                    result = -result;
                    break;
                case Reciproc:
                    if (result == 0) {
                        throw new IllegalArgumentException("Cannot divide by zero");
                    }
                    result = 1 / result;
                    break;
                case Sqrt:
                    if (result < 0) {
                        throw new IllegalArgumentException("Invalid input");
                    }
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
        switch (binaryOp) {
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
        sb.append(" ");
        return sb.toString();
    }

    protected void BuildUnaryExpression(int idx, StringBuilder sb) {
        if (idx >= unaryOps.size()) {
            sb.append(NumberStorage.FormatNumber(value));
            return;
        }
        MathProcessor.UnaryOperatorType op = unaryOps.get(idx);
//        if(op != MathProcessor.UnaryOperatorType.Percent) {
            sb.append(op.toString());
            sb.append("(");
//        }
        BuildUnaryExpression(idx + 1, sb);
//        if(op != MathProcessor.UnaryOperatorType.Percent) {
            sb.append(")");
//        }
    }
}
