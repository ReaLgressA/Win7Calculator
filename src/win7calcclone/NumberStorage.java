package win7calcclone;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.DecimalFormat;

/*
Bugs:
Ввод числа, перемена знака - редактирование невозможно
Потеря точности при вводе чисел (Ввод дробного числа, перемена знака, продолжение редактирования)
5*5 reciproc рассинхрон с калькулятором
*/

public class NumberStorage implements ClipboardOwner {
    protected static final DecimalFormat NumberFormat = new DecimalFormat("################.################");//"0.###############"
    protected static final DecimalFormat ScientificNumberFormat = new DecimalFormat("0.############E0");
    protected static final char ZERO_SYMBOL = '0';
    protected static final int DISPLAY_CAPACITY = 15;
    protected double memory;
    protected StringBuilder display;
    protected boolean displaySet;
    protected MathProcessor mathProc;
    private Clipboard clipboard;
    public static String FormatNumber(double number) {
        if(number != 0 && (number > 999999999999999.0 || number < -999999999999999.0 || (number > -0.0000000000001 && number < 0.0000000000001))) {
            String s = ScientificNumberFormat.format(number);
            return s.equals("0E0") ? "0" : s;
        }
        return NumberFormat.format(number);
    }
    
    public NumberStorage(MathProcessor mathProc) {
        this.mathProc = mathProc;
        display = new StringBuilder(DISPLAY_CAPACITY);
        displaySet = false;
        MemoryClear();
        ClearEntry();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }
    
   
   public void lostOwnership(Clipboard aClipboard, Transferable aContents){
    /**
     * Empty implementation of the ClipboardOwner interface.
     */
   }
    
    public void RestoreNumberFromClipboard() {
        Transferable contents =  clipboard.getContents(null);
        boolean hasText = contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
        if(hasText) {
            try {
                String str = (String)contents.getTransferData(DataFlavor.stringFlavor);
                double num = Double.parseDouble(str);
                display.delete(0, display.length());
                display.append(FormatNumber(num));
            } catch(UnsupportedFlavorException | IOException | NumberFormatException | NullPointerException ex) {
                ex.printStackTrace();
                return;
            }
        }
    }
    
    public void StoreNumberInClipboard() {
        StringSelection ss = new StringSelection(display.toString());
        try {
            clipboard.setContents(ss, this);
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
            return;
        }
    }
    
    public boolean HasValueInMemory() {
        return memory != 0;
    }
    
    public void UnsetDisplay() {
        displaySet = false;
    }
    
    //The left arrow - clears only last entered symbol.
    //@return false if backspace failed because number was set by calculator recently
    public boolean Backspace() {
        if(!displaySet) {
            if(display.length() > 0) {
                display.deleteCharAt(display.length() - 1);
                if(display.toString().compareTo("-0") == 0) {
                    display.deleteCharAt(0);
                }
            }
            return true;
        }
        return false;
    }
    
    //CE - clears only the recent entry
    public final void ClearEntry() {
        display.delete(0, display.length());
    }
    
    //MC - clears the memory (sets it to zero)
    public final void MemoryClear() {
        memory = 0;
    }
    
    //MR recalls the memory (puts the number from memory into the display, so that you can add to it or whatever.
    public void MemoryRecall() {
        ClearEntry();
        if(HasValueInMemory()) {
            display.append(FormatNumber(memory));    
        }
    }
    
    //S stores the number on the display into memory.
    public void MemoryStore() {
        memory = GetNumber();
        ClearEntry();
        display.append(FormatNumber(memory));
    }
    
    //M+ adds the number on the display to the number in memory
    public void MemoryAdd() {
        memory += GetNumber();
    }
    
    //M subtracts the number on the display from the number in memory
    public void MemorySubtract() {
        memory -= GetNumber();
    }
    
    public String GetDisplayNumber() {
        if(display.length() == 0) {
            return "0";
        }
        return display.toString();
    }
    
    public double GetNumber() {
        return Double.parseDouble(GetDisplayNumber());
    }
    
    public void SetDisplay(String value) {
        ClearEntry();
        try {
            display.append(FormatNumber(Double.parseDouble(value)));
        } catch(NumberFormatException e) { //then it's an error message
            display.append(value);
        }
        displaySet = true;
    }
    
    public void AddSymbol(char symbol) {
        if(displaySet) {
            ClearEntry();
            if(!mathProc.expressions.isEmpty()) {
                int lastIdx = mathProc.expressions.size() - 1;
                MathExpression ex = mathProc.expressions.get(lastIdx);
                if(ex.binaryOp == MathProcessor.BinaryOperatorType.Undefined) {
                    mathProc.expressions.remove(lastIdx);
                }
            }
            displaySet = false;
        }
        if(display.length() == DISPLAY_CAPACITY) {
            return;
        }
        else if(symbol == '.') {
            AddPoint();
        } else if(Character.isDigit(symbol)) {
            if(display.length() == 1 && display.charAt(0) == ZERO_SYMBOL) {
                display.deleteCharAt(0);
            }
            display.append(symbol);
        }
    }
    
    protected boolean AddPoint() {
        if(display.toString().contains(".")) {
            return false;
        }
        if(display.length() == 0) {
            display.append(ZERO_SYMBOL);
        }
        display.append(".");
        return true;
    }
}