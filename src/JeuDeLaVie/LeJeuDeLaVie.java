package JeuDeLaVie;

import java.io.IOException;

public class LeJeuDeLaVie {

    public static void main(String[] args) {
        Liste l = new Liste();
        String fichier = "test.lif";
        try {
            l = GestionFichier.LireFichier(fichier);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        if (!l.estVide()) {
            System.out.print(l.toString());
        }
    }
}