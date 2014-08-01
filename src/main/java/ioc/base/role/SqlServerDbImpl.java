package ioc.base.role;

public class SqlServerDbImpl implements DbIntf {

	@Override
	public void save() {
		System.out.println("Oracle save!");
	}

	@Override
	public void update() {
		System.out.println("Oracle update!");
	}

	@Override
	public void delete() {
		System.out.println("Oracle delete!");
	}

}
