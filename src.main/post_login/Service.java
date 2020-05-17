package post_login;

public class Service {
    String name;
    double price;
    //Date date;

    public Service()
    {
        this.name = "";
        this.price = 0;
    }

    public Service(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//

    public String toString()
    {
        return "Service{" +
                "name='" + name + '\'' +
                ", price='" + price + '\''+
                '}';
    }

    public boolean equals(Object o)
    {
        return (o instanceof Service) && ( (Service) o).name.equals(this.name) && (((Service) o).price == this.price); //&& ((Service) o).date.equals(this.date))
    }
}
