package test.mybatis;

public class User {
	private Integer id;
	private String name;
	private Integer age;
	
	public User(){
		super();
	}
	
	
	public User(String name, Integer age){
		this.name = name;
		this.age = age;
	}

	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	
	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id : " + id +  "  name : " + name ;
	}
}
