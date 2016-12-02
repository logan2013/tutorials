/**
 * Created by Logan on 2016/12/2.
 */
let SimpleData = (function () {

    let _yearKey = Symbol();
    let _monthKey = Symbol();
    let _dayKey = Symbol();

    class SimpleData3 {

        cconstructor(year, month, day) {
            this[_yearKey] = year;
            this[_monthKey] = month;
            this[_dayKey] = day;
        }

        addDays(nDays) {

        }

        getDay() {
            return this[_dayKey];
        }
    }

    return SimpleData3;
})();