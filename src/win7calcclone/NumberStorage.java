package win7calcclone;

import java.text.DecimalFormat;

public class NumberStorage {
    private static final char ZERO_SYMBOL = '0';
    private static final int DISPLAY_CAPACITY = 16;
    private double memory;
    private StringBuilder display;
    private DecimalFormat dFormat;
    
    public NumberStorage() {
        display = new StringBuilder(DISPLAY_CAPACITY);
        dFormat = new DecimalFormat("0.####");
        MemoryClear();
        Clear();
    }
    
    public boolean HasValueInMemory() {
        return memory != 0;
    }
    
    //The left arrow - clears only last entered symbol
    public void Backspace() {
        display.deleteCharAt(display.length() - 1);
    }
    
    //C - clears everything
    public void Clear() {
        //TODO: clear expressions
        ClearEntry();
    }
    
    //CE - clears only the recent entry
    public void ClearEntry() {
        display.delete(0, display.length());
    }
    
    //MC - clears the memory (sets it to zero)
    public void MemoryClear() {
        memory = 0;
    }
    
    //MR recalls the memory (puts the number from memory into the display, so that you can add to it or whatever.
    public void MemoryRecall() {
        ClearEntry();
        if(HasValueInMemory()) {
            display.append(dFormat.format(memory));    
        }
    }
    
    //S stores the number on the display into memory.
    public void MemoryStore() {
        memory = Double.parseDouble(display.toString());
    }
    
    //M+ adds the number on the display to the number in memory
    public void MemoryAdd() {
        memory += Double.parseDouble(display.toString());
    }
    
    //M subtracts the number on the display from the number in memory
    public void MemorySubtract() {
        memory -= Double.parseDouble(display.toString());
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
    
    public void AddSymbol(char symbol) {
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
