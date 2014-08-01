package ioc.base.role;

public class MySqlDbImpl implements DbIntf {

	@Override
	public void save() {
		System.out.println("MySql save!");
	}

	@Override
	public void update() {
		System.out.println("MySql update!");
	}

	@Override
	public void delete() {
		System.out.println("MySql delete!");
	}

}
