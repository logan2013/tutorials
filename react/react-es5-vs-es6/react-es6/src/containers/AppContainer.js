/**
 * Created by Logan on 2017/1/18.
 */
import React, {Component} from  "react";
import Calculator from  "../components/Calculator";

class AppContainer extends Component {

    constructor(props) {
        super(props);

        this.state = {
            value1: 1,
            value2: 1
        };
    }

    render() {
        return (
            <Calculator value1={this.state.value1} value2={this.state.value2}/>
        );
    }
}

export default AppContainer;