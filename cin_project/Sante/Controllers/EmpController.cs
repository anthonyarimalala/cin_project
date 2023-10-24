using Microsoft.AspNetCore.Mvc;

namespace Sante.Controllers;

[ApiController]
[Route("[controller]")]
public class EmpController : ControllerBase
{
    [HttpGet(Name = "GetEmp")]
    public ActionResult Get()
    {
        Emp e = new Emp();
        e.Nom="Kantyyyy";
        return Ok(e);
    }
}
