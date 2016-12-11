/**
 * Created by Logan on 2016/12/2.
 */
let SimpleData = (function () {

    let _years = new WeakMap();
    let _months = new WeakMap();
    let _days = new WeakMap();

    class SimpleData4 {

        constructor(year ,month, day) {

            _years.set(this, year);
            _months.set(this, month);
            _days.set(this, day);

        }

        addDays(nDays) {

        }

        getDay() {
            return _days.get(this);
        }
    }

    return SimpleData4;
})();