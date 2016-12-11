/**
 * Created by Logan on 2016/11/30.
 */
import {observable, action} from "mobx";
import  moment from "moment";

class Clock {
    @observable time = moment();

    constructor(period = 1000) {
        this.interval = setInterval(() => this.clockTick(), period);
    }

    @action clockTick(newTime = moment()) {
        this.time = newTime;
    }
}

const clock = new Clock();

export default clock;