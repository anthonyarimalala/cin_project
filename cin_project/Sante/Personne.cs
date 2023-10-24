
namespace Sante;
using MySql;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;

public class Personne
{
    public string Cin { get; set; }
    public string Nom { get; set; }
    public string Prenom { get; set; }
    public DateTime DateNaissance { get; set; }

    public List<Personne> SelectAll()
    {
        MySqlConnection connection = MySqlConnectionHelper.GetConnection();
        List<Personne> personnes = new List<Personne>();

        string selectQuery = "SELECT * FROM personne";
        using (MySqlCommand command = new MySqlCommand(selectQuery, connection))
        {
            using (MySqlDataReader reader = command.ExecuteReader())
            {
                while (reader.Read())
                {
                    Personne personne = new Personne
                    {
                        Cin = reader["cin"].ToString(),
                        Nom = reader["nom"].ToString(),
                        Prenom = reader["prenom"].ToString(),
                        DateNaissance = Convert.ToDateTime(reader["date_naissance"])
                    };
                    personnes.Add(personne);
                }
            }
        }

        return personnes;
    }

    public List<Personne> SelectByPerson(string cin)
    {
        MySqlConnection connection = MySqlConnectionHelper.GetConnection();
        List<Personne> personnes = new List<Personne>();

        string selectQuery = $"SELECT * FROM personne WHERE cin LIKE '%{cin}%' OR nom LIKE '%{cin}%' OR prenom LIKE '%{cin}%' OR CONCAT(nom, ' ', prenom) LIKE '%{cin}%'";
        using (MySqlCommand command = new MySqlCommand(selectQuery, connection))
        {
            using (MySqlDataReader reader = command.ExecuteReader())
            {
                while (reader.Read())
                {
                    Personne personne = new Personne
                    {
                        Cin = reader["cin"].ToString(),
                        Nom = reader["nom"].ToString(),
                        Prenom = reader["prenom"].ToString(),
                        DateNaissance = Convert.ToDateTime(reader["date_naissance"])
                    };
                    personnes.Add(personne);
                }
            }
        }
        
        //Console.WriteLine(selectQuery);
        
        return personnes;
    }

    public List<Personne> SelectByCin(string cin)
    {
        MySqlConnection connection = MySqlConnectionHelper.GetConnection();
        List<Personne> personnes = new List<Personne>();

        string selectQuery = $"SELECT * FROM personne WHERE cin = '{cin}'";
        using (MySqlCommand command = new MySqlCommand(selectQuery, connection))
        {
            using (MySqlDataReader reader = command.ExecuteReader())
            {
                while (reader.Read())
                {
                    Personne personne = new Personne
                    {
                        Cin = reader["cin"].ToString(),
                        Nom = reader["nom"].ToString(),
                        Prenom = reader["prenom"].ToString(),
                        DateNaissance = Convert.ToDateTime(reader["date_naissance"])
                    };
                    personnes.Add(personne);
                }
            }
        }
        
        //Console.WriteLine(selectQuery);
        
        return personnes;
    }

}


public class MySqlConnectionHelper
{
    public static MySqlConnection GetConnection(){
        string connectionString = "Server=localhost;Database=cin_sante;User=root;Password=root;Charset=utf8;";
        MySqlConnection connection = new MySqlConnection(connectionString);


        try
        {
            connection.Open();
            return connection;
        }
        catch (MySqlException ex)
        {
            Console.WriteLine("Erreur de connexion à la base de données PostgreSQL : " + ex.Message);
            throw;
        }
    }
}


public class Info{
    // public int Id_info{ get; set; }
    // public string Cin { get; set; } 
    public string Allergie { get; set; }

    public static List<Info> SelectInfoByCin(string cin)
    {
        MySqlConnection connection = MySqlConnectionHelper.GetConnection();
        List<Info> infos = new List<Info>();

        string selectQuery = $"SELECT * FROM info WHERE cin = '{cin}'";
        using (MySqlCommand command = new MySqlCommand(selectQuery, connection))
        {
            using (MySqlDataReader reader = command.ExecuteReader())
            {
                while (reader.Read())
                {
                    Info info = new Info
                    {
                        // Id_info = Convert.ToInt32(reader["id_info"]),
                        // Cin = reader["cin"].ToString(),
                        Allergie = reader["allergie"].ToString()
                    };
                    infos.Add(info);
                }
            }
        }
        
        Console.WriteLine(selectQuery);
        
        return infos;
    }
}

public class Antecedantt{
    // public int Id_antecedant{ get; set; }
    // public string Cin { get; set; } 
    public string Antecedant { get; set; }

    public static List<Antecedantt> SelectAntecedantByCin(string cin)
    {
        MySqlConnection connection = MySqlConnectionHelper.GetConnection();
        List<Antecedantt> infos = new List<Antecedantt>();

        string selectQuery = $"SELECT * FROM antecedant WHERE cin = '{cin}'";
        using (MySqlCommand command = new MySqlCommand(selectQuery, connection))
        {
            using (MySqlDataReader reader = command.ExecuteReader())
            {
                while (reader.Read())
                {
                    Antecedantt info = new Antecedantt
                    {
                        // Id_antecedant = Convert.ToInt32(reader["id_antecedant"]),
                        // Cin = reader["cin"].ToString(),
                        Antecedant = reader["antecedant"].ToString()
                    };
                    infos.Add(info);
                }
            }
        }
        
        Console.WriteLine(selectQuery);
        
        return infos;
    }
}


public class Unite
{
    public string Symbole { get; set; }
    public string Libelle { get; set; }

    public List<Unite> SelectAll()
    {
        MySqlConnection connection = MySqlConnectionHelper.GetConnection();
        List<Unite> unites = new List<Unite>();

        string selectQuery = "SELECT * FROM unite";
        using (MySqlCommand command = new MySqlCommand(selectQuery, connection))
        {
            using (MySqlDataReader reader = command.ExecuteReader())
            {
                while (reader.Read())
                {
                    Unite unite = new Unite
                    {
                        Symbole = reader["symbole"].ToString(),
                        Libelle = reader["unite"].ToString()
                    };
                    unites.Add(unite);
                }
            }
        }

        return unites;
    }
}
public class Cours
{
    public int IdCours { get; set; }
    public string Symbole { get; set; }
    public double ValeurAriary { get; set; }
    public DateTime DateCours { get; set; }
    public double TauxVente { get; set; }

    public Cours SelectCours(string symbole)
    {
        MySqlConnection mysqlConnection = MySqlConnectionHelper.GetConnection();
        Cours result = null;

        string query = "SELECT * FROM cours WHERE symbole = @Symbole ORDER BY date_cours DESC LIMIT 1";
        using (MySqlCommand cmd = new MySqlCommand(query, mysqlConnection))
        {
            cmd.Parameters.AddWithValue("@Symbole", symbole);
            using (MySqlDataReader reader = cmd.ExecuteReader())
            {
                if (reader.Read())
                {
                    result = new Cours
                    {
                        IdCours = Convert.ToInt32(reader["id_cours"]),
                        Symbole = reader["symbole"].ToString(),
                        ValeurAriary = Convert.ToDouble(reader["valeur_ariary"]),
                        DateCours = Convert.ToDateTime(reader["date_cours"]),
                        TauxVente = Convert.ToDouble(reader["taux_vente"])
                    };
                }
            }
        }

        mysqlConnection.Close();
        return result;
    }
}
