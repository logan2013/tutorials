/**
 * Created by Logan on 2016/11/30.
 */
import {extendObservable, action} from "mobx";
import  moment from "moment";

class Clock {

    constructor(period = 1000) {

        extendObservable(this, {
            time: moment(),
            clockTick: action((newTime = moment()) => this.time = newTime)
        });

        this.interval = setInterval(() => this.clockTick(), period);
    }
}

const clock = new Clock();

export default clock;