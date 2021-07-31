package br.inatel.dm110.impl.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.inatel.dm110.api.example.MessageTO;

public class HelloMemoryDAO {

	private static int count = 0;

	// only for class example: in memory storage
	private static Map<Integer, MessageTO> cache = new HashMap<>();

	public MessageTO getMessage(Integer id) {
		return cache.get(id);
	}

	public int storeNewMessage(MessageTO message) {
		message.setMessage("Hello " + message.getFirstName() + " " + message.getLastName());
		cache.put(count++, message);
		return count;
	}

	public Collection<MessageTO> getMessages() {
		return cache.values();
	}

	public MessageTO createMessage(String first, String last) {
		MessageTO result = new MessageTO();
		result.setFirstName(first);
		result.setLastName(last);
		String message = String.format("Hello %s %s!!!", first, last);
		result.setMessage(message);
		return result;
	}
}

