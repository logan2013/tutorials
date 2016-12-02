/**
 * Created by Logan on 2016/12/2.
 */
class SimpleData2 {

    /**
     * 利用闭包来创建私有变量
     *
     * @param year
     * @param month
     * @param day
     */
    constructor(year, month, day) {

        let _year = year;
        let _month = month;
        let _day = day;

        this.addDays = function (nDays) {
            
        }

        this.getDay = function () {
            return day;
        }
    }
}