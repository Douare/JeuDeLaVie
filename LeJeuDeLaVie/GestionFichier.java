package LeJeuDeLaVie;

/*public class GestionFichier {
    public static void LireFichier(String fichier) {
        
    }

    public static Salle lireLigne(String ligne) throws LigneIncorrecteException {
        Salle LaSalle;
        String nomSalle = "";
        int capacite = 0;
        double tarif = 0.0;
        Scanner in = new Scanner(ligne);
        in.useDelimiter(";");
        if (in.hasNext()) {
            nomSalle = in.next();
            if (in.hasNextInt()) {
                capacite = in.nextInt();
                if (in.hasNextDouble()) {
                    tarif = in.nextDouble();
                } else {
                    in.close();
                    throw new LigneIncorrecteException("Salle incorrecte");
                }
            } else {
                in.close();
                throw new LigneIncorrecteException("Salle incorrecte");
            }
        } else {
            in.close();
            throw new LigneIncorrecteException("Salle incorrecte");
        }
        if (capacite >= 0 && tarif >= 0) {
            LaSalle = new Salle(nomSalle, capacite, tarif);
        } else {
            in.close();
            throw new LigneIncorrecteException("Salle incorrecte");
        }
        in.close();
        return LaSalle;
    }

    public static Set<Salle> lireFichier(String fichier) throws FileNotFoundException, IOException {
        Set<Salle> ensembleSallesCinema = new HashSet<Salle>();
        Salle laSalle = null;
        int nbMauvaiseLignes = 0;
        String ligne = "";
        FileReader fr = new FileReader(fichier);
        BufferedReader br = new BufferedReader(fr);
        ligne = br.readLine();
        while ((ligne = br.readLine()) != null) {
            try {
                laSalle = lireLigneCinema(ligne);
                ensembleSallesCinema.add(laSalle);
            } catch (LigneIncorrecteException e) {
                nbMauvaiseLignes++;
            }
        }
        br.close();
        System.out.println(
                "Fichier " + fichier + " chargé. Le nombre de lignes incorrectes est " + nbMauvaiseLignes + ".");
        return ensembleSallesCinema;
    }
}
*/