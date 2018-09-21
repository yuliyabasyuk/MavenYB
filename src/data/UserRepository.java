package data;

public final class UserRepository {

	// Use Singleton, Repository
	private static volatile UserRepository instance; // volatile - doesn't cache.

	// Constructor
	private UserRepository() {

	}
	// static factory to return instance.
	public static UserRepository get() { 
		if (instance == null) {
			synchronized (UserRepository.class) {
				if (instance == null) {
					instance = new UserRepository();
				}
			}
		}
		return instance;
	}
	
	// Methods which use builder to create object of the user credentials:
	public IUser dfrUser22Login() {
		return User.get().setUsername("dfrdemo2.2@wsi.com").setPassword("wsi").build();
	}

	public IUser dfrUser23Login() {
		return User.get().setUsername("dfrdemo2.3@wsi.com").setPassword("wsi").build();
	}

	public IUser dfrInvUser22Login() {
		return User.get().setUsername("dfr").setPassword("zzz").build();
	}

	public IUser dfrInvUser23Login() {
		return User.get().setUsername("dfrdem.....o.3@wsi.com").setPassword("...").build();
	}

//	public static List<IUser> getNewUsersFromCsvFile() {
//	    return new UserUtils().getAllUsers();
//  }

//  public static List<IUser> getNewUsersFromExcelFile() {
//	    return new UserUtils("/newUsers.xlsx", new ExcelUtils()).getAllUsers();
//  }

//  public static List<IUser> getNewUsersFromDB() {
//	    return new UserUtils("/", new DBUtils()).getAllUsers();
//  }
}
