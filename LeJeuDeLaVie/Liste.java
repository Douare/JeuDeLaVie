package LeJeuDeLaVie;

/**
 *
 */
public class Liste {

    // Attributs
    private Maillon tete;

    // Constructeur

    /**
     * Initialise la liste a null
     */
    public Liste() {
        this.tete = new Maillon(null, null);
    }

    /**
     * Initialise la liste avec un maillon
     *
     * @param tete : maillon de tete
     */
    public Liste(Maillon tete) {
        this.tete = tete;
    }

    // Methodes

    /**
     * Retourne le premier maillon de la liste
     *
     * @return : tete de la liste
     */
    public Maillon getTete() {
        return tete;
    }

    /**
     * Affecte une nouvelle tete de liste a la liste avec le maillon passe en parametre
     *
     * @param tete : nouvelle tete de liste
     */
    public void setTete(Maillon tete) {
        this.tete = tete;
    }

    // Ayoub
    /**
     * Ajoute un maillon en debut de liste
     *
     * @param m
     */
    public void ajouterMaillon(Maillon m) {
        m.setSuivant(this.getTete());
        this.tete = m;
    }

    // Ozgur

    /**
     * Retourne vrai si la liste est vide faut sinon
     *
     * @return boolean
     */
    public boolean estVide(){
        return this.tete == null;
    }

    // Ozgur

    /**
     * Trie la liste courante
     */
    public void sort(){
        if(!estVide()){
            boolean trie = false;
            Maillon tmp = tete;
            Maillon echange = new Maillon(null,null);
            while (!trie){
                trie = true;
                while(tmp.getSuivant() != null) {
                    if (tmp.getInfo().compareTo(tmp.getSuivant().getInfo()) == 1) {
                        echange.setInfo(tmp.getInfo());
                        tmp.setInfo(tmp.getSuivant().getInfo());
                        tmp.getSuivant().setInfo(echange.getInfo());
                        trie = false;
                    }
                    tmp = tmp.getSuivant();
                }
            }
        }
    }

    //Uzay

    /**
     * Retourne un entier correspondant a la taille de la liste
     *
     * @return : la taille de la liste
     */
    public int taille() {
        Maillon tmp = this.tete;
        int taille = 0;
        while (tmp != null) {
            taille++;
            tmp = tmp.getSuivant();
        }
        return taille;
    }

    // Juliette

    /**
     * Supprime un maillon de la liste
     *
     * @param m : maillon a supprimer
     */
    public void supprimerMaillon(Maillon m){
        if (tete.equals(m)) {
            tete = tete.getSuivant();
        } else {
            Maillon tmp = tete;
            while (!(tmp.getSuivant() == null)) {
                if (tmp.getSuivant().equals(m)) {
                    tmp.setSuivant(tmp.getSuivant().getSuivant());
                    break;
                } else tmp = tmp.getSuivant();
            }
        }
    }

    /**
     * Retourne la liste sous forme de chaine de caracteres
     *
     * @return : Une chaine de caractere contenant la liste entiere
     */
    @Override
    public String toString() {
        String s = "";
        if(tete==null) return null;
        else {
            if (tete.getSuivant() == null) return tete.toString();
            else {
                Maillon tmp = tete;
                while(tmp.getSuivant() != null){
                    s += tmp.toString();
                    tmp = tmp.getSuivant();
                }
            }
        }
        return s;
    }
}
