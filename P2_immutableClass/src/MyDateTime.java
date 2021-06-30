import java.util.Date;

/*This is a immutable class example, create a immutable class you need set all attribute to with final keyword, and only provide get method to
access attribute*/
public final class MyDateTime {
	private final String name;
	private final Date date;

	public MyDateTime(String name, Date date) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.date = date;
	}
	public String getName() {
		return this.name;
	}
	public String getDate() {
		return date.toString();
	}

}
