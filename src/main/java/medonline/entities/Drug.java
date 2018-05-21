package medonline.entities;

public class Drug {
    private int id_drug;
    private String drug_name;
    private int id_provider;
    private float price;
    private int quantity;
    private int ir_class;

    public Drug() {
    }

    public Drug(int id_drug, String drug_name, int id_provider, float price, int quantity, int ir_class) {
        this.id_drug = id_drug;
        this.drug_name = drug_name;
        this.id_provider = id_provider;
        this.price = price;
        this.quantity = quantity;
        this.ir_class = ir_class;
    }

    public int getId_drug() {
        return id_drug;
    }

    public void setId_drug(int id_drug) {
        this.id_drug = id_drug;
    }

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public int getId_provider() {
        return id_provider;
    }

    public void setId_provider(int id_provider) {
        this.id_provider = id_provider;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIr_class() {
        return ir_class;
    }

    public void setIr_class(int ir_class) {
        this.ir_class = ir_class;
    }


    @Override
    public String toString() {
        return "Drug{" +
                "id_drug=" + id_drug +
                ", drug_name='" + drug_name + '\'' +
                ", id_provider=" + id_provider +
                ", price=" + price +
                ", quantity=" + quantity +
                ", ir_class=" + ir_class +
                '}';
    }
}
