/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author tts
 */
public class SudokuTile extends JLabel {
    private final int x, y;
    private final Border DEFAULT_BORDER;
    private final Border HIGHLIGHTED_BORDER;
    public SudokuTile(String text, int x, int y){
        super(text);
        this.x = x;
        this.y = y;
        
        DEFAULT_BORDER = BorderFactory.createLineBorder(new Color(0x000000));
        HIGHLIGHTED_BORDER = BorderFactory.createLineBorder(new Color(0x000000));
        setBorder(DEFAULT_BORDER);
    }
    
    public boolean checkCoordinates(int x, int y){
        return this.x == x && this.y == y;
    }
    
    public void update(String text){
        setText(text);
    }
}
