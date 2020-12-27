package shoppingcart;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.*;

public class Invent {
        private Map<ItemInfo, Integer> stock = new HashMap<ItemInfo, Integer>();

        public Invent() throws IOException {
            load();
        }
        private void load() throws IOException {
            Workbook wb = new XSSFWorkbook("./StockInfo.xlsx");
            Sheet sh = wb.getSheetAt(0);
            int lastRow = sh.getLastRowNum();
            for(int i=1; i<=lastRow;i++){
                Row row = sh.getRow(i);
                Cell itemcode = row.getCell(0);
                Cell itemname = row.getCell(1);
                Cell itemdesc = row.getCell(2);
                Cell itemprice = row.getCell(3);
                Cell itemquantity = row.getCell(4);
                ItemInfo it = new ItemInfo();
                it.setItemcode((int)itemcode.getNumericCellValue());
                it.setItemname(itemname.getStringCellValue());
                it.setItemdesc(itemdesc.getStringCellValue());
                it.setItemprice(itemprice.getNumericCellValue());
                int quan = (int)itemquantity.getNumericCellValue();
                stock.put(it, quan);
            }
           // System.out.println(stock.get(it));
        }

        public int getItemStock(ItemInfo it) {
            return stock.get(it);
        }

        public boolean validateItem(ItemInfo it) throws ItemNotFoundException{
            Set<ItemInfo> currentitem = new HashSet<ItemInfo>();
            for(ItemInfo itn: currentitem){
                itn.getItemcode().equals(it.getItemcode());
            }
            return true;
        }

        public Map<Integer, String> getItemCatalogue(){
            Map<Integer, String> getItem = new HashMap<Integer, String>();
            Set<ItemInfo> cic = stock.keySet();
            for (ItemInfo itn: cic){
                Integer currentitemcode = itn.getItemcode();
                String currentitemname = itn.getItemname();
                getItem.put(currentitemcode,currentitemname);
            }
            return getItem;
        }

        boolean reduceStock(ItemInfo it, Integer qu)throws ItemNotFoundException{
           //***if(validateItem(it)) {//Include Validateitem method***
            Integer currentquan = stock.get(it);
            currentquan = currentquan-qu;
            //stock.put(it,currentquan);
            return true;
        }

        boolean increaseStock(ItemInfo it){
            Integer currentquan = stock.get(it);
            currentquan += currentquan ;
            stock.put(it,currentquan);
            return true;
        }

        public static void main(String[] args) throws IOException {
            Invent inv = new Invent();
            System.out.println(inv.getItemCatalogue());
            ItemInfo it = new ItemInfo(1002, "S10", "Samsung", 830.0);
            ItemInfo in = new ItemInfo(1002, "IPhone12", "Apple", 800.0);
            ItemInfo in1 = new ItemInfo(1003, "Pro20", "Huawei", 740.0 );
            if (inv.validateItem(in)){
                System.out.println("Valid Item");
            }

            inv.getItemStock(it);

            inv.reduceStock(in1, 10);

        }
}
