package shoppingcart;

public class ItemInfo {
    private Integer itemcode;
    private String itemname;
    private String itemdesc;
    private double itemprice;

    public ItemInfo(){}

    public ItemInfo(Integer itemcode, String itemname, String itemdesc, double itemprice) {
        this.itemcode = itemcode;
        this.itemname = itemname;
        this.itemdesc = itemdesc;
        this.itemprice = itemprice;
    }

    public Integer getItemcode() {
        return itemcode;
    }

    public void setItemcode(Integer itemcode) {
        this.itemcode = itemcode;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getItemdesc() {
        return itemdesc;
    }

    public void setItemdesc(String itemdesc) {
        this.itemdesc = itemdesc;
    }

    public double getItemprice() {
        return itemprice;
    }

    public void setItemprice(double itemprice) {
        this.itemprice = itemprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemInfo itemInfo = (ItemInfo) o;

        if (Double.compare(itemInfo.itemprice, itemprice) != 0) return false;
        if (!itemcode.equals(itemInfo.itemcode)) return false;
        if (!itemname.equals(itemInfo.itemname)) return false;
        return itemdesc.equals(itemInfo.itemdesc);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = itemcode.hashCode();
        result = 31 * result + itemname.hashCode();
        result = 31 * result + itemdesc.hashCode();
        temp = Double.doubleToLongBits(itemprice);
        result = 31 * result + (int) ( temp ^ ( temp >>> 32 ) );
        return result;
    }

    @Override
    public String toString() {
        return "ItemInfo{" +
                "itemcode=" + itemcode +
                ", itemname='" + itemname + '\'' +
                ", itemdesc='" + itemdesc + '\'' +
                ", itemprice=" + itemprice +
                '}';
    }
}
