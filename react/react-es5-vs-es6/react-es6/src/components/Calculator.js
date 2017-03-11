/**
 * Created by Logan on 2017/1/18.
 */
import React, {Component} from "react";

class Calculator extends Component {
    constructor(props) {
        super(props);

        this.state = {
            value1: this.props.value1,
            value2: this.props.value2,
            result: Number.parseInt(this.props.value1) + Number.parseInt(this.props.value2)
        };

        this.handleChangeValue1 = this.handleChangeValue1.bind(this);
        this.handleChangeValue2 = this.handleChangeValue2.bind(this);
    }

    handleChangeValue1(e) {
        this.setState({value1: e.target.value});
    }

    handleChangeValue2(e) {
        this.setState({value2: e.target.value});
    }

    calculate(e) {
        e.preventDefault();

        this.setState({result: Number.parseInt(this.state.value1) + Number.parseInt(this.state.value2)});
    }

    render() {
        return (
            <form>

                <div>
                    <label>Value1</label>
                    <input type="text" name="value1" onChange={this.handleChangeValue1} value={this.state.value1}/>
                </div>

                <div>
                    <label>Value2</label>
                    <input type="text" name="value2" onChange={this.handleChangeValue2} value={this.state.value2}/>
                </div>

                <div>

                    <label>Result</label>
                    <div>{this.state.result}</div>
                </div>

                <div>
                    <button onClick={this.calculate.bind(this)}>Calculate</button>

                </div>
            </form>

        );
    }
}

export default Calculator;