/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package win7calcclone;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.KeyStroke;

/**
 *
 * @author ReaLgressA
 */
public class MainWindow extends javax.swing.JFrame {
    private NumberStorage numStorage;
    private MathProcessor mathProc;
    
    public MainWindow(NumberStorage numStorage, MathProcessor mathProc) {
        this.numStorage = numStorage;
        this.mathProc = mathProc;
        initComponents();
        getContentPane().setBackground(getBackground());
        UpdateDisplay();
        InitHotkeys();
    }
    
    public final void UpdateDisplay() {
        UpdateDisplay(true);
    }
    
    public final void UpdateDisplay(boolean unlockArithmetic) {
        if(unlockArithmetic) {
            mathProc.UnlockArithmetic();
        }
        String displayNumber = numStorage.GetDisplayNumber();
        if(displayNumber.length() > 12) {
            jLabelNumber.setFont(new Font("Serif", Font.PLAIN, 18));
        } else {
            jLabelNumber.setFont(new Font("Serif", Font.PLAIN, 22));
        }
        jLabelNumber.setText(displayNumber);
        jLabelMemory.setText(numStorage.HasValueInMemory() ? "M" : "");
        jLabelExpression.setText(mathProc.GetExpression());
        ErrorCheck();
    }
    
    private void InitHotkeys() {
        InputMap inputMap = jButtonNum1.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW);
        KeyStroke key_1 = KeyStroke.getKeyStroke(KeyEvent.VK_1, 0);//1 -> shift, 2 -> control
        inputMap.put(key_1, "Num1");
        KeyStroke num_key_1 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, 0);//1 -> shift, 2 -> control
        inputMap.put(num_key_1, "Num1");
        jButtonNum1.getActionMap().put("Num1", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jButtonNum1ActionPerformed(ae);
            }
        });
        inputMap = jButtonNum2.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW);
        KeyStroke key_2 = KeyStroke.getKeyStroke(KeyEvent.VK_2, 0);//1 -> shift, 2 -> control
        inputMap.put(key_2, "Num2");
        KeyStroke num_key_2 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0);//1 -> shift, 2 -> control
        inputMap.put(num_key_2, "Num2");
        jButtonNum2.getActionMap().put("Num2", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jButtonNum2ActionPerformed(ae);
            }
        });
        inputMap = jButtonNum3.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW);
        KeyStroke key_3 = KeyStroke.getKeyStroke(KeyEvent.VK_3, 0);//1 -> shift, 2 -> control
        inputMap.put(key_3, "Num3");
        KeyStroke num_key_3 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, 0);//1 -> shift, 2 -> control
        inputMap.put(num_key_3, "Num3");
        jButtonNum3.getActionMap().put("Num3", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jButtonNum3ActionPerformed(ae);
            }
        });
        inputMap = jButtonNum4.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW);
        KeyStroke key_4 = KeyStroke.getKeyStroke(KeyEvent.VK_4, 0);//1 -> shift, 2 -> control
        inputMap.put(key_4, "Num4");
        KeyStroke num_key_4 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD4, 0);//1 -> shift, 2 -> control
        inputMap.put(num_key_4, "Num4");
        jButtonNum4.getActionMap().put("Num4", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jButtonNum4ActionPerformed(ae);
            }
        });
        inputMap = jButtonNum5.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW);
        KeyStroke key_5 = KeyStroke.getKeyStroke(KeyEvent.VK_5, 0);//1 -> shift, 2 -> control
        inputMap.put(key_5, "Num5");
        KeyStroke num_key_5 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, 0);//1 -> shift, 2 -> control
        inputMap.put(num_key_5, "Num5");
        jButtonNum5.getActionMap().put("Num5", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jButtonNum5ActionPerformed(ae);
            }
        });
        inputMap = jButtonNum6.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW);
        KeyStroke key_6 = KeyStroke.getKeyStroke(KeyEvent.VK_6, 0);//1 -> shift, 2 -> control
        inputMap.put(key_6, "Num6");
        KeyStroke num_key_6 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD6, 0);//1 -> shift, 2 -> control
        inputMap.put(num_key_6, "Num6");
        jButtonNum6.getActionMap().put("Num6", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jButtonNum6ActionPerformed(ae);
            }
        });
        inputMap = jButtonNum7.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW);
        KeyStroke key_7 = KeyStroke.getKeyStroke(KeyEvent.VK_7, 0);//1 -> shift, 2 -> control
        inputMap.put(key_7, "Num7");
        KeyStroke num_key_7 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7, 0);//1 -> shift, 2 -> control
        inputMap.put(num_key_7, "Num7");
        jButtonNum7.getActionMap().put("Num7", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jButtonNum7ActionPerformed(ae);
            }
        });
        inputMap = jButtonNum8.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW);
        KeyStroke key_8 = KeyStroke.getKeyStroke(KeyEvent.VK_8, 0);//1 -> shift, 2 -> control
        inputMap.put(key_8, "Num8");
        KeyStroke num_key_8 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0);//1 -> shift, 2 -> control
        inputMap.put(num_key_8, "Num8");
        jButtonNum8.getActionMap().put("Num8", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jButtonNum8ActionPerformed(ae);
            }
        });
        inputMap = jButtonNum9.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW);
        KeyStroke key_9 = KeyStroke.getKeyStroke(KeyEvent.VK_9, 0);//1 -> shift, 2 -> control
        inputMap.put(key_9, "Num9");
        KeyStroke num_key_9 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD9, 0);//1 -> shift, 2 -> control
        inputMap.put(num_key_9, "Num9");
        jButtonNum9.getActionMap().put("Num9", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jButtonNum9ActionPerformed(ae);
            }
        });
        inputMap = jButtonNum0.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW);
        KeyStroke key_0 = KeyStroke.getKeyStroke(KeyEvent.VK_0, 0);//1 -> shift, 2 -> control
        inputMap.put(key_0, "Num0");
        KeyStroke num_key_0 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0, 0);//1 -> shift, 2 -> control
        inputMap.put(num_key_0, "Num0");
        jButtonNum0.getActionMap().put("Num0", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jButtonNum0ActionPerformed(ae);
            }
        });
        inputMap = jButtonPoint.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW);
        KeyStroke num_key_point = KeyStroke.getKeyStroke(KeyEvent.VK_DECIMAL, 0);//1 -> shift, 2 -> control
        inputMap.put(num_key_point, "Point");
        KeyStroke key_point = KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD, 0);//1 -> shift, 2 -> control
        inputMap.put(key_point, "Point");
        jButtonPoint.getActionMap().put("Point", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jButtonPointActionPerformed(ae);
            }
        });
        inputMap = jButtonPlus.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW);
        KeyStroke key_plus = KeyStroke.getKeyStroke(KeyEvent.VK_ADD, 0);//1 -> shift, 2 -> control
        inputMap.put(key_plus, "Plus");
        jButtonPlus.getActionMap().put("Plus", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jButtonPlusActionPerformed(ae);
            }
        });
        inputMap = jButtonMinus.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW);
        KeyStroke key_minus = KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, 0);//1 -> shift, 2 -> control
        inputMap.put(key_minus, "Minus");
        jButtonMinus.getActionMap().put("Minus", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jButtonMinusActionPerformed(ae);
            }
        });
        inputMap = jButtonDivision.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW);
        KeyStroke key_divide = KeyStroke.getKeyStroke(KeyEvent.VK_DIVIDE, 0);//1 -> shift, 2 -> control
        inputMap.put(key_divide, "Divide");
        jButtonDivision.getActionMap().put("Divide", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jButtonDivisionActionPerformed(ae);
            }
        });
        inputMap = jButtonMultiplication.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW);
        KeyStroke key_multiply = KeyStroke.getKeyStroke(KeyEvent.VK_MULTIPLY, 0);//1 -> shift, 2 -> control
        inputMap.put(key_multiply, "Multiply");
        jButtonMultiplication.getActionMap().put("Multiply", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jButtonMultiplicationActionPerformed(ae);
            }
        });
        inputMap = jButtonCalculate.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW);
        KeyStroke key_enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);//1 -> shift, 2 -> control
        inputMap.put(key_enter, "Enter");
        //KeyStroke num_key_0 = KeyStroke.getKeyStroke(KeyEvent.VK_e, 0);//1 -> shift, 2 -> control
        //inputMap.put(num_key_0, "Num0");
        jButtonCalculate.getActionMap().put("Enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jButtonCalculateActionPerformed(ae);
            }
        });
    }
    
    protected boolean ErrorCheck() {
        if(mathProc.IsErrorOccured()) {
            java.awt.Toolkit.getDefaultToolkit().beep();
            return true;
        }
        return false;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCalc = new javax.swing.JPanel();
        jLabelExpression = new javax.swing.JLabel();
        jLabelNumber = new javax.swing.JLabel();
        jLabelMemory = new javax.swing.JLabel();
        jButtonMR = new javax.swing.JButton();
        jButtonMC = new javax.swing.JButton();
        jButtonMS = new javax.swing.JButton();
        jButtonMPlus = new javax.swing.JButton();
        jButtonMMinus = new javax.swing.JButton();
        jButtonBackspace = new javax.swing.JButton();
        jButtonNum7 = new javax.swing.JButton();
        jButtonNum1 = new javax.swing.JButton();
        jButtonNum4 = new javax.swing.JButton();
        jButtonNum0 = new javax.swing.JButton();
        jButtonNum2 = new javax.swing.JButton();
        jButtonNum5 = new javax.swing.JButton();
        jButtonNum8 = new javax.swing.JButton();
        jButtonNum3 = new javax.swing.JButton();
        jButtonNum6 = new javax.swing.JButton();
        jButtonNum9 = new javax.swing.JButton();
        jButtonC = new javax.swing.JButton();
        jButtonCE = new javax.swing.JButton();
        jButtonSquareRoot = new javax.swing.JButton();
        jButtonInvertSign = new javax.swing.JButton();
        jButtonPoint = new javax.swing.JButton();
        jButtonDivision = new javax.swing.JButton();
        jButtonPercent = new javax.swing.JButton();
        jButtonMultiplication = new javax.swing.JButton();
        jButtonReciprocating = new javax.swing.JButton();
        jButtonMinus = new javax.swing.JButton();
        jButtonPlus = new javax.swing.JButton();
        jButtonCalculate = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setBackground(new java.awt.Color(220, 237, 255));
        setMaximumSize(new java.awt.Dimension(220, 320));
        setMinimumSize(new java.awt.Dimension(220, 320));
        setPreferredSize(new java.awt.Dimension(220, 320));
        setResizable(false);
        setSize(new java.awt.Dimension(220, 320));

        jPanelCalc.setBackground(new java.awt.Color(240, 248, 255));
        jPanelCalc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelExpression.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jLabelExpression.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelExpression.setText("12345_____12345_____12345_____ ");
        jLabelExpression.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabelExpression.setMaximumSize(new java.awt.Dimension(45, 15));
        jLabelExpression.setMinimumSize(new java.awt.Dimension(45, 15));
        jLabelExpression.setPreferredSize(new java.awt.Dimension(45, 15));

        jLabelNumber.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jLabelNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelNumber.setText("3072");
        jLabelNumber.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabelMemory.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabelMemory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMemory.setText("M");
        jLabelMemory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabelMemory.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelCalcLayout = new javax.swing.GroupLayout(jPanelCalc);
        jPanelCalc.setLayout(jPanelCalcLayout);
        jPanelCalcLayout.setHorizontalGroup(
            jPanelCalcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalcLayout.createSequentialGroup()
                .addComponent(jLabelMemory, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabelExpression, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelCalcLayout.setVerticalGroup(
            jPanelCalcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalcLayout.createSequentialGroup()
                .addComponent(jLabelExpression, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCalcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMemory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jButtonMR.setBackground(new java.awt.Color(169, 198, 255));
        jButtonMR.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonMR.setText("MR");
        jButtonMR.setBorder(null);
        jButtonMR.setFocusPainted(false);
        jButtonMR.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonMR.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonMR.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonMR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMRActionPerformed(evt);
            }
        });

        jButtonMC.setBackground(new java.awt.Color(169, 198, 255));
        jButtonMC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonMC.setText("MC");
        jButtonMC.setBorder(null);
        jButtonMC.setFocusPainted(false);
        jButtonMC.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonMC.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonMC.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMCActionPerformed(evt);
            }
        });

        jButtonMS.setBackground(new java.awt.Color(169, 198, 255));
        jButtonMS.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonMS.setText("MS");
        jButtonMS.setBorder(null);
        jButtonMS.setFocusPainted(false);
        jButtonMS.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonMS.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonMS.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMSActionPerformed(evt);
            }
        });

        jButtonMPlus.setBackground(new java.awt.Color(169, 198, 255));
        jButtonMPlus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonMPlus.setText("M+");
        jButtonMPlus.setBorder(null);
        jButtonMPlus.setFocusPainted(false);
        jButtonMPlus.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonMPlus.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonMPlus.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonMPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMPlusActionPerformed(evt);
            }
        });

        jButtonMMinus.setBackground(new java.awt.Color(169, 198, 255));
        jButtonMMinus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonMMinus.setText("M-");
        jButtonMMinus.setBorder(null);
        jButtonMMinus.setFocusPainted(false);
        jButtonMMinus.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonMMinus.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonMMinus.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonMMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMMinusActionPerformed(evt);
            }
        });

        jButtonBackspace.setBackground(new java.awt.Color(180, 214, 249));
        jButtonBackspace.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jButtonBackspace.setText("←");
        jButtonBackspace.setAutoscrolls(true);
        jButtonBackspace.setBorder(null);
        jButtonBackspace.setFocusPainted(false);
        jButtonBackspace.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonBackspace.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonBackspace.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonBackspace.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButtonBackspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackspaceActionPerformed(evt);
            }
        });

        jButtonNum7.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNum7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButtonNum7.setText("7");
        jButtonNum7.setBorder(null);
        jButtonNum7.setFocusPainted(false);
        jButtonNum7.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonNum7.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonNum7.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonNum7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNum7ActionPerformed(evt);
            }
        });

        jButtonNum1.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNum1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButtonNum1.setText("1");
        jButtonNum1.setBorder(null);
        jButtonNum1.setFocusPainted(false);
        jButtonNum1.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonNum1.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonNum1.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonNum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNum1ActionPerformed(evt);
            }
        });

        jButtonNum4.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNum4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButtonNum4.setText("4");
        jButtonNum4.setBorder(null);
        jButtonNum4.setFocusPainted(false);
        jButtonNum4.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonNum4.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonNum4.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonNum4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNum4ActionPerformed(evt);
            }
        });

        jButtonNum0.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNum0.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButtonNum0.setText("0");
        jButtonNum0.setBorder(null);
        jButtonNum0.setFocusPainted(false);
        jButtonNum0.setMaximumSize(new java.awt.Dimension(70, 27));
        jButtonNum0.setMinimumSize(new java.awt.Dimension(70, 27));
        jButtonNum0.setPreferredSize(new java.awt.Dimension(70, 27));
        jButtonNum0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNum0ActionPerformed(evt);
            }
        });

        jButtonNum2.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNum2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButtonNum2.setText("2");
        jButtonNum2.setBorder(null);
        jButtonNum2.setFocusPainted(false);
        jButtonNum2.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonNum2.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonNum2.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonNum2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNum2ActionPerformed(evt);
            }
        });

        jButtonNum5.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNum5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButtonNum5.setText("5");
        jButtonNum5.setBorder(null);
        jButtonNum5.setFocusPainted(false);
        jButtonNum5.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonNum5.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonNum5.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonNum5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNum5ActionPerformed(evt);
            }
        });

        jButtonNum8.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNum8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButtonNum8.setText("8");
        jButtonNum8.setBorder(null);
        jButtonNum8.setFocusPainted(false);
        jButtonNum8.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonNum8.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonNum8.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonNum8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNum8ActionPerformed(evt);
            }
        });

        jButtonNum3.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNum3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButtonNum3.setText("3");
        jButtonNum3.setBorder(null);
        jButtonNum3.setFocusPainted(false);
        jButtonNum3.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonNum3.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonNum3.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonNum3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNum3ActionPerformed(evt);
            }
        });

        jButtonNum6.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNum6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButtonNum6.setText("6");
        jButtonNum6.setBorder(null);
        jButtonNum6.setFocusPainted(false);
        jButtonNum6.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonNum6.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonNum6.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonNum6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNum6ActionPerformed(evt);
            }
        });

        jButtonNum9.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNum9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButtonNum9.setText("9");
        jButtonNum9.setBorder(null);
        jButtonNum9.setFocusPainted(false);
        jButtonNum9.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonNum9.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonNum9.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonNum9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNum9ActionPerformed(evt);
            }
        });

        jButtonC.setBackground(new java.awt.Color(180, 214, 249));
        jButtonC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonC.setText("C");
        jButtonC.setAutoscrolls(true);
        jButtonC.setBorder(null);
        jButtonC.setFocusPainted(false);
        jButtonC.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonC.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonC.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCActionPerformed(evt);
            }
        });

        jButtonCE.setBackground(new java.awt.Color(180, 214, 249));
        jButtonCE.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonCE.setText("CE");
        jButtonCE.setAutoscrolls(true);
        jButtonCE.setBorder(null);
        jButtonCE.setFocusPainted(false);
        jButtonCE.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonCE.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonCE.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCEActionPerformed(evt);
            }
        });

        jButtonSquareRoot.setBackground(new java.awt.Color(180, 214, 249));
        jButtonSquareRoot.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonSquareRoot.setText("√");
        jButtonSquareRoot.setAutoscrolls(true);
        jButtonSquareRoot.setBorder(null);
        jButtonSquareRoot.setFocusPainted(false);
        jButtonSquareRoot.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonSquareRoot.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonSquareRoot.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonSquareRoot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSquareRootActionPerformed(evt);
            }
        });

        jButtonInvertSign.setBackground(new java.awt.Color(180, 214, 249));
        jButtonInvertSign.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonInvertSign.setText("±");
        jButtonInvertSign.setAutoscrolls(true);
        jButtonInvertSign.setBorder(null);
        jButtonInvertSign.setFocusPainted(false);
        jButtonInvertSign.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonInvertSign.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonInvertSign.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonInvertSign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInvertSignActionPerformed(evt);
            }
        });

        jButtonPoint.setBackground(new java.awt.Color(255, 255, 255));
        jButtonPoint.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButtonPoint.setText(".");
        jButtonPoint.setBorder(null);
        jButtonPoint.setFocusPainted(false);
        jButtonPoint.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonPoint.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonPoint.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonPoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPointActionPerformed(evt);
            }
        });

        jButtonDivision.setBackground(new java.awt.Color(180, 214, 249));
        jButtonDivision.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonDivision.setText("/");
        jButtonDivision.setAutoscrolls(true);
        jButtonDivision.setBorder(null);
        jButtonDivision.setFocusPainted(false);
        jButtonDivision.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonDivision.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonDivision.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonDivision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDivisionActionPerformed(evt);
            }
        });

        jButtonPercent.setBackground(new java.awt.Color(180, 214, 249));
        jButtonPercent.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonPercent.setText("%");
        jButtonPercent.setAutoscrolls(true);
        jButtonPercent.setBorder(null);
        jButtonPercent.setFocusPainted(false);
        jButtonPercent.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonPercent.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonPercent.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonPercent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPercentActionPerformed(evt);
            }
        });

        jButtonMultiplication.setBackground(new java.awt.Color(180, 214, 249));
        jButtonMultiplication.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonMultiplication.setText("*");
        jButtonMultiplication.setAutoscrolls(true);
        jButtonMultiplication.setBorder(null);
        jButtonMultiplication.setFocusPainted(false);
        jButtonMultiplication.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonMultiplication.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonMultiplication.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonMultiplication.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButtonMultiplication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMultiplicationActionPerformed(evt);
            }
        });

        jButtonReciprocating.setBackground(new java.awt.Color(180, 214, 249));
        jButtonReciprocating.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonReciprocating.setText("<html>1/<i>x</i></html>");
        jButtonReciprocating.setAutoscrolls(true);
        jButtonReciprocating.setBorder(null);
        jButtonReciprocating.setFocusPainted(false);
        jButtonReciprocating.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonReciprocating.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonReciprocating.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonReciprocating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReciprocatingActionPerformed(evt);
            }
        });

        jButtonMinus.setBackground(new java.awt.Color(180, 214, 249));
        jButtonMinus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonMinus.setText("-");
        jButtonMinus.setAutoscrolls(true);
        jButtonMinus.setBorder(null);
        jButtonMinus.setFocusPainted(false);
        jButtonMinus.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonMinus.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonMinus.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMinusActionPerformed(evt);
            }
        });

        jButtonPlus.setBackground(new java.awt.Color(180, 214, 249));
        jButtonPlus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonPlus.setText("+");
        jButtonPlus.setAutoscrolls(true);
        jButtonPlus.setBorder(null);
        jButtonPlus.setFocusPainted(false);
        jButtonPlus.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonPlus.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonPlus.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlusActionPerformed(evt);
            }
        });

        jButtonCalculate.setBackground(new java.awt.Color(180, 214, 249));
        jButtonCalculate.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jButtonCalculate.setText("=");
        jButtonCalculate.setAutoscrolls(true);
        jButtonCalculate.setBorder(null);
        jButtonCalculate.setFocusPainted(false);
        jButtonCalculate.setMaximumSize(new java.awt.Dimension(33, 27));
        jButtonCalculate.setMinimumSize(new java.awt.Dimension(33, 27));
        jButtonCalculate.setPreferredSize(new java.awt.Dimension(33, 27));
        jButtonCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalculateActionPerformed(evt);
            }
        });

        jMenu1.setText("View");
        jMenuBar.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar.add(jMenu2);

        jMenu3.setText("Help");
        jMenuBar.add(jMenu3);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelCalc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonMC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonMR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonBackspace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonCE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonMPlus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonMMinus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonInvertSign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonSquareRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButtonNum0, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButtonNum7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonNum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonNum4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButtonNum8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonNum2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonNum5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonNum9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonDivision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonPercent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonNum6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonMultiplication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonReciprocating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButtonNum3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonMinus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButtonPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonPlus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 21, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCalc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMPlus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonMMinus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonBackspace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonCE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonInvertSign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonSquareRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonNum7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonNum4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonNum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonNum8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonNum5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonNum6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonNum2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonNum0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPlus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonNum9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDivision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPercent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonMultiplication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonReciprocating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonNum3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonMinus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonCalculate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNum1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNum1ActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.AddSymbol('1');
        UpdateDisplay();
    }//GEN-LAST:event_jButtonNum1ActionPerformed

    private void jButtonNum2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNum2ActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.AddSymbol('2');
        UpdateDisplay();
    }//GEN-LAST:event_jButtonNum2ActionPerformed

    private void jButtonNum3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNum3ActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.AddSymbol('3');
        UpdateDisplay();
    }//GEN-LAST:event_jButtonNum3ActionPerformed

    private void jButtonNum4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNum4ActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.AddSymbol('4');
        UpdateDisplay();
    }//GEN-LAST:event_jButtonNum4ActionPerformed

    private void jButtonNum5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNum5ActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.AddSymbol('5');
        UpdateDisplay();
    }//GEN-LAST:event_jButtonNum5ActionPerformed

    private void jButtonNum6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNum6ActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.AddSymbol('6');
        UpdateDisplay();
    }//GEN-LAST:event_jButtonNum6ActionPerformed

    private void jButtonNum7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNum7ActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.AddSymbol('7');
        UpdateDisplay();
    }//GEN-LAST:event_jButtonNum7ActionPerformed

    private void jButtonNum8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNum8ActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.AddSymbol('8');
        UpdateDisplay();
    }//GEN-LAST:event_jButtonNum8ActionPerformed

    private void jButtonNum9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNum9ActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.AddSymbol('9');
        UpdateDisplay();
    }//GEN-LAST:event_jButtonNum9ActionPerformed

    private void jButtonNum0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNum0ActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.AddSymbol('0');
        UpdateDisplay();
    }//GEN-LAST:event_jButtonNum0ActionPerformed

    private void jButtonPointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPointActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.AddSymbol('.');
        UpdateDisplay();
    }//GEN-LAST:event_jButtonPointActionPerformed

    private void jButtonBackspaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackspaceActionPerformed
        numStorage.Backspace();
        UpdateDisplay();
    }//GEN-LAST:event_jButtonBackspaceActionPerformed

    private void jButtonCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCEActionPerformed
        if(mathProc.IsErrorOccured()) {
            jButtonCActionPerformed(evt);
            return;
        }
        numStorage.ClearEntry();
        UpdateDisplay();
    }//GEN-LAST:event_jButtonCEActionPerformed

    private void jButtonCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCActionPerformed
        mathProc.Clear();
        numStorage.ClearEntry();
        UpdateDisplay();
    }//GEN-LAST:event_jButtonCActionPerformed

    private void jButtonMCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMCActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.MemoryClear();
        UpdateDisplay();
    }//GEN-LAST:event_jButtonMCActionPerformed

    private void jButtonMRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMRActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.MemoryRecall();
        UpdateDisplay();
    }//GEN-LAST:event_jButtonMRActionPerformed

    private void jButtonMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMSActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.MemoryStore();
        UpdateDisplay();
    }//GEN-LAST:event_jButtonMSActionPerformed

    private void jButtonMPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMPlusActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.MemoryAdd();
        UpdateDisplay();
    }//GEN-LAST:event_jButtonMPlusActionPerformed

    private void jButtonMMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMMinusActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.MemorySubtract();
        UpdateDisplay();
    }//GEN-LAST:event_jButtonMMinusActionPerformed

    private void jButtonCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalculateActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.SetDisplay(mathProc.Calculate(numStorage.GetNumber()));
        UpdateDisplay();        
    }//GEN-LAST:event_jButtonCalculateActionPerformed

    private void jButtonPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlusActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.SetDisplay(mathProc.Add(numStorage.GetNumber()));
        UpdateDisplay(false);
    }//GEN-LAST:event_jButtonPlusActionPerformed

    private void jButtonMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMinusActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.SetDisplay(mathProc.Subtract(numStorage.GetNumber()));
        UpdateDisplay(false);
    }//GEN-LAST:event_jButtonMinusActionPerformed

    private void jButtonMultiplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMultiplicationActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.SetDisplay(mathProc.Multiply(numStorage.GetNumber()));
        UpdateDisplay(false);
    }//GEN-LAST:event_jButtonMultiplicationActionPerformed

    private void jButtonDivisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDivisionActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.SetDisplay(mathProc.Divide(numStorage.GetNumber()));
        UpdateDisplay(false);
    }//GEN-LAST:event_jButtonDivisionActionPerformed

    private void jButtonInvertSignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInvertSignActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.SetDisplay(mathProc.Negate(numStorage.GetNumber()));
        UpdateDisplay();
    }//GEN-LAST:event_jButtonInvertSignActionPerformed

    private void jButtonSquareRootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSquareRootActionPerformed
        
        numStorage.SetDisplay(mathProc.Sqrt(numStorage.GetNumber()));
        UpdateDisplay();
    }//GEN-LAST:event_jButtonSquareRootActionPerformed

    private void jButtonReciprocatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReciprocatingActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.SetDisplay(mathProc.Reciproc(numStorage.GetNumber()));
        UpdateDisplay();
    }//GEN-LAST:event_jButtonReciprocatingActionPerformed

    private void jButtonPercentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPercentActionPerformed
        if(ErrorCheck()) {
            return;
        }
        numStorage.SetDisplay(mathProc.Percent());
        UpdateDisplay();
    }//GEN-LAST:event_jButtonPercentActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBackspace;
    private javax.swing.JButton jButtonC;
    private javax.swing.JButton jButtonCE;
    private javax.swing.JButton jButtonCalculate;
    private javax.swing.JButton jButtonDivision;
    private javax.swing.JButton jButtonInvertSign;
    private javax.swing.JButton jButtonMC;
    private javax.swing.JButton jButtonMMinus;
    private javax.swing.JButton jButtonMPlus;
    private javax.swing.JButton jButtonMR;
    private javax.swing.JButton jButtonMS;
    private javax.swing.JButton jButtonMinus;
    private javax.swing.JButton jButtonMultiplication;
    private javax.swing.JButton jButtonNum0;
    private javax.swing.JButton jButtonNum1;
    private javax.swing.JButton jButtonNum2;
    private javax.swing.JButton jButtonNum3;
    private javax.swing.JButton jButtonNum4;
    private javax.swing.JButton jButtonNum5;
    private javax.swing.JButton jButtonNum6;
    private javax.swing.JButton jButtonNum7;
    private javax.swing.JButton jButtonNum8;
    private javax.swing.JButton jButtonNum9;
    private javax.swing.JButton jButtonPercent;
    private javax.swing.JButton jButtonPlus;
    private javax.swing.JButton jButtonPoint;
    private javax.swing.JButton jButtonReciprocating;
    private javax.swing.JButton jButtonSquareRoot;
    private javax.swing.JLabel jLabelExpression;
    private javax.swing.JLabel jLabelMemory;
    private javax.swing.JLabel jLabelNumber;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JPanel jPanelCalc;
    // End of variables declaration//GEN-END:variables
}
