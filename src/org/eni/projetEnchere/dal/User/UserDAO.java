/**
 *
 */
package org.eni.projetEnchere.dal.User;

import org.eni.projetEnchere.bo.Utilisateur;

/**
 * @author var_dump
 *
 */
public interface UserDAO {
//
//   private int no_utilisateur;
//    private String pseudo;
//    private String nom;
//    private String prenom;
//    private String email;
//    private String telephone;
//    private String rue;
//    private String code_postal;
//    private String ville;
//    private String mot_de_passe;
//    private int credit;
//    private int administrateur;
//
	public int connect(String email, String mot_de_passe, boolean choice_requete) throws Exception;

//
//	En tant qu’utilisateur,
//	je peux m’inscrire sur la plateforme Enchères.org. Le pseudo doit être unique sur toute la plateforme, ainsi que l’email.
//	Le pseudo n’accepte que des caractères alphanumériques.
//	Si la création du profil est validée,
//	l’utilisateur est dirigé vers la page d’accueil (liste des enchères).
//	Le crédit initial est de 0
//
	public Utilisateur subscribe(Utilisateur newUser) throws Exception;

	boolean check_unique_pseudo_and_email(String pseudo, String email);

	public Utilisateur get_infos_profile(int id) throws Exception;

	void update_user(int id, String pseudo, String nom, String prenom, String email, String telephone, String rue, String code_postal, String ville, String mot_de_passe) throws Exception;

	void delete_user(int id) throws Exception;
	
}
