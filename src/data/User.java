package data;

interface IUsername {
	IPassword setUsername(String username);
}

interface IPassword {
	IUserBuilder setPassword(String password);
}

// Add ILoginBtn in which we'll have IUserBuilder clickLoginBtn ??

interface IUserBuilder {
	IUser build();
}

public class User implements IUsername, IPassword, IUserBuilder, IUser {

	// Fields
	private String username;
	private String password;

	// Constructor
	private User() {

	}

	// Static Factory
	public static IUsername get() { // public static IUser get()
		return new User(); // return constructor (because it is private).
	}

	// Setters
	public IPassword setUsername(String username) {
		this.username = username;
		return this;
	}

	public IUserBuilder setPassword(String password) {  // try to change IUserBuilder to IUserLogin ?
		this.password = password;
		return this;
	}

	public IUser build() {
		return this;
	}

	// Getters
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
