import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class Service {
    @RequestMapping("/api/get-location")
    String m1() {
        return "Bangkok";
    }

    @RequestMapping("/api/get-products")
    String[] m2() {
        String[] data = { "Latte", "Mocha" };
        return data;
    }

    @RequestMapping("/api/get-hq-name")
    String m3() {
        return hq.name;
    }

    @Autowired
    HeadQuarter hq;

    // http://localhost:8080/api/get-total?price=120
    @RequestMapping("/api/get-total")
    String m4(String price) {
        try {
            double p = Double.valueOf(price);
            return "" + p * 1.07;
        } catch (Exception e) {
            return "Invalid price";
        }
    }
}

@Component
class HeadQuarter {
    String name = "Atlanta";
}
