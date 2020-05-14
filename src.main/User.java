public class User {
    private String name;
    private String password;

    public User(){
        this.name = "";
        this.password = "";
    }

    public User(String name, String password)
    {
        this.name = name;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }


    public boolean checkUsername(String username) {
        if ((username.length() <= 5) || (username.length() > 15))
        {
            return false;
        }
        else
        {
            return username.matches("[a-zA-Z0-9]+");
        }
    }

    public boolean checkPassword(String password)
    {
        return (password.length() >= 7) && (password.length() <= 12);
    }



    public boolean equals(Object o)
    {
        return (o instanceof User) && ( ((User) o).name.equals(this.name) && ((User) o).password.equals(this.password));
    }

    public String toString()
    {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", password='" + password + '\''+
                '}';
    }
}
