package saveTheLolipop.moteurGraphique.donneesAffichage.utilitaire;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import saveTheLolipop.moteur.elements.Elements;
import saveTheLolipop.moteur.gestionnaireEvenements.GestionnaireClavierSouris;
import saveTheLolipop.moteur.utilitaire.Coordonnees;

public class UtilitaireAffichage {

	public static void pleineEcran() {
		Integer largeur = Display.getWidth();
		Integer hauteur = Display.getHeight();

		setDisplayMode(largeur, hauteur, GestionnaireClavierSouris.enPleinEcran);
	}

	private static void setDisplayMode(int width, int height, boolean fullscreen) {
		// return if requested DisplayMode is already set
		if ((Display.getDisplayMode().getWidth() == width)
				&& (Display.getDisplayMode().getHeight() == height)
				&& (Display.isFullscreen() == fullscreen)) {
			return;
		}

		try {
			DisplayMode targetDisplayMode = null;

			if (fullscreen) {
				DisplayMode[] modes = Display.getAvailableDisplayModes();
				int freq = 0;
				boolean resolutionTrouver = true;
				do {
					for (int i = 0; i < modes.length; i++) {
						resolutionTrouver = true;
						DisplayMode current = modes[i];

						if ((current.getWidth() == width)
								&& (current.getHeight() == height)) {
							if ((targetDisplayMode == null)
									|| (current.getFrequency() >= freq)) {
								if ((targetDisplayMode == null)
										|| (current.getBitsPerPixel() > targetDisplayMode
												.getBitsPerPixel())) {
									targetDisplayMode = current;
									freq = targetDisplayMode.getFrequency();
								}
							}

							if ((current.getBitsPerPixel() == Display
									.getDesktopDisplayMode().getBitsPerPixel())
									&& (current.getFrequency() == Display
											.getDesktopDisplayMode()
											.getFrequency())) {
								targetDisplayMode = current;
								resolutionTrouver = false;
								break;
							}
						}
					}
					for (int i = 0; i < modes.length; i++) {
						DisplayMode current = modes[i];
						if ((current.getWidth() == width)
								&& (current.getHeight() >= height)) {
							height = current.getHeight();
							break;
						}
					}
				} while (resolutionTrouver);
				System.out.println("plein ecran resolution " + width + "x"
						+ height);

			} else {
				targetDisplayMode = new DisplayMode(width, height);
			}

			if (targetDisplayMode == null) {
				System.out.println("failed to find value mode: " + width + "x"
						+ height + " fs " + fullscreen);
				return;
			}

			Display.setDisplayMode(targetDisplayMode);
			Display.setFullscreen(fullscreen);

		} catch (LWJGLException e) {
			System.out.println("Unable to setup mode " + width + "x" + height
					+ " fullscreen " + fullscreen + e);
		}
	}

	public static void spawnMiddle(Elements e) {
		Integer largeur = Display.getWidth();
		Integer hauteur = Display.getHeight();

		e.setCoord(new Coordonnees((float) largeur / 2, (float) hauteur / 2));
	}

	public static void displayModeList() {
		try {
			DisplayMode[] modes = Display.getAvailableDisplayModes();
			for (int i = 0; i < modes.length; i++) {
				DisplayMode cur = modes[i];
				System.out.println("Display mode " + i + " : " + cur.getWidth()
						+ "x" + cur.getHeight() + "x" + cur.getBitsPerPixel()
						+ " " + cur.getFrequency() + "Hz");
			}
		} catch (LWJGLException e) {
			System.out.println("impossible d'acc�der aux modes d'affichages: "
					+ e);
		}

	}
}
