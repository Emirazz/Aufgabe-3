package de.hawhh.informatik.sml.kino.werkzeug.barzahlung;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

public class BarzahlungsWerkzeugUI
{
	private static final String TITEL = "Barzahlung";

	private JButton _AbbruchButton;
    private JButton _OKButton;
    private String _text;
    private int _rueckgeld;
    private int _preis;
    private JDialog _dialog;
    
    public BarzahlungsWerkzeugUI(String tickets, int preis, JFrame owner)
    {
    	_text = tickets;
    	_preis = preis;
    	_rueckgeld = -preis;
    	_dialog = new JDialog(owner,TITEL,true);
    	_dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    	
    	
    	
        _dialog.getContentPane().setLayout(new BorderLayout());
        JComponent topPanel = erstelleUeberschriftPanel();
        JComponent bottomPanel = erstelleBottomPanel();
        JComponent centerPanel = erstelleMitte();
        
        _dialog.getContentPane().add(topPanel, BorderLayout.NORTH);
        _dialog.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        _dialog.getContentPane().add(centerPanel, BorderLayout.CENTER);
    }
    
    public int getRueckgeld()
    {
    	return _rueckgeld;
    }
    /**
     * 
     */
    private JPanel erstelleMitte()
    {    	JPanel pane = new JPanel();
    	
    	JLabel label = new JLabel(_text);
    	label.setBorder(BorderFactory
                .createEmptyBorder(5, 5, 5, 5));
    	pane.add(label, BorderLayout.NORTH);
    	
    	label = new JLabel("\nZu zahlen: " + _preis + " Eurocent");
    	label.setBorder(BorderFactory
                .createEmptyBorder(5, 5, 5, 5));
    	pane.add(label, BorderLayout.NORTH);
    	
    	
    	label = new JLabel("\nin Bar erhalten: ");
    	label.setBorder(BorderFactory
                .createEmptyBorder(5, 5, 5, 5));
    	pane.add(label, BorderLayout.CENTER);
    	JFormattedTextField field = new JFormattedTextField(int.class);
    	pane.add(field);
    	field.addActionListener(new ActionListener()
    			{
    				@Override
    	            public void actionPerformed(ActionEvent e)
    	            {
    					if(field.getValue() instanceof String)
    					{
    						String text = (String) field.getValue();
    						int bargeld = toInt(text);
    						aktualisiereRueckgeld(bargeld);
    					}
    					
    	            }    		
    			});
    	
    	label = new JLabel("Rückgeld: " + _rueckgeld + " Eurocent");
    	label.setBorder(BorderFactory
                .createEmptyBorder(5, 5, 5, 5));
    	pane.add(label, BorderLayout.SOUTH);
    	return pane;
    }
    
    private int toInt(String text)
    {
    	int length =text.length();
		int multi = 1;
		int result = 0;
		for(int i = length-1; i >= 0; i--)
		{
			char ch = text.charAt(i);
			switch(ch)
			{
			case'0':
				multi = multi*10;
				break;
			case '1':
				result += 1*multi;
				multi = multi*10;
				break;
			case '2':
				result += 2*multi;
				multi = multi*10;
				break;
			case '3':
				result += 3*multi;
				multi = multi*10;
				break;
			case '4':
				result += 4*multi;
				multi = multi*10;
				break;
			case '5':
				result += 5*multi;
				multi = multi*10;
				break;
			case '6':
				result += 6*multi;
				multi = multi*10;
				break;
			case '7':
				result += 7*multi;
				multi = multi*10;
				break;
			case '8':
				result += 8*multi;
				multi = multi*10;
				break;
			case '9':
				result += 9*multi;
				multi = multi*10;
				break;
			}
		}
		return result;
    }
    
    /**
     * Berechnet das Rueckgeld.
     */
    private void aktualisiereRueckgeld(int bargeld)
    {
    	_rueckgeld = _preis - bargeld;
    	JComponent centerPanel = erstelleMitte();
    	_dialog.remove(centerPanel);
    	_dialog.add(centerPanel);
    	_dialog.revalidate();
    	_dialog.repaint();
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
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
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
