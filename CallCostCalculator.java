public class CallCostCalculator {
    public static double calculateCost(double time, String callRegion) {
        double baseRateFirstMinute_domestic = 1000.0;
        double baseRateMinutes1To5_domestic = 1500.0;
        double baseRateAfterMinute5_domestic = 2000.0;
        double baseRateFirstMinute_international = 1500.0;
        double baseRateMinutes1To5_international = 2000.0;
        double baseRateAfterMinute5_international = 2500.0;
        time = Math.ceil(time);
        double totalCost = 0;
        if (time < 0) {
            return -1;
        }
        // Xác định giá cước dựa trên khu vực
        if (callRegion.equals("domestic")) {
            if (time <= 1 && time > 0) {
                totalCost = baseRateFirstMinute_domestic;
            } else if (time <= 5 && time > 1) {
                totalCost = baseRateMinutes1To5_domestic * (time - 1) + baseRateFirstMinute_domestic;
            } else {
                totalCost = baseRateAfterMinute5_domestic * (time - 5) + baseRateMinutes1To5_domestic * 4 + baseRateFirstMinute_domestic;
            }
        } else if (callRegion.equals("international")) {
            if (time <= 1 && time > 0) {
                totalCost = baseRateFirstMinute_international;
            } else if (time <= 5 && time > 1) {
                totalCost = baseRateMinutes1To5_international * (time - 1) + baseRateFirstMinute_international;
            } else {
                totalCost = baseRateAfterMinute5_international * (time - 5) + baseRateMinutes1To5_international * 4 + baseRateFirstMinute_international;
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        double time = 4;
        String callRegion = "international";
        double cost = calculateCost(time, callRegion);
        System.out.println("Call cost: " + cost + " VNĐ");
    }
}
