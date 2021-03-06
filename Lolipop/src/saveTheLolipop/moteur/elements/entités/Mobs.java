package saveTheLolipop.moteur.elements.entit�s;

import saveTheLolipop.moteur.elements.Elements;
import saveTheLolipop.moteur.gestionnaireEvenements.GestionnaireEvenement;
import saveTheLolipop.moteur.utilitaire.Coordonnees;
import saveTheLolipop.moteur.utilitaire.EnumType;
import saveTheLolipop.moteurGraphique.boucleAffichage.Afficheur;
import saveTheLolipop.moteurGraphique.donneesAffichage.DeplacementAffichages;

public final class Mobs extends Actifs {
	public Mobs(String nom, Coordonnees coord, EnumType type, Integer PV,
			Integer ATT, Float Vit) {
		super(nom, coord, type, PV, ATT, Vit);
	}

	public void deplacement(int delta) {
		DeplacementAffichages.deplacementSimple(this.getCoord(), this.getVitesse(), delta);
	}

	public void attaquer() {
		// TODO appel animation + evenement
	}

	@Override
	public void ajoutElement() {
		Afficheur.addElemPresent(this);
		GestionnaireEvenement.addElemPresent(this);
	}

	@Override
	public void supElement(Elements e) {
		Afficheur.delElemPresent(this);
		GestionnaireEvenement.delElemPresent(this);
	}
}
