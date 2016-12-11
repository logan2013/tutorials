/**
 * Created by Logan on 2016/12/2.
 */
class SimpleData {

    constructor(year, month, day) {
        this._year = year;
        this._month = month;
        this._day = day;
    }

    addDays(nDays) {

    }

    getDay() {
        return this._day;
    }
}

let today = new SimpleData(2000, 2, 28);

today.addDays(1);