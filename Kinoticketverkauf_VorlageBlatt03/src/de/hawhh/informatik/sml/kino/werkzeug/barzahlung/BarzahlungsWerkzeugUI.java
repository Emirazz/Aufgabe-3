package de.hawhh.informatik.sml.kino.werkzeug.barzahlung;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JDialog;

public class BarzahlungsWerkzeugUI
{
	private static final String TITEL = "Barzahlung";

	private JButton _AbbruchButton;
    private JButton _OKButton;
    private JLabel _preisLabel;
    private JDialog _dialog;
    private JFrame _frame;
    
    public BarzahlungsWerkzeugUI(JFrame owner)
    {
    	_dialog = new JDialog(owner,TITEL, true);
    	_dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        _frame.getContentPane().setLayout(new BorderLayout());
        JComponent topPanel = erstelleUeberschriftPanel();
        JComponent bottomPanel = erstelleAbbruchPanel();
        JComponent bottom2Panel = erstelleOKPanel();
        
        _frame.getContentPane().add(topPanel, BorderLayout.NORTH);
        _frame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        _frame.getContentPane().add(bottom2Panel, BorderLayout.SOUTH);
        _dialog.setContentPane(_frame);
    }
    
    /**
     * Erzeugt das Panel mit der Überschrift fuer das Programm.
     */
    private JPanel erstelleUeberschriftPanel()
    {
        JPanel topPanel = new JPanel();
        JLabel label = new JLabel(TITEL, SwingConstants.CENTER);

        Font font = label.getFont().deriveFont(Font.BOLD + Font.ITALIC, 20);
        label.setFont(font);
        label.setForeground(Color.black);

        topPanel.setLayout(new BorderLayout());
        topPanel.add(label, BorderLayout.CENTER);

        return topPanel;
    }
    
    /**
     * Erzeugt das Panel mit dem Beenden-Button.
     */
    private JPanel erstelleAbbruchPanel()
    {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        _AbbruchButton = new JButton("Abbruch");
        bottomPanel.add(_AbbruchButton);

        return bottomPanel;
    }
    
    /**
     * Erzeugt das Panel mit dem Beenden-Button.
     */
    private JPanel erstelleOKPanel()
    {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        _OKButton = new JButton("OK");
        bottomPanel.add(_OKButton);

        return bottomPanel;
    }
    
    /**
     * Zeigt das Fenster an.
     */
    public void zeigeFenster()
    {
        _frame.setSize(600, 450);
        _frame.setVisible(true);
    }
    
    /**
     * Schließt das Fenster.
     */
    public void schliesseFenster()
    {
        _frame.dispose();
    }
    
    /**
     * Gibt den Abbruch-Button zurück.
     */
    public JButton getAbbruchButton()
    {
        return _AbbruchButton;
    }
    
    /**
     * Gibt den OK-Button zurück.
     */
    public JButton getOKButton()
    {
        return _OKButton;
    }
}
