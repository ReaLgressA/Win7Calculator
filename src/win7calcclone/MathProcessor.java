package win7calcclone;

import java.util.ArrayList;

public class MathProcessor {

    public enum UnaryOperatorType {
        Undefined,
        Negate,
        Sqrt,
        Reciproc,
        Percent
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
    protected MathExpression lastExp;
    protected boolean arithmeticLock;//If arithmetic operation used recently - block it until user will do something else. (Also, let user change an arithmetic operator)
    protected boolean unaryLock;
    protected boolean errorState;
    protected double lastCalculated;
    protected NumberStorage numStorage;
    
    public MathProcessor() {
        expressions = new ArrayList<>();
        Clear();
    }

    public void SetStorage(NumberStorage numStorage) {
        this.numStorage = numStorage;
    }
    
    public int ExpressionsCount() {
        return expressions.size();
    }
    
    public final void Clear() { 
        expressions.clear();
        arithmeticLock = false;
        unaryLock = false;
        errorState = false;
        lastExp = null;
        lastCalculated = 0;
    }
    
    public boolean IsErrorOccured() {
        return errorState;
    }
    
    protected String ProcessUnaryOperation(double value, UnaryOperatorType type) {
        try {
            if (unaryLock) {
                MathExpression me = expressions.get(expressions.size() - 1);
                me.unaryOps.add(type);
                return NumberStorage.FormatNumber(me.GetValue());
            } 
            else /*if (arithmeticLock)*/ {
                expressions.add(new MathExpression(value, type));
                unaryLock = true;
                return NumberStorage.FormatNumber(expressions.get(expressions.size() - 1).GetValue());
            }/* else {
                MathExpression me = new MathExpression(value, type);
                return NumberStorage.FormatNumber(me.GetValue());
            }*/
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
        if(exp.binaryOp != BinaryOperatorType.Undefined) {
            lastExp = exp;
        }
        return exp;
    }
    
    protected void ProcArithmeticAction(double argument, BinaryOperatorType opType) {
        unaryLock = false;
        if(arithmeticLock) {
            expressions.get(expressions.size() - 1).binaryOp = opType;
        } else {
            if(!expressions.isEmpty()) {
                MathExpression me = expressions.get(expressions.size() - 1);
                if(me.binaryOp == BinaryOperatorType.Undefined) {
                    me.binaryOp = opType; 
                } else {
                    expressions.add(CreateExpression(argument, opType));
                }
            } else {
                expressions.add(CreateExpression(argument, opType));
            }
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
    public String Percent(double argument) {
        if(expressions.isEmpty()) {
            expressions.add(CreateExpression(lastCalculated * argument / 100.0, BinaryOperatorType.Undefined));
        } else {
            MathExpression ex = expressions.get(expressions.size() - 1);
            if(ex.binaryOp == BinaryOperatorType.Undefined) {
                ex.value = lastCalculated * argument / 100.0;
                lastCalculated = ex.value;
            } else {
                expressions.add(CreateExpression(lastCalculated * argument / 100.0, BinaryOperatorType.Undefined));
            }
        }
//        if(expressions.isEmpty()) {
//            expressions.add(CreateExpression(0, BinaryOperatorType.Undefined));
//        } else {
//            MathExpression ex = expressions.get(expressions.size() - 1);
//            if(ex.binaryOp == BinaryOperatorType.Undefined) {
//                ex.value *= argument / 100.0;
//            } else {
//                expressions.add(CreateExpression(ex.value * argument / 100.0, BinaryOperatorType.Undefined));
//            }
//        }
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
        if(arg1 == Double.POSITIVE_INFINITY || arg1 == Double.NEGATIVE_INFINITY) {
            throw new IllegalArgumentException("Overflow");
        }
        return arg1;
    }

    protected String Precalculate() {
        return Precalculate(false);
    }    
    protected String Precalculate(boolean finalCalculation) {
        double result = expressions.isEmpty() ? 0 : expressions.get(0).GetValue();
        if(expressions.get(0).binaryOp != BinaryOperatorType.Undefined) {
            lastCalculated = result;
        }
        for (int i = 1; i < expressions.size(); ++i) {
            try {
                result = ProcessBinaryExpression(result, expressions.get(i).GetValue(), expressions.get(i - 1).GetBinaryOperator());
                if(expressions.get(i).binaryOp != BinaryOperatorType.Undefined) {
                    lastCalculated = result;
                }
            } catch (IllegalArgumentException ex) {
                errorState = true;
                return ex.getMessage();
            }
        }
        if(!finalCalculation && !expressions.isEmpty()) {
            MathExpression ex = expressions.get(expressions.size() - 1);
            if(ex.binaryOp == BinaryOperatorType.Undefined) {
                result = ex.value;
            }
        }
        return NumberStorage.FormatNumber(result);
    }

    //Returns true if expressions list has any binary operator inside
    protected final boolean HasBinOperators(ArrayList<MathExpression> exp) {
        for(int i = 0; i < exp.size(); ++i) {
            if(exp.get(i).binaryOp != BinaryOperatorType.Undefined) {
                return true;
            }
        }
        return false;
    }
    
    public String Calculate(double displayValue) {
        if(!HasBinOperators(expressions)) {
            expressions.clear();
        }
        if(expressions.isEmpty()) {
            unaryLock = false;
            try {
                return lastExp == null 
                        ? NumberStorage.FormatNumber(displayValue)
                        : NumberStorage.FormatNumber(ProcessBinaryExpression(displayValue, lastExp.GetValue(), lastExp.GetBinaryOperator()));
            } catch (IllegalArgumentException ex) {
                errorState = true;
                return ex.getMessage();
            }
        }
        if(expressions.get(expressions.size() - 1).binaryOp != BinaryOperatorType.Undefined) {
            expressions.add(CreateExpression(displayValue, expressions.get(expressions.size() - 1).binaryOp));
        } else if (expressions.size() > 1) {
            MathExpression me = expressions.get(expressions.size() - 1);
            me.binaryOp = expressions.get(expressions.size() - 2).binaryOp;
            if(me.binaryOp != BinaryOperatorType.Undefined) {
                lastExp = me;
            }
        }
        String result = Precalculate(true);
        lastCalculated = Double.parseDouble(result);
        expressions.clear();
        unaryLock = false;
        if(result.compareTo("-0") == 0) {
            result = "0";
        }
        return result;
    }

    private static final int ExpressionCharLimit = 26;
    
    public String GetExpression() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expressions.size(); ++i) {
            sb.append(expressions.get(i).toString());
        }
        String s = sb.toString();
        int len = s.length();
        if(len > ExpressionCharLimit) {
            return "<<" + s.substring(len - ExpressionCharLimit + 2);
        }
        return sb.toString();
    }
}