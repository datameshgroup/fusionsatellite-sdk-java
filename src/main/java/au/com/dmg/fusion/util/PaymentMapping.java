package au.com.dmg.fusion.util;

import au.com.dmg.fusion.data.EntryMode;
import au.com.dmg.fusion.data.PaymentBrand;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PaymentMapping {

    private static final List<PaymentTypeMapping> paymentTypeMappings = Arrays.asList(
            new PaymentTypeMapping("Scheme", "eftpos", "0001", PaymentBrand.Card),
            new PaymentTypeMapping("Scheme", "Mastercard Debit", "0002", PaymentBrand.Mastercard),
            new PaymentTypeMapping("Scheme", "Mastercard Debit", "0002", PaymentBrand.Mastercard),
            new PaymentTypeMapping("Scheme", "Mastercard Credit", "0003", PaymentBrand.Mastercard),
            new PaymentTypeMapping("Scheme", "Visa Debit", "0004", PaymentBrand.VISA),
            new PaymentTypeMapping("Scheme", "Visa Credit", "0005", PaymentBrand.VISA),
            new PaymentTypeMapping("Scheme", "American Express", "0006", PaymentBrand.AmericanExpress),
            new PaymentTypeMapping("Scheme", "JCB", "0007", PaymentBrand.JCB),
            new PaymentTypeMapping("Scheme", "Diners", "0008", PaymentBrand.DinersClub),
            new PaymentTypeMapping("Scheme", "China Union Pay Credit", "0009", PaymentBrand.UnionPay),
            new PaymentTypeMapping("Scheme", "China Union Pay Debit", "0010", PaymentBrand.CUPDebit),
            new PaymentTypeMapping("Scheme", "Cabcharge Gift Card", "0011", PaymentBrand.Card),
            new PaymentTypeMapping("Scheme", "Discover", "0012", PaymentBrand.Discover),
            new PaymentTypeMapping("Scheme", "American Express International", "0013", PaymentBrand.AmericanExpress),
            new PaymentTypeMapping("Scheme", "Diners International", "0014", PaymentBrand.DinersClub),
            new PaymentTypeMapping("Scheme", "JCB International", "0015", PaymentBrand.JCB),
            new PaymentTypeMapping("Scheme", "Mastercard International", "0016", PaymentBrand.Mastercard),
            new PaymentTypeMapping("Scheme", "VISA International", "0017", PaymentBrand.VISA),
            new PaymentTypeMapping("Scheme", "UnionPay International", "0018", PaymentBrand.UnionPay),
            new PaymentTypeMapping("Scheme", "Discover International", "0019", PaymentBrand.Discover),

            new PaymentTypeMapping("Fuel card", "BP Card", "0100", PaymentBrand.BPFuelCard),
            new PaymentTypeMapping("Fuel card", "BP Gift Card", "0101", PaymentBrand.BPGiftCard),
            new PaymentTypeMapping("Fuel card", "Fleet Card", "0102", PaymentBrand.FleetCard),
            new PaymentTypeMapping("Fuel card", "Shell Card", "0103", PaymentBrand.ShellCard),
            new PaymentTypeMapping("Fuel card", "Motorpass", "0104", PaymentBrand.Motorpass),
            new PaymentTypeMapping("Fuel card", "Motorcharge", "0105", PaymentBrand.Motorcharge),
            new PaymentTypeMapping("Fuel card", "Ampol card", "0106", PaymentBrand.AmpolCard),
            new PaymentTypeMapping("Fuel card", "Freedom fuel card", "0107", PaymentBrand.FreedomFuelCard),
            new PaymentTypeMapping("Fuel card", "Trinity fuel card", "0108", PaymentBrand.TrinityFuelCard),
            new PaymentTypeMapping("Fuel card", "Liberty Card", "0109", PaymentBrand.LibertyCard),
            new PaymentTypeMapping("Fuel card", "Caltex StarCard", "0110", PaymentBrand.CaltexStarCard),
            new PaymentTypeMapping("Fuel card", "United Fuel Card", "0111", PaymentBrand.UnitedFuelCard),
            new PaymentTypeMapping("Fuel card", "OTR Card", "0112", PaymentBrand.OTRCard),

            new PaymentTypeMapping("Transit card", "Fastcard", "0201", PaymentBrand.Fastcard),
            new PaymentTypeMapping("Transit card", "eTicket", "0202", PaymentBrand.eTicket),
            new PaymentTypeMapping("Transit card", "Digital Product", "0203", PaymentBrand.DigitalProduct),
            new PaymentTypeMapping("Transit card", "ACT TSS", "0204", PaymentBrand.ACTTSS),
            new PaymentTypeMapping("Transit card", "NSW TTSS", "0205", PaymentBrand.NSWTSS),
            new PaymentTypeMapping("Transit card", "NT TSS", "0206", PaymentBrand.NTTSS),
            new PaymentTypeMapping("Transit card", "QLD TSS", "0207", PaymentBrand.QLDTSS),
            new PaymentTypeMapping("Transit card", "TAS TSP", "0208", PaymentBrand.TASTSS),
            new PaymentTypeMapping("Transit card", "CPVV MPTP", "0209", PaymentBrand.CPVVMPTP),

            new PaymentTypeMapping("Alternative payment", "Crypto.com", "0300", PaymentBrand.CryptoDotCom),
            new PaymentTypeMapping("Alternative payment", "Alipay", "0301", PaymentBrand.AliPay),
            new PaymentTypeMapping("Alternative payment", "WeChat", "0302", PaymentBrand.WeChatPay),

            new PaymentTypeMapping("Loyalty", "Qantas Points", "0400", PaymentBrand.Qantas),
            new PaymentTypeMapping("Loyalty", "DRC", "0401", PaymentBrand.DRC),

            new PaymentTypeMapping("Other", "Cash", "0500", PaymentBrand.Cash)
    );

    private static final List<PaymentMethodMapping> paymentMethodMappings = Arrays.asList(
            new PaymentMethodMapping("Swipe", EntryMode.MagStripe),
            new PaymentMethodMapping("Insert", EntryMode.ICC),
            new PaymentMethodMapping("Tap", EntryMode.Tapped),
            new PaymentMethodMapping("Manual Entry", EntryMode.Keyed),
            new PaymentMethodMapping("MOTO", EntryMode.Manual),
            new PaymentMethodMapping("Scanned", EntryMode.Scanned),
            new PaymentMethodMapping("Online", EntryMode.Keyed),
            new PaymentMethodMapping("Cash", EntryMode.Unknown),
            new PaymentMethodMapping("PayOnOtherTerminal", EntryMode.Unknown),
            new PaymentMethodMapping("File",EntryMode.File)
    );

    private static final PaymentBrand unknownPaymentBrand = PaymentBrand.Other;


    public static ProductIDDetails getProductIDDetails(String productID) {
        for (PaymentTypeMapping mapping : paymentTypeMappings) {
            if (mapping.getId().equals(productID)) {
                return new ProductIDDetails(mapping.getPaymentBrand());
            }
        }
        return null;
    }

    public static EntryMode getMethodEntryMode(String method) {
        for (PaymentMethodMapping mapping : paymentMethodMappings) {
            if (mapping.getMethod().equals(method)) {
                return mapping.getEntryMode();
            }
        }
        System.out.println("ERROR: FusionSatelliteAPI | PaymentMapping | Unable to locate Entry Mode details for Method: " + method);
        return null;
    }

    public static PaymentBrand getPaymentBrand(String ProductID) {
        PaymentBrand paymentBrandResult;

        ProductIDDetails productIDDetails = getProductIDDetails(ProductID);
        if (productIDDetails != null) {
            paymentBrandResult = productIDDetails.getPaymentBrand();
        } else {
            System.out.println("ERROR: FusionSatelliteAPI | PaymentMapping | Unable to locate Payment Brand details for Product ID: " + ProductID);
            paymentBrandResult = unknownPaymentBrand;
        }

        System.out.println("FusionSatelliteAPI | PaymentMapping | getPaymentBrand() returns " + paymentBrandResult);
        return paymentBrandResult;
    }
}

class PaymentTypeMapping {

    private String category;
    private String name;
    private String id;
    private PaymentBrand paymentBrand;

    public PaymentTypeMapping(String category, String name, String id, PaymentBrand paymentBrand) {
        this.category = category;
        this.name = name;
        this.id = id;
        this.paymentBrand = paymentBrand;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public PaymentBrand getPaymentBrand() {
        return paymentBrand;
    }
}

class PaymentMethodMapping {

    private String method;
    private EntryMode entryMode;

    public PaymentMethodMapping(String method, EntryMode entryMode) {
        this.method = method;
        this.entryMode = entryMode;
    }

    public String getMethod() {
        return method;
    }

    public EntryMode getEntryMode() {
        return entryMode;
    }
}

class ProductIDDetails {

    private PaymentBrand paymentBrand;

    public ProductIDDetails(PaymentBrand paymentBrand) {
        this.paymentBrand = paymentBrand;
    }

    public PaymentBrand getPaymentBrand() {
        return paymentBrand;
    }
}

