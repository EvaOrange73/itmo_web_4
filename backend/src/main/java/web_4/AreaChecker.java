package web_4;

public class AreaChecker {
    private enum Quarters {
        FIRST, SECOND, THIRD, FOURTH;

        static Quarters quarter(double x, double y) {
            if (x >= 0 && y >= 0) return Quarters.FIRST;
            if (x < 0 && y >= 0) return Quarters.SECOND;
            if (x < 0 && y < 0) return Quarters.THIRD;
            return Quarters.FOURTH;
        }
    }

    public boolean check(double x, double y, double r) {
        boolean result = false;
        switch (Quarters.quarter(x, y)) {
            case FIRST:
                result = x * x + y * y < r * r;
                break;
            case SECOND:
                break;
            case THIRD:
                result = y > (-x - r/2);
                break;
            case FOURTH:
                result = (x < r / 2) && (y > - r);
                break;
        }
        return result;
    }
}
