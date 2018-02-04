package LeJeuDeLaVie;

public class Verification {


    //Juliette
    public boolean estVaisseau(Liste l1, Liste l2){
        if(l1.taille()==l2.taille()){
            Maillon<Coordonnee> tmp1=l1.getTete();
            Maillon<Coordonnee> tmp2=l2.getTete();
            Coordonnee vecteur = tmp1.getInfo().distanceCoordonnee(tmp2.getInfo()); //vecteur modele entre les coordonnees du premier maillon de chaque liste

            for(int i=1; i<=l1.taille();i++){
                tmp1=tmp1.getSuivant(); //coordonnee tmp1
                tmp2=tmp2.getSuivant();//coordonnee tmp2
                if(!(tmp1.getInfo().distanceCoordonnee(tmp2.getInfo()).equals(vecteur)))return false;

            }
            return  true;

        }else return false;

    }

    public boolean estOscillateur(Liste l1, Liste l2){
        if(l1.taille()==l2.taille()){
            Maillon<Coordonnee> tmp1=l1.getTete();
            Maillon<Coordonnee> tmp2=l2.getTete();

            for(int i=1; i<=l1.taille();i++){
                if(tmp1.getInfo().equals(tmp2.getInfo())){
                    tmp1 = tmp1.getSuivant(); //coordonnee tmp1
                    tmp2 = tmp2.getSuivant();//coordonnee tmp2
                    }else return false;
            }
            return  true;

        }else return false;

    }




}

