package de.hawhh.informatik.sml.kino.werkzeug.barzahlung;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JDialog;
import javax.swing.JTextField;

public class BarzahlungsWerkzeugUI
{
	private static final String TITEL = "Barzahlung";

	private JButton _AbbruchButton;
    private JButton _OKButton;
    private String _text;
    private int _preis;
    private JDialog _dialog;
    
    public BarzahlungsWerkzeugUI(String tickets, int preis)
    {
    	_text = tickets;
    	_preis = preis;
    	_dialog = new JDialog();
    	_dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        _dialog.getContentPane().setLayout(new BorderLayout());
        JComponent topPanel = erstelleUeberschriftPanel();
        JComponent bottomPanel = erstelleBottomPanel();
        JComponent centerPanel = erstelleMitte();
        
        _dialog.getContentPane().add(topPanel, BorderLayout.NORTH);
        _dialog.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        _dialog.getContentPane().add(centerPanel, BorderLayout.CENTER);
    }
    
    /**
     * 
     */
    private JPanel erstelleMitte()
    {
    	JPanel pane = new JPanel();
    	JLabel label = new JLabel(_text + "\nZu zahlen: " + _preis);
    	label.setBorder(BorderFactory
                .createEmptyBorder(15, 15, 15, 15));
    	pane.add(label);
    	JTextField text = new JTextField("\nin Bar erhalten: \nRückgeld: ");
    	return pane;
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
    private JPanel erstelleBottomPanel()
    {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        _OKButton = new JButton("OK");
        bottomPanel.add(_OKButton);
        _AbbruchButton = new JButton("Abbrechen");
        bottomPanel.add(_AbbruchButton);
        

        return bottomPanel;
    }
    
    /**
     * Zeigt das Fenster an.
     */
    public void zeigeFenster()
    {
    	_dialog.setSize(600, 450);
    	_dialog.setVisible(true);
    }
    
    /**
     * Schließt das Fenster.
     */
    public void schliesseFenster()
    {
    	_dialog.dispose();
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
