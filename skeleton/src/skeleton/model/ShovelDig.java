package skeleton.model;

public class ShovelDig implements DigStrategy{
	private boolean lastUsed;
	public boolean Dig(Tile t) {
		// @NOTE(boti): mindig az elozo allapotot adjuk vissza, igy minden
		//             paros asaskor adunk vissza true-t
		// @TODO(boti): Ha tobbfele asast akarunk, akkor int-et kene tarolni. Ennel a dig-nel pl.
		//              azt inkrementalnank minden lepesben es digCount % 2 == 0-t adnank vissza
		lastUsed = !lastUsed;
		return !lastUsed; 
	}
}
