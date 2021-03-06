package saveTheLolipop.moteur.elements.entités;

import saveTheLolipop.moteur.elements.Elements;
import saveTheLolipop.moteur.gestionnaireEvenements.GestionnaireEvenement;
import saveTheLolipop.moteur.utilitaire.Coordonnees;
import saveTheLolipop.moteur.utilitaire.EnumType;
import saveTheLolipop.moteurGraphique.boucleAffichage.Afficheur;

public class CaseQuadrillage extends ElementsJeu {
	private ElementsJeu elementJeu;

	public CaseQuadrillage(Coordonnees coord) {
		super("herbe", coord, EnumType.HERBE);
	}

	public CaseQuadrillage(String nom, Coordonnees coord, EnumType type) {
		super(nom, coord, type);
	}

	@Override
	public void affiche() {
		super.affiche();
		if (elementJeu != null)
			elementJeu.affiche();
	}

	@Override
	public void deplacement(int delta) {
		// pas de déplacement
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
