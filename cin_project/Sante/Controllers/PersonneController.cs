using Microsoft.AspNetCore.Mvc;

namespace Sante.Controllers;

[ApiController]
[Route("[controller]")]
public class PersonneController : ControllerBase
{

    [HttpGet("SelectAllUnites", Name = "SelectAllUnites")]
    public ActionResult SelectAllUnite()
    {
        Unite unit = new Unite();
        List<Unite> unites = unit.SelectAll();
        return Ok(unites);
    }

    [HttpGet("SelectCours/{symbole}", Name = "SelectCours")]
    public ActionResult SelectCours(string symbole)
    {
        Cours cours= new Cours();
        Cours c = cours.SelectCours(symbole);
        return Ok(c);
    }

    [HttpGet(Name = "SelectAll")]
    public ActionResult SelectAll()
    {
        Personne pers = new Personne();
        List<Personne> personnes = pers.SelectAll();
        return Ok(personnes);
    }


    [HttpGet("SelectByPerson/{cin}", Name = "SelectByPerson")]
    public ActionResult SelectByPerson(string cin)
    {
        Personne pers = new Personne();
        List<Personne> personnes = pers.SelectByPerson(cin);
        return Ok(personnes);
    }

    [HttpGet("SelectByCin/{cin}", Name = "SelectByCin")]
    public ActionResult SelectByCin(string cin)
    {
        Personne pers = new Personne();
        List<Personne> personnes = pers.SelectByCin(cin);
        return Ok(personnes);
    }

    [HttpGet("SelectInfoByCin/{cin}", Name = "SelectInfoByCin")]
    public ActionResult SelectInfoByCin(string cin)
    {
        List<Info> infos = Info.SelectInfoByCin(cin);
        return Ok(infos);
    }

    [HttpGet("SelectAntecedantByCin/{cin}", Name = "SelectAntecedantByCin")]
    public ActionResult SelectAntecedantByCin(string cin)
    {
        List<Antecedantt> antecedants = Antecedantt.SelectAntecedantByCin(cin);
        return Ok(antecedants);
    }


}
