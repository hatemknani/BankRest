package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PreDestroy;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bank")
public class BankRestService {
	
	private static Map<Integer, Account> accounts = new HashMap<Integer, Account>();

	@GET
	@Path("/conversion/{amount}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public double conversion(@PathParam (value="amount") double amt){
		return amt*3.3;
	}
	
	@GET
	@Path("/accounts/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Account getAccount(@PathParam (value="code") int code){
		return accounts.get(code);
	}
	
	@GET
	@Path("/accounts")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Account> listAccounts(){
		/*List<Account> list = new ArrayList<>();
		list.add(new Account(1, Math.random()*67500, new Date()));
		list.add(new Account(2, Math.random()*67500, new Date()));
		list.add(new Account(3, Math.random()*67500, new Date()));
		return list;
		*/
		return new ArrayList<>(accounts.values());
	}
	
	@POST
	@Path("/accounts")
	@Produces(MediaType.APPLICATION_JSON)
	public Account save(Account acc){
		acc.setDateCreation(new Date());
		accounts.put(acc.getCode(), acc);
		return acc;
	}
	
	@PUT
	@Path("/accounts/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public Account update(Account acc, @PathParam (value="code") int code){
		accounts.put(code, acc);
		return acc;
	}

	@DELETE
	@Path("/accounts/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam (value="code") int code){
		accounts.remove(code);
	}

}
