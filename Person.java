
public abstract class Person {

    private String id;
    private String name;
    private String password;

    /**
     * person constructor.
     *
     * @param id of the person.
     * @param name of the person.
     * @param password of person's account.
     */
    public Person(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    /**
     * sets the name of the person's name.
     *
     * @param name to be set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return person's name.
     */
    public String getName() {
        return name;
    }

    /**
     * sets id of the person's id.
     *
     * @param id to be set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return person's id.
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return person's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * sets person's password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
