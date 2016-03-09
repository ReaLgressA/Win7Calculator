package win7calcclone;

import java.util.ArrayList;

public class MathProcessor {

    public enum UnaryOperatorType {
        Undefined,
        Negate,
        Sqrt,
        Reciproc
    }

    public enum BinaryOperatorType {
        Undefined,
        Add,
        Subtract,
        Multiply,
        Divide//,
        //Percent
    }

    protected ArrayList<MathExpression> expressions;
    protected boolean arithmeticLock;//If arithmetic operation used recently - block it until user will do something else. (Also, let user change an arithmetic operator)
    protected boolean unaryLock;
    protected MathExpression lastExp;
    protected boolean errorState;
    
    public MathProcessor() {
        expressions = new ArrayList<>();
        Clear();
    }

    public void Clear() { 
        expressions.clear();
        arithmeticLock = false;
        unaryLock = false;
        errorState = false;
        lastExp = null;
    }
    
    public boolean IsErrorOccured() {
        return errorState;
    }
    
    protected String ProcessUnaryOperation(double value, UnaryOperatorType type) {
        try {
            if (unaryLock) {
                MathExpression me = expressions.get(expressions.size() - 1);
                me.unaryOps.add(type);
                return NumberStorage.NumberFormat.format(me.GetValue());
            } else if (arithmeticLock) {
                expressions.add(new MathExpression(value, type));
                unaryLock = true;
                return NumberStorage.NumberFormat.format(expressions.get(expressions.size() - 1).GetValue());
            } else {
                MathExpression me = new MathExpression(value, type);
                return NumberStorage.NumberFormat.format(me.GetValue());
            }
        } catch (IllegalArgumentException ex) {
            errorState = true;
            return ex.getMessage();
        }
    }
    
    public String Negate(double value) {
        return ProcessUnaryOperation(value, UnaryOperatorType.Negate);
    }

    public String Sqrt(double value) {
        return ProcessUnaryOperation(value, UnaryOperatorType.Sqrt);
    }

    // 1 / x
    public String Reciproc(double value) {
        return ProcessUnaryOperation(value, UnaryOperatorType.Reciproc);
    }

    public void UnlockArithmetic() {
        arithmeticLock = false;
    }
    
    protected MathExpression CreateExpression(double value, BinaryOperatorType opType) {
        MathExpression exp = new MathExpression();
        exp.SetValue(value);
        exp.SetBinaryOperator(opType);
        lastExp = exp;
        return exp;
    }
    
    protected void ProcArithmeticAction(double argument, BinaryOperatorType opType) {
        if(arithmeticLock) {
            expressions.get(expressions.size() - 1).binaryOp = opType;
        } else {
            expressions.add(CreateExpression(argument, opType));
            arithmeticLock = true;
        }
    }
    
    public String Add(double argument) {
        ProcArithmeticAction(argument, BinaryOperatorType.Add);
        return Precalculate();
    }

    public String Subtract(double argument) {
        ProcArithmeticAction(argument, BinaryOperatorType.Subtract);
        return Precalculate();
    }

    public String Multiply(double argument) {
        ProcArithmeticAction(argument, BinaryOperatorType.Multiply);
        return Precalculate();
    }

    public String Divide(double argument) {
        ProcArithmeticAction(argument, BinaryOperatorType.Divide);
        return Precalculate();
    }

    //%
    public String Percent() {
        return Precalculate();
    }

    protected double ProcessBinaryExpression(double arg1, double arg2, BinaryOperatorType binaryOp) {
        switch (binaryOp) {
            case Add:
                arg1 += arg2;
                break;
            case Subtract:
                arg1 -= arg2;
                break;
            case Multiply:
                arg1 *= arg2;
                break;
            case Divide:
                if(arg1 == 0 && arg2 == 0) {
                    throw new IllegalArgumentException("Result is undefined");
                }
                else if(arg2 == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                arg1 /= arg2;
                break;
        }
        return arg1;
    }

    protected String Precalculate() {
        double result = expressions.isEmpty() ? 0 : expressions.get(0).value;
        for (int i = 1; i < expressions.size(); ++i) {
            try {
                result = ProcessBinaryExpression(result, expressions.get(i).GetValue(), expressions.get(i - 1).GetBinaryOperator());
            } catch (IllegalArgumentException ex) {
                errorState = true;
                return ex.getMessage();
            }
        }
        return NumberStorage.NumberFormat.format(result);
    }

    public String Calculate(double displayValue) {
        if(expressions.isEmpty()) {
            return lastExp == null ? "0" : NumberStorage.NumberFormat.format(ProcessBinaryExpression(displayValue, lastExp.GetValue(), lastExp.GetBinaryOperator()));
        }
        expressions.add(new MathExpression(displayValue, expressions.get(expressions.size() - 1).binaryOp));
        String result = Precalculate();
        expressions.clear();
        return result;
    }

    public String GetExpression() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expressions.size(); ++i) {
            sb.append(expressions.get(i).toString());
        }
        return sb.toString();
    }
}