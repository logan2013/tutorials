/**
 * Created by Logan on 2016/11/30.
 */
import Component from "react";
import moment from "moment";

import {Provider} from "mobx-react";
import DevTools from "mobx-react-devtools";

import Clock from "./Clock";
import Time from "./Time";

class App extends Component {

    render() {
        return (
            <Provider Clock={Clock}>

                <DevTools />

                <div className="App-intro">

                    <Time until={moment().add(10, "minutes")}></Time>
                    <Time since={moment().subtract(5, "minutes")}></Time>
                    <Time/>

                </div>

            </Provider>
        );
    }
}