package de.hawhh.informatik.sml.kino.fachwerte;

import java.util.Map;
import java.util.HashMap;
/**
 * Ein GeldbetragKopie, bestehend aus Euro und Cent.
 * 
 * Ein Klassenobjekt bietet Methoden zur Addition und subtrahtion zweier Beträge,
 * sowie die Multiplikation mit einem Integer, und das Umwandeln von 
 * String- und Integer-Objekten in Geldbeträge an.
 * 
 * @author Emira Zorgati
 * @version SoSe17
 *
 */
public class GeldbetragKopie
{
	//ganzer Euroanteil
	private int _euro;
	//ganzer Centanteil
	private int _cent;
	//Set von Geldbeträgen
	static Map<Integer, GeldbetragKopie> _betraege = new HashMap<Integer, GeldbetragKopie>();
	
	/**
	 * Erzeugt einen GeldbetragKopie.
	 * @param Euro
	 * 			Die ganzen Euro.
	 * @param Cent
	 * 			Der Cent Anteil.
	 * @require euro >= 0
	 * @require cent >= 0
	 */
	private GeldbetragKopie(int euro, int cent)
	{
		assert euro >= 0 : "Vorbedingung verletzt: euro >=0";
		assert cent >= 0 : "Vorbedingung verletzt: cent >=0";
		_euro = euro;
		_cent = cent;
	}
	
	/**
	 * Gibt den Euroanteil zurück.
	 * @return Euroanteil
	 */
	public int getEuro()
	{
		return _euro;
	}

	/**
	 * Gibt den Centanteil zurück.
	 * @return Centanteil
	 */
	public int getCent()
	{
		return _cent;
	}

	@Override
	public String toString()
	{
		String result;
		if(_euro == 0)
		{
			if(_cent == 0)
			{
				result = "00,00";
			}
			else
			{
				result = "00," +_cent;
			}
		}
		else if(_cent == 0)
		{
			result = _euro +",00";
		}
		else
		{
			result = _euro +"," + _cent;
		}
		return result;
	}
	
	@Override
	public boolean equals(Object o)
	{
		boolean result = false;
		if(o instanceof GeldbetragKopie)
		{
			GeldbetragKopie betrag = (GeldbetragKopie) o;
			if(betrag._euro == _euro)
			{
				if(betrag._cent == _cent)
				{
					result = true;
				}
			}
			
		}
		return result;
	}
	
	@Override
	public int hashCode()
	{
		//den Eurocent betrag als int
		return (_euro*100 + _cent);
	}
	
	/**
	 * Addier zwei Geldbeträge
	 * @param betrag
	 * 			der GeldbetragKopie, welche addiert werden soll
	 * @return der neue GeldbetragKopie
	 * @require betrag != null
	 * @ensure result != null
	 */
	public GeldbetragKopie addiere(GeldbetragKopie betrag)
	{
		assert betrag != null : "Vorbedingung verletzt: betrag != null";
		
		int meinBetrag = _euro *100 + _cent;
		int zuAddieren = (betrag._euro) *100 + betrag._cent;
		int neu = meinBetrag + zuAddieren;
		return GeldbetragKopie.get(neu/100,neu%100);
	}
	
	/**
	 * Subtrahiert zwei Geldbeträge
	 * @param betrag
	 * 			der GeldbetragKopie, welche subtrahiert werden soll
	 * @return der neue GeldbetragKopie
	 * @require betrag != null
	 * @require istGroeßerOderGleich(betrag)
	 * @ensure result != null
	 */
	public GeldbetragKopie subtrahiere(GeldbetragKopie betrag)
	{
		assert betrag != null : "Vorbedingung verletzt: betrag != null";
		assert istGroeßerOderGleich(betrag) :"Vorbedingung verletzt: istGroeßerOderGleich(betrag)";
		
		int meinBetrag = _euro *100 + _cent;
		int zuSubtrahieren = (betrag._euro) *100 + betrag._cent;
		int neu = meinBetrag - zuSubtrahieren;
		return GeldbetragKopie.get(neu/100,neu%100);
	}

	/**
	 * 
	 * @param betrag
	 * @return
	 * @require betrag != null
	 */
	private boolean istGroeßerOderGleich(GeldbetragKopie betrag)
	{
		assert betrag != null : "Vorbedingung verletzt: betrag != null";
		
		boolean result = false;
		if(_euro > betrag._euro)
		{
			result = true;
		}
		else if(_euro == betrag._euro)
		{
			if(_cent >= betrag._cent)
			{
				result = true;
			}
		}
		return result;
		
	}
	/**
	 * Multipliziert einen GeldbetragKopie mit einem Faktor
	 * @param faktor
	 * 			Der Faktor, mit dem der GeldbetragKopie multipliziert werden soll
	 * @return neuer GeldbetragKopie
	 * @require faktor >= 0
	 * @ensure result != null
	 */
	public GeldbetragKopie multipliziere(int faktor)
	{
		assert faktor >= 0 : "Vorbedingung verletzt: faktor >=0";
		int meinBetrag = _euro*100 + _cent;
		int neu = meinBetrag * faktor;
		return GeldbetragKopie.get(neu/100,neu%100);
	}
	
	/**
	 * Gibt einen GeldbetragKopieObjekt zurück.
	 * @param Euro
	 * 			Die ganzen Euro.
	 * @param Cent
	 * 			Der Cent Anteil.
	 * @require euro >= 0
	 * @require cent >= 0
	 */
	public static GeldbetragKopie get(int euro, int cent)
	{
		int betrag = euro*100 + cent;
		
		if(_betraege.containsKey(betrag))
		{
			return _betraege.get(betrag);
		}
		else
		{
			GeldbetragKopie geldbetrag = new GeldbetragKopie(euro,cent);
			_betraege.put(betrag, geldbetrag);
			return geldbetrag;
		}
	}
	
	/**
	 * Macht aus einem Integer einen GeldbetragKopie. Zb 5 -> GeldbetragKopie "00,05"
	 * 												500 -> GeldbetragKopie "05,00" 
	 * @param betrag
	 * 			Der Betrag in Eurocent.
	 * @return ein GeldbetragKopie der den Betrag betrag hat.
	 * @require betrag >= 0
	 */
	public static GeldbetragKopie toGeldbetragKopie(int betrag)
	{
		assert betrag >= 0 :"Vorbedinung verletzt: betrag >= 0'";
		
		return GeldbetragKopie.get(betrag/100, betrag%100);
	}
}
