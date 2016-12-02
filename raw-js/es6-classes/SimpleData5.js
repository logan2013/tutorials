/**
 * Created by Logan on 2016/12/2.
 */
class SimpleData5 {

    static setDefaultDate(year, month, day) {
        SimpleData5._defaultDate = new SimpleData5(year, month, day);
    }

    constructor(year, month, day) {

        if(arguments.length === 0) {

            this._year = SimpleData5._defaultDate._year;
            this._month = SimpleData5._defaultDate._month;
            this._day = SimpleData5._defaultDate._day;

            return;
        }

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

SimpleData5.setDefaultDate(1970, 1, 1);

let defaultDate = new SimpleData5();