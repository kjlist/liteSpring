package v4.entity;


import beans.factory.annotation.Autowired;
import stereotype.Component;

@Component(value="petStore")

public class PetStoreService {
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private ItemDao  itemDao;
	
	public AccountDao getAccountDao() {
		return accountDao;
	}

	public ItemDao getItemDao() {
		return itemDao;
	}
	
	
}