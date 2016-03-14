package win7calcclone;

import java.text.DecimalFormat;

public class NumberStorage {
    private static final DecimalFormat NumberFormat = new DecimalFormat("###############.###############");//"0.###############"
    private static final DecimalFormat ScientificNumberFormat = new DecimalFormat("0.############E0");
    protected static final char ZERO_SYMBOL = '0';
    protected static final int DISPLAY_CAPACITY = 16;
    protected double memory;
    protected StringBuilder display;
    protected boolean displaySet;
    
    public static String FormatNumber(double number) {
        if(number > 9999999999999999.0 || number < -9999999999999999.0 || (number > -0.00000000000001 && number < 0.00000000000001)) {
            return ScientificNumberFormat.format(number);
        }
        return NumberFormat.format(number);
    }
    
    public NumberStorage() {
        display = new StringBuilder(DISPLAY_CAPACITY);
        displaySet = false;
        MemoryClear();
        ClearEntry();
    }
    
    public boolean HasValueInMemory() {
        return memory != 0;
    }
    
    //The left arrow - clears only last entered symbol.
    //@return false if backspace failed because number was set by calculator recently
    public boolean Backspace() {
        if(!displaySet) {
            if(display.length() > 0) {
                display.deleteCharAt(display.length() - 1); 
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
            displaySet = false;
        }
        if(display.length() == DISPLAY_CAPACITY) {
            return;
        }
        else if(symbol == '.') {
            AddPoint();
        } else if(Character.isDigit(symbol)) {
            if(symbol == ZERO_SYMBOL && display.length() == 0) {
               return; //Only trailing zeros allowed 
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