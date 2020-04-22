package proto.model;

/**
 * 
 *Ilyen a jégtábla, ha nincs rajta iglu. A jégtáblán nincs védelem a vihar elol.
 *
 */
public class BareIce extends Shelter {
	
	/**
	 * A paraméterként kapott t Tilen álló játékosok testhõje csökken.
	 * @param t A Tile típusú jégtábla objektum, amin a menedék(jelen esetben a semmi) található, és a rajta lévõ entitások fáznak rajta.
	 *
	 */
	public void chillStorm(Tile t) {
        for (Entity e:t.getOccupants()) {
        	e.chill();
        }
    }

	/**
	 *  A paraméterként kapott t Tilen álló minden játékost megtámad a medve.
	 * @param t A Tile típusú jégtábla objektum, amin a menedék(jelen esetben a semmi) található, és a rajta lévõ entitások medvetámadás áldozatai lettek.
	 *
	 */
    public void bearAttack(Tile t) {
    	for (Entity e:t.getOccupants()) {
        	e.bearAttack();
        }
    }
    /**
    * Nem csinál semmit, mert a nem létezõ menedék nem törik el.
    * @param t A Tile típusú jégtábla objektum, amin a menedék(jelen esetben a semmi) található.
    */
    public void ruin(Tile t) {
        return;
    }
}
