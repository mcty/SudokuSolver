/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import model.SudokuTile;

/**
 *
 * @author tts
 */
public class MainWindow extends JFrame implements ActionListener{
    
    private final int WINDOW_WIDTH = 800, WINDOW_HEIGHT =600;
    private static MainWindow instance;
    private final List<SudokuTile> SudokuTiles = new ArrayList();
    
    private MainWindow(){
        super("Sudoku Solver");
        buildGUI();
    }
    
    private void buildGUI(){
        setPreferredSize(new Dimension(400, 600));
        setResizable(false);
        setVisible(true);
        JPanel panel = new JPanel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel.add(buildMap());
        panel.add(buildSolver());
        panel.add(buildUpdater());
        
        
        add(panel);
        pack();
    }
    
    private JScrollPane buildMap() {
        JPanel sMap = new JPanel(new GridLayout(9, 9));
        sMap.setBorder(BorderFactory.createRaisedBevelBorder());
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                SudokuTile tile = new SudokuTile(" ", j, i);
                SudokuTiles.add(tile);
                sMap.add(tile);
            }
        }
        JScrollPane scroll = new JScrollPane(sMap);
        scroll.setPreferredSize(new Dimension(380, 400));
        return scroll;
    }
    
    private JScrollPane buildSolver(){
        JPanel sMap = new JPanel(new GridLayout(1,2));
        sMap.setBorder(BorderFactory.createRaisedBevelBorder());
        
        JButton solve = new JButton("Solve");
        solve.setPreferredSize(new Dimension(150,40));
        solve.addActionListener((ActionEvent ae) -> {
           //Add later for functionality
        });
        sMap.add(solve);
        
        JLabel title1 = new JLabel("<html> Creator mcty <br/> Version 0.1</html>");
        title1.setFont(title1.getFont().deriveFont(Font.BOLD,12));
        sMap.add(title1);
        
        JScrollPane scroll = new JScrollPane(sMap);
        scroll.setPreferredSize(new Dimension(380, 50));
        
        return scroll;
    }
    
    private JScrollPane buildUpdater() {
        JPanel sMap = new JPanel(new GridLayout(1,4));
        sMap.setBorder(BorderFactory.createRaisedBevelBorder());
        
        JTextField tfield1 = new JTextField();
        tfield1.setPreferredSize(new Dimension(85,40));
        sMap.add(tfield1);
        
        JTextField tfield2 = new JTextField();
        tfield2.setPreferredSize(new Dimension(85,40));
        sMap.add(tfield2);
        
        JTextField tfield3 = new JTextField();
        tfield3.setPreferredSize(new Dimension(85,40));
        sMap.add(tfield3);
        
        JButton valChanger = new JButton("Add/Update");
        valChanger.setPreferredSize(new Dimension(85,40));
        
        valChanger.addActionListener((ActionEvent ae) -> {
            for(SudokuTile p : SudokuTiles){
                if(p.checkCoordinates((Integer.parseInt(tfield1.getText())),(Integer.parseInt(tfield2.getText())))){
                    p.update(tfield3.getText());
                }
            }
        });
        sMap.add(valChanger);
        
        JScrollPane scroll = new JScrollPane(sMap);
        scroll.setPreferredSize(new Dimension(380, 50));
        
        return scroll;
    }
    
    public static MainWindow getInstance(){
        if(instance == null)
            instance = new MainWindow();
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
