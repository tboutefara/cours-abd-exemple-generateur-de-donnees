package dz.univjijel.generateurdonnees.core;


import java.sql.*;
import java.util.Random;

public class ChargerDonneesAleatoires {

    public static String PRENOMS[] = {"Mohammed", "Abubakr", "Omar", "Othmane", "Ali", "Khaled",
        "Soufiane", "Karim", "Houcine", "Rabeh"};
    public static String NOMS[] = {"Benamer", "Kaouche", "Brik", "Laggoune", "Bensalem", "Sahraoui",
        "Benabdallah", "Didouche", "Benbouali", "Amirouche"};

    final static String URLSGBD = "jdbc:mysql://localhost:3306/LargeDonnees"; // Fix this value depending on the name
                                    // you gave to your database.
    final static String USER = "tarek"; // Fix this value according to your configuration
    final static String PASSWORD = "tarek";

    public static void lancerChargement(long nombre) {

        Random random = new Random();

        // Chargement des données SQL
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URLSGBD, USER, PASSWORD);

            Statement st = con.createStatement();

            System.out.println("Chargement de " + nombre + " ligne(s)");
            
            int pourcentage = 0;

            for (long i = 0; i < nombre; i++) {
                
                if(i % (nombre / 100) == 0){
                    pourcentage++;
                    System.out.println(pourcentage + "% accompli");
                }

                int posNoms = random.nextInt(10);
                int posPrenom = random.nextInt(10);

                String requete = "Insert into Personne (nom, prenom) Values ('" + NOMS[posNoms] + "', '" + PRENOMS[posPrenom] + "')";
                st.executeUpdate(requete);

            }

            st.close();
            con.close();

        } catch (SQLException sqle) {
            System.out.println("Erreur avec la base des donénes");
        } catch (ClassNotFoundException e) {
            System.out.println("Pilote introuvable");
        }

    }

}
