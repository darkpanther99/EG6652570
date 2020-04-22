package proto.model;
/**
 * 
 * Játékos fajta. 5 egységnyi testhõvel kezd. Képes iglut építeni. A játékos irányítja. 
 *
 */
public class Eskimo extends Player {
	
	/**
	 * Konstruktor, ami létrehoz egy játékost, majd beállítja a teshõjét ötre, mint az eszkimóknak.
	 */
	public Eskimo() {
		super();
		this.bodyTemp=5;
	}
	
	/**
	 * Épít egy iglut a mezõre, amin áll, a BuildStrategyjétõl függetlenül. Az iglu megvéd majd a hóvihartól. Beállítja a mezõ menedékét Iglura. 
	 */
    public void build() {
        if (energy>0) {
        	energy--;
        	Igloo i=new Igloo();
        	currentTile.setShelter(i);
        }
    }
}
