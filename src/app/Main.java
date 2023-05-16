package app;
import app.ProductService;

public class Main {
    public static void main(String[] args) {
        var productService = new ProductService();
        var productId = productService.findId(107);
        var productName = productService.findName("消し");

//        //インサート
//        var productinsert = new ProductRecord(106, "ノート", 500);
//        var insert = productService.insert(productinsert);
//        System.out.println(insert);

        //アップデート
//        var productupdate = new ProductRecord(106,"筆箱",1000);
//        var update = productService.update(productupdate);
//        System.out.println(update);

        //デリート
//        var delete = productService.delete(106);
//        System.out.println(delete);

        productId.stream().forEach(System.out::println);
        productName.stream().forEach(System.out::println);
    }
}