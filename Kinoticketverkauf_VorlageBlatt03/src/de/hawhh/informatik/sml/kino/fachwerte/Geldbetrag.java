package de.hawhh.informatik.sml.kino.fachwerte;

/**
 * Ein Geldbetrag, bestehend aus Euro und Cent.
 * 
 * Ein Klassenobjekt bietet Methoden zur Addition und subtrahtion zweier Beträge,
 * sowie die Multiplikation mit einem Integer, und das Umwandeln von 
 * String- und Integer-Objekten in Geldbeträge an.
 * 
 * @author Emira Zorgati
 * @version SoSe17
 *
 */
public class Geldbetrag
{
	//ganzer Euroanteil
	private int _euro;
	//ganzer Centanteil
	private int _cent;
	//Set von Geldbeträgen
	static Map<Integer, Geldbetrag> _betraege = new HashMap<Integer, Geldbetrag>();
	
	/**
	 * Erzeugt einen Geldbetrag.
	 * @param Euro
	 * 			Die ganzen Euro.
	 * @param Cent
	 * 			Der Cent Anteil.
	 * @require euro >= 0
	 * @require cent >= 0
	 */
	private Geldbetrag(int euro, int cent)
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
		if(o instanceof Geldbetrag)
		{
			Geldbetrag betrag = (Geldbetrag) o;
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
	 * 			der Geldbetrag, welche addiert werden soll
	 * @return der neue Geldbetrag
	 * @require betrag != null
	 * @ensure result != null
	 */
	public Geldbetrag addiere(Geldbetrag betrag)
	{
		assert betrag != null : "Vorbedingung verletzt: betrag != null";
		
		int meinBetrag = _euro *100 + _cent;
		int zuAddieren = (betrag._euro) *100 + betrag._cent;
		int neu = meinBetrag + zuAddieren;
		return Geldbetrag.get(neu/100,neu%100);
	}
	
	/**
	 * Subtrahiert zwei Geldbeträge
	 * @param betrag
	 * 			der Geldbetrag, welche subtrahiert werden soll
	 * @return der neue Geldbetrag
	 * @require betrag != null
	 * @require istGroeßerOderGleich(betrag)
	 * @ensure result != null
	 */
	public Geldbetrag subtrahiere(Geldbetrag betrag)
	{
		assert betrag != null : "Vorbedingung verletzt: betrag != null";
		assert istGroeßerOderGleich(betrag) :"Vorbedingung verletzt: istGroeßerOderGleich(betrag)";
		
		int meinBetrag = _euro *100 + _cent;
		int zuSubtrahieren = (betrag._euro) *100 + betrag._cent;
		int neu = meinBetrag - zuSubtrahieren;
		return Geldbetrag.get(neu/100,neu%100);
	}

	/**
	 * 
	 * @param betrag
	 * @return
	 * @require betrag != null
	 */
	private boolean istGroeßerOderGleich(Geldbetrag betrag)
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
	 * Multipliziert einen Geldbetrag mit einem Faktor
	 * @param faktor
	 * 			Der Faktor, mit dem der Geldbetrag multipliziert werden soll
	 * @return neuer Geldbetrag
	 * @require faktor >= 0
	 * @ensure result != null
	 */
	public Geldbetrag multipliziere(int faktor)
	{
		assert faktor >= 0 : "Vorbedingung verletzt: faktor >=0";
		int meinBetrag = _euro*100 + _cent;
		int neu = meinBetrag * faktor;
		return Geldbetrag.get(neu/100,neu%100);
	}
	
	/**
	 * Gibt einen GeldbetragObjekt zurück.
	 * @param Euro
	 * 			Die ganzen Euro.
	 * @param Cent
	 * 			Der Cent Anteil.
	 * @require euro >= 0
	 * @require cent >= 0
	 */
	public static Geldbetrag get(int euro, int cent)
	{
		Geldbetrag geldbetrag = new Geldbetrag(euro,cent);
		return geldbetrag;
	}
	
	/**
	 * Macht aus einem Integer einen Geldbetrag. Zb 5 -> Geldbetrag "00,05"
	 * 												500 -> Geldbetrag "05,00" 
	 * @param betrag
	 * 			Der Betrag in Eurocent.
	 * @return ein Geldbetrag der den Betrag betrag hat.
	 * @require betrag >= 0
	 */
	public static Geldbetrag toGeldbetrag(int betrag)
	{
		assert betrag >= 0 :"Vorbedinung verletzt: betrag >= 0'";
		
		return Geldbetrag.get(betrag/100, betrag%100);
	}
	
	public static Geldbetrag toGeldbetrag(String text)
	{
		
	}
}
