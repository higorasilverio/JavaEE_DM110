package br.inatel.dm110.impl.example;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;

import br.inatel.dm110.api.example.HelloService;
import br.inatel.dm110.api.example.MessageTO;

@RequestScoped
public class HelloServiceImpl implements HelloService {
 
	// in memory cache
	private HelloMemoryDAO dao = new HelloMemoryDAO();

	private static Logger log = Logger.getLogger(HelloServiceImpl.class.getName());

	@Override
	public String sayHello(String name) {
		log.info("name: " + name);
		return "Status OK. Name provided: " + name + ". Hello, " + name + "!";
	}

	@Override
	public Response getMessage(Integer id) {
		log.info("retrieving message: " + id);
		MessageTO msg = dao.getMessage(id);
		if (msg != null) {
			return Response.ok(msg).build();
		}
		return Response.noContent().build();
	}

	@Override
	public Response storeNewMessage(MessageTO message) {
		log.info("storing message: " + message);
		int id = dao.storeNewMessage(message);
		return Response.ok(String.valueOf(id)).build();
	}

	@Override
	public Response getAllMessages() {
		log.info("retrieving all messages.");
		return Response.ok(dao.getMessages()).build();
	}

	@Override
	public MessageTO postMessage(String first, String last) {
		MessageTO msg = dao.createMessage(first, last);
		dao.storeNewMessage(msg);
		log.info("posting new message: " + msg.getMessage());
		return msg;
	}
}
