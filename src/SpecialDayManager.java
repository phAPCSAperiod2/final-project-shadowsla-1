public class SpecialDayManager {

    public String getScheduleType(
            String date) {

        // PEP RALLY DAYS
        if (date.equals("10/24")
                || date.equals("1/30")
                || date.equals("4/24")) {

            return "PEP";
        }

        // FINALS
        if (date.equals("12/17")
                || date.equals("12/18")
                || date.equals("12/19")
                || date.equals("5/26")
                || date.equals("5/27")
                || date.equals("5/28")) {

            return "FINALS";
        }

        // NO SCHOOL
        if (date.equals("9/1")
                || date.equals("11/11")
                || date.equals("12/25")
                || date.equals("1/1")
                || date.equals("5/25")) {

            return "NO SCHOOL";
        }

        return "NORMAL";
    }
}
