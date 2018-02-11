package LeJeuDeLaVie;

import java.util.Objects;

/**
 *
 */
public class Maillon<T>{

    // Attributs
    private T info;
    private Maillon<T> suivant;

    /** Constructeur du maillon
     *
     */
    public Maillon() {

    }

    /** Constructeur du maillon
     *
     * @param suivant : Maillon suivant
     * @param info : Coordonnee
     */
    public Maillon(T info, Maillon<T> suivant) {
        this.suivant = suivant;
        this.info = info;
    }

    // Methodes

    /** Retourne le maillon suivant
     *
     * @return maillon.suivant : Champ suivant du maillon
     */
    public Maillon<T> getSuivant() {
        return suivant;
    }

    /** Affecte le maillon suivant au champ suivant
     *
     * @param suivant : Maillon suivant
     */
    public void setSuivant(Maillon<T> suivant) {
        this.suivant = suivant;
    }

    /** Retourne l'objet du champ info
     *
     * @return objet du champ info
     */
    public T getInfo() {
        return info;
    }

    /** Affecte un objet au champ info
     *
     * @param info : Objet à affecter
     */
    public void setInfo(T info) {
        this.info = info;
    }

    public boolean equals(Maillon<T> o) {
        if (this == o) return true;
        if (!(o instanceof Maillon)) return false;
        return o.getInfo().equals(this.getInfo());
    }


    /**
     * Retourne les coordonnees contenues dans le maillon sous forme de chaine de caracteres
     *
     * @return : Chaine de caractere contenant les coordonnees
     *
     */
    @Override
    public String toString() {
        return "Maillon{" +
                "info=" + info +
                '}';
    }
}
