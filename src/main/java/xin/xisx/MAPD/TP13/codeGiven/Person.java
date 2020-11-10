package xin.xisx.MAPD.TP13.codeGiven;

public class Person {

	private final String firstName;
    private final String surname;
    private final Citizenship citizenship;

    public Person(String firstName, String surname, Citizenship citizenship) {
        this.firstName = firstName;
        this.surname = surname;
        this.citizenship = citizenship;
    }
    public String getFirstName() {
		return firstName;
	}
	public String getSurname() {
		return surname;
	}
	public Citizenship getCitizenship() {
		return citizenship;
	}
	@Override
	public String toString() {
		return "Person(" + firstName + ", " + surname + ", " + citizenship + ")";
	}
}
