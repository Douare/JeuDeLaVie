package LeJeuDeLaVie;

/**
 *
 */
public class Liste<T>{

    // Attributs
    private Maillon<T> tete;

    // Constructeur

    /**
     * Initialise la liste a null
     */
    public Liste() {
        this.tete = null;
    }

    /**
     * Initialise la liste avec un maillon
     *
     * @param tete : maillon de tete
     */
    public Liste(Maillon<T> tete) {
        this.tete = tete;
    }

    // Methodes

    /**
     * Retourne le premier maillon de la liste
     *
     * @return : tete de la liste
     */
    public Maillon<T> getTete() {
        return tete;
    }

    /**
     * Affecte une nouvelle tete de liste a la liste avec le maillon passe en parametre
     *
     * @param tete : nouvelle tete de liste
     */
    public void setTete(Maillon<T> tete) {
        this.tete = tete;
    }

    // Ayoub
    /**
     * Ajoute un maillon en debut de liste
     *
     * @param m
     */
    public void ajouterEnTete(Maillon<T> m) {
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


    //Uzay

    /**
     * Retourne un entier correspondant a la taille de la liste
     *
     * @return : la taille de la liste
     */
    public int taille() {
        Maillon<T> tmp = this.tete;
        int taille = 0;
        while (tmp != null) {
            taille++;
            tmp = tmp.getSuivant();
        }
        return taille;
    }

    //JULIETTE ET OZGUR LA BONNE

    public void ajouterMaillon(Maillon<T> m) {
        if(m.getInfo() instanceof Coordonnee) {
            if(this.estVide()) {
                this.ajouterEnTete(m);
            } else {
                Maillon<Coordonnee> tmp = (Maillon<Coordonnee>) this.getTete();
                Maillon<Coordonnee> mc = (Maillon<Coordonnee>) m;

                if (mc.getInfo().compareTo(tmp.getInfo()) == -1) {
                    this.ajouterEnTete(m);
                } else {
                    if (tmp.getSuivant() != null) {
                        while ((tmp.getSuivant() != null) && mc.getInfo().compareTo(tmp.getSuivant().getInfo()) == 1) {
                            tmp = tmp.getSuivant();
                        }
                    }
                    mc.setSuivant(tmp.getSuivant());
                    tmp.setSuivant(mc);
                }
            }
        } else {
            this.ajouterEnTete(m);
        }
    }

    //Uzay

    /**
     *
     * @return : la plus petite colonne
     */
    public int minColonne(){
        if(estVide()){
            return 0;
        }else{
            int c;
            Maillon<T> m=getTete();
            c=((Coordonnee)m.getInfo()).getColonne();
            m=m.getSuivant();
            while (m!=null){
                if(((Coordonnee)m.getInfo()).getColonne()<c){
                    c=((Coordonnee)m.getInfo()).getColonne();
                }
                m=m.getSuivant();
            }
            return c;
        }
    }

    //Uzay

    /**
     *
     * @return : la plus petite ligne
     */
    public int minLigne(){
        if(estVide()){
            return 0;
        }else{
            return ((Coordonnee)getTete().getInfo()).getLigne();
        }
    }

    //Uzay

    /**
     *
     * @return : la plus grande colonne
     */
    public int maxColonne(){
        if(estVide()){
            return 0;
        }else{
            int c;
            Maillon<T> m=getTete();
            c=((Coordonnee)m.getInfo()).getColonne();
            m=m.getSuivant();
            while (m!=null){
                if(((Coordonnee)m.getInfo()).getColonne()>c){
                    c=((Coordonnee)m.getInfo()).getColonne();
                }
                m=m.getSuivant();
            }
            return c;
        }
    }

    //Uzay

    /**
     *
     * @return : la plus grande ligne
     */
    public int maxLigne(){
        if (estVide()){
            return 0;
        }else{
            Maillon<T> tmp = getTete();
            while(tmp.getSuivant()!=null){
                tmp=tmp.getSuivant();
            }
            return ((Coordonnee)tmp.getInfo()).getLigne();
        }
    }

    // Uzay
    /**
     * Retourne la liste sous forme de chaine de caracteres
     *
     * @return : Une chaine de caractere contenant la liste entiere
     */
    @Override
    public String toString() {
        String s = "";
        if (this.estVide()) {
            return s;
        } else {
            int minColonne = minColonne();
            int maxColonne = maxColonne();
            int minLigne = minLigne();
            int maxLigne = maxLigne();
            System.out.print(maxLigne + "\n");

            Liste<Coordonnee> lc = new Liste<Coordonnee>();

            for (int l = minLigne; l <= maxLigne; l++){
                for (int c = minColonne; c <= maxColonne; c++){
                    lc.ajouterMaillon(new Maillon<Coordonnee>(new Coordonnee(l,c), null));
                }
            }

            Maillon<Coordonnee> tmplc = lc.getTete();
            Maillon<Coordonnee> tmp = (Maillon<Coordonnee>) this.getTete();

            int compteurC = minColonne;
            int compteurL = minLigne;

            if (tmp.getSuivant() != null) {
                Maillon<Coordonnee> suiv = tmp.getSuivant();
                Maillon<Coordonnee> suivlc = tmplc.getSuivant();
                while (suiv != null) {
                    while (tmp.getInfo().compareTo(tmplc.getInfo()) != 0 && suivlc != null) {
                        if (compteurC > maxColonne) {
                            s += "\n";
                            compteurL++;
                            compteurC = minColonne;
                        }
                        s += ".";
                        compteurC++;
                        suivlc = suivlc.getSuivant();
                        tmplc = tmplc.getSuivant();
                    }
                    if (tmp.getInfo().compareTo(tmplc.getInfo()) == 0) {
                        s += "*";
                        compteurC++;
                        suivlc = suivlc.getSuivant();
                        tmplc = tmplc.getSuivant();
                        if (compteurC > maxColonne) {
                            s += "\n";
                            compteurL++;
                            compteurC = minColonne;
                        }
                    }
                    suiv = suiv.getSuivant();
                    tmp = tmp.getSuivant();
                }
            }

            //refait pour le dernier maillon
            if (tmp != null && tmplc != null) {
                if (tmp.getInfo().compareTo(tmplc.getInfo()) == 0) {
                    s += "*";
                    compteurC++;
                    if (compteurC > maxColonne) {
                        s += "\n";
                        compteurL++;
                        compteurC = minColonne;
                    }
                } else {
                    s += ".";
                }
            }
            return s;
        }
    }

    // Juliette

    /**
     * Supprime un maillon de la liste
     *
     * @param m : maillon a supprimer
     */
    public void supprimerMaillon(Maillon<T> m) {
        if (tete.equals(m)) {
            tete = tete.getSuivant();
        } else {
            Maillon<T> tmp = tete;
            while (!(tmp.getSuivant() == null)) {
                if (tmp.getSuivant().equals(m)) {
                    tmp.setSuivant(tmp.getSuivant().getSuivant());
                    break;
                } else tmp = tmp.getSuivant();
            }
        }
    }
}